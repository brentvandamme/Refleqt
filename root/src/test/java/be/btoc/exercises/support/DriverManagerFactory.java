package be.btoc.exercises.support;

import be.btoc.exercises.enums.BROWSERTYPES;
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
        WebDriver driver = null;
        switch (browser){
            case CHROME:
                System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Java\\Webdrivers\\chromedriver.exe");
                driver = new ChromeDriver();
                return driver;
            case FIREFOX:
                System.setProperty("webdriver.gecko.driver", "C:\\Program Files\\Java\\Webdrivers\\geckodriver.exe");
                return new FirefoxDriver();
            case EDGE:
                return new EdgeDriver();
            case OPERA:
                return new OperaDriver();
            case SAFARI:
                return new SafariDriver();
            case INTERNETEXPLORERE:
                return new InternetExplorerDriver();
            default:
                return new ChromeDriver();
        }
    }

}
