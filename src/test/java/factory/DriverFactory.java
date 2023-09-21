package factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class DriverFactory {
    public WebDriver driver;
    //singleton design pattern - only one instance exits ever , provide global access to that instance by creating getInstance method

    public DriverFactory(){

    }

    private static DriverFactory instance = new DriverFactory();
    public static DriverFactory getInstance(){
        return instance;
    }

    public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<WebDriver>();

    public WebDriver initializeBrowser(String browserName) {

        // This method is used to initialize the threadlocal driver on the basis of
        // given browser

        if (browserName.equals("chrome")) {
            ChromeOptions co = new ChromeOptions();
            co.addArguments("incognito");
            co.addArguments("--remote-allow-origins=*");


            driver = new ChromeDriver(co);
//			WebDriverManager.chromedriver().setup();

            tlDriver.set(driver);;

        } else if (browserName.equals("firefox")) {

            tlDriver.set(new FirefoxDriver());

        } else if (browserName.equals("safari")) {
            tlDriver.set(new SafariDriver());

        }
        getDriver().manage().deleteAllCookies();
        getDriver().manage().window().maximize();
        return getDriver();

    }

    // This is used to get the driver with ThreadLocal

    public static WebDriver getDriver() {
        return tlDriver.get();
    }

    public static void quitDriver(){
       WebDriver driver = getDriver();
        if (driver != null) {
            driver.quit();
            tlDriver.remove();
        }
    }

}
