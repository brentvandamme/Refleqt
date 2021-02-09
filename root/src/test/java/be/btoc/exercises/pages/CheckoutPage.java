package be.btoc.exercises.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutPage {

    WebDriver driver;
    WebDriverWait waiter;

    public CheckoutPage(WebDriver driver, WebDriverWait waiter) {
        this.driver = driver;
        this.waiter = waiter;
    }

    public boolean productIsAddedToCart(WebDriver driver) {
        String txt = driver.findElement(By.cssSelector(".cart_description .product-name")).getText();
        System.out.println(txt);
        return txt.equals("Faded Short Sleeve T-shirts");
    }
}
