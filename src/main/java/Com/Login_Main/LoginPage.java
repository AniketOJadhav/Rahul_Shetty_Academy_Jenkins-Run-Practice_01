package Com.Login_Main;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {

WebDriver driver;


	@FindBy(how = How.XPATH, using = "//input[@id='userEmail']")
	private WebElement UserName;
	
	@FindBy(how = How.XPATH, using = "//*[@id='userPassword']")
	private WebElement Password;
	
	@FindBy(how = How.XPATH, using = "//input[@id='login']")
	private WebElement Login_Btn;
	
	@FindBy(how = How.XPATH, using = "//div[@id='toast-container']")
	private WebElement Wrong_UserID_And_Password_ErrorMassage;
	
	@FindBy(how = How.XPATH, using = "//a[@id='forgotResetLink']")
	private WebElement Forget_Password;
	
	@FindBy(how = How.XPATH, using = "//input[@id='txtusername']")
	private WebElement Forget_Password_UserName_TXTBOX;
	
	@FindBy(how = How.XPATH, using = "//input[@id='btnLogin']")
	private WebElement Send_Verification_Link;
	
	public WebElement getUserName() {
		return UserName;
	}

	public WebElement getPassword() {
		return Password;
	}

	public WebElement getLogin_Btn() {
		return Login_Btn;
	}

	public WebElement getWrong_UserID_And_Password_ErrorMassage() {
		return Wrong_UserID_And_Password_ErrorMassage;
	}

	public WebElement getForget_Password() {
		return Forget_Password;
	}

	public WebElement getForget_Password_UserName_TXTBOX() {
		return Forget_Password_UserName_TXTBOX;
	}

	public WebElement getSend_Verification_Link() {
		return Send_Verification_Link;
	}
	
	
}
