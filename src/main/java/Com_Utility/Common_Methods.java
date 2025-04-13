package Com_Utility;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;

public class Common_Methods {

	//Print Error Massage
	 public static void checkErrorMessage(WebDriver driver, String xpathLocator) {
	        try {
	            // Locate the error message element by XPath
	            WebElement errorMessage = driver.findElement(By.xpath(xpathLocator));

	            // Check if the error message is displayed
	            if (errorMessage.isDisplayed()) {
	                // Print the error message
	                System.out.println("Error: " + errorMessage.getText());
	            } else {
	                System.out.println("Login successful & no error message displayed.");
	            }
	        } catch (Exception e) {
	            // Handle the case where the error message element is not found
	            System.out.println("Error message element not found: " + e.getMessage());
	        }
	    }
	 
	 
	 
	 //Print calender massage-----------------------------
	 
	/*  // Test:3 With From Date & Download Button.
		// From Date Empty & only fill To Date and click View Button then "Please select from Date." message should display and print in console.

		// To Date
		String month = "November 2024";
		String date = "29";

		// Click on the To Date popup button
		driver.findElement(By.xpath("//a[@id='ctl00_ParentMasterContentPlaceHolder1_Todate_popupButton']")).click();

		// Wait until the calendar displays the correct month
		while (true) {
		    String text = driver.findElement(By.xpath("//*[@id='ctl00_ParentMasterContentPlaceHolder1_Todate_calendar_Title']")).getText();
		    
		    if (text.equals(month)) {
		        break;
		    } else {
		        // Navigate to previous month if the current month doesn't match
		        driver.findElement(By.xpath("//a[@id='ctl00_ParentMasterContentPlaceHolder1_Todate_calendar_NP']//span[@class='t-font-icon t-i-arrow-left']")).click();
		    }
		    Thread.sleep(1000);  // Using Thread.sleep temporarily for synchronization
		}

		// Select the 29th date
		List<WebElement> dateElements = driver.findElements(By.xpath("//div[@id='ctl00_ParentMasterContentPlaceHolder1_Todate_calendar']//table//tbody//tr//td//a[text()='" + date + "']"));
		for (WebElement element : dateElements) {
		    String dateText = element.getText();
		    if (dateText.equals(date)) {
		        element.click();  // Click the date
		        break;  // Exit the loop after clicking the correct date
		    }
		}

		// Click on the Download Button
		Liabrary.custom_click(AR3.getDownload_Button(), "Click on Download Button");
		Thread.sleep(1000);

		// Print From date Error Message Because we Enter To Date
		try {
		    // Find the error message element
		    WebElement fromDateErrorMessage = driver.findElement(By.xpath("//span[text()='Please select  from Date.']"));
		    
		    // Check if the error message is displayed
		    if (fromDateErrorMessage.isDisplayed()) {
		    	System.out.println("");
		        System.out.println("Error Message For Test:3 " + fromDateErrorMessage.getText());
		    	System.out.println("");
		    } else {
		        System.out.println("No error message displayed.");
		    }
		} catch (Exception e) {
		    System.out.println("Error message element not found.");
		}

		Thread.sleep(1000);  
   */
	//print Daynamic error massage in one code
	
	/*
	//Print Error Massage-----------------------------------------
 	//Method 1 
  //Find the error message element (assumed XPath or ID for the error message)
  	WebElement To_Date_errorMessage1 = driver.findElement(By.xpath("//span[text()='Product Hierarchy is required.']"));
  	WebElement To_Date_errorMessage2 = driver.findElement(By.xpath("//span[text()='Sales Hierarchy is required.']"));
  	WebElement To_Date_errorMessage3 = driver.findElement(By.xpath("//span[text()='Geography Hierarchy is required.']"));
  	WebElement To_Date_errorMessage4 = driver.findElement(By.xpath("//span[text()='Report Level is required.']"));
  	// Check if the error message is displayed and print it to the console
  	if (To_Date_errorMessage1.isDisplayed()) {
  		System.out.println("");
  	    System.out.println("Error Message For Test:1 " + To_Date_errorMessage1.getText());
  	    System.out.println("");
  	} 
  	if (To_Date_errorMessage2.isDisplayed()) {
  		System.out.println("");
  	    System.out.println("Error Message For Test:1 " + To_Date_errorMessage2.getText());
  	    System.out.println("");
  	} 
  	if (To_Date_errorMessage3.isDisplayed()) {
  		System.out.println("");
  	    System.out.println("Error Message For Test:1 " + To_Date_errorMessage3.getText());
  	    System.out.println("");
  	} 
  	if (To_Date_errorMessage4.isDisplayed()) {
  		System.out.println("");
  	    System.out.println("Error Message For Test:1 " + To_Date_errorMessage4.getText());
  	    System.out.println("");
  	} 
  	
  	else {
  		
  	    System.out.println("No error message displayed.");
  	}
  	 
  	
  	  ---------------------------------
  	 // Method 2 
  	 List<WebElement> errorMessages = driver.findElements(By.xpath("//span[contains(text(), 'required.')]"));

  // Check if any error messages are displayed and print them
  if (errorMessages.size() > 0) {
      int testNumber = 1;  // Start from Test:1 and increment for each message
      for (WebElement errorMessage : errorMessages) {
          System.out.println("Error Message For Test:" + testNumber + ": " + errorMessage.getText());
          testNumber++;
      }
  } else {
      System.out.println("No error messages displayed.");
  }
 
  	
  	   //Method 3------------------------------
  	// Find all elements that contain the text 'required.' (error messages for "To Date")
  	 List<WebElement> To_Date_errorMessage1 = driver.findElements(By.xpath("//span[contains(text(), 'required.')]"));

  	 // Check if any error message is displayed
  	 if (To_Date_errorMessage1.size() > 0) {
  	     // Iterate over the list of error messages
  	     for (WebElement errorMessage : To_Date_errorMessage1) {
  	         // Check if the error message is displayed
  	         if (errorMessage.isDisplayed()) {
  	             System.out.println("Error Message For Test:1: " + errorMessage.getText());
  	         }
  	     }
  	 } else {
  	     System.out.println("No error message displayed.");
  	 }

  	 //All Liabrary methods----------------------------------------------------
  	  * 
public static void handle_dropdown(WebElement element,String name) {
		
		try {
			Select sel =new Select(element);
			sel.selectByVisibleText(name);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	public static void custom_Sendkeys(WebElement element , String Value , String FieldName) {
		try {
			element.sendKeys(Value);
		
			ObjectRepo.test.log(Status.PASS, FieldName+"==>"+Value);
			
			}
		catch(Exception e) {
			
			}
		}
	
	
	
	public static void custom_click(WebElement element, String FieldName) {
		try {
			element.click();
			
			ObjectRepo.test.log(Status.PASS, FieldName+"==>is Clickable..");
			
			  // Print a message confirming that the button was clicked
	        System.out.println(FieldName + " was clicked successfully!");
		}
		catch(Exception e)
		{
	  System.out.println(e.getMessage());		
      System.out.println();//Blank Print For space Between Error massage and another Error Massage
      System.out.println("Error: Failed to click on element " + FieldName + "' due to: " + e.getMessage());
      
    //  System.exit(1);//Terminate The Program
		}
	}
	
	public static void custom_click2(WebElement element, String FieldName) {
		try {
			element.click();
			
		//	ObjectRepo.test.log(Status.PASS, FieldName+"==>is Clickable..");
			
			  // Print a message confirming that the button was clicked
	        System.out.println(FieldName + " was clicked successfully!");
		}
		catch(Exception e)
		{
	  System.out.println(e.getMessage());		
      System.out.println();//Blank Print For space Between Error massage and another Error Massage
      System.out.println("Error: Failed to click on element " + FieldName + "' due to: " + e.getMessage());
      
      System.exit(500);//Terminate The Program
		}
	}
	
	
	public static void Mouse_Action_(WebElement element,WebDriver driver) {
	
		try {
			Actions action = new Actions(driver);
			action.moveToElement(element).build().perform();
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	
	public static void Mouse_click(WebElement element,WebDriver driver) {
		
		try {
			Actions action =new Actions(driver);
			action.moveToElement(element).click().build().perform();
		}
		catch(Exception e){
			System.out.println(e.getMessage());
          }
	      }
	
	
	public static void Scroll_to_Element(WebElement element,WebDriver driver) {
		try {
		 JavascriptExecutor jse1= (JavascriptExecutor)driver;
		 jse1.executeScript("arguments[0].scrollIntoView(true);", element);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());}
		}
	
	
	public static int get_decimal_removal(String Value) {
		int dotindex=Value.lastIndexOf(".");
		String str= Value.substring(0, dotindex);
		return Integer.parseInt(str);
	}
	
	
	public static void custom_clear(WebElement element) {
		try {
			element.clear();
			
			ObjectRepo.test.log(Status.PASS,"");
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());	
		}
	}
	
	public static void custom_clear_XPATH(WebDriver driver , String xpathLocator ) {
		try {
			  WebElement element = driver.findElement(By.xpath(xpathLocator));
			element.clear();
			
			ObjectRepo.test.log(Status.PASS,"");
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());	
		}
	}
	
	
	
	
	
	public static void compare_value(WebElement Actual , String expected) {
        try {
             SoftAssert s_assert = new SoftAssert();
             s_assert.assertEquals(Actual, expected);
  System.out.println("Assertion passed: Actual Value = " + Actual + " == Expected Value = " + expected);
           //  ObjectRepo.test.log(Status.PASS, Actual+"=="+expected);      
        }
        catch(Exception e) {
            //ObjectRepo.test.log(Status.FAIL, Actual+"=="+expected);
        }
	 
	}
	
	
	//Error Message For Normal Xpath Means every time we need to insert Xpath
	 public static void checkErrorMessageChangeble(WebDriver driver, String xpathLocator) {
	        try {
	            // Locate the error message element by XPath
	            WebElement errorMessage = driver.findElement(By.xpath(xpathLocator));

	            // Check if the error message is displayed
	            if (errorMessage.isDisplayed()) {
	                // Print the error message
	                System.out.println("Error: " + errorMessage.getText());
	            } else {
	                System.out.println("Login successful & no error message displayed.");
	            }
	        } catch (Exception e) {
	            // Handle the case where the error message element is not found
	            System.out.println("Error message element not found: " + e.getMessage());
	        }
	    }
	 
	 
//Error Message For Common Xpath
	public static void checkErrorMessageCommon(WebDriver driver, String xpathLocator) {
        try {
            // Locate the error message element by XPath
            WebElement errorMessage = driver.findElement(By.xpath("//div[@id='toast-container']"));

            // Check if the error message is displayed
            if (errorMessage.isDisplayed()) {
                // Print the error message
                System.out.println("Error: " + errorMessage.getText());
            } else {
                System.out.println("Login successful & no error message displayed.");
            }
        } catch (Exception e) {
            // Handle the case where the error message element is not found
            System.out.println("Error message element not found: " + e.getMessage());
        }
        
    }	
	
}

  	 
  	 
  	 
  	 
  	 
  	 
  	 
  	 
	
	*/
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
