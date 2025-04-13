package Com_Utility;

import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;
import com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.File;

public class Liabrary {
	
	// Ensure that the WebDriver is initialized before performing any actions
    public static void ensureDriverInitialized() {
        if (RSA_Base_Class_Login.driver == null) {
            throw new IllegalStateException("Driver is not initialized. Please ensure the driver is initialized in the BaseClass.");
        }
    }

public static void handle_dropdown(WebElement element,String name) {
		
		try {
			Select sel =new Select(element);
			sel.selectByVisibleText(name);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

public static void custom_Sendkeys_Config(WebElement element, String value, String fieldName) {
    try {
        element.sendKeys(value);
        
        // Mask the password in logs for security
        if (fieldName.toLowerCase().contains("password")) {
            ObjectRepo.test.log(Status.PASS, fieldName + " ==> ******");
        } else {
            ObjectRepo.test.log(Status.PASS, fieldName + " ==> " + value);
        }
    } catch (Exception e) {
        ObjectRepo.test.log(Status.FAIL, "Failed to enter value in " + fieldName + ": " + e.getMessage());
    }
}

public static void custom_Sendkeys(WebElement element, String value, String fieldName) {
    try {
        element.sendKeys(value);
        if (ObjectRepo.test != null) {
            ObjectRepo.test.log(Status.PASS, fieldName + " ==> " + value);
        } else {
            System.out.println("[INFO] " + fieldName + " ==> " + value);
        }
    } catch (Exception e) {
        if (ObjectRepo.test != null) {
            ObjectRepo.test.log(Status.FAIL, "Failed to enter value in " + fieldName + ": " + e.getMessage());
        } else {
            System.err.println("[ERROR] Failed to enter value in " + fieldName + ": " + e.getMessage());
        }
        throw e; // Optional: Rethrow to fail the test if needed
    }
}



	/*
	    // Combined custom click method with logging, screenshot capture, and exception handling
	    public static void custom_click(WebElement element, String fieldName) throws Exception {
	        try {
	            // Perform the click action
	            element.click();
	            
	            // Log the action to ExtentReport
	            ObjectRepo.test.log(Status.PASS, fieldName + " ==> is Clickable..");

	            // Print a message confirming that the button was clicked
	            System.out.println(fieldName + " was clicked successfully!");

	         /*   // Take a screenshot after the click
	            String screenshotPath = ObjectRepo.takeScreenshot();

	            // Add the screenshot to the report
	            ObjectRepo.test.addScreenCaptureFromPath(screenshotPath); 
	        } catch (Exception e) {
	            // Log failure and capture screenshot in case of exception
	            String screenshotPath = ObjectRepo.takeScreenshot();
	            ObjectRepo.test.fail("Error: Failed to click on element " + fieldName + " due to: " + e.getMessage());
	            ObjectRepo.test.addScreenCaptureFromPath(screenshotPath);

	            // Print the error message and the stack trace
	            System.out.println(e.getMessage());
	            System.out.println("Error: Failed to click on element " + fieldName + " due to: " + e.getMessage());

	            // Optionally, you can re-throw the exception to halt the test execution
	            throw e; // Re-throw the exception after logging
	        }
	    }
	*/

	
	
	
	
	/*
	public static void custom_click(WebElement element, String FieldName) throws IOException {
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
      
   // Log failure and capture screenshot in case of exception
   //   String screenshotPath = ObjectRepo.takeScreenshot("custom_click_fail");

      // Log the failure in the report
      ObjectRepo.test.fail("Failed to click on element: " + e.getMessage());

      // Add the screenshot to the report
     // ObjectRepo.test.addScreenCaptureFromPath(screenshotPath);
    //  System.exit(1);//Terminate The Program
		}
	} */
	
   public static void custom_click(WebElement element, String fieldName) {
    try {
        element.click();

        if (ObjectRepo.test != null) {
            ObjectRepo.test.log(Status.PASS, fieldName + " ==> Clicked Successfully");
        }

        System.out.println(fieldName + " was clicked successfully!");

    } catch (Exception e) {
        System.out.println("Error: Failed to click on " + fieldName + " due to: " + e.getMessage());

        if (ObjectRepo.test != null) {
            ObjectRepo.test.log(Status.FAIL, fieldName + " ==> Click Failed. Error: " + e.getMessage());

            String base64Screenshot = ObjectRepo.captureScreenshotBase64();
            ObjectRepo.test.addScreenCaptureFromBase64String(base64Screenshot, "Failure Screenshot");
        }

        System.out.println(fieldName + " was NOT clicked");
    }
}


	


	
/*
	// Method to capture a screenshot
	public static String captureScreenshot(String screenshotName) throws IOException {
	    // Get the WebDriver instance from the ObjectRepo or directly use driver
	    TakesScreenshot screenshot = (TakesScreenshot) ObjectRepo.driver;
	    
	    // Take a screenshot
	    java.io.File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
	    
	    // Define the path where the screenshot will be saved
	    String screenshotPath = System.getProperty("user.dir") + "/test-output/screenshots/" + screenshotName + ".png";
	    
	    // Copy the screenshot to the destination path
	    FileUtils.copyURLToFile(srcFile, new File(screenshotPath));
	    
	    return screenshotPath;
	}

*/

	

		// Custom click method with logging and screenshot
	    public static void custom_click_For_Report(WebElement element, String description) throws Exception {
	        try {
	            // Perform the click action
	            element.click();

	            // Log the action to ExtentReport
	            ObjectRepo.test.log(Status.INFO, description);

	        } catch (Exception e) {
	            
	            // Log the failure in the report
	            ObjectRepo.test.fail("Failed to click on element: " + e.getMessage());

	            // Re-throw the exception after logging
	            throw e;
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
			
			ObjectRepo.test.log(Status.PASS," Clear The Field ");
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
	
	
   //Print_Dynamic_Error_Massage. Print all Error massage in one single method when we call
	public static void Print_Dynamic_Error_Massage(WebDriver driver, String xpathLocator,String Test_Case_Number) {
	    try {
	        // Find all elements that contain the text 'required.' (error messages for "Dropdown")
	        List<WebElement> errorMessageList = driver.findElements(By.xpath(xpathLocator));

	        // Check if any error message is displayed
	        if (errorMessageList.size() > 0) {
	            // Iterate over the list of error messages
	            for (WebElement errorMessage : errorMessageList) {
	                // Check if the error message is displayed
	                if (errorMessage.isDisplayed()) {
	                	System.out.println("");
	                    System.out.println("Error Message Print: " + errorMessage.getText());
	                	System.out.println (Test_Case_Number);
	                	
	                }
	            }
	        } else {
	            System.out.println("No error message displayed.");
	        }
	    }
	    catch (Exception e) {
	        // Catch any other exception that might occur
	        System.err.println("An unexpected error occurred: " + e.getMessage());
	        e.printStackTrace();
	    }
	    }
	
	
	
	    /*
	    catch (NoSuchElementException e) {
	        System.out.println("No such element found for the provided XPath: " + xpathLocator);
	        e.printStackTrace();
	    } catch (StaleElementReferenceException e) {
	        System.out.println("The error message element is no longer attached to the DOM.");
	        e.printStackTrace();
	    } catch (TimeoutException e) {
	        System.out.println("The operation timed out while trying to find the element.");
	        e.printStackTrace(); 
	     catch (Exception e) {
	        // Catch any other exception that might occur
	        System.err.println("An unexpected error occurred: " + e.getMessage());
	        e.printStackTrace();
	    }
	}          */
                                
	
	
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
