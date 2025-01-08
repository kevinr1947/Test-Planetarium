package com.revature.steps;

import com.revature.TestRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;
import java.util.List;

public class LoginSteps {

    @Given("the existing user is on the login page")
    public void the_existing_user_is_on_the_login_page() {
        TestRunner.loginPage.openLoginPage();
    }

    @When("the user provides a valid login username")
    public void the_user_provides_a_valid_login_username() {
        TestRunner.loginPage.enterUsername("Batman");
    }

    @When("the user provides a valid login password")
    public void the_user_provides_a_valid_login_password() {
        TestRunner.loginPage.enterPassword("Iamthenight1939");
    }

    @When("the user submits the login credentials")
    public void the_user_submits_the_login_credentials() {
        TestRunner.loginPage.clickLoginButton();
    }

    @When("the user provides a username {string}")
    public void the_user_provides_username(String username) {
        TestRunner.loginPage.enterUsername(username);
    }

    @When("the user provides a password {string}")
    public void the_user_provides_password(String password) {
        TestRunner.loginPage.enterPassword(password);
    }

    @When("the user clicks the logout link")
    public void the_user_clicks_the_logout_link() {
        TestRunner.homePage.logout();
    }

    @Then("the user should be redirected to the home page")
    public void the_user_should_be_redirected_to_the_home_page() {
        TestRunner.wait.until(ExpectedConditions.not(ExpectedConditions.titleIs("Planetarium Login")));
        Assert.assertEquals("Home", TestRunner.driver.getTitle());
    }

    @Then("the user should stay on the login page")
    public void the_user_should_stay_on_the_login_page() {
        TestRunner.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        Assert.assertEquals("Planetarium Login", TestRunner.driver.getTitle());
    }

    @Then("the user should not have access to their planetarium data")
    public void the_user_should_not_have_access_to_their_planetarium_data() {
        List<WebElement> planetsAndMoons = TestRunner.driver.findElements(By.id("celestialTable"));
        Assert.assertTrue(planetsAndMoons.isEmpty());
    }

    @Then("the user should be redirected from the home page to the login page")
    public void the_user_should_be_redirected_from_the_home_page_to_the_login_page() {
        TestRunner.wait.until(ExpectedConditions.not(ExpectedConditions.titleIs("Home")));
        Assert.assertEquals("Planetarium Login", TestRunner.driver.getTitle());
    }
}
