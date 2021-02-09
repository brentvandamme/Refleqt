package be.btoc.exercises.tests;

import be.btoc.exercises.pages.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class FirstTest {

    WebDriver driver;
    WebDriverWait waiter;

    @BeforeMethod
    public void beforeTest() {
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Java\\Webdrivers\\chromedriver.exe");
        this.driver = new ChromeDriver();
        this.waiter = new WebDriverWait(this.driver, 5);
        this.driver.get("http://automationpractice.com/index.php");
    }

    @Test
    public void goToWebsite() {
        FrontPage fp = new FrontPage(driver,waiter);
        fp.searchDress();

        waiter.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(".left-block")));
        List<WebElement> products = driver.findElements(By.cssSelector(".left-block"));
        products.get(1).click();

        DetailPage dp = new DetailPage(driver,waiter);
        Assert.assertTrue(dp.checkIfDressIsShown(driver));
    }

    @Test
    public void addSomethingToCartFrontPage() {
        FrontPage fp = new FrontPage(driver, waiter);
        fp.hoverOverProductItem("#homefeatured li:nth-child(1)", "#homefeatured li:nth-child(1) .button");

        PopupPage pp = new PopupPage(driver,waiter);
        pp.proceedToCheckoutPage();

        CheckoutPage cp = new CheckoutPage(driver,waiter);
        Assert.assertTrue(cp.productIsAddedToCart(driver));
    }

    @Test
    public void addSomethingToCartResultPage() {
        FrontPage fp = new FrontPage(driver, waiter);
        fp.searchDress();

        ResultPage rp = new ResultPage(driver,waiter);
        rp.hoverOverProductItem(".product_list li:nth-child(6)", ".product_list li:nth-child(6) .button");

        PopupPage pp = new PopupPage(driver,waiter);
        pp.proceedToCheckoutPage();

        CheckoutPage cp = new CheckoutPage(driver,waiter);
        Assert.assertTrue(cp.productIsAddedToCart(driver));
    }

    @AfterMethod()
    public void afterTest() {
        driver.close();
        driver.quit();
    }


}
