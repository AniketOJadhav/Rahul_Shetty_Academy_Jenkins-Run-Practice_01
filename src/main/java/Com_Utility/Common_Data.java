package Com_Utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Common_Data {

	//we can add common data path locators in this class
	WebDriver driver;
	
	@FindBy(how = How.XPATH, using = "//*[@Class='btn-custom']")
	private WebElement Upload_Btn;
	
	@FindBy(how = How.XPATH, using = "//*[@id='ParentMasterContentPlaceHolder1_btnEdit']")
	private WebElement View_Btn;
	


	public WebElement getUpload_Btn() {
		return Upload_Btn;
	}

	public WebElement getView_Btn() {
		return View_Btn;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
