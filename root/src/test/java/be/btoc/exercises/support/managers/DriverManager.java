package be.btoc.exercises.support.managers;

import be.btoc.exercises.enums.BROWSERTYPES;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;

public abstract class DriverManager {

    WebDriver webDriver;

    public WebDriver getDriver() {
        if (null == webDriver){
            createDriver();
        }
        return webDriver;
    }

    protected abstract void createDriver();

}
