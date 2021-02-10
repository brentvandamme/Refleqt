package be.btoc.exercises.support;

import be.btoc.exercises.enums.BROWSERTYPES;
import be.btoc.exercises.enums.executionMode;
import be.btoc.exercises.support.managers.ChromeManager;
import be.btoc.exercises.support.managers.DriverManager;
import be.btoc.exercises.support.managers.FirefoxManager;
import be.btoc.exercises.support.managers.RemoteManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;

public class DriverManagerFactory{

    public DriverManagerFactory() {
    }

    public static WebDriver returnWebdriver(BROWSERTYPES browser) {
        DriverManager driver;
        switch (browser){
            case FIREFOX:
                driver = new FirefoxManager();
                break;
            case CLOUD:
                driver = new RemoteManager();
                break;
            case CHROME:
            default:
                driver = new ChromeManager();
        }
        return driver.getDriver();
    }

}
