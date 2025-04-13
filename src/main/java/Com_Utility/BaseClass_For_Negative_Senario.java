package Com_Utility;
	import java.util.concurrent.TimeUnit;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.support.PageFactory;
	import org.openqa.selenium.support.ui.WebDriverWait;
	import org.testng.annotations.AfterMethod;
	import org.testng.annotations.BeforeMethod;
	import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import Com.Login_Main.LoginPage;
	import io.github.bonigarcia.wdm.WebDriverManager;

	public class BaseClass_For_Negative_Senario {

		public static WebDriver driver;
		public static Confiq_Data_Provider confiq;
		public static Excel_Data_Provider excel;
		
		@BeforeSuite 
		public void Data_Provider() throws Exception {
			 confiq=new Confiq_Data_Provider();
			 excel=new Excel_Data_Provider();	   
		}
		@BeforeMethod
	
		public void openbrowser() throws Exception {
	    System.setProperty("webdriver.chrome.driver", "C:\\Users\\10389\\eclipse-workspace\\FOSROC_Automation\\Driver_New_Version\\chromedriver.exe");
	       	//WebDriver driver = new ChromeDriver();
			//WebDriverManager.chromedriver().setup();
		  driver = new ChromeDriver();
		  driver.get("https://fosrocuat.hspldms.com");
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				
		}
		
		@AfterMethod
		public void close()
		{
			
			driver.quit();
			
		}
			
	}


