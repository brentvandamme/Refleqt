package be.btoc.exercises.tests;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class FirstTest {

    WebDriver driver;
    WebDriverWait waiter;

    @Test
    public void goToWebsite() {
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Java\\Webdrivers\\chromedriver.exe");
        this.driver = new ChromeDriver();
        this.waiter = new WebDriverWait(this.driver, 5);
        this.driver.get("http://automationpractice.com/index.php");

        driver.findElement(By.cssSelector("#search_query_top"));
        driver.findElement((By.cssSelector("#homefeatured:first-child")));

        driver.findElement(By.cssSelector("#search_query_top")).sendKeys("dress" + Keys.ENTER);
        waiter.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(".left-block")));
        List<WebElement> products = driver.findElements(By.cssSelector(".left-block"));
        products.get(1).click();

        Assert.assertTrue(checkIfDressIsShown(driver));

        driver.close();
        driver.quit();
    }

    @Test
    public void addSomethingToCart() {
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Java\\Webdrivers\\chromedriver.exe");
        this.driver = new ChromeDriver();
        this.waiter = new WebDriverWait(this.driver, 5);
        this.driver.get("http://automationpractice.com/index.php");

        WebElement target = driver.findElement(By.cssSelector("#homefeatured li:nth-child(1)"));
        Actions action = new Actions(driver);
        action.moveToElement(target).perform();
        driver.findElement(By.cssSelector("#homefeatured li:nth-child(1) .button")).click();

        WebElement checkoutButton = driver.findElement(By.cssSelector("[title='Proceed to checkout']"));
        waiter.until(ExpectedConditions.visibilityOf(checkoutButton));
        checkoutButton.click();

        Assert.assertTrue(productIsAddedToCart(driver));

        driver.close();
        driver.quit();
    }

    public boolean checkIfDressIsShown(WebDriver driver) {
        String txt = driver.findElement(By.cssSelector(".pb-center-column h1")).getText();
        return txt.equals("Printed Dress");
    }

    public boolean productIsAddedToCart(WebDriver driver) {
        String txt = driver.findElement(By.cssSelector(".layer_cart_product h2")).getText();
        System.out.println(txt);
        return txt.equals("Product successfully added to your shopping cart");
    }
}
