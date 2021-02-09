package be.btoc.exercises.tests;

import be.btoc.exercises.pages.*;
import be.btoc.exercises.support.DriverProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class FirstTest {

    @BeforeMethod
    public void beforeTest() {
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Java\\Webdrivers\\chromedriver.exe");
        DriverProvider.createWebdriver();
        DriverProvider.getDriver().get("http://automationpractice.com/index.php");
    }

    @Test
    public void goToWebsite() {
        new FrontPage()
                .searchDress()
                .clickOnProductFoto()
                .checkIfDressIsShown();
    }

    @Test
    public void addSomethingToCartFrontPage() {
       new FrontPage()
            .hoverOverProductItem(1)
            .proceedToCheckoutPage()
            .productIsAddedToCart();
    }

    @Test
    public void addSomethingToCartResultPage() {
        new FrontPage()
            .searchDress()
            .hoverOverProductItem(6)
            .proceedToCheckoutPage()
            .productIsAddedToCart();
    }

    @AfterMethod()
    public void afterTest() {
        DriverProvider.closeWebdriver();
    }


}
