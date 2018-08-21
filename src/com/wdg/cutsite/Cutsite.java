package com.wdg.cutsite;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.time.DurationFormatUtils;
import org.openqa.selenium.WebDriver;

import com.wdg.common.CommonMethods;
import com.wdg.core.Core;
import com.wdg.utils.Utilities;

public class Cutsite {

	public static void main(String[] args) throws InterruptedException, ParseException {

		// Execute Commandments

		Date date1 = CommonMethods.getDate();
		System.out.println("Starting time : " + date1.toString());

		execute();

		Date date2 = CommonMethods.getDate();
		System.out.println("Ending time : " + date2.toString());

		long difference = date2.getTime() - date1.getTime();

		System.out.println("Average : " + DurationFormatUtils.formatDuration(difference, "HH:mm:ss"));

	}

	public static void execute() throws InterruptedException {

		Boolean proceedFurther = null;
		// Call Utilities
		WebDriver driver = Utilities.utilities();
		System.out.println("Call Utilities");

		if (driver == null) {
			System.out.println("Web Driver creation fail.");
			proceedFurther = false;
		} else {
			proceedFurther = true;
		}

		if (proceedFurther) {
			System.out.println("Load page and login");
			proceedFurther = Utilities.loginPageLoad(driver);
		}

		if (proceedFurther) {
			System.out.println("Load page");
			proceedFurther = Core.login(driver);
		}

		if (proceedFurther) {
			System.out.println("Navigate to Add Click");
			proceedFurther = Core.navigateToAddClick(driver);
		}

		if (proceedFurther) {
			System.out.println("Add Click Iterator");
			proceedFurther = Core.AddClickIterator(driver, 50);
		}

		if (proceedFurther) {
			System.out.println("Log Out");
			proceedFurther = Utilities.logout(driver);
		}

		if (proceedFurther) {
			System.out.println("Successfylly Done..!");

		} else {
			System.out.println("Something has gone wrong.");
		}

	}

}
