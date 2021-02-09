package be.btoc.exercises.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PopupPage {

    WebDriver driver;
    WebDriverWait waiter;

    public PopupPage(WebDriver driver, WebDriverWait waiter) {
        this.driver = driver;
        this.waiter = waiter;
    }

    public void proceedToCheckoutPage() {
        WebElement checkoutButton = driver.findElement(By.cssSelector("[title='Proceed to checkout']"));
        waiter.until(ExpectedConditions.visibilityOf(checkoutButton));
        checkoutButton.click();
    }
}
