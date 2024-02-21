package vtiger.pomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpportunitiesPage {

	// Constructor
		public OpportunitiesPage(WebDriver driver) {
			PageFactory.initElements(driver, this);
		}

		// identifying elements
		@FindBy(xpath = "//img[@title='Create Opportunity...']")
		private WebElement opportunitiesPlusButton;

		// Getter method
		public WebElement getOpportunitiesPlusButtonButton() {
			return opportunitiesPlusButton;
		}

		// Business Logic
		/**
		 * This method is used to click on Leads Plus button
		 */
		public void clickOnOpportunitiesPlusButton() {
			opportunitiesPlusButton.click();
		}

}
