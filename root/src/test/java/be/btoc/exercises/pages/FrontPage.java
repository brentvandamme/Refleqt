package be.btoc.exercises.pages;

import be.btoc.exercises.support.DriverProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FrontPage extends ProductPage {

    @FindBy(css ="#search_query_top" )
    WebElement searchbar;

    public ResultPage searchDress() {
        searchbar.sendKeys("dress" + Keys.ENTER);
        return new ResultPage();
    }
}
