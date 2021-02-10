package be.btoc.exercises.support.eventhandler;

import be.btoc.exercises.support.DriverProvider;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class ListenerMainClass {

    EventFiringWebDriver eventWebdriver = new EventFiringWebDriver(DriverProvider.getDriver());
    EventCapture eCapture = new EventCapture();

}
