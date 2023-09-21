package sangathan_runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(features = "src/src/test/sangathan_features/loksabhaKaryakarta/loksabhaKaryakarta.feature", glue = { "sangathan_stepdefinations" , "hooks" }, publish = true, plugin = { "pretty",
        "html:target/CucumberReports/CucumberReport.html", "timeline:test-output-thread/", "html:target/CucumberReports/CucumberLoksabhaKaryakartaReport.html" })
public class loksabhaKaryakartaRunner extends AbstractTestNGCucumberTests {
//
//	@Override
//	@DataProvider(parallel = true)
//	public Object[][] scenarios() {
//		return super.scenarios();
//	}

}
