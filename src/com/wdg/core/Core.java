package com.wdg.core;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.wdg.common.CommonMethods;

public class Core {

	public static Boolean login(WebDriver driver) {

		// check login username present
		WebElement elementUsername = CommonMethods.checkElemetPresent(driver, "//input[@id='loginname']", 2);
		System.out.println("check login username present");

		// check login password present
		WebElement elementpassword = CommonMethods.checkElemetPresent(driver, "//input[@id='password']", 2);
		System.out.println("check login password present");

		// check login submit button present
		WebElement elementSubmit = CommonMethods.checkElemetPresent(driver,
				"//form[@name='frmLogin']//a[@class='place-order']", 2);
		System.out.println(" check login submit button present");

		if (elementUsername == null || elementpassword == null || elementSubmit == null) {
			System.out.println("Login form elements not found");
			return false;
		}
		System.out.println("Login form elements found");

		// Enter username
		elementUsername.sendKeys("13297");
		System.out.println("Enter username");

		// Enter password
		elementpassword.sendKeys("1234");
		System.out.println("Enter password");

		// submit login
		elementSubmit.submit();
		System.out.println("submit login");
		return true;
	}

	public static Boolean navigateToAddClick(WebDriver driver) {

		// check popup present
		WebElement elementPopup = CommonMethods.checkElemetPresent(driver, "//a[@type='button']", 2);
		System.out.println("check popup present");

		if (elementPopup == null) {
			System.out.println("Popup not present");
			return false;
		}

		// Click on close Popup
		elementPopup.click();

		// check banner cuts present
		WebElement elementBannercuts = CommonMethods.checkElemetPresent(driver, "//h4[contains(text(),'Banner Cuts')]",
				2);
		System.out.println("check banner cuts present");

		if (elementBannercuts == null) {
			System.out.println("banner cuts element not present");
			return false;
		}

		System.out.println("Visibility of Banner Cut : " + elementBannercuts.isEnabled());

		// This is because of this error : Element Not Visible
		driver.get("https://bannercuts.com/?m=ads&a=AdzCtrl");

		// elementBannercuts.click();

		// check Addview present
		WebElement elementAddview = CommonMethods.checkElemetPresent(driver, "//h4[contains(text(),'Ads View')]", 2);
		System.out.println("check Addview present");

		if (elementAddview == null) {
			System.out.println("Addview element not present");
			return false;
		}

		// Click on Addview element
		elementAddview.click();

		// check Addview present
		WebElement elementDropdown = CommonMethods.checkElemetPresent(driver, "//select[@id='plan']", 2);
		System.out.println("check elementDropdown present");

		if (elementDropdown == null) {
			System.out.println("Dropdown element not present");
			return false;
		}

		Select dropdownSelect = new Select(elementDropdown);

		// Select My Plan
		dropdownSelect.selectByValue("4");
		System.out.println("Select My Plan");

		return true;

	}

	public static Boolean AddClickIterator(WebDriver driver, int iteration) throws InterruptedException {
		Boolean state = false;

		// Iterate for given number
		System.out.println("Iterate for given number");
		for (int i = 0; i < iteration; i++) {
			state = AddClicker(driver);

			if (!state)
				break;
		}
		return state;
	}

	public static Boolean AddClicker(WebDriver driver) throws InterruptedException {

		// check add present
		WebElement elementAdd = CommonMethods.checkElemetPresent(driver, "//a[@href='javascript:confAdd(0,2)']", 2);
		System.out.println("check add present");

		if (elementAdd == null) {
			System.out.println("Add not present");
			return false;
		}

		// Get original Handle
		String originalHandle = driver.getWindowHandle();

		// Click on element add
		System.out.println("Click on element add");
		elementAdd.click();

		WebElement elementVerifyAdd = CommonMethods.checkElemetPresent(driver, "//input[@id='submit2']", 2);
		System.out.println("check VerifyAdd present");

		if (elementVerifyAdd == null) {
			System.out.println("elementVerifyAdd not present");
			return false;
		}

		
		// Click on elementVerifyAdd
		elementVerifyAdd.click();


		// This is to pretend as a human
		
		Thread.sleep(4000);
		// driver.manage().timeouts().setScriptTimeout(100,TimeUnit.SECONDS);		
			 
		 //Switch to second window
		List <String> browserTabs = new ArrayList<String>(driver.getWindowHandles());
		
		//driver.switchTo().window(browserTabs.get(1));

		
		// WebElement elementEmail = CommonMethods.checkElemetPresent(driver, "//input[@id='mce-EMAIL']", 2);
		//	System.out.println("check elementEmail present");

		//	if (elementEmail == null) {
		//		System.out.println("elementEmail not present");
		//		return false;
		//	}

		 
		 
		 
		System.out.println("Click on elementVerifyAdd");

		// Do something to open new tabs

		for (String handle : browserTabs) {
			if (!handle.equals(originalHandle)) {
				driver.switchTo().window(handle);
				driver.close();
			}
		}

		driver.switchTo().window(originalHandle);

		WebElement elementGoNextImage = CommonMethods.checkElemetPresent(driver, "//input[@id='submit3']", 2);
		System.out.println("check elementGoNextImage present");

		if (elementGoNextImage == null) {
			System.out.println("elementGoNextImage not present");
			return false;
		}
		elementGoNextImage.click();

		return true;
	}
}
