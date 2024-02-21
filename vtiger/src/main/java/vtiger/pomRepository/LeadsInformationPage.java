package vtiger.pomRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
/**
 * 
 * @author Akash Deb
 *
 */
public class LeadsInformationPage {
	WebDriver driver;
	public LeadsInformationPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	/**
	 * 
	 * @param leadLastName
	 * @return String
	 */
	
	public String fetchLeadInformation(String leadLastName) {
		
		return driver.findElement(By.xpath("//span[contains(text(), '"+leadLastName+"')]")).getText();
		
	}
	
	

}
