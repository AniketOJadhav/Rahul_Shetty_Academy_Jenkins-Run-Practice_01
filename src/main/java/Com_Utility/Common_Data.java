package Com_Utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Common_Data {

	
	WebDriver driver;
	
	@FindBy(how = How.XPATH, using = "//*[@Class='btn-custom']")
	private WebElement Upload_Btn;
	
	@FindBy(how = How.XPATH, using = "//*[@id='ParentMasterContentPlaceHolder1_btnEdit']")
	private WebElement View_Btn;
	
	@FindBy(how = How.XPATH, using = "//*[@id='btnadd']")
	private WebElement Add_Btn;
	
	@FindBy(how = How.XPATH, using = "//input[@id='ParentMasterContentPlaceHolder1_btnSave']")
	private WebElement Save_Btn;
	
	@FindBy(how = How.XPATH, using = "//input[@id='ParentMasterContentPlaceHolder1_btnClose']")
	private WebElement Close_Btn;
	
	@FindBy(how = How.XPATH, using = "//input[@id='ParentMasterContentPlaceHolder1_Savebtn']")
	private WebElement SentNotification_Btn;
	
	@FindBy(how = How.XPATH, using = "//input[@id='ParentMasterContentPlaceHolder1_BtnApproval']")
	private WebElement Approval_Btn;
	
	@FindBy(how = How.XPATH, using = "//input[@id='ParentMasterContentPlaceHolder1_Button1']")
	private WebElement Edit_Btn;
	
	@FindBy(how = How.XPATH, using = "//*[@id='ParentMasterContentPlaceHolder1_UploadUserControl_UploadButton']")
	private WebElement SelectFileToUpload_Btn;
	
	@FindBy(how = How.XPATH, using = "//*[@id='ParentMasterContentPlaceHolder1_UploadUserControl_Button3']")
	private WebElement UploadNow_Btn;
	
	@FindBy(how = How.XPATH, using = "//input[@id='ParentMasterContentPlaceHolder1_Button3']")
	private WebElement Search_Btn;
	
	@FindBy(how = How.XPATH, using = "//input[@id='ParentMasterContentPlaceHolder1_btnTransfer']")
	private WebElement Transfer_Btn;
	
	@FindBy(how = How.XPATH, using = "//input[@id='ParentMasterContentPlaceHolder1_btnApprove']")
	private WebElement Approve_Btn;
	
	@FindBy(how = How.XPATH, using = "//*[@id='ParentMasterContentPlaceHolder1_UploadUserControl_lnkDownload']")
	private WebElement Download_Template;

	public WebElement getUpload_Btn() {
		return Upload_Btn;
	}

	public WebElement getView_Btn() {
		return View_Btn;
	}

	public WebElement getAdd_Btn() {
		return Add_Btn;
	}

	public WebElement getSave_Btn() {
		return Save_Btn;
	}

	public WebElement getClose_Btn() {
		return Close_Btn;
	}

	public WebElement getSentNotification_Btn() {
		return SentNotification_Btn;
	}

	public WebElement getApproval_Btn() {
		return Approval_Btn;
	}

	public WebElement getEdit_Btn() {
		return Edit_Btn;
	}

	public WebElement getSelectFileToUpload_Btn() {
		return SelectFileToUpload_Btn;
	}

	public WebElement getUploadNow_Btn() {
		return UploadNow_Btn;
	}

	public WebElement getSearch_Btn() {
		return Search_Btn;
	}

	public WebElement getTransfer_Btn() {
		return Transfer_Btn;
	}

	public WebElement getApprove_Btn() {
		return Approve_Btn;
	}

	public WebElement getDownload_Template() {
		return Download_Template;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
