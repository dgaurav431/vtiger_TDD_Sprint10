package vtiger.pomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatingNewOrganizationPage {
	
	//Constructor
	public CreatingNewOrganizationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
			}
	//Identification
	@FindBy(name = "accountname")
	private WebElement organizationNameTextField;

	@FindBy(xpath = "//input[@title=\"Save [Alt+S]\"]")
	private WebElement saveButton;
	
	//Getter
	public WebElement getOrganizationNameTextField() {
		return organizationNameTextField;
	}
	
	
	
	public WebElement getSaveButton() {
		return saveButton;
	}


	//Business Logics
	public void enterOrganizationName(String organizationName) {
		organizationNameTextField.sendKeys(organizationName);
	}
	
	public void clickOnSaveButton() {

		saveButton.click();

	}
	
	
	
	

}
