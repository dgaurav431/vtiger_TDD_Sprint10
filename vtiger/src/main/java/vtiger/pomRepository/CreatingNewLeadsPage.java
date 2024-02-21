package vtiger.pomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
/**
 * 
 * @author Akash Deb
 *
 */
public class CreatingNewLeadsPage {

	public CreatingNewLeadsPage(WebDriver driver) {

		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "salutationtype")
	private WebElement leadSalutationDropdown;

	@FindBy(name = "firstname")
	private WebElement leadFirstNameTextbox;

	@FindBy(name = "lastname")
	private WebElement leadLastNameTextbox;

	@FindBy(name = "company")
	private WebElement leadCompanyNameTextbox;

	@FindBy(xpath = "//input[@title=\"Save [Alt+S]\"]")
	private WebElement saveButton;

	public WebElement getLeadSalutationDropdown() {
		return leadSalutationDropdown;
	}

	public WebElement getLeadFirstNameTextbox() {
		return leadFirstNameTextbox;
	}

	public WebElement getLastNameNameTextbox() {
		return leadLastNameTextbox;
	}

	public WebElement getCompanyNameTextbox() {
		return leadCompanyNameTextbox;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}

	/**
	 * 
	 * @param option
	 */
	public void selectLeadSalutation(String option) {

		Select select = new Select(leadSalutationDropdown);
		select.selectByVisibleText(option);

	}

	/**
	 * 
	 * @param leadFirstName
	 */
	public void enterLeadFirstName(String leadFirstName) {

		leadFirstNameTextbox.sendKeys(leadFirstName);

	}

	/**
	 * 
	 * @param leadLastName
	 */
	public void enterLeadLastName(String leadLastName) {

		leadLastNameTextbox.sendKeys(leadLastName);

	}

	public void enterLeadCompanyName(String leadCompanyName) {

		leadCompanyNameTextbox.sendKeys(leadCompanyName);

	}
	
	public void clickOnSaveButton() {

		saveButton.click();

	}
	

}
