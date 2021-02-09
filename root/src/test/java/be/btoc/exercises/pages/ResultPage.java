package be.btoc.exercises.pages;

import be.btoc.exercises.support.DriverProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class ResultPage extends ProductPage{

    public DetailPage clickOnProductFoto(){
        waiter.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(".left-block")));
        List<WebElement> products = driver.findElements(By.cssSelector(".left-block"));
        products.get(1).click();
        return new DetailPage();
    }
}
