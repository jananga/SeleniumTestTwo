package com.wdg.common;

import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonMethods {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@SuppressWarnings("deprecation")
	public static WebElement checkElemetPresent(WebDriver driver, String xpath, int waitingTime) {

		WebElement element = null;

		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
		wait.pollingEvery(250, TimeUnit.MILLISECONDS);
		wait.withTimeout(waitingTime, TimeUnit.MINUTES);
		wait.ignoring(NoSuchElementException.class);

		Function<WebDriver, WebElement> checkElement = new Function<WebDriver, WebElement>() {

			@Override
			public WebElement apply(WebDriver driver) {

				WebElement element = driver.findElement(By.xpath(xpath));
				if (element == null) {
					System.out.println("Target web element not found : " + xpath);
				} else {
					System.out.println("Target web element found : " + xpath);

				}
				return element;

			}
		};

		// Perform wait
		return element = wait.until(checkElement);

	}

	public static void checkElementVisible(WebDriver driver, String xpath, int waitingTime) {

		WebDriverWait wait = new WebDriverWait(driver, waitingTime);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
	}

}
