import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FirstTest {

    WebDriver driver;

    @Test
    public void goToWebsite() {
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Java\\Webdrivers\\chromedriver.exe");
        this.driver = new ChromeDriver();
        this.driver.get("http://automationpractice.com/index.php");
        driver.close();
        driver.quit();
    }
}
