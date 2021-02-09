package be.btoc.exercises.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PopupPage extends AbstractPage{

    @FindBy(css ="[title='Proceed to checkout']" )
    WebElement checkoutBtn;

    public CheckoutPage proceedToCheckoutPage() {
        AbstractPage.waitForElement(checkoutBtn);
        checkoutBtn.click();
        return new CheckoutPage();
    }
}
