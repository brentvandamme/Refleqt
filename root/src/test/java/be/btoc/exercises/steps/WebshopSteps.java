package be.btoc.exercises.steps;

import be.btoc.exercises.enums.BROWSERTYPES;
import be.btoc.exercises.pages.*;
import be.btoc.exercises.support.DriverProvider;
import be.btoc.exercises.support.eventhandler.EventCapture;
import io.cucumber.java.After;
import io.cucumber.java.Before;
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
    private FrontPage frontPage;
    private CheckoutPage checkoutPage;
    private DetailPage detailPage;
    private PopupPage popupPage;
    private ProductPage productPage;
    private ResultPage resultPage;

    public WebshopSteps(FrontPage frontPage, CheckoutPage checkoutPage, DetailPage detailPage, PopupPage popupPage, ProductPage productPage, ResultPage resultPage){
        this.frontPage = frontPage;
        this.checkoutPage = checkoutPage;
        this.detailPage = detailPage;
        this.popupPage = popupPage;
        this.productPage = productPage;
        this.resultPage = resultPage;
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

    @When("I search for {string}")
    public void iSearchFor(String kledij) {
        frontPage.searchDress(kledij);
    }

    @When("I hover over product card {int}")
    public void iHoverOverProductCard(int index) {
        productPage.hoverOverProductItem(index);
    }

    @And("I click on the product card picture")
    public void iClickOnTheProductCardPicture() {
        resultPage.clickOnProductFoto();
    }

    @And("I add product to cart")
    public void iAddProductToCart() {
        popupPage.proceedToCheckoutPage();
    }

    @Then("{string} is shown")
    public void isShown(String productText) {
        detailPage.checkIfDressIsShown(productText);
    }

    @Then("I check if {string} is added at cart")
    public void iCheckIfProductIsAddedAtCart(String productText) {
        checkoutPage.productIsAddedToCart(productText);
    }

    @After
    public void afterTest() {
        this.scenario.attach(((TakesScreenshot)DriverProvider.getDriver()).getScreenshotAs(OutputType.BYTES),"image/png","screenshot");
        DriverProvider.closeWebdriver();
    }
}
