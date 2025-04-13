package Com_Utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import Com.Login_Main.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;



public class RSA_Base_Class_Practice_Projects {

    public static WebDriver driver;
    public static Confiq_Data_Provider confiq;
    public static Excel_Data_Provider excel;

    //BeforeSuite to initialize the ExtentReports
    @BeforeSuite
    public void Data_Provider() throws Exception {
        // Initialize the data providers
        confiq = new Confiq_Data_Provider();
        excel = new Excel_Data_Provider();

        // Initialize Extent Reports
        ObjectRepo.initializeReport();
    }

    // BeforeMethod to open the browser and run the login process
    @BeforeMethod
    
   
    public void openbrowser() throws Exception {
     // Automatically download and set up the ChromeDriver using WebDriverManager
     WebDriverManager.chromedriver().setup();
    	System.setProperty("webdriver.chrome.driver", "C:\\Jenkins_Projects\\Rahul_Shetty_Academy_Jenkins_Run_Project\\Driver_New_Version");
        // Initialize the WebDriver for Chrome browser
        driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/practice-project");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // Initialize the LoginPage object using PageFactory
        LoginPage loginelements = PageFactory.initElements(driver, LoginPage.class);

        // Use custom methods to send keys and clicks, replace Liabrary with Library
        Liabrary.custom_Sendkeys(loginelements.getUserName(), excel.getStringdata2("Sheet1", 2, 0), "UserName Field");
        Thread.sleep(1000);
       Liabrary.custom_Sendkeys(loginelements.getPassword(), excel.getStringdata2("Sheet1", 2, 1), "Password Field");
        Thread.sleep(3000);
        Liabrary.custom_click(loginelements.getLogin_Btn(), "Login Btn");
        Thread.sleep(3000);
    }
 
 // AfterMethod to close the browser after each test
    @AfterMethod
    public void close() {
        // Quit the driver after the test
        if (driver != null) {
            driver.quit();
        }
    }

    // AfterSuite to finalize the ExtentReports and generate the final report after all tests are executed
    @AfterSuite
    public void afterSuite() {
        // Finalize the report after all tests are executed
        ObjectRepo.finalizeReport();
    }
    
}
    
    