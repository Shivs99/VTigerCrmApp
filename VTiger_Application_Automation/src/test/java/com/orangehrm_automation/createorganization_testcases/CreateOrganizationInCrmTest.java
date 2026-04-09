package com.orangehrm_automation.createorganization_testcases;

import org.junit.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.basic_utilities.BaseClass;
import com.crm.listener_utilites.ListenerImpClass;
import com.crm.objectrepository_utility.CreateNewOrganizationPage;
import com.crm.objectrepository_utility.HomePage;
import com.crm.objectrepository_utility.OrganizationInformationPage;
import com.crm.objectrepository_utility.OrganizationsPage;

@Listeners(ListenerImpClass.class)
public class CreateOrganizationInCrmTest extends BaseClass {

	@Test
	public void createNewOrg() throws Exception {

		String orgName = ex.getDataFromExecl("Organizations", 1, 0) + jut.getRandomNumber();

		HomePage hp = new HomePage(driver);
		hp.clickOnOrgLink();

		OrganizationsPage org = new OrganizationsPage(driver);
		org.createNewOrganization();

		CreateNewOrganizationPage nwOrg = new CreateNewOrganizationPage(driver);
		nwOrg.createOrg(orgName);

		OrganizationInformationPage orgInfo = new OrganizationInformationPage(driver);
		String actualMsg = orgInfo.getHeaderMsg().getText();
		Assert.assertEquals(actualMsg, org);

	}

}
