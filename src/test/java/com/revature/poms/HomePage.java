package com.revature.poms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.nio.file.Paths;
import java.time.Duration;
import java.util.List;

public class HomePage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(id = "greeting")
    private WebElement greetingHeader;

    @FindBy(id = "logoutButton")
    private WebElement logoutButton;

    @FindBy(id = "locationSelect")
    private WebElement celestialBodySelect;

    @FindBy(id = "planetNameInput")
    private WebElement planetNameInput;

    @FindBy(id = "moonNameInput")
    private WebElement moonNameInput;

    @FindBy(id = "orbitedPlanetInput")
    private WebElement orbitedPlanetInput;

    @FindBy(id = "planetImageInput")
    private WebElement planetImageInput;

    @FindBy(id = "moonImageInput")
    private WebElement moonImageInput;

    @FindBy(id = "deleteInput")
    private WebElement deleteInput;

    @FindBy(id = "deleteButton")
    private WebElement deleteButton;

    @FindBy(className = "submit-button")
    private WebElement submitButton;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public String getHomePageGreeting() {
        return greetingHeader.getText();
    }

    public int getNumberOfCelestialRows() {
        return driver.findElements(By.tagName("tr")).size() - 1;
    }

    public List<WebElement> getCelestialRows() {
        return driver.findElements(By.tagName("tr"));
    }

    public void tryToAccessHomePageDirectly() {
        driver.get("http://localhost:8080/planetarium");
    }

    public void logout() {
        logoutButton.click();
    }

    public void setSelectedBody(String body) {
        Select select = new Select(celestialBodySelect);
        select.selectByVisibleText(body);
    }

    public void enterPlanetName(String planetName) {
        planetNameInput.sendKeys(planetName);
    }

    public String getPlanetNameInput() {
        return planetNameInput.getAttribute("value");
    }

    public void enterMoonName(String moonName) {
        moonNameInput.sendKeys(moonName);
    }

    public String getMoonNameInput() {
        return moonNameInput.getAttribute("value");
    }

    public void enterOwnerId(String ownerId) {
        orbitedPlanetInput.sendKeys(ownerId);
    }

    public void addPlanetImage(String image) {
        if (!image.isEmpty()) {
            String absolutePath = Paths.get("src/test/resources/Celestial-Images/", image).toAbsolutePath().toString();
            planetImageInput.sendKeys(absolutePath);
        }
    }

    public void addMoonImage(String image) {
        if (!image.isEmpty()) {
            String absolutePath = Paths.get("src/test/resources/Celestial-Images/", image).toAbsolutePath().toString();
            moonImageInput.sendKeys(absolutePath);
        }
    }

    public void enterDeleteInput(String celestialBodyName) {
        deleteInput.sendKeys(celestialBodyName);
    }

    public void clickDeleteButton() {
        deleteButton.click();
    }

    public String getDeleteInput() {
        return deleteInput.getAttribute("value");
    }

    public void clickSubmitButton() {
        submitButton.click();
    }

    public void waitForTableRefreshAfterAdding() {
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.tagName("tr"), 5));
    }

    public void waitForTableRefreshAfterDeleting() {
        wait.until(ExpectedConditions.numberOfElementsToBeLessThan(By.tagName("tr"), 5));
    }

}