package vtiger.pomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * This is an object repository for Leads Page
 * @author Akash Deb
 *
 */
public class LeadsPage {
	//Constructor
	public LeadsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	//identifying elements
	@FindBy(xpath = "//img[@title=\"Create Lead...\"]")
	private WebElement leadsPlusButton;

	//Getter method	
	public WebElement getLeadsPlusButton() {
		return leadsPlusButton;
	}
	
	//Business Logic
	/**
	 * This method is used to click on Leads Plus button
	 */
	public void clickOnLeadPlusButton() {
		leadsPlusButton.click();
	}

}
