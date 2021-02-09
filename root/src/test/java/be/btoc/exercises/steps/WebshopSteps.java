package be.btoc.exercises.steps;

import be.btoc.exercises.pages.*;
import be.btoc.exercises.support.DriverProvider;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.annotations.AfterMethod;

public class WebshopSteps {

    @Before
    public void beforeTest() {
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Java\\Webdrivers\\chromedriver.exe");
        DriverProvider.createWebdriver();
    }

    @Given("I go to {string}")
    public void goToWebsite(String url) {
        DriverProvider.getDriver().get(url);
    }

    @When("I search for {string}")
    public void iSearchFor(String kledij) {
        new FrontPage().searchDress(kledij);
    }

    @When("I hover over product card {int}")
    public void iHoverOverProductCard(int index) {
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
        new DetailPage().checkIfDressIsShown(productText);
    }

    @Then("I check if {string} is added at cart")
    public void iCheckIfProductIsAddedAtCart(String productText) {
        new CheckoutPage().productIsAddedToCart(productText);
    }

    @After
    public void afterTest() {
        DriverProvider.closeWebdriver();
    }
}
