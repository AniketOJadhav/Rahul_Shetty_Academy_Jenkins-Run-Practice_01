package Com.Login_Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Com.Login_Main.Login_Register_Main;
import Com_Utility.Liabrary;
import Com_Utility.ObjectRepo;
import io.github.bonigarcia.wdm.WebDriverManager;
public class Login_Register_Test {

    WebDriver driver;
    Login_Register_Main RSA;

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/client");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        ObjectRepo.driver = driver;              // telling to object repo to use this driver for report
        ObjectRepo.initializeReport();           // Ensure ExtentReports is ready


//   // Initialize PageFactory
//		Login_Register_Main  RSA = PageFactory.initElements(driver, Login_Register_Main.class);
    }
		@Test
		public void Register_Page() throws Exception {
		
			// Initialize PageFactory
			Login_Register_Main  RSA = PageFactory.initElements(driver, Login_Register_Main.class);
			
			// STEP 1: Click Register Button
			ObjectRepo.startTestAndLog_1_SS("Test no 1", "Click Register Button");
			WebElement Element = driver.findElement(By.xpath("//div[@class='banner']//a[@href='/client/auth/register']"));
			Element.click();
            Thread.sleep(1000);
            
			// STEP 2: Enter First Name
			ObjectRepo.startTestAndLog_1_SS("Test no 2", "Enter First Name");
			Liabrary.custom_Sendkeys(RSA.getFirstName_Textbox(), "Aniket", "Enter First Name");
			Thread.sleep(1000);
			
			// STEP 3: Enter Last Name
			ObjectRepo.startTestAndLog_1_SS("Test no 3", "Enter Last Name");
			Liabrary.custom_Sendkeys(RSA.getLastName_Textbox(), "Jadhav", "Enter Last Name");
			Thread.sleep(1000);
			
			// STEP 4: Enter Email
			ObjectRepo.startTestAndLog_1_SS("Test no 4", "Enter Email");
			Liabrary.custom_Sendkeys(RSA.getEmail_Textbox(), "jadhavaniket1572@gmail.com", "Enter Email");
			Thread.sleep(1000);
			
			// STEP 5: Enter Phone Number
			ObjectRepo.startTestAndLog_1_SS("Test no 5", "Enter Phone Number");
			Liabrary.custom_Sendkeys(RSA.getPhoneNumber_Textbox(), "866839", "Enter Phone Number");
			Thread.sleep(1000);
			
			// STEP 6: Select Occupation
			ObjectRepo.startTestAndLog_1_SS("Test no 6", "Select Occupation");
			 try {
			// Wait for the dropdown to be clickable
		    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		    WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='form-group col-md-6']//select[@formcontrolname='occupation']")));
		    
		    // Select the option from the dropdown
		    Select sel = new Select(element);
		    sel.selectByValue("3: Engineer");
		        } 
			 catch (Exception e) 
			    {
		    // Log any exception in Extent Reports
		    System.out.println("Error selecting occupation: " + e.getMessage());
			     }
			Thread.sleep(1000);
			
			// STEP 7: Select Gender - Male
			ObjectRepo.startTestAndLog_1_SS("Test no 7", "Click on male radio button");
			WebElement radio1 = driver.findElement(By.xpath("//div[@class='form-group col-md-6']//input[@value='Male']"));
			radio1.click();
			
			// Optional: Verify if it's selected properly
			if (radio1.isSelected()) {
			    System.out.println("Radio Button 1 is selected.");
			} else {
			    System.out.println("Radio Button 1 is not selected.");
			}
			Thread.sleep(1000);

			// STEP 8: Enter Password
			ObjectRepo.startTestAndLog_1_SS("Test no 8", "Enter Password");
			Liabrary.custom_Sendkeys(RSA.getPassword_Textbox(), "Password123", "Enter Password");
			Thread.sleep(1000);
			
			// STEP 9: Confirm Password
			ObjectRepo.startTestAndLog_1_SS("Test no 9", "Confirm Password");
			Liabrary.custom_Sendkeys(RSA.getConfirmPassword_Textbox(), "Password123", "Confirm Password");
			Thread.sleep(1000);
			
			// STEP 10: Tick Age Checkbox
			ObjectRepo.startTestAndLog_1_SS("Test no 10", "Tick Age Checkbox");
			WebElement ageCheckbox = driver.findElement(By.xpath("//div[@class='col-md-1']//input[@type='checkbox']"));
			ageCheckbox.click();
			Thread.sleep(1000);
			
			// STEP 11: Click Register
			ObjectRepo.startTestAndLog_1_SS("Test no 11", "Click Register Button");
			Liabrary.custom_click(RSA.getSubmitRegisterButton(), "Click button");
			ObjectRepo.Print_Dynamic_Error_Massage(driver,"//div[@id='toast-container']", null);
			Thread.sleep(2000);

		   
		}
		
		  @AfterMethod
		    public void tearDown() {
		        if (driver != null) {
		            driver.quit();
		
		            ObjectRepo.finalizeReport();  // ✅ Generate and send report
		        
		        }
}
}

