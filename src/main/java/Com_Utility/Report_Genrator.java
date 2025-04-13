

package Com_Utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Report_Genrator {

  // Declare static variables for ExtentReports and WebDriver
    public static ExtentReports extent;
    public static ExtentTest test;
    public static WebDriver driver;
	public static Object startTest;

    // Method to initialize ExtentReports
    public static ExtentReports initializeReport() {
        // Define the path for the report to be saved
        String reportFolderPath = System.getProperty("user.dir") + File.separator + "test-output" + File.separator + "Extent_Reports" + File.separator;

        // Create the folder if it doesn't exist
        File reportDir = new File(reportFolderPath);
        if (!reportDir.exists()) {
            reportDir.mkdirs(); // Create the directory if it doesn't exist
        }

        // Create an ExtentSparkReporter and provide the path where the report will be saved
        ExtentSparkReporter reporter = new ExtentSparkReporter(reportFolderPath + "TestReport.html");
        reporter.config().setDocumentTitle("Test Execution Report");
        reporter.config().setReportName("Automation Test Report For Fosroc_HO");
        reporter.config().setTheme(Theme.DARK);  // Use a dark theme for the report

        // Initialize ExtentReports instance and attach the reporter
        extent = new ExtentReports();
        extent.attachReporter(reporter);

        // Set system information to display in the report
        extent.setSystemInfo("Browser Name", "Chrome");
        extent.setSystemInfo("QA Name", " Aniket Jadhav");
        extent.setSystemInfo("Environment", "QA Environment");

        return extent;  // Return the instance of ExtentReports
    }

    // Method to start a test case in ExtentReports (needed for logging)
    public static void startTest(String testName, String testDescription) {
        // Start the test in ExtentReports
      test = extent.createTest(testName, testDescription);
    }
    

        // Method 1: to start the test and log the step
    public static void startTestAndLog_1(String testNumber, String testDescription ) { //,String logMessage) {
            // Start the test
       test = extent.createTest(testNumber, testDescription);            
            // Log the message
         // test.log(Status.INFO, logMessage);
        }
        
        // Existing methods like startTest, finalizeReport, etc.
    
     public static void startTestAndLog_1_SS(String testNumber, String testDescription) {
            // Start the test
       test = extent.createTest(testNumber, testDescription);  
            
            // Capture a screenshot automatically after starting the test
            try {
                String encodedScreenshot = takeScreenshot();  // Capture screenshot as Base64
                if (encodedScreenshot != null && !encodedScreenshot.isEmpty()) {
                    // Attach screenshot to Extent Report in Base64 format
                    test.info(testDescription + " - Screenshot Captured");
                    test.addScreenCaptureFromBase64String(encodedScreenshot);
                } else {
                    test.fail("Screenshot could not be captured.");
                }
            }
            catch (IOException e) {
                e.printStackTrace();
                test.fail("Error while capturing screenshot: " + e.getMessage());
            }
        }

        
        
        
        //Method 2:
        
        // Method 1: to start the test and log the step
      public static void startTestAndLog_2(String testNumber, String testDescription) {
            // Start the test
        test = extent.createTest(testNumber, testDescription);            
            // Log the message
        test.log(Status.INFO,testDescription);
        }

        // Existing methods like startTest, finalizeReport, etc.
    
      
     // Utility method for asserting text and logging the result
      public static void AssertTextAndLog(String actualText, String expectedText) throws Exception {
            try {
                // Assert that the actual text matches the expected text
                Assert.assertEquals(actualText, expectedText);

                // If assertion passes, log the success in the report
                
            //    ObjectRepo.test.log(Status.PASS, testNumber + " - " + logMessage + " | Expected: " + expectedText + " | Actual: " + actualText);
                Report_Genrator.test.log(Status.PASS," | Expected: " + expectedText + " | Actual: " + actualText); 
                
            } catch (AssertionError e) {
                // If assertion fails, log the failure in ExtentReport
               // ObjectRepo.test.fail(testNumber + " - " + logMessage + " | Expected: " + expectedText + " | Actual: " + actualText);
                Report_Genrator.test.fail(" | Expected: " + expectedText + " | Actual: " + actualText);
                
                // Optionally take a screenshot and attach it to the report
                String screenshotPath = Report_Genrator.takeScreenshot();
                Report_Genrator.test.addScreenCaptureFromPath(screenshotPath);

                // Rethrow the exception to mark the test as failed
                throw e; // Re-throw the AssertionError to indicate the failure
            }
        }
        
        
        public static void Print_Dynamic_Error_Massage(WebDriver driver, String xpathLocator, String testNumber_Print_Massage) {
            try {
            	// Start the test
                test = extent.createTest(testNumber_Print_Massage);
                // Find all elements that contain the error message
                List<WebElement> errorMessageList = driver.findElements(By.xpath(xpathLocator));

                // Check if any error message is displayed
                if (errorMessageList.size() > 0) {
                    // Iterate over the list of error messages
                    for (WebElement errorMessage : errorMessageList) {
                        // Check if the error message is displayed
                        if (errorMessage.isDisplayed()) {
                            String errorText = errorMessage.getText();

                            // Log the error message in the console
                            System.out.println("Error Message Print: " + errorText);
                            System.out.println("Test Case Number: " +testNumber_Print_Massage);

                            // Log the error message into Extent Report
                            Report_Genrator.test.pass("  Error Massage: " + errorText);
                          /*  
                            // Log any additional message (optional)
                            if (logMessage != null && !logMessage.isEmpty()) {
                                ObjectRepo.test.info(logMessage);
                            } */  //add this string in method name for additional log massage
                            // public static void Print_Dynamic_Error_Massage(WebDriver driver, String xpathLocator, String Test_Case_Number, String logMessage)

                            // Optionally capture and log the screenshot as well
                            logTestWithScreenshot("Error captured for  " + testNumber_Print_Massage);
                        }
                    }
                } 
                else 
                {
                    // If no error message is found, log that information
                    System.out.println("No error message displayed.");
                }
            } 
            catch (Exception e)
            {
                // Catch any other exception that might occur
                System.err.println("An unexpected error occurred: " + e.getMessage());
                e.printStackTrace();
                Report_Genrator.test.fail("An unexpected error occurred: " + e.getMessage());
            }
        }

        
        
        

    // Method to log test result
    public static void logTestResult(String testName, String testDescription, boolean isTestPassed, String additionalInfo) {
        startTest(testName, testDescription);
        if (isTestPassed) {
            test.pass(additionalInfo);
        } else {
            test.fail(additionalInfo);
        }
    }

    public static String takeScreenshot() throws IOException {
        if (RSA_Base_Class_Login.driver == null) {
            throw new IllegalStateException("Driver is not initialized.");
        }

        // Take screenshot
        File srcFile = ((TakesScreenshot) RSA_Base_Class_Login.driver).getScreenshotAs(OutputType.FILE);

        // Convert the screenshot to Base64 encoding (without saving it to disk)
        byte[] fileContent = FileUtils.readFileToByteArray(srcFile);
        String encodedScreenshot = Base64.getEncoder().encodeToString(fileContent);

        return encodedScreenshot;  // Return Base64 encoded screenshot
    }

    public static void logTestWithScreenshot(String logMessage) {
        try {
            // Capture the screenshot as Base64
            String encodedScreenshot = takeScreenshot();

            // Log the message and attach the screenshot to the Extent Report
            if (encodedScreenshot != null && !encodedScreenshot.isEmpty()) {
                // Attach screenshot to Extent Report in Base64 format
                test.info(logMessage +"==>Screenshot Captured");
                test.addScreenCaptureFromBase64String(encodedScreenshot);
            } else {
                test.fail("Screenshot could not be captured.");
            }
        }
        catch (IOException e) {
            e.printStackTrace();
            test.fail("Error while capturing screenshot: " + e.getMessage());
        }
    }
    
    
    //Finalize Report 
    public static void finalizeReport() {
        if (extent != null) {
            extent.flush();
        }
        System.out.println("Extent Report flushed successfully...");

        try {
            // Send email with attached report
            String reportPath = System.getProperty("user.dir") + "/test-output/Extent_Reports/TestReport.html";
            Demo_Mail.sendReportEmail(reportPath);
        } catch (Exception e) {
            System.out.println("Failed to send email: " + e.getMessage());
        }
    }


    // Optional: You can use @AfterClass annotation to finalize the report after each test class
    @AfterClass
    public static void finalizeReportAfterClass() {
        finalizeReport();  // Flush the report after all tests in this class are executed
    }

	

	public static ExtentReports extentreport() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
