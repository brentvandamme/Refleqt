package be.btoc.exercises.pages;

import be.btoc.exercises.support.DriverProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class DetailPage extends AbstractPage{

    String productTxt = "Printed Dress";

    @FindBy(css =".pb-center-column h1" )
    WebElement productName;

    public void checkIfDressIsShown() {
        String txt = productName.getText();
        Assert.assertTrue(txt.equals(productTxt));
    }

}
