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

public class RSA_Baseclass_Config_Data {
    public static WebDriver driver;
    public static Confiq_Data_Provider confiq;
    public static Excel_Data_Provider excel;

    // BeforeSuite to initialize the data providers and reports
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
        // Initialize the test report for each test
    	ObjectRepo.test = ObjectRepo.initializeReport().createTest("Test Case: " + this.getClass().getSimpleName());


        // Automatically download and set up the ChromeDriver using WebDriverManager
        WebDriverManager.chromedriver().setup();

        // Initialize the WebDriver for Chrome browser
        driver = new ChromeDriver();

        // Fetch URL, username, and password from config file
        String url = confiq.get_BaseURL();
        String username = confiq.get_username();
        String password = confiq.get_password();

        // Open URL and maximize the window
        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // Initialize the LoginPage object using PageFactory
        LoginPage loginelements = PageFactory.initElements(driver, LoginPage.class);

        // Perform login using properties from config file
        Liabrary.custom_Sendkeys_Config(loginelements.getUserName(), username, "UserName Field");
        Liabrary.custom_Sendkeys_Config(loginelements.getPassword(), password, "Password Field");
        Liabrary.custom_click(loginelements.getLogin_Btn(), "Login Btn");
    }

    // AfterMethod to close the browser after each test
    @AfterMethod
    public void close() {
        if (driver != null) {
            driver.quit();
        }
    }

    // AfterSuite to finalize the ExtentReports and generate the final report after all tests are executed
    @AfterSuite
    public void afterSuite() {
        ObjectRepo.finalizeReport();
    }
}
