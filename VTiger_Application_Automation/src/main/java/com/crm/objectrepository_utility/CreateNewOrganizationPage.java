package com.crm.objectrepository_utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreateNewOrganizationPage {

	WebDriver driver;

	public CreateNewOrganizationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "accountname")
	private WebElement accountNameEdit;

	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveButton;

	@FindBy(name = "industry")
	private WebElement selectIndustry;

	@FindBy(xpath = "//textarea[@name='ship_street']")
	private WebElement shippingInfo;

	public WebElement getAccountNameEdit() {
		return accountNameEdit;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}

	public WebElement getSelectIndustry() {
		return selectIndustry;
	}

	public WebElement getShippingInfo() {
		return shippingInfo;
	}

	public void createOrg(String orgName) {
		getAccountNameEdit().sendKeys(orgName);
		getShippingInfo().sendKeys("Banglore");
		getSaveButton().click();
	}

	public void createOrg(String orgName, String industryName) {
		getAccountNameEdit().sendKeys(orgName);
		Select select = new Select(selectIndustry);
		select.selectByContainsVisibleText(industryName);
		getSaveButton().click();
		driver.switchTo().alert().dismiss();
	}

}
