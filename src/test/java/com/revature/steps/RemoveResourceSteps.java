package com.revature.steps;

import com.revature.TestRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.List;

public class RemoveResourceSteps {

    @When("the user enters the valid planet name to be deleted")
    public void the_user_enters_the_valid_planet_name_to_be_deleted() {
        TestRunner.homePage.enterDeleteInput("Earth");
    }

    @When("the user enters an invalid planet name to be deleted")
    public void the_user_enters_an_invalid_planet_name_to_be_deleted() {
        TestRunner.homePage.enterDeleteInput("Venus");
    }

    @When("the user enters the valid moon name to be deleted")
    public void the_user_enters_the_valid_moon_name_to_be_deleted() {
        TestRunner.homePage.enterDeleteInput("Luna");
    }

    @When("the user enters an invalid moon name to be deleted")
    public void the_user_enters_an_invalid_moon_name_to_be_deleted() {
        TestRunner.homePage.enterDeleteInput("Giant");
    }

    @When("the user clicks the delete button")
    public void the_user_clicks_the_delete_button() {
        TestRunner.homePage.clickDeleteButton();
    }

    @Then("the user should no longer see the deleted planet")
    public void the_user_should_no_longer_see_the_deleted_planet() {
        TestRunner.homePage.waitForTableRefreshAfterDeleting();
        List<WebElement> rows = TestRunner.homePage.getCelestialRows();
        String planetToDelete = TestRunner.homePage.getDeleteInput();

        boolean deletedPlanetFound = false;
        for (WebElement row : rows) {
            if (row.getText().contains(planetToDelete)) {
                deletedPlanetFound = true;
                break;
            }
        }
        Assert.assertFalse(deletedPlanetFound);
    }

    @Then("the user should no longer see the deleted moon")
    public void the_user_should_no_longer_see_the_deleted_moon() {
        TestRunner.homePage.waitForTableRefreshAfterDeleting();
        List<WebElement> rows = TestRunner.homePage.getCelestialRows();
        String moonToDelete = TestRunner.homePage.getDeleteInput();

        boolean deletedMoonFound = false;
        for (WebElement row : rows) {
            if (row.getText().contains(moonToDelete)) {
                deletedMoonFound = true;
                break;
            }
        }
        Assert.assertFalse(deletedMoonFound);
    }

    @Then("the user should no longer see the associated moons")
    public void the_planet_s_associated_moons_should_be_deleted() {
        TestRunner.homePage.waitForTableRefreshAfterDeleting();
        int numRowsRemaining = TestRunner.homePage.getNumberOfCelestialRows();

        Assert.assertEquals(2, numRowsRemaining);

    }

}
