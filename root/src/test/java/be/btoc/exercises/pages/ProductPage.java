package be.btoc.exercises.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ProductPage extends AbstractPage{

    public PopupPage hoverOverProductItem(String productCard, String productCardCartBtn) {
        WebElement target = driver.findElement(By.cssSelector(productCard));
        Actions action = new Actions(driver);
        action.moveToElement(target).perform();
        driver.findElement(By.cssSelector(productCardCartBtn)).click();
        return new PopupPage();
    }

}
