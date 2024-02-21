package vtiger.pomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatingNewCampaignPage {

	// Constructor
	public CreatingNewCampaignPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// Identification
	@FindBy(name = "campaignname")
	private WebElement campaignNameTextField;

	@FindBy(xpath = "//input[@title=\"Save [Alt+S]\"]")
	private WebElement saveButton;

	// Getter
	public WebElement getCampaignNameTextField() {
		return campaignNameTextField;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}

	// Business Logics
	public void enterCampaignName(String campaignName) {
		campaignNameTextField.sendKeys(campaignName);
	}

	public void clickOnSaveButton() {

		saveButton.click();

	}

}
