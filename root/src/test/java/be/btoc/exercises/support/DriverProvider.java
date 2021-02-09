package be.btoc.exercises.support;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class DriverProvider {

    public static WebDriver getDriver() {
        return driver;
    }

    public static WebDriverWait getWaiter() {
        return waiter;
    }

    private static WebDriver driver;
    private static WebDriverWait waiter;

    public static void createWebdriver() {
        driver = new ChromeDriver();
        waiter = new WebDriverWait(driver, 5);
    }

    public static void closeWebdriver() {
        driver.quit();
    }

}
