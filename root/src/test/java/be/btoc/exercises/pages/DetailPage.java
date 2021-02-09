package be.btoc.exercises.pages;

import be.btoc.exercises.support.DriverProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class DetailPage extends AbstractPage{

    public void checkIfDressIsShown() {
        String txt = driver.findElement(By.cssSelector(".pb-center-column h1")).getText();
        Assert.assertTrue(txt.equals("Printed Dress"));
    }

}
