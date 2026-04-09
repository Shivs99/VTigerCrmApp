package com.crm.objectrepository_utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewContact {

	WebDriver driver;

	public CreateNewContact(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//img[@title='Create Contact...']")
	private WebElement clickOnCreateContactButton;

	public WebElement getClickOnCreateContactButton() {
		return clickOnCreateContactButton;
	}
	
	public void clickOnCreateContact()
	{
		getClickOnCreateContactButton().click();
	}

}
