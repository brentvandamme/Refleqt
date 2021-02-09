package be.btoc.exercises.pages;

import be.btoc.exercises.support.DriverProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PopupPage extends AbstractPage{

    @FindBy(css ="[title='Proceed to checkout']" )
    WebElement checkoutBtn;

    public CheckoutPage proceedToCheckoutPage() {
        waiter.until(ExpectedConditions.visibilityOf(checkoutBtn));
        checkoutBtn.click();
        return new CheckoutPage();
    }
}
