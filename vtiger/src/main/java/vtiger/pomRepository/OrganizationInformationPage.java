package vtiger.pomRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInformationPage {
	
	WebDriver driver;
	public OrganizationInformationPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	/**
	 * 
	 * @param organizationName
	 * @return
	 */
	
	public String fetchOrganizationInformation(String organizationName) {
		
		return driver.findElement(By.xpath("//span[contains(text(), '"+organizationName+"')]")).getText();
		
	}
}
