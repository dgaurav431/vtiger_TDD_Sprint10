package vtiger.lead_module;

import java.io.IOException;

import org.apache.commons.math3.geometry.euclidean.oned.Euclidean1D;
import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import vtiger.genericUtility.BaseClass;
import vtiger.genericUtility.IPathConstant;
import vtiger.pomRepository.CreatingNewLeadsPage;
import vtiger.pomRepository.HomePage;
import vtiger.pomRepository.LeadsInformationPage;
import vtiger.pomRepository.LeadsPage;
@Listeners (vtiger.genericUtility.ItestListenersImplementation.class)
public class ToCreateALeadTest extends BaseClass {
	
	@Test(retryAnalyzer = vtiger.genericUtility.RetryAnalyzer.class, groups = "smoke")
	public void toCreateALeadAndToVerifyTheLeadInfo() throws EncryptedDocumentException, IOException {
		
		//TestData
		String leadSalutation = eUtils.fetchStringDataFromExcelSheet(IPathConstant.LEAD_SHEET_NAME, 1, 0);
		String leadFirstName = eUtils.fetchStringDataFromExcelSheet(IPathConstant.LEAD_SHEET_NAME, 1, 1);
		String leadLastName = eUtils.fetchStringDataFromExcelSheet(IPathConstant.LEAD_SHEET_NAME, 1, 2);
		String leadCompanyName = eUtils.fetchStringDataFromExcelSheet(IPathConstant.LEAD_SHEET_NAME, 1, 3);

		//POM Object Creation
		HomePage home = new HomePage(driver);
		LeadsPage lead = new LeadsPage(driver);
		CreatingNewLeadsPage createLead = new CreatingNewLeadsPage(driver);
		LeadsInformationPage leadInfo = new LeadsInformationPage(driver);
		
		home.clickOnLeadsModule();
		lead.clickOnLeadPlusButton();
		createLead.selectLeadSalutation(leadSalutation);
		createLead.enterLeadFirstName(leadFirstName);
		createLead.enterLeadLastName(leadLastName);
		createLead.enterLeadCompanyName(leadCompanyName);
		createLead.clickOnSaveButton();
		
		String actualLeadInformation = leadInfo.fetchLeadInformation(leadLastName);

		Assert.assertTrue(actualLeadInformation.contains(leadLastName));
		System.out.println("Pass: the lead has been created");
		
	}

}
