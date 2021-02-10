package be.btoc.exercises.steps;

import be.btoc.exercises.enums.BROWSERTYPES;
import be.btoc.exercises.pages.*;
import be.btoc.exercises.support.DriverProvider;
import be.btoc.exercises.support.World;
import be.btoc.exercises.support.eventhandler.EventCapture;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.ParameterType;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterMethod;

import java.io.File;
import java.io.IOException;

public class WebshopSteps {

    private Scenario scenario;
    private final World world;

    public WebshopSteps(World world){
        this.world = world;
    }

    @ParameterType("shirt|dress|pants")
    public String kledij(String kledij){
        return kledij;
    }

    @Before
    public void beforeTest( Scenario scenario) {
        DriverProvider.createWebdriver(BROWSERTYPES.CHROME);
        this.scenario = scenario;
        DriverProvider.setScenario(scenario);
    }

    @Given("I go to {string}")
    public void goToWebsite(String url) {
        DriverProvider.getDriver().get(url);
    }

    @When("I search for {kledij}")
    public void iSearchFor(String kledij) {
        world.kledij = kledij;
        new FrontPage().searchDress(kledij);
    }

    @When("I hover over product card {int}")
    public void iHoverOverProductCard(int index) {
        world.index = index;
        new ProductPage().hoverOverProductItem(index);
    }

    @And("I click on the product card picture")
    public void iClickOnTheProductCardPicture() {
        new ResultPage().clickOnProductFoto();
    }

    @And("I add product to cart")
    public void iAddProductToCart() {
        new PopupPage().proceedToCheckoutPage();
    }

    @Then("{string} is shown")
    public void isShown(String productText) {
        world.productText = productText;
        new DetailPage().checkIfDressIsShown(productText);
    }

    @Then("I check if {string} is added at cart")
    public void iCheckIfProductIsAddedAtCart(String productText) {
        world.productText = productText;
        new  CheckoutPage().productIsAddedToCart(productText);
    }

    @After
    public void afterTest() {
        this.scenario.attach(((TakesScreenshot)DriverProvider.getDriver()).getScreenshotAs(OutputType.BYTES),"image/png","screenshot");
        DriverProvider.closeWebdriver();
    }
}
