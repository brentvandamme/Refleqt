package be.btoc.exercises.pages;

import be.btoc.exercises.support.DriverProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PopupPage extends AbstractPage{

    public CheckoutPage proceedToCheckoutPage() {
        WebElement checkoutButton = driver.findElement(By.cssSelector("[title='Proceed to checkout']"));
        waiter.until(ExpectedConditions.visibilityOf(checkoutButton));
        checkoutButton.click();
        return new CheckoutPage();
    }
}
