package sangathan_runner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(features = "src/src/test/sangathan_features/Pradesh/pradesh.feature", glue = {"sangathan_stepdefinations",
        "hooks" }, publish = true, plugin = {"pretty", "html:target/CucumberReports/CucumberPradeshRepor.html" } ,

        tags="@Test_with_few_data"
)

public class pradeshKaryakartaRunner extends AbstractTestNGCucumberTests {

//	@Override
//	@DataProvider(parallel = true)
//	public Object[][] scenarios() {
//		return super.scenarios();
//	}

}
