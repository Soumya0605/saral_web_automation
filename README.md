# **Saral Web Automation**

   ## **Prerequisite**

* Java is installed

* Maven is installed

* TestNG is installed

* Eclipse or IntelliJ Java IDE installed

### **Dependency List**

* Selenium – 4.12.0
* Java 17
* Cucumber Java – 7.11.0
* Cucumber TestNG – 7.11.0
* Maven – 3.8.1
* TestNG – 7.7.1
* Maven Surefire Plugin – 3.0.0-M7
* Maven Compiler Plugin – 3.10.1

### **Detailed Step Description**

* **Step 1 – Create a **Maven Project****

   Create a Maven project in your favorite IDE using the cucumber archetype. To know more about this, click here.

* **Step 2 – Update Properties section in Maven **pom.xml****
```
<properties>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
        <java.version>17.0.5</java.version>
        <junit.version>4.13.2</junit.version>
        <cucumber.version>7.11.0</cucumber.version>
        <maven.compiler.version>3.8.1</maven.compiler.version>
        <maven.surefire.version>3.0.0-M5</maven.surefire.version>
        <maven-failsafe-plugin.version>3.0.0-M5</maven-failsafe-plugin.version>
        <testng.version>7.7.1</testng.version>
        <selenium-java.version>4.12.0</selenium-java.version>
        <poi.version>4.1.2</poi.version>
        <poi-ooxml.version>4.1.2</poi-ooxml.version>
        <poi-ooxml-schemas.version>4.1.2</poi-ooxml-schemas.version>
        <log4j-core.version>2.20.0</log4j-core.version>
        <ngwebdriver.version>1.2</ngwebdriver.version>
        <maven.compiler.source>1.7</maven.compiler.source>
        <maven.compiler.target>1.7</maven.compiler.target>
    </properties>
```

* **Step 3 – Add Cucumber, Selenium, and TestNG dependencies to the project** 

  Add below mentioned **Cucumber-Java** and **Cucumber-TestNG** and **Selenium-java** dependencies to the project.
```
<dependencies>


        <!--Cucumber Dependencies -->

        <dependency>

            <groupId>io.cucumber</groupId>

            <artifactId>cucumber-java</artifactId>

            <version>${cucumber.version}</version>

        </dependency>

 
        <dependency>

            <groupId>io.cucumber</groupId>

            <artifactId>cucumber-testng</artifactId>

            <version>${cucumber.version}</version>

            <scope>test</scope>

        </dependency>

 
        <!-- Selenium Dependency -->

        <dependency>

            <groupId>org.seleniumhq.selenium</groupId>

            <artifactId>selenium-java</artifactId>

            <version>${selenium.version}</version>

        </dependency>

 
        <!-- TestNG Dependency -->

        <dependency>

            <groupId>org.testng</groupId>

            <artifactId>testng</artifactId>

            <version>${testng.version}</version>

            <scope>test</scope>

        </dependency>

 
        <!-- Dependency Injection-->

        <dependency>

            <groupId>io.cucumber</groupId>

            <artifactId>cucumber-picocontainer</artifactId>

            <version>${cucumber.version}</version>

            <scope>test</scope>

        </dependency>
        
    </dependencies>


```
* **Step 4 – Add Surefire plugin configuration to the build section of the POM**
```
<plugin>

<groupId>org.apache.maven.plugins</groupId>

<artifactId>maven-surefire-plugin</artifactId>

<version>${maven.surefire.plugin.version}</version>

<configuration>

<parallel>methods</parallel>

<useUnlimitedThreads>true</useUnlimitedThreads>

</configuration>

</plugin>
```


**The complete POM.xml is shown below:**
```
<?xml version="1.0" encoding="UTF-8"?>

<project xmlns="http://maven.apache.org/POM/4.0.0"

xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"

xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">

<modelVersion>4.0.0</modelVersion>


    <groupId>org.example</groupId>

    <artifactId>ParallelTests_TestNG_Demo</artifactId>

    <version>1.0-SNAPSHOT</version>

 
    <properties>

        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>

        <selenium.version>4.8.0</selenium.version>

        <cucumber.version>7.11.1</cucumber.version>

        <testng.version>7.7.1</testng.version>

        <webdrivermanager.version>5.3.2</webdrivermanager.version>

        <maven.compiler.plugin.version>3.10.1</maven.compiler.plugin.version>

        <maven.surefire.plugin.version>3.0.0-M7</maven.surefire.plugin.version>

        <maven.compiler.source>11</maven.compiler.source>

        <maven.compiler.target>11</maven.compiler.target>

    </properties>

 
    <dependencies>

 
        <!--Cucumber Dependencies -->

        <dependency>

            <groupId>io.cucumber</groupId>

            <artifactId>cucumber-java</artifactId>

            <version>${cucumber.version}</version>

        </dependency>

 
        <dependency>

            <groupId>io.cucumber</groupId>

            <artifactId>cucumber-testng</artifactId>

            <version>${cucumber.version}</version>

            <scope>test</scope>

        </dependency>

 
        <!-- Selenium Dependency -->

        <dependency>

            <groupId>org.seleniumhq.selenium</groupId>

            <artifactId>selenium-java</artifactId>

            <version>${selenium.version}</version>

        </dependency>

 
        <!-- TestNG Dependency -->

        <dependency>

            <groupId>org.testng</groupId>

            <artifactId>testng</artifactId>

            <version>${testng.version}</version>

            <scope>test</scope>

        </dependency>

 
        <!-- Dependency Injection-->

        <dependency>

            <groupId>io.cucumber</groupId>

            <artifactId>cucumber-picocontainer</artifactId>

            <version>${cucumber.version}</version>

            <scope>test</scope>

        </dependency>

 
        <!-- WebDriver Manager Dependency -->

        <dependency>

            <groupId>io.github.bonigarcia</groupId>

            <artifactId>webdrivermanager</artifactId>

            <version>${webdrivermanager.version}</version>

        </dependency>

 
    </dependencies>

    <build>

        <plugins>

 
            <plugin>

                <groupId>org.apache.maven.plugins</groupId>

                <artifactId>maven-compiler-plugin</artifactId>

                <version>${maven.compiler.plugin.version}</version>

                <configuration>

                    <source>${maven.compiler.source}</source>

                    <target>${maven.compiler.target}</target>

                </configuration>

            </plugin>

 
            <plugin>

                <groupId>org.apache.maven.plugins</groupId>

                <artifactId>maven-surefire-plugin</artifactId>

                <version>${maven.surefire.plugin.version}</version>

                <configuration>

                    <parallel>methods</parallel>

                    <useUnlimitedThreads>true</useUnlimitedThreads>

                </configuration>

            </plugin>

        </plugins>

    </build>


</project>
```


* **Step 5 – Create 2 feature files in src/test/resources – LoginPage.feature and ForgotPasswordPage.feature**

A Feature File is an entry point to the Cucumber tests.

The first keyword in the Feature file is the Feature keyword, followed by: and short text that describes the feature.


To know more about the Feature file, please refer to this tutorial.


Below are the sample feature files.


LoginPage.feature

'''

    Feature: Login to HRM Application

    Background:

    Given User is on Home page

    @ValidCredentials

    Scenario: Login with valid credentials - Feature 1, Scenario -1

    When User enters username as "Admin" and password as "admin123"

    Then User should be able to login successfully


    @InvalidCredentials

    Scenario Outline: Login with invalid credentials - Feature 1, Scenario -2


    When User enters username as "<username>" and password as "<password>"

    Then User should be able to see error message "<errorMessage>"

 
    Examples:

      | username    | password   | errorMessage                      |

      | Admin        | admin12$$  | Invalid credentials               |

      | admin$$     | admin123   | Invalid credentials               |

      | abc123       | xyz$$      | Invalid credentials               |
'''

ForgotPasswordPage.feature
'''

    Feature: Forgot Password Page

    Background:
    Given User is on Home page

    @BackFunctionality
    Scenario: Validate the cancel functionality - Feature 2, Scenario - 1

    When User clicks on Forgot your password? link
    Then User should be able to navigate to Reset Password page
    And User clicks on Cancel button to go back to Login Page


    @ResetFunctionality

    Scenario: Validate the Reset Password functionality - Feature 2, Scenario - 2

    When User clicks on Forgot your password? link
    Then User should be able to navigate to Reset Password page
    And User clicks on Reset Password button and provide username as "abc1234"
    And Verify the message "Reset Password link sent successfully"

* **Step 6 – Create Page Object Model classes of both feature files**

Page Object Model class contains all the locators and the actions performed on these locators for the particular class to improve the readability and maintainability of the code.

Below are the Page Object Model classes for these feature files.

LoginPage

'''
        
    import org.openqa.selenium.By;
    import org.openqa.selenium.WebDriver;

    public class LoginPage {
    public WebDriver driver;

    By userName = By.name("username");
    By passWord = By.name("password");
    By login = By.xpath("//*[@id='app']/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button");
    By errorMessage = By.xpath("//*[@id='app']/div[1]/div/div[1]/div/div[2]/div[2]/div/div[1]/div[1]/p");
    By forgotPasswordLink = By.xpath("//*[@id='app']/div[1]/div/div[1]/div/div[2]/div[2]/form/div[4]/p");
    By loginPageTitle = By.xpath("//*[@id='app']/div[1]/div/div[1]/div/div[2]/h5");
     
    public LoginPage(WebDriver driver) {

        this.driver = driver;
    }
    public String getErrorMessage() {

        return driver.findElement(errorMessage).getText();
    }

    public void login(String strUserName, String strPassword) {

        // Fill user name
        driver.findElement(userName).sendKeys(strUserName);

        // Fill password
        driver.findElement(passWord).sendKeys(strPassword);

        // Click Login button
        driver.findElement(login).click();
    }
    // Click on Forgot Password link
    public void clickOnForgotPasswordLink() {

        driver.findElement(forgotPasswordLink).click();
    }
    //Get Login Page Title

    public String getLoginPageTitle() {

        return driver.findElement(loginPageTitle).getText();
      }
    }

'''

HomePage
'''


    import org.openqa.selenium.By;
    import org.openqa.selenium.WebDriver;

    public class HomePage {
    public WebDriver driver;

    public HomePage(WebDriver driver) {

        this.driver = driver;
    }
    By homePageUserName = By.xpath("//*[@id='app']/div[1]/div[1]/header/div[1]/div[1]/span/h6");

    public String getHomePageText() {

        return driver.findElement(homePageUserName).getText();
    }
}

ForgotPasswordPage
'''

    import org.openqa.selenium.By;
    import org.openqa.selenium.WebDriver;

    public class ForgotPasswordPage {

    WebDriver driver;

 
     By forgotPasswordPageTitle = By.xpath("//*[@id='app']/div[1]/div[1]/div/form/h6");

     By cancelBtn = By.xpath("//*[@id='app']/div[1]/div[1]/div/form/div[2]/button[1]");

     By resetPasswordBtn = By.xpath("//*[@id='app']/div[1]/div[1]/div/form/div[2]/button[2]");

     By userName = By.name("username");

     By resetMessage = By.xpath("//*[@id='app']/div[1]/div[1]/div/h6");

 
    public ForgotPasswordPage(WebDriver driver) {

        this.driver = driver;

    }
    // Get the Title of ForgotPage

    public String getForgotPageText() {

        return driver.findElement(forgotPasswordPageTitle).getText();
    }
    // Click Cancel Button
    public void clickOnCancelBtn() {

         driver.findElement(cancelBtn).click();
    }
    // Click ResetPassword Button
    public void clickOnRestPasswordBtn() {

        driver.findElement(resetPasswordBtn).click();
    }
    // Type username in TextBox
    public void TypeOnUsernameTextBox(String username) {

        driver.findElement(userName).sendKeys(username);
    }
    // Get Message
    public String getRestMessage() {

        return driver.findElement(resetMessage).getText();
    }
    }

'''

PageObjectManager – This class creates the object of all the above-mentioned Page Object Model classes. This an optional class. If you want you can create the objects in StepDefinition class also.
'''

    public class PageObjectManager {


    public LoginPage loginPage;

    public HomePage homePage;

    public ForgotPasswordPage forgotPasswordPage;

    public WebDriver driver;

 
 
    public PageObjectManager(WebDriver driver)

    {

        this.driver = driver;

    }

 
    public LoginPage getLoginPage()

    {

 
        loginPage= new LoginPage(driver);

        return loginPage;

    }

 
    public HomePage getHomePage()

    {

        homePage = new HomePage(driver);

        return homePage;

    }

 
    public ForgotPasswordPage getForgotPasswordPage()

    {

        forgotPasswordPage = new ForgotPasswordPage(driver);

        return forgotPasswordPage;

    }

}

**Step 7 – Create the Step Definition classes for both feature files or Glue Code**

Below is the Step Definition for LoginPage.feature.
'''


    import io.cucumber.java.en.Given;

    import io.cucumber.java.en.Then;
    
    import io.cucumber.java.en.When;
    
    import pageObjects.HomePage;
    
    import pageObjects.LoginPage;
    
    import pageObjects.PageObjectManager;
    
    import utils.TestSetUp;
    
    import org.testng.Assert;
    
    
    public class LoginPageDefinitions {


    TestSetUp setUp;

    public PageObjectManager pageObjectManager;

    public LoginPage loginPage;

    public HomePage homePage;

 
 
    public LoginPageDefinitions(TestSetUp setUp) {

        this.setUp = setUp;

        this.loginPage = setUp.pageObjectManager.getLoginPage();

        this.homePage= setUp.pageObjectManager.getHomePage();

    }

 
    @Given("User is on Home page")

    public void loginTest() throws IOException {

        setUp.baseTest.WebDriverManager().get("https://opensource-demo.orangehrmlive.com/");

 
    }

 
    @When("User enters username as {string} and password as {string}")

    public void goToHomePage(String userName, String passWord) {

 
        // login to application

        loginPage.login(userName, passWord);

 
        // go the next page

 
    }

 
    @Then("User should be able to login successfully")

    public void verifyLogin() {

 
        // Verify home page

        Assert.assertTrue(homePage.getHomePageText().contains("Dashboard"));

 
    }

 
    @Then("User should be able to see error message {string}")

    public void verifyErrorMessage(String expectedErrorMessage) {

 
        // Verify home page

        Assert.assertEquals(loginPage.getErrorMessage(),expectedErrorMessage);

 
    }
    }
'''

Below is the Step Definition for ForgotPasswordPage.feature.
'''

    import io.cucumber.java.en.Then;
    
    import io.cucumber.java.en.When;
    
    import pageObjects.ForgotPasswordPage;
    
    import pageObjects.LoginPage;
    
    import pageObjects.PageObjectManager;
    
    import utils.TestSetUp;
    
    import org.testng.Assert;
    
    
    public class ForgotPasswordPageDefinitions{


    TestSetUp setUp;

    PageObjectManager pageObjectManager;

    public LoginPage loginPage;

    public  ForgotPasswordPage forgotPasswordPage;

 
    public ForgotPageDefinitions(TestSetUp setUp) {

        this.setUp = setUp;

        this.loginPage = setUp.pageObjectManager.getLoginPage();

        this.forgotPasswordPage = setUp.pageObjectManager.getForgotPasswordPage();

    }

 
    @When("User clicks on Forgot your password? link")

    public void forgotPasswordLink() {

 
        loginPage.clickOnForgotPasswordLink();

 
    }

 
    @Then("User should be able to navigate to Reset Password page")

    public void verifyForgotPasswordPage() {

 
        Assert.assertEquals(forgotPasswordPage.getForgotPageText(),"Reset Password");

 
    }

 
    @Then("User clicks on Cancel button to go back to Login Page")

    public void verifyCancelBtn() {

 
        forgotPasswordPage.clickOnCancelBtn();

        Assert.assertEquals(loginPage.getLoginPageTitle(),"Login");

 
    }

 
    @Then("User clicks on Reset Password button and provide username as {string}")

    public void verifyResetPasswordBtn(String username) {

 
        forgotPasswordPage.TypeOnUsernameTextBox(username);

        forgotPasswordPage.clickOnRestPasswordBtn();

 
    }

 
    @Then("Verify the message {string}")

    public void verifyMessage(String message) {

 
        Assert.assertEquals(forgotPasswordPage.getRestMessage(),message);

 
    }

    }
'''

* **Step 8 – Create the Hook Class and Dependency Injection class (TestSetUp) and BaseTest class**

Below is the code for the ApplicationHook Class.
'''

      import io.cucumber.java.After;
        
      import utils.TestSetUp;
      
      
      public class ApplicationHooks {
      
      
      public TestSetUp setUp;
  
  
      public ApplicationHooks(TestSetUp setUp) {
  
          this.setUp = setUp;
  
      }
  
   
      @After
  
      public void tearDown( ) throws IOException {
  
          setUp.baseTest.WebDriverManager().quit();
  
      }

      }
'''

Below is the code for the Dependency Injection class. In Cucumber, if we want to share the state between multiple-step definition files, we will need to use dependency injection (DI).
'''

    import org.openqa.selenium.WebDriver;
    
    import org.openqa.selenium.WebElement;
    
    import pageObjects.PageObjectManager;
    
    
    public class TestSetUp {


    public WebElement errorMessage;

    public WebElement homePageUserName;

    public PageObjectManager pageObjectManager;

    public BaseTest baseTest;

 
    public TestSetUp()  {

 
        baseTest = new BaseTest();

        pageObjectManager = new PageObjectManager(baseTest.WebDriverManager());

 
    }

    }
'''

BaseTest class is used to initialize the WebDriver.
'''

    import io.github.bonigarcia.wdm.WebDriverManager;
    
    import org.openqa.selenium.WebDriver;
    
    import org.openqa.selenium.chrome.ChromeDriver;
    
    import java.time.Duration;
    
    
    public class BaseTest {


    public WebDriver driver;

    public final static int TIMEOUT = 10;

 
    public WebDriver WebDriverManager ()  {

 
    
        if (driver == null) {

         
            WebDriverManager.chromedriver().setup();

            driver = new ChromeDriver();

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TIMEOUT));

            driver.manage().window().maximize();

            driver.get(url);

 
        }

        return driver;

    }

    }
'''

* **Step 9 – Create a Cucumber TestNG Runner class**

Add a cucumber runner by extending the AbstractTestNGCucumberTests class and overriding the scenarios method. Set the parallel option value to true for the DataProvider annotation.
'''

    import io.cucumber.testng.AbstractTestNGCucumberTests;
    
    import io.cucumber.testng.CucumberOptions;
    
    import org.testng.annotations.DataProvider;
    
    
    @CucumberOptions(tags = "", features = "src/test/resources/features", glue = "org.example.definitions")
    
    public class CucumberRunnerTests  extends AbstractTestNGCucumberTests {
    
    
    @Override
    
    @DataProvider(parallel = true)
    
    public Object[][] scenarios() {
    
    return super.scenarios();
    
    }
    
    
    }
'''

* **Step 10 – Report Generation**

Add cucumber.properties under src/test/resources and add the below instruction in the file.


    cucumber.publish.enabled=true

* **Step 11 – Execute the test from Command Line**

Use the below-mentioned command in the command prompt to run the tests.

    mvn clean test

The output of the above program is



* **Step 12 – Execute the tests from TestNG Runner**

Go to the Runner class and right-click Run As TestNG Test. The tests will run as TestNG tests. (Eclipse)



In the case of IntelliJ, right-click and select Run “CucumberRunnerTests”.


* **Step 13 – Test Execution Result**

All the tests are started at the same time, so they share different threads. The way tests are executed is different in them. With non-parallel tests, all the scenarios of the same feature are executed together, and then the scenarios of another feature file. Whereas in parallel tests, all the tests are started at the same time, so there won’t be any specific order.

All the scenarios have started simultaneously.

The Cucumber Report is shown below:

There are chances that we don’t want to run all the scenarios simultaneously, in this case, we need to add the below-mentioned configuration in the pom.xml. The value =2 means that 2 scenarios will be executed simultaneously.


'''

    <configuration>
    
    <properties>
    
    <property>
    
    <name>dataproviderthreadcount</name>
    
    <value>2</value>
    
    </property>
    
    </properties>
    
    </configuration>

The below Cucumber Report shows that the execution time has increased as we are running only 2 scenarios at a time.



The default thread count of the dataprovider in parallel mode is 10.