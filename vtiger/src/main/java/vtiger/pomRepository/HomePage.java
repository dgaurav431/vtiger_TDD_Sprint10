package vtiger.pomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * This POM class has all the elements present in the Home Page
 * @author Akash Deb
 *
 */
public class HomePage {
	WebDriver driver;

	//Constructor to load elements
	public HomePage(WebDriver driver) {

		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	//Identifying Elements
	@FindBy(linkText = "Leads")
	private WebElement leadsModule;

	@FindBy(linkText = "Organizations")
	private WebElement organizationsModule;

	@FindBy(linkText = "Contacts")
	private WebElement contactsModule;

	@FindBy(linkText = "Opportunities")
	private WebElement opportunitiesModule;

	@FindBy(linkText = "Products")
	private WebElement productsModule;

	@FindBy(linkText = "More")
	private WebElement moreDropdown;

	@FindBy(linkText = "Campaigns")
	private WebElement campaignsModule;

	@FindBy(linkText = "Vendors")
	private WebElement vendorsModule;

	@FindBy(xpath = "//img[@src=\"themes/softed/images/user.PNG\"]")
	private WebElement administratorProfilePicture;
	
	@FindBy(linkText = "Sign Out")
	private WebElement signOutOption;
	
	
	//Getter Methods
	public WebElement getLeadsModule() {
		return leadsModule;
	}

	public WebElement getOrganizationsModule() {
		return organizationsModule;
	}

	public WebElement getContactsModule() {
		return contactsModule;
	}

	public WebElement getProductsModule() {
		return productsModule;
	}

	public WebElement getMoreDropdown() {
		return moreDropdown;
	}

	public WebElement getCampaignsModule() {
		return campaignsModule;
	}

	public WebElement getVendorsModule() {
		return vendorsModule;
	}
	
	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getOpportunitiesModule() {
		return opportunitiesModule;
	}
	
	//Business Logic
	public WebElement getAdministratorProfilePicture() {
		return administratorProfilePicture;
	}

	public WebElement getSignOutOption() {
		return signOutOption;
	}

	/**
	 * This method is used click on the lead module
	 */
	public void clickOnLeadsModule() {
		leadsModule.click();
	}

	public void clickOnOrganizationModule() {
		organizationsModule.click();
	}

	public void clickOnContactsModule() {
		contactsModule.click();
	}

	public void clickOnOpportunityModule() {
		opportunitiesModule.click();
	}

	public void clickOnProductsModule() {
		productsModule.click();
	}

	/**
	 * This method is used perform mouse hover on more option and click on campaign module
	 */
	public void clickOnCampaignModule() {

		Actions action = new Actions(driver);
		action.moveToElement(moreDropdown).perform();
		action.click(campaignsModule).perform();
	}

	public void clickOnVendorModule() {

		Actions action = new Actions(driver);
		action.moveToElement(moreDropdown).perform();
		action.click(vendorsModule).perform();
	}
	
	public void signOutAction() {
		Actions action = new Actions(driver);
		action.moveToElement(administratorProfilePicture).perform();
		action.click(signOutOption).perform();
	}

}
