package be.btoc.exercises.support.managers;

import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxManager extends DriverManager{

    @Override
    protected void createDriver() {
        System.setProperty("webdriver.gecko.driver", "C:\\Program Files\\Java\\Webdrivers\\geckodriver.exe");
        webDriver = new FirefoxDriver();
    }
}
