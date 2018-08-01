package com.wdg.cutsite;

import org.openqa.selenium.WebDriver;

import com.wdg.core.Core;
import com.wdg.utils.Utilities;

public class Cutsite {

	public static void main(String[] args) {

		// Execute Commandments
		execute();
	}

	public static void execute() {

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
			proceedFurther = Core.AddClickIterator(driver, 12);
		}
		
		if (proceedFurther) {
			System.out.println("Log Out");
			proceedFurther = Utilities.logout(driver);
		}
		
		if (proceedFurther) {
			System.out.println("Successfylly Done..!");
			
		}else{
			System.out.println("Something has gone wrong.");
		}
		
	}

}
