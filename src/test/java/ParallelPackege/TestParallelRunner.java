package ParallelPackege;

//import org.junit.runner.RunWith;
import org.testng. annotations.DataProvider;

//import io.cucumber.junit.Cucumber;
import io.cucumber.testng.CucumberOptions;
//import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
 
//@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src\\src\\test\\resources\\ParallelPackege"},
		glue = {"ParallelPackege"},
		monochrome = true,
		publish = true,
//      glue= {"src\\test\\java\\ParallelPackege"}, //
//        plugin = {"pretty","html:target/CucumberReports/CucumberReport.html", "timeline:test-output-thread/"},
		plugin = {"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
				"pretty",
				"json:target/cucumber-reports/cucumber.json"}
//        dryRun = false
        )

public class TestParallelRunner extends  AbstractTestNGCucumberTests{
	@Override
	@DataProvider(parallel=true)
	public Object[][] scenarios(){
		
		return super.scenarios();
	}
	
	
	

}
