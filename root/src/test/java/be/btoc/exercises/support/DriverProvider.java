package be.btoc.exercises.support;

import be.btoc.exercises.support.eventhandler.EventCapture;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class DriverProvider {

    public static WebDriver getDriver() {
        return driver;
    }

    public static WebDriverWait getWaiter() {
        return waiter;
    }

    private static EventFiringWebDriver driver;
    private static WebDriverWait waiter;

    private static Scenario scenario;

    public static void createWebdriver() {
        WebDriver webDriver = new ChromeDriver();
        driver = new EventFiringWebDriver(webDriver);
        waiter = new WebDriverWait(driver, 5);
        DriverProvider.register();
    }

    public static void register() {
        EventCapture eCapture = new EventCapture();
        driver.register(eCapture);
    }

    public static void takeScreenshot() {
        scenario.attach(((TakesScreenshot)DriverProvider.getDriver()).getScreenshotAs(OutputType.BYTES),"image/png","screenshot");
    }

    public static void closeWebdriver() {
        driver.quit();
    }

    public static void setScenario(Scenario scenario) {
        DriverProvider.scenario = scenario;
    }
}
