package Com.Login_Main;



import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Login_Register_Main {

    @FindBy(how = How.XPATH, using = "//a[@class='btn1' and text()='Register']")
    private WebElement Register_Button;

    @FindBy(how = How.XPATH, using = "//input[@id='firstName']")
    private WebElement FirstName_Textbox;

    @FindBy(how = How.XPATH, using = "//input[@id='lastName']")
    private WebElement LastName_Textbox;

    @FindBy(how = How.XPATH, using = "//input[@id='userEmail']")
    private WebElement Email_Textbox;

    @FindBy(how = How.XPATH, using = "//input[@id='userMobile']")
    private WebElement PhoneNumber_Textbox;

    @FindBy(how = How.XPATH, using = "//select[@formcontrolname='occupation']")
    private WebElement Occupation_Dropdown;

    @FindBy(how = How.XPATH, using = "//input[@value='Male']")
    private WebElement GenderMale_Radio_Button;

    @FindBy(how = How.XPATH, using = "//input[@value='Female']")
    private WebElement GenderFemale_Radio_Button;

    @FindBy(how = How.XPATH, using = "//input[@id='userPassword']")
    private WebElement Password_Textbox;

    @FindBy(how = How.XPATH, using = "//input[@id='confirmPassword']")
    private WebElement ConfirmPassword_Textbox;

    @FindBy(how = How.XPATH, using = "//input[@type='checkbox']")
    private WebElement AgeCheckbox;

    @FindBy(how = How.XPATH, using = "//input[@id='login']")
    private WebElement SubmitRegisterButton;

    // Optionally: add getters if you're accessing elements in your test methods

    public WebElement getRegister_Button() {
        return Register_Button;
    }

    public WebElement getFirstName_Textbox() {
        return FirstName_Textbox;
    }

    public WebElement getLastName_Textbox() {
        return LastName_Textbox;
    }

    public WebElement getEmail_Textbox() {
        return Email_Textbox;
    }

    public WebElement getPhoneNumber_Textbox() {
        return PhoneNumber_Textbox;
    }

    public WebElement getOccupation_Dropdown() {
        return Occupation_Dropdown;
    }

    public WebElement getGenderMale_Radio_Button() {
        return GenderMale_Radio_Button;
    }

    public WebElement getGenderFemale_Radio_Button() {
        return GenderFemale_Radio_Button;
    }

    public WebElement getPassword_Textbox() {
        return Password_Textbox;
    }

    public WebElement getConfirmPassword_Textbox() {
        return ConfirmPassword_Textbox;
    }

    public WebElement getAgeCheckbox() {
        return AgeCheckbox;
    }

    public WebElement getSubmitRegisterButton() {
        return SubmitRegisterButton;
    }
}
