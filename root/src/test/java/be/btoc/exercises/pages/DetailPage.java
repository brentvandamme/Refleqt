package be.btoc.exercises.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DetailPage {

    WebDriver driver;
    WebDriverWait waiter;

    public DetailPage(WebDriver driver, WebDriverWait waiter) {
        this.driver = driver;
        this.waiter = waiter;
    }

    public boolean checkIfDressIsShown(WebDriver driver) {
        String txt = driver.findElement(By.cssSelector(".pb-center-column h1")).getText();
        return txt.equals("Printed Dress");
    }

}
