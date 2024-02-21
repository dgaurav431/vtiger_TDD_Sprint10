package vtiger.opportunity_module;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import vtiger.genericUtility.BaseClass;
import vtiger.genericUtility.IPathConstant;
import vtiger.pomRepository.CampagnInformationPage;
import vtiger.pomRepository.CampaignPage;
import vtiger.pomRepository.CreatingNewCampaignPage;
import vtiger.pomRepository.CreatingNewOpportunitiesPage;
import vtiger.pomRepository.CreatingNewOrganizationPage;
import vtiger.pomRepository.HomePage;
import vtiger.pomRepository.OpportunitiesPage;
import vtiger.pomRepository.OpportunityInformationPage;
import vtiger.pomRepository.OrganizationInformationPage;
import vtiger.pomRepository.OrganizationPage;
@Listeners(vtiger.genericUtility.ItestListenersImplementation.class)
public class ToCreateOpportunityTest extends BaseClass {
	
	@Test(retryAnalyzer = vtiger.genericUtility.RetryAnalyzer.class, groups = "regression")
	public void toCreateAnOpportunityWithOrganizationAndCampaignDetails() throws EncryptedDocumentException, IOException {
		
		String organizationName = eUtils.fetchStringDataFromExcelSheet(IPathConstant.ORGANIZATION_SHEET_NAME, 1, 0)+jUtils.generateRandomNumber(10000);
		String campaignName = eUtils.fetchStringDataFromExcelSheet(IPathConstant.CAMPAIGN_SHEET_NAME, 1, 0);
		String opportunityName = eUtils.fetchStringDataFromExcelSheet(IPathConstant.OPPORTUNITY_SHEET_NAME, 1, 0);
		String opportunityClosingDate = eUtils.fetchDateDataFromExcelSheet(IPathConstant.OPPORTUNITY_SHEET_NAME, 1, 1);
		String opportunityLookUpPageTitle = eUtils.fetchStringDataFromExcelSheet(IPathConstant.OPPORTUNITY_SHEET_NAME, 1, 2);
		String campaignLookUpPageTitle = eUtils.fetchStringDataFromExcelSheet(IPathConstant.OPPORTUNITY_SHEET_NAME, 1, 3);

		
		HomePage home=new HomePage(driver);
		OrganizationPage organization=new OrganizationPage(driver);
		CreatingNewOrganizationPage createOrganization=new CreatingNewOrganizationPage(driver);
		OrganizationInformationPage organizationInfo=new OrganizationInformationPage(driver);
		CampaignPage campaign=new CampaignPage(driver);
		CreatingNewCampaignPage createCampaign=new CreatingNewCampaignPage(driver);
		CampagnInformationPage campaignInfo=new CampagnInformationPage(driver);
		OpportunitiesPage opportunity=new OpportunitiesPage(driver);
		CreatingNewOpportunitiesPage createOpportunity=new CreatingNewOpportunitiesPage(driver);
		OpportunityInformationPage opportunityInfo=new OpportunityInformationPage(driver);
		
		
		home.clickOnOrganizationModule();
		organization.clickOnOrganizationPlusButton();
		createOrganization.enterOrganizationName(organizationName);
		createOrganization.clickOnSaveButton();
		
		String actualOrganizartionDetails = organizationInfo.fetchOrganizationInformation(organizationName);
		Assert.assertTrue(actualOrganizartionDetails.contains(organizationName));
		System.out.println("Pass: the organization has been created");
		
		home.clickOnCampaignModule();
		campaign.clickOnCampaignPlusButton();
		createCampaign.enterCampaignName(campaignName);
		createCampaign.clickOnSaveButton();
		
		String actualCampaignDetails = campaignInfo.fetchCampaignInformation(campaignName);
		Assert.assertTrue(actualCampaignDetails.contains(campaignName));
		System.out.println("Pass: the Campaign has been created");
		
		home.clickOnOpportunityModule();
		opportunity.clickOnOpportunitiesPlusButton();
		createOpportunity.enterOpportunityName(opportunityName);
		createOpportunity.clickAndSelectOrganizationNameFromLookUpPage(organizationName, opportunityLookUpPageTitle);
		createOpportunity.clickAndSelectCampaignNameFromLookUpPage(campaignName, campaignLookUpPageTitle);
		createOpportunity.enterClosingDate(opportunityClosingDate);
		createOpportunity.clickOnSaveButton();
		
		String actualOpportunityInfo = opportunityInfo.fetchOpportunityInformation(opportunityName);
		Assert.assertTrue(actualOpportunityInfo.contains(opportunityName));
		System.out.println("Pass: the Opportunity has been created");
	

	}

}
