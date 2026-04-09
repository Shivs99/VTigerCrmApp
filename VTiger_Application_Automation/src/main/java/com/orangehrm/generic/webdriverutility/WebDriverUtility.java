package com.orangehrm.generic.webdriverutility;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {

	// Wait For Page to Load
	public void waitForPageToLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	public void maximizeWindow(WebDriver driver) {
		driver.manage().window().maximize();
	}

	public void minimizeWindow(WebDriver driver) {
		driver.manage().window().minimize();
	}

	public void refershPage(WebDriver driver) {
		driver.navigate().refresh();
	}

	public void moveForward(WebDriver driver) {
		driver.navigate().forward();
	}

	public void moveBackWard(WebDriver driver) {
		driver.navigate().back();
	}

	// Wait A Particular Element to be Load
	public void waitForElementToLoad(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	// Switch to Window..
	public void switchToNewBrowserTab(WebDriver driver) {
		Set<String> set = driver.getWindowHandles();
		Iterator<String> itr = set.iterator();
		while (itr.hasNext()) {
			String windowId = itr.next();
			driver.switchTo().window(windowId);

		}
	}

	// Switch to Frame Based on Index
	public void switchToFrame(WebDriver driver, int index) {
		driver.switchTo().frame(index);
	}

	// Switch to Frame Based On NameID
	public void switchToFrame(WebDriver driver, String nameId) {
		driver.switchTo().frame(nameId);
	}

	// Switch to Frame Based on WebElement
	public void switchToFrame(WebDriver driver, WebElement element) {
		driver.switchTo().frame(element);
	}

	// Switch to Alert to Accept
	public void switchToAlertAccept(WebDriver driver) {
		driver.switchTo().alert().accept();
	}

	// Switch to Alert to Dismiss
	public void switchToAlertCancel(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}

	// Select DropDown Based On Index
	public void select(WebElement element, int index) {
		Select select = new Select(element);
		select.selectByIndex(index);
	}

	// Select DropDown Based on Text
	public void select(WebElement element, String visibilityText) {
		Select select = new Select(element);
		select.selectByContainsVisibleText(visibilityText);
	}

	// MouseOverOnElememt
	public void mouseOverActions(WebDriver driver, WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).click().build().perform();
	}

	// DoubleClickOnElement
	public void doubleClickOnElement(WebDriver driver, WebElement element) {
		Actions action = new Actions(driver);
		action.doubleClick(element).build().perform();
	}

	// RightClickOnElement
	public void rightClickOnElement(WebDriver driver, WebElement element) {
		Actions action = new Actions(driver);
		action.contextClick(element).build().perform();
	}

	// DragAndDropOnElement
	public void dragAndDropOnElement(WebDriver driver, WebElement Sourceelement, WebElement targElement) {
		Actions action = new Actions(driver);
		action.dragAndDrop(Sourceelement, targElement).click().release().build().perform();

	}

	// disable Notification
	public void disableNotifications(WebDriver driver) {
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disbale-notificatons");
		driver = new ChromeDriver(option);
	}

}
