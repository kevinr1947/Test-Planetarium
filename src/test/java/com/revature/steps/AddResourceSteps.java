package com.revature.steps;

import com.revature.TestRunner;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class AddResourceSteps {



    @When("the user enters an invalid planet name {string}")
    public void the_user_enters_an_invalid_planet_name(String planetName) {
        TestRunner.homePage.enterPlanetName(planetName);
    }

    @When("the user enters an invalid moon name {string}")
    public void the_user_enters_an_invalid_moon_name(String moonName) {
        TestRunner.homePage.enterMoonName(moonName);
    }

    @When("the user enters a valid planet name")
    public void the_user_enters_a_valid_planet_name() {
        TestRunner.homePage.enterPlanetName("Mars A-B_1234");
    }

    @When("the user enters a valid moon name")
    public void the_user_enters_a_valid_moon_name() {
        TestRunner.homePage.enterMoonName("Titan A-B_1234");
    }

    @When("the user enters an invalid owner id")
    public void the_user_enters_an_invalid_owner_id() {
        TestRunner.homePage.enterOwnerId("0");
    }

    @When("the user enters a valid owner id")
    public void the_user_enters_a_valid_owner_id() {
        TestRunner.homePage.enterOwnerId("1");
    }

    @When("the user selects an invalid planet image")
    public void the_user_selects_an_invalid_planet_image() {
        TestRunner.homePage.addPlanetImage("invalid_file_type.gif");
    }

    @When("the user selects an invalid moon image")
    public void the_user_selects_an_invalid_moon_image() {
        TestRunner.homePage.addMoonImage("invalid_file_type.gif");
    }

    @When("the user selects a valid planet image {string}")
    public void the_user_selects_a_valid_planet_image(String image) {
        TestRunner.homePage.addPlanetImage(image);
    }

    @When("the user selects a valid moon image {string}")
    public void the_user_selects_a_valid_moon_image(String image) {
        TestRunner.homePage.addMoonImage(image);
    }

    @When("the user clicks submit")
    public void the_user_clicks_submit() {
        TestRunner.homePage.clickSubmitButton();
    }

    @Then("the planet should be added")
    public void the_planet_should_be_added() {
        TestRunner.homePage.waitForTableRefreshAfterAdding();
        List<WebElement> rows = TestRunner.homePage.getCelestialRows();
        String newPlanetName = TestRunner.homePage.getPlanetNameInput();

        System.out.println("Num rows: " + rows.size());

        boolean rowExists = false;
        for (WebElement row : rows) {
            if (row.getText().contains(newPlanetName)) {
                rowExists = true;
                break;
            }
        }
        Assert.assertTrue(rowExists);
    }

    @Then("the moon should be added")
    public void the_moon_should_be_added() {
        TestRunner.homePage.waitForTableRefreshAfterAdding();
        List<WebElement> rows = TestRunner.homePage.getCelestialRows();
        String newMoonName = TestRunner.homePage.getMoonNameInput();

        System.out.println("Num rows: " + rows.size());

        boolean rowExists = false;
        for (WebElement row : rows) {
            if (row.getText().contains(newMoonName)) {
                rowExists = true;
                break;
            }
        }
        Assert.assertTrue(rowExists);
    }
}
