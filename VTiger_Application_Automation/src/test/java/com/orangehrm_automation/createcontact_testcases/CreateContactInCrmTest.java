package com.orangehrm_automation.createcontact_testcases;

import org.testng.annotations.Test;

import com.crm.basic_utilities.BaseClass;
import com.crm.objectrepository_utility.CreateNewContact;
import com.crm.objectrepository_utility.HomePage;

public class CreateContactInCrmTest extends BaseClass {

	@Test
	public void createContactTest()
	{
		HomePage hp=new HomePage(driver);
		hp.clickOnContacts();
		
		CreateNewContact con=new CreateNewContact(driver);
		con.clickOnCreateContact();
	}
}
