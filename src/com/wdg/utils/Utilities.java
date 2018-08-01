package com.wdg.utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.wdg.common.CommonMethods;

public class Utilities {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static WebDriver utilities() {

		System.setProperty("webdriver.chrome.driver", "res/chrome/chromedriver.exe");

		// Launch new Browser
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		return driver;

	}

	public static boolean loginPageLoad(WebDriver driver) {

		System.out.println("Launch new Browser");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// Open URL
		// “http://toolsqa.wpengine.com/automation-practice-switch-windows/”

		driver.get("http://bannercuts.com/");
		System.out.println("Open URL “http://bannercuts.com/”");

		// check login link present
		WebElement element = CommonMethods.checkElemetPresent(driver, "//i[contains(text(),'login')]", 2);
		System.out.println("check login link present");

		if (element == null) {
			return false;
		} else {
			System.out.println("Click on login link");
			element.click();
			return true;
		}
	}

	public static Boolean logout(WebDriver driver) {

		// check logout link present
		WebElement elementLogout = CommonMethods.checkElemetPresent(driver, "//a[contains(text(),'Log Out')]", 2);
		System.out.println("check logout link present");

		if (elementLogout == null) {
			return false;
		} else {
			System.out.println("Click on logout link");
			elementLogout.click();
			return true;
		}
	}

}
