package com.crm.objectrepository_utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationsPage {
	WebDriver driver;

	public OrganizationsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
 
	@FindBy(xpath = "//img[@title='Create Organization...']")
	private WebElement clickonOrgButton;

	public WebElement getClickonOrgButton() {
		return clickonOrgButton;
	}
	
	public void createNewOrganization() {
		getClickonOrgButton().click();
	}

}
