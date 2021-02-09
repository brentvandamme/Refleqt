package be.btoc.exercises.pages;

import be.btoc.exercises.support.DriverProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class CheckoutPage extends AbstractPage{

    public void productIsAddedToCart() {
        String txt = driver.findElement(By.cssSelector(".cart_description .product-name")).getText();
        System.out.println(txt);
        Assert.assertTrue(txt.equals("Faded Short Sleeve T-shirts"));
    }
}
