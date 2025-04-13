package Com_Utility;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class Listners  extends RSA_Base_Class_Login implements ITestListener {

	 
	
	//Report_Genrator extent1 = new Report_Genrator();
	ObjectRepo extent1 = new ObjectRepo ();
		ExtentReports extent=ObjectRepo.extentreport();
		ThreadLocal<ExtentTest> extenttest=new ThreadLocal<ExtentTest>();
		
		public void onTestStart(ITestResult result) {
			ObjectRepo.test=extent.createTest(result.getTestClass().getName()+"=="+result.getMethod().getMethodName());
			extenttest.set(ObjectRepo.test);
		}
		public void onTestSuccess(ITestResult result) {
			ObjectRepo.test.log(Status.PASS, "Test case is pass");
			

			String src=((TakesScreenshot)driver).getScreenshotAs(OutputType.BASE64);
			ObjectRepo.test.addScreenCaptureFromBase64String(src);
		}
		public void onTestFailure(ITestResult result) {
			
			ObjectRepo.test.log(Status.FAIL, "Test case is fail");
			
				
		    String src=((TakesScreenshot)driver).getScreenshotAs(OutputType.BASE64);
			ObjectRepo.test.addScreenCaptureFromBase64String(src);
			
				
			
			
		}
		public void onTestSkipped(ITestResult result) {
			ObjectRepo.test.log(Status.SKIP, "Test case is skip");
		}	
		public void onFinish(ITestContext context) {
			extent.flush();
		}
		
		
		
	}
	
	
	

