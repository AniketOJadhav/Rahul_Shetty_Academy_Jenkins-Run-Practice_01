package Com_Utility;

import java.io.File;
import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ObjectRepo {

    public static ExtentReports extent;
    public static ExtentTest test;
    public static WebDriver driver;

    // ✅ Initialize WebDriver only if not already
    public static void initializeDriverIfNeeded() {
        if (driver == null) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.manage().window().maximize();
            System.out.println("WebDriver initialized.");
        }
    }

    // ✅ Initialize Extent Report
    public static ExtentReports initializeReport() {
        if (extent == null) {
            String reportFolderPath = System.getProperty("user.dir") + File.separator + "test-output" + File.separator + "Extent_Reports" + File.separator;
            File reportDir = new File(reportFolderPath);
            if (!reportDir.exists()) {
                reportDir.mkdirs();
            }

            ExtentSparkReporter reporter = new ExtentSparkReporter(reportFolderPath + "TestReport.html");
            reporter.config().setDocumentTitle("Test Execution Report");
            reporter.config().setReportName("Automation Test Report For RSA Jenkins Run");
            reporter.config().setTheme(Theme.DARK);

            extent = new ExtentReports();
            extent.attachReporter(reporter);
            extent.setSystemInfo("Browser Name", "Chrome_Version");
            extent.setSystemInfo("Automation Test Engineer", "Aniket Jadhav");
            extent.setSystemInfo("Environment", "QA Automation Environment");
        }

        return extent;
    }

    public static void startTest(String testName, String testDescription) {
        test = extent.createTest(testName, testDescription);
    }

    
    
    public static void startTestAndLog_1(String testNumber, String testDescription) {
        test = extent.createTest(testNumber, testDescription);
    }

    /*
    public static void startTestAndLog_1_SS(String testNumber, String testDescription) {
        test = extent.createTest(testNumber, testDescription);
        try {
            String encodedScreenshot = takeScreenshot();
            if (encodedScreenshot != null && !encodedScreenshot.isEmpty()) {
                test.info(testDescription + " - Screenshot Captured");
                test.addScreenCaptureFromBase64String(encodedScreenshot);
            } else {
                test.fail("Screenshot could not be captured.");
            }
        } catch (IOException e) {
            e.printStackTrace();
            test.fail("Error while capturing screenshot: " + e.getMessage());
        }
    }
    
    public static void startTestAndLog_1_SS(String testNumber, String testDescription, Runnable action) {
        // Start the test
        test = extent.createTest(testNumber, testDescription);

        try {
            // Perform the test action
            action.run();

            // Capture screenshot after successful execution
            String encodedScreenshot = takeScreenshot();
            test.pass(testDescription + " - Step Passed");

            if (encodedScreenshot != null && !encodedScreenshot.isEmpty()) {
                test.addScreenCaptureFromBase64String(encodedScreenshot, "Screenshot - Passed");
            } else {
                test.warning("Screenshot could not be captured.");
            }

        } catch (Exception e) {
            // Capture screenshot on failure
            String encodedScreenshot = null;
            try {
                encodedScreenshot = takeScreenshot();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }

            test.fail(testDescription + " - Step Failed: " + e.getMessage());
            if (encodedScreenshot != null && !encodedScreenshot.isEmpty()) {
                test.addScreenCaptureFromBase64String(encodedScreenshot, "Screenshot - Failed");
            }

            throw new RuntimeException(e); // Rethrow to fail the test
        }
    }
    */
//When Driver Not Initialised Problem Occours..only capture a screenshot if driver is initialized method Refurbished thats why i put name same-->
     public static void startTestAndLog_1_SS(String testNumber, String testDescription, Runnable action) {
        // Start the test
        test = extent.createTest(testNumber, testDescription);

        try {
            // Perform the test action
            action.run();
            test.pass(testDescription + " - Step Passed");

            // Capture screenshot only if driver is initialized
            if (driver != null) {
                String encodedScreenshot = takeScreenshot();
                if (encodedScreenshot != null && !encodedScreenshot.isEmpty()) {
                    test.addScreenCaptureFromBase64String(encodedScreenshot, "Screenshot - Passed");
                } else {
                    test.warning("Screenshot could not be captured.");
                }
            } else {
                test.info("Driver not initialized — screenshot skipped.");
            }

        } catch (Exception e) {
            test.fail(testDescription + " - Step Failed: " + e.getMessage());

            // Capture screenshot only if driver is initialized
            if (driver != null) {
                try {
                    String encodedScreenshot = takeScreenshot();
                    if (encodedScreenshot != null && !encodedScreenshot.isEmpty()) {
                        test.addScreenCaptureFromBase64String(encodedScreenshot, "Screenshot - Failed");
                    } else {
                        test.warning("Screenshot could not be captured on failure.");
                    }
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                    test.warning("Screenshot capture failed with IOException.");
                }
            } else {
                test.info("Driver not initialized — failure screenshot skipped.");
            }

            throw new RuntimeException(e); // Rethrow to fail the test
        }
    }
    
    

    public static void startTestAndLog_2(String testNumber, String testDescription) {
        test = extent.createTest(testNumber, testDescription);
        test.log(Status.INFO, testDescription);
        
    }

    
    
    public static void AssertTextAndLog(String actualText, String expectedText) throws Exception {
        try {
            Assert.assertEquals(actualText, expectedText);
            test.log(Status.PASS, "| Expected: " + expectedText + " | Actual: " + actualText);
        } catch (AssertionError e) {
            test.fail(" | Expected: " + expectedText + " | Actual: " + actualText);
            String screenshotPath = takeScreenshot();
            test.addScreenCaptureFromPath(screenshotPath);
            throw e;
        }
        
    }
    
    

    public static void logTestResult(String testName, String testDescription, boolean isTestPassed, String additionalInfo) {
        startTest(testName, testDescription);
        if (isTestPassed) {
            test.pass(additionalInfo);
        } else {
            test.fail(additionalInfo);
        }
    }

    public static void Print_Dynamic_Error_Massage(WebDriver driver, String xpathLocator, String testNumber_Print_Massage) {
    	
        try {
        	
            test = extent.createTest(testNumber_Print_Massage);
            List<WebElement> errorMessageList = driver.findElements(By.xpath(xpathLocator));
            if (!errorMessageList.isEmpty()) {
                for (WebElement errorMessage : errorMessageList) {
                    if (errorMessage.isDisplayed()) {
                        String errorText = errorMessage.getText();
                        System.out.println("Error Message Print: " + errorText);
                        System.out.println("Test Case Number: " + testNumber_Print_Massage);
                        test.pass("  Error Massage: " + errorText);
                        logTestWithScreenshot("Error captured for  " + testNumber_Print_Massage);
                    }
                }
            } else {
                System.out.println("No error message displayed.");
            }
        } catch (Exception e) {
            System.err.println("An unexpected error occurred: " + e.getMessage());
            e.printStackTrace();
            test.fail("An unexpected error occurred: " + e.getMessage());
        }
        
    }
    
    

    public static String takeScreenshot() throws IOException {
        // Ensure the WebDriver is initialized
        if (driver == null) {
            throw new IllegalStateException("Driver is not initialized.");
        }

        // Take screenshot and store it in a temporary file
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        // Convert the screenshot file to a byte array
        byte[] fileContent = FileUtils.readFileToByteArray(srcFile);

        // Convert the byte array to a Base64 encoded string
        return Base64.getEncoder().encodeToString(fileContent);
    }

    public static void logTestWithScreenshot(String logMessage) {
        try {
            String encodedScreenshot = takeScreenshot();
            if (encodedScreenshot != null && !encodedScreenshot.isEmpty()) {
                test.info(logMessage + " ==>Screenshot Captured");
                test.addScreenCaptureFromBase64String(encodedScreenshot);
            } else {
                test.fail("Screenshot could not be captured.");
            }
        } catch (IOException e) {
            e.printStackTrace();
            test.fail("Error while capturing screenshot: " + e.getMessage());
        }
    }

    public static void finalizeReport() {
        if (extent != null) {
            extent.flush();
        }
        System.out.println("✅ Extent Report flushed successfully...");

        try {
            String reportPath = System.getProperty("user.dir") + "/test-output/Extent_Reports/TestReport.html";
            File reportFile = new File(reportPath);
            if (!reportFile.exists()) {
                System.out.println("❌ Report file not found at: " + reportPath);
                return;
            }
            Thread.sleep(5000);
            Demo_Mail.sendReportEmail();
        } catch (Exception e) {
            System.out.println("❌ Failed to send email: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @AfterClass
    public static void finalizeReportAfterClass() {
        finalizeReport();
    }

    public static ExtentReports extentreport() {
        return null;
    }
} 
