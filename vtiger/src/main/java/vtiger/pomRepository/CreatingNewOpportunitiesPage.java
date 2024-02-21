package vtiger.pomRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.genericUtility.WebDriverUtility;

public class CreatingNewOpportunitiesPage {
	WebDriver driver;

	public CreatingNewOpportunitiesPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	@FindBy(name = "potentialname")
	private WebElement opportunityNameTextField;

	@FindBy(xpath = "//select[@id=\"related_to_type\"]/../..//img[@title='Select']")
	private WebElement organizationLookUpButton;

	@FindBy(name = "search_text")
	private WebElement organizationSearchTextField;

	@FindBy(name = "search")
	private WebElement organizationSearchButton;

	@FindBy(xpath = "(//img[@title=\"Select\"])[2]")
	private WebElement campaignLookUpButton;

	@FindBy(name = "search_text")
	private WebElement campaignSearchTextField;

	@FindBy(name = "search")
	private WebElement campaignSearchButton;

	@FindBy(name = "closingdate")
	private WebElement opportunityClosingDate;

	@FindBy(xpath = "//input[@title=\"Save [Alt+S]\"]")
	private WebElement saveButton;

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getOpportunityNameTextField() {
		return opportunityNameTextField;
	}

	public WebElement getOrganizationLookUpButton() {
		return organizationLookUpButton;
	}

	public WebElement getOrganizationSearchTextField() {
		return organizationSearchTextField;
	}

	public WebElement getOrganizationSearchButton() {
		return organizationSearchButton;
	}

	public WebElement getCampaignLookUpButton() {
		return campaignLookUpButton;
	}

	public WebElement getCampaignSearchTextField() {
		return campaignSearchTextField;
	}

	public WebElement getCampaignSearchButton() {
		return campaignSearchButton;
	}

	public WebElement getOpportunityClosingDate() {
		return opportunityClosingDate;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}

	public void clickOnOrganizationOnLookUpPage(String organizationName) {
		driver.findElement(By.xpath("//a[text()='" + organizationName + "']")).click();
	}

	public void clickOncampaignOnLookUpPage(String campaignName) {
		driver.findElement(By.xpath("//a[text()='" + campaignName + "']")).click();
	}

	public void enterOpportunityName(String opportunityName) {

		opportunityNameTextField.sendKeys(opportunityName);
	}

	public void clickAndSelectOrganizationNameFromLookUpPage(String organizationName, String titleToSwitch) {

		String parentPageTitle = driver.getTitle();

		organizationLookUpButton.click();

		WebDriverUtility wUtils = new WebDriverUtility();
		wUtils.switchToWindow(driver, titleToSwitch);

		organizationSearchTextField.sendKeys(organizationName);
		organizationSearchButton.click();

		clickOnOrganizationOnLookUpPage(organizationName);

		wUtils.switchToWindow(driver, parentPageTitle);

	}

	public void clickAndSelectCampaignNameFromLookUpPage(String campaignName, String titleToSwitch) {

		String parentPageTitle = driver.getTitle();

		campaignLookUpButton.click();

		WebDriverUtility wUtils = new WebDriverUtility();
		wUtils.switchToWindow(driver, titleToSwitch);

		campaignSearchTextField.sendKeys(campaignName);
		campaignSearchButton.click();

		clickOncampaignOnLookUpPage(campaignName);

		wUtils.switchToWindow(driver, parentPageTitle);

	}

	public void enterClosingDate(String closingDate) {

		opportunityClosingDate.sendKeys(closingDate);

	}

	public void clickOnSaveButton() {

		saveButton.click();

	}

}
