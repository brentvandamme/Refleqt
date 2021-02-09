package be.btoc.exercises.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProductPage extends AbstractPage{

    @FindBy(css = ".product_list .product-container" )
    List <WebElement> productCard;

    @FindBy(css = "[title='Add to cart']")
    List <WebElement> productCardCartBtn;

    public PopupPage hoverOverProductItem(int index) {
        WebElement target = productCard.get((index));
        Actions action = new Actions(driver);
        action.moveToElement(target).perform();
        productCardCartBtn.get(index).click();
        return new PopupPage();
    }

}
