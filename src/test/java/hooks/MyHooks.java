//package hooks;
//
//import java.io.IOException;
//import java.time.Duration;
//import java.util.Properties;
//
//import org.openqa.selenium.WebElement;
//import resources.DriverFactory1;
//import org.openqa.selenium.OutputType;
//import org.openqa.selenium.TakesScreenshot;
//import org.openqa.selenium.WebDriver;
//
//import factory.DriverFactory;
//import io.cucumber.java.After;
//import io.cucumber.java.Before;
//import io.cucumber.java.Scenario;
//import resources.Base;
//import utils.ConfigReader;
//
//public class MyHooks {
//    private DriverFactory driverFactory;
//    private WebDriver driver;
//    private ConfigReader configReader;
//    Properties prop;
//
//    Base base = new Base();
//
//    @Before(order = 0)
//    public void getProperty() throws IOException {
//        configReader = new ConfigReader();
//        prop = configReader.intializeProperties();
//
//    }
//
//    @Before(order = 1)
//    public void launchBrowser() {
//        String browserName = prop.getProperty("browser");
//        //driverFactory = new DriverFactory();
//        DriverFactory.getInstance().initializeBrowser(browserName);
//        //driverFactory.initializeBrowser(browserName);
//        driver = DriverFactory.getDriver();
//        //driver = DriverFactory.getInstance().getDriver();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(120));
//
////        DriverFactory1.getInstance().setDriver(base.createBrowserInstance("chrome"));
////        WebDriver driver = DriverFactory1.getInstance().getDriver();
////
////        driver.manage().window().maximize();
////        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(120));
////        driver.navigate().to("https://zila-staging.ccdms.in/");
//
//
//
//    }
//
//    @After(order = 0)
//    public void quitBrowser() {
//        DriverFactory.quitDriver();
//    }
//
//    @After(order = 1)
//    public void tearDown(Scenario scenario) {
//        String scenarioName = scenario.getName().replaceAll(" ", "_");
//        if (scenario.isFailed()) {
//            byte[] srcScreenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
//            scenario.attach(srcScreenshot, "image/png", scenarioName);
//
//        }
//
//    }
//
//}
