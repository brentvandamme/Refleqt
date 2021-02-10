package be.btoc.exercises.support.managers;

import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeManager extends DriverManager{

    @Override
    protected void createDriver() {
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Java\\Webdrivers\\chromedriver.exe");
        webDriver = new ChromeDriver();
    }
}
