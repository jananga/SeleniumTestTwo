package com.wdg.alerts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestAlerts {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//testOne();
		
		excirseEight();
	}

	public static void excirseEight() {

		System.setProperty("webdriver.chrome.driver", "res/chrome/chromedriver.exe");

		// Launch new Browser
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		
		System.out.println("Launch new Browser");
		
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//Open URL “http://toolsqa.wpengine.com/automation-practice-switch-windows/”
		
		driver.get("http://toolsqa.wpengine.com/automation-practice-switch-windows/");
		System.out.println("Open URL “http://toolsqa.wpengine.com/automation-practice-switch-windows/”");
		
		//Click on the Button “Timing Alert”
		WebElement btnTimingAlert = driver.findElement(By.xpath("//button[@id='timingAlert']"));
		btnTimingAlert.click();
		System.out.println("Click on the Button “Timing Alert”");
		
		
		
		// Accept the Alert (Alert will take 3 second to get displayed, Use WebDriverWait to wait for it)
		WebDriverWait waitWebDrive = new WebDriverWait(driver, 10);
		
		Alert alert = waitWebDrive.until(ExpectedConditions.alertIsPresent());
		System.out.println("Accept the Alert (Alert will take 3 second to get displayed, Use WebDriverWait to wait for it)");
		
		alert.accept();
		
		System.out.println("Alert Accepted");
		
		
		driver.quit();
	}

	public static void testOne() {

		System.setProperty("webdriver.chrome.driver", "res/chrome/chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("http://toolsqa.wpengine.com/automation-practice-form/");

	}

}
