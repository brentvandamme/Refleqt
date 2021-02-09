package be.btoc.exercises.pages;

import be.btoc.exercises.support.DriverProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class CheckoutPage extends AbstractPage{

    @FindBy(css =".cart_description .product-name" )
    WebElement productName;

    public void productIsAddedToCart(String productText) {
        String txt = productName.getText();
        System.out.println(txt);
        Assert.assertTrue(txt.equals(productText));
    }
}
