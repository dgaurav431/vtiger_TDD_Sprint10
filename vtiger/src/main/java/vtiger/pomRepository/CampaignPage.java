package vtiger.pomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignPage {

	// Constructor
	public CampaignPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// identifying elements
	@FindBy(xpath = "//img[@title='Create Campaign...']")
	private WebElement campaignPlusButton;

	// Getter method
	public WebElement getCampaignPlusButton() {
		return campaignPlusButton;
	}

	// Business Logic
	/**
	 * This method is used to click on Leads Plus button
	 */
	public void clickOnCampaignPlusButton() {
		campaignPlusButton.click();
	}

}
