package be.btoc.exercises.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ResultPage {

     WebDriver driver;
     WebDriverWait waiter;

    public ResultPage(WebDriver driver, WebDriverWait waiter) {
        this.driver = driver;
        this.waiter = waiter;
    }

    public void hoverOverProductItem(String productCard, String productCardCartBtn) {
        WebElement target = driver.findElement(By.cssSelector(productCard));
        Actions action = new Actions(driver);
        action.moveToElement(target).perform();
        driver.findElement(By.cssSelector(productCardCartBtn)).click();
    }
}
