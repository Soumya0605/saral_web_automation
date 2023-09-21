package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Properties;

import com.paulhammant.ngwebdriver.NgWebDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;

public class Base {

    WebDriver driver;


    public String url;

    public WebDriver createBrowserInstance(String browser) {

        driver = null;
        if (browser.equalsIgnoreCase("Chrome")) {
//            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--incognito");
            driver = new ChromeDriver(options);
        } else if (browser.equalsIgnoreCase("firefox")) {
//            WebDriverManager.firefoxdriver().setup();
            FirefoxOptions foptions = new FirefoxOptions();
            foptions.addArguments("--private");
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("ie")) {

//            WebDriverManager.iedriver().setup();
            InternetExplorerOptions ioptions = new InternetExplorerOptions();
            ioptions.addCommandSwitches("--private");
            driver = new InternetExplorerDriver(ioptions);

        }
        return driver;


    }
//        Properties prop = new Properties();
//
//        FileInputStream fis = new FileInputStream(
//                System.getProperty("user.dir") + "\\src\\main\\java\\resources\\data.properties");
//
//        prop.load(fis);
//
//        String browserName = prop.getProperty("browser");
//
//        // following is for parameterized browser through maven command
//        // String browserName = System.getProperty("browser");
//
//        System.out.println("browser name is :" + browserName);
//        url = prop.getProperty("url");
//
//        if (browserName.contains("chrome")) {
//
//            WebDriverManager.chromedriver().setup();
//            ChromeOptions options = new ChromeOptions();
//
//            HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
//            options.addArguments("start-maximized");
//            chromePrefs.put("profile.default_content_settings.popups", 0);
//            chromePrefs.put("download.default_directory", System.getProperty("user.dir") + "\\downloadTestFolder");
//            options.setExperimentalOption("prefs", chromePrefs);
//
//            if (browserName.contains("headless")) {
//                options.addArguments("--headless");
//                options.addArguments("--window-size=1920,1080");
//                System.out.println("inside chrome headless....");
//            }
//
//            driver = new ChromeDriver(options);
//
//        }
//
//        else if (browserName.equals("edge")) {
//
//            System.out.println("inside edge");
//            WebDriverManager.edgedriver().setup();
//            driver = new EdgeDriver();
//            EdgeOptions options = new EdgeOptions();
//
//            if (browserName.contains("headless")) {
//                options.addArguments("--headless");
//                options.addArguments("--window-size=1920,1080");
//            }
//            // driver = new EdgeDriver(options);
//        }
//
//        else if (browserName.equals("firefox")) {
//
//        }
//
//        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(120));
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//
//        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(120));
//        // driver.manage().window().maximize();
//        return driver;


    public String getScreenShortpath(String testCaseName, WebDriver driver) {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        String destinationFile = System.getProperty("user.dir") + "\\reports\\" + testCaseName + ".png";
        try {
            FileUtils.copyFile(source, new File(destinationFile));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return destinationFile;
    }
}

