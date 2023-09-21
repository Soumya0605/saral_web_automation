package stepdefination_runner;
//import io.cucumber.junit.Cucumber;
//import io.cucumber.junit.CucumberOptions;
//import org.junit.runner.RunWith;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
 

//@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/src/test/resources/ParallelPackege/Homepage.feature"},
//        features = {"src/src/test/resurces/StagingFeature/Homepage.feature"},//Homepage.feature
//        features = {"src\\test\\resources\\StagingFeature\\Homepage.feature"},
        glue= {"Stepdefination","AppHooks"}, //
        publish = true,
        plugin = {"pretty","html:target/CucumberReports/CucumberReport.html", "timeline:test-output-thread/" },
        dryRun = false
        )
public class Runner extends AbstractTestNGCucumberTests {
//	\\Homepage.feature
}
