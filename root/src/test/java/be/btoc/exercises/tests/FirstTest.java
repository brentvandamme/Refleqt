package be.btoc.exercises.tests;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
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

        driver.close();
        driver.quit();
    }
}
