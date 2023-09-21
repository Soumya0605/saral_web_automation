package resources;

import org.openqa.selenium.WebDriver;

public class DriverFactory1 {

    private DriverFactory1(){

    }
    private static DriverFactory1 instance = new DriverFactory1();

    public static DriverFactory1 getInstance(){
        return instance;
    }
    //factory design pattern --> define separate factory methods for creating getInstances methods
    ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
    public WebDriver getDriver(){

        return driver.get();

    }
    public void setDriver(WebDriver driverParm){
        driver.set(driverParm);

    }
    public void closeBrowser(){
        driver.get().close();
        driver.remove();

    }

}
