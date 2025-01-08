package com.revature.steps;

import com.revature.TestRunner;
import io.cucumber.java.en.When;

public class SharedSteps {

    @When("the user selects planet from the dropdown")
    public void the_user_selects_planet_from_the_dropdown() {
        TestRunner.homePage.setSelectedBody("Planet");
    }

    @When("the user selects moon from the dropdown")
    public void the_user_selects_moon_from_the_dropdown() {
        TestRunner.homePage.setSelectedBody("Moon");
    }
}
