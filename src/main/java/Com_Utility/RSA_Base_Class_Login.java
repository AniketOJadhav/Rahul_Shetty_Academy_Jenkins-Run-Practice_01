package Com_Utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import Com.Login_Main.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class RSA_Base_Class_Login {

    public static WebDriver driver;
    public static Confiq_Data_Provider confiq;
    public static Excel_Data_Provider excel;

    @BeforeSuite
    public void Data_Provider() throws Exception {
        confiq = new Confiq_Data_Provider();
        excel = new Excel_Data_Provider();
        ObjectRepo.initializeReport();
        System.out.println("✅ ExtentReport initialized.");
    }

    @BeforeMethod
    public void openbrowser() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        ObjectRepo.driver = driver; // ✅ Sync ObjectRepo's driver
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://rahulshettyacademy.com/client");

        LoginPage loginelements = PageFactory.initElements(driver, LoginPage.class);
        WebDriverWait wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(10));

        // Login flow
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("userEmail")))
            .sendKeys("jadhavaniket1572@gmail.com");
        ObjectRepo.startTestAndLog_1_SS("Test No 1", "User should enter Username on Username Field");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("userPassword")))
            .sendKeys("Aniket001");
        ObjectRepo.startTestAndLog_1_SS("Test No 2", "User should enter Password on Password Field");

        Liabrary.custom_click(loginelements.getLogin_Btn(), "Login Btn");
        Thread.sleep(2000);
        ObjectRepo.startTestAndLog_1_SS("Test No 3", "User clicks on Login Button");
    }

    @AfterMethod
    public void close() {
        if (driver != null) {
            driver.quit();
            System.out.println("🔐 Browser closed.");
        }
    }

    @AfterSuite
    public void afterSuite() {
        ObjectRepo.finalizeReport();
        System.out.println("📄 Report finalized and email triggered.");
        
        
       // We can use this method also
//        try {
//        	Demo_Mail.sendReportEmail(null);  // Send Email with Report
//        } catch (Exception e) {
//            System.out.println("Email sending failed! Error: " + e.getMessage());
//            e.printStackTrace();
//        }
    }
}
