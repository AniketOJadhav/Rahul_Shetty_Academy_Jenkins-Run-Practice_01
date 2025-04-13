package Com_Utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomePage {

	
WebDriver driver;
	
	@FindBy(how = How.XPATH, using = "//p[normalize-space()='Dashboard']")
	private WebElement Dashboard_Menu;
	
	@FindBy(how = How.XPATH, using = "//p[normalize-space()='Activity']")
	private WebElement Activity_Menu;
	
	@FindBy(how = How.XPATH, using = "//p[normalize-space()='Activity Master']")
	private WebElement ActivityMaster_SubMenu;
	
	@FindBy(how = How.XPATH, using = "//p[normalize-space()='Media']")
	private WebElement Media_SubMenu;
	
	@FindBy(how = How.XPATH, using = "//p[normalize-space()='Notification Master']")
	private WebElement NotificationMaster_SubMenu;
	
	@FindBy(how = How.XPATH, using = "//p[normalize-space()='Master']")
	private WebElement Master_Menu;
	
	@FindBy(how = How.XPATH, using = "//p[normalize-space()='Distributor Master']")
	private WebElement DistributorMaster_SubMenu;
	
	@FindBy(how = How.XPATH, using = "//p[normalize-space()='Account Master']")
	private WebElement AccountMaster_SubMenu;
	
	@FindBy(how = How.XPATH, using = "(//p[contains(text(),'FSG Master')])[1]")
	private WebElement FSGMaster_SubMenu;
	
	@FindBy(how = How.XPATH, using = "//p[text()='Outlet Master']")
	private WebElement DealerMaster_SubMenu;
	
	@FindBy(how = How.XPATH, using = "(//p[contains(text(),'Route Master')])[1]")
	private WebElement RouteMaster_SubMenu;
	
	@FindBy(how = How.XPATH, using = "(//p[contains(text(),'User Master')])[1]")
	private WebElement UserMaster_SubMenu;
	
	@FindBy(how = How.XPATH, using = "(//p[contains(text(),'Product Master')])[1]")
	private WebElement ProductMaster_SubMenu;
	
	
	@FindBy(how = How.XPATH, using = "//p[normalize-space()='Settings']")
	private WebElement Settings_Menu;
	
	@FindBy(how = How.XPATH, using = "//p[text()='Configurations']")
	private WebElement Configurations_SubMenu;
	
	@FindBy(how = How.XPATH, using = "//a[@href='#']//p[text()='Scheme']")
	private WebElement Scheme_Menu;
	
	@FindBy(how = How.XPATH, using = "//p[normalize-space()='Scheme Setup']")
	private WebElement Scheme_Setup_SubMenu;
	
	@FindBy(how = How.XPATH, using = "//p[normalize-space()='Reports']")
	private WebElement Reports_Menu;
	
	@FindBy(how = How.XPATH, using = "//a[@href='#']//p[contains(text(),'Activity Report')]")
	private WebElement Activity_Report_SubMenu;
	
	@FindBy(how = How.XPATH, using = "(//p[contains(text(),'Inventory')])[1]")
	private WebElement Inventory_Report_SubMenu;
	
	@FindBy(how = How.XPATH, using = "//p[normalize-space()='Order Report']")
	private WebElement Order_Report_SubMenu;
	
	@FindBy(how = How.XPATH, using = "//p[normalize-space()='Other Reports']")
	private WebElement Other_Report_SubMenu;
	
	@FindBy(how = How.XPATH, using = "//p[normalize-space()='Performance Report']")
	private WebElement Performance_Report_SubMenu;
	
	@FindBy(how = How.XPATH, using = "//p[normalize-space()='Redemption Report']")
	private WebElement Redumption_Report_SubMenu;
	
	@FindBy(how = How.XPATH, using = "//p[normalize-space()='Sales Report']")
	private WebElement Sales_Report_SubMenu;
	
	@FindBy(how = How.XPATH, using = "//p[normalize-space()='Scheme Report']")
	private WebElement Scheme_Report_SubMenu;

	public WebElement getDashboard_Menu() {
		return Dashboard_Menu;
	}

	public WebElement getActivity_Menu() {
		return Activity_Menu;
	}

	public WebElement getActivityMaster_SubMenu() {
		return ActivityMaster_SubMenu;
	}

	public WebElement getMedia_SubMenu() {
		return Media_SubMenu;
	}

	public WebElement getNotificationMaster_SubMenu() {
		return NotificationMaster_SubMenu;
	}

	public WebElement getMaster_Menu() {
		return Master_Menu;
	}

	public WebElement getDistributorMaster_SubMenu() {
		return DistributorMaster_SubMenu;
	}

	public WebElement getAccountMaster_SubMenu() {
		return AccountMaster_SubMenu;
	}

	public WebElement getFSGMaster_SubMenu() {
		return FSGMaster_SubMenu;
	}

	public WebElement getDealerMaster_SubMenu() {
		return DealerMaster_SubMenu;
	}

	public WebElement getRouteMaster_SubMenu() {
		return RouteMaster_SubMenu;
	}

	public WebElement getUserMaster_SubMenu() {
		return UserMaster_SubMenu;
	}

	public WebElement getProductMaster_SubMenu() {
		return ProductMaster_SubMenu;
	}

	public WebElement getSettings_Menu() {
		return Settings_Menu;
	}

	public WebElement getConfigurations_SubMenu() {
		return Configurations_SubMenu;
	}

	public WebElement getScheme_Menu() {
		return Scheme_Menu;
	}

	public WebElement getScheme_Setup_SubMenu() {
		return Scheme_Setup_SubMenu;
	}

	public WebElement getReports_Menu() {
		return Reports_Menu;
	}

	public WebElement getActivity_Report_SubMenu() {
		return Activity_Report_SubMenu;
	}

	public WebElement getInventory_Report_SubMenu() {
		return Inventory_Report_SubMenu;
	}

	public WebElement getOrder_Report_SubMenu() {
		return Order_Report_SubMenu;
	}

	public WebElement getOther_Report_SubMenu() {
		return Other_Report_SubMenu;
	}

	public WebElement getPerformance_Report_SubMenu() {
		return Performance_Report_SubMenu;
	}

	public WebElement getRedumption_Report_SubMenu() {
		return Redumption_Report_SubMenu;
	}

	public WebElement getSales_Report_SubMenu() {
		return Sales_Report_SubMenu;
	}

	public WebElement getScheme_Report_SubMenu() {
		return Scheme_Report_SubMenu;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
