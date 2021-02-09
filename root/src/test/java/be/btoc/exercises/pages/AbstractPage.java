package be.btoc.exercises.pages;

import be.btoc.exercises.support.DriverProvider;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractPage {

    WebDriver driver = DriverProvider.getDriver();
    WebDriverWait waiter = DriverProvider.getWaiter();

}
