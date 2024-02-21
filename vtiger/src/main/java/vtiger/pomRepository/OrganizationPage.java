package vtiger.pomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationPage {

	public OrganizationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//identifying elements
		@FindBy(xpath = "//img[@title='Create Organization...']")
		private WebElement organizationPlusButton;

		//Getter method	
		public WebElement getOrganizationPlusButton() {
			return organizationPlusButton;
		}
		
		//Business Logic
		/**
		 * This method is used to click on Leads Plus button
		 */
		public void clickOnOrganizationPlusButton() {
			organizationPlusButton.click();
		}


}
