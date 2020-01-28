package com.tradeRev.Utilities;

import org.openqa.selenium.WebDriver;

public class SwitchingBetweenTabs {

	public static String switcToNextTab(WebDriver driver) {

		for (String handles : driver.getWindowHandles()) {

			driver.switchTo().window(handles); // switching to next tab
		}

		waitStatements.waitUntilPageLoadsSuccessfully(driver, 50000);

		return driver.getTitle();
	}
}
