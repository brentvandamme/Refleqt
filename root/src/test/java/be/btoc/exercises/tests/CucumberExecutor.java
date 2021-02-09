package be.btoc.exercises.tests;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/test/resources/features/"},
        glue = "be.btoc.exercises.steps",
        plugin = {"de.monochromata.cucumber.report.PrettyReports:target/cucumber", "cucumber.api.event.EventListener"}
)
public class CucumberExecutor extends AbstractTestNGCucumberTests {

}
