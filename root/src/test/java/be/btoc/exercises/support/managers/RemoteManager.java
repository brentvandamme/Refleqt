package be.btoc.exercises.support.managers;

import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class RemoteManager extends DriverManager{


    @Override
    protected void createDriver() {
        try {
            webDriver = new RemoteWebDriver(
                    new URL("https://carole_vink:43fc27674ea440789f0dc7b4990e0b5b@ondemand.eu-central-1.saucelabs.com:443/wd/hub"),
                    new DesiredCapabilities( "Chrome", "", Platform.ANY)
            );
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
