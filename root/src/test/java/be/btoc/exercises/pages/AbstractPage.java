package be.btoc.exercises.pages;

import be.btoc.exercises.support.DriverProvider;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public abstract class AbstractPage {

    WebDriver driver = DriverProvider.getDriver();
    static WebDriverWait waiter = DriverProvider.getWaiter();

    public AbstractPage() {
        PageFactory.initElements(driver,this);
    }

    public static void waitForElement(WebElement element) {
        waiter.until(ExpectedConditions.visibilityOf(element));
    }

    public static void waitForElements(List <WebElement> elements) {
        waiter.until(ExpectedConditions.visibilityOfAllElements(elements));
    }

}
