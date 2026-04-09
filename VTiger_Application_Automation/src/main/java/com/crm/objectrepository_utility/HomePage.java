package com.crm.objectrepository_utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//Class Name and Page Name Should be Same
public class HomePage {

	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		// Initializing The Identified WebElements
		PageFactory.initElements(driver, this);
	}

	// Identifying The WebElement Using @FindBy
	@FindBy(xpath = "//a[normalize-space()='Organizations']")
	private WebElement clickOrganization;

	@FindBy(linkText = "Contacts")
	private WebElement clickContacts;

	@FindBy(linkText = "Products")
	private WebElement clickonProducts;

	@FindBy(linkText = "Campaigns")
	private WebElement clickcampaigns;

	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement addImg;

	@FindBy(xpath = "//a[normalize-space()='Sign Out']")
	private WebElement signOut;

	public WebElement getClickOrganization() {
		return clickOrganization;
	}

	public WebElement getClickonProducts() {
		return clickonProducts;
	}

	public WebElement getClickContacts() {
		return clickContacts;
	}

	public WebElement getClickcampaigns() {
		return clickcampaigns;
	}

	public void clickOnOrgLink() {
		getClickOrganization().click();
	}

	public void clickOnContacts() {
		getClickContacts().click();
	}

	public WebElement getAddImg() {
		return addImg;
	}

	public WebElement getSignOut() {
		return signOut;
	}

	public void navigateTOCampaignsPage() {
		Actions act = new Actions(driver);
		act.moveToElement(clickcampaigns).build().perform();
		getClickcampaigns().click();
	}

	public void logout() {
		Actions act = new Actions(driver);
		act.moveToElement(addImg).perform();
		getSignOut().click();
		System.out.println("Thank You ....");
	}

}
