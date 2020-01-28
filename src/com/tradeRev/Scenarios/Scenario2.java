package com.tradeRev.Scenarios;

import java.util.HashMap;
import java.util.Map.Entry;
import org.openqa.selenium.WebDriver;
import com.tradeRev.Utilities.ElementLocatorAndSelector;
import com.tradeRev.Utilities.SetUpWebDriver;
import com.tradeRev.Utilities.StoringElementsAsKeyValuePair;
import com.tradeRev.Utilities.waitStatements;

public class Scenario2 {

	public static void solution() {

		int counter = 1;
		boolean flag = true;
		String format = "%-80s%s%n";

		// --------------------Setting Up Web driver-------------------------//

		WebDriver driver = SetUpWebDriver.initializeChromeWebDriver();

		// ------------------------------------------------------------------//

		try {

			// ------------Checking If Page Loaded Successfully------------------//

			driver.get("https://jobs.lever.co/traderev"); // Navigating to TradeRev Canadian Opportunities WebSite

			System.out.println("*******************************Scenario2*************************************");

			if (waitStatements.waitUntilPageLoadsSuccessfully(driver, 50000)) {
				System.out.println("TradeRev Website loaded Successfully");
			} else {
				System.err.println("TradeRev Website didnt loaded Successfully in given time");
			}

			System.out.println("//------------------------------------------------------------------//");

			// ------------------------------------------------------------------//

			// --------Capturing All Opportunities with Their Location-----------//

			String selectingDropDown = ElementLocatorAndSelector.selectingElementFromSameClassNameByVisibleText(driver,
					"filter-button-wrapper", "CITY");

			System.out.println(selectingDropDown);

			System.out.println("//------------------------------------------------------------------//");

			ElementLocatorAndSelector.selectingElementByTag(driver,
					"[href='?location=Toronto%2C%20Ontario%2C%20Canada']");

			System.out.println("Filtering Job Opportunities for Toronto");

			System.out.println("//------------------------------------------------------------------//");
			System.out.println("S.No---Posting Name-------------------------------------------------------------Location");

			HashMap<String, String> postingWithLocation = StoringElementsAsKeyValuePair.store(driver,
					"[data-qa='posting-name']", ".sort-by-location.posting-category.small-category-label");

			// ------------------------------------------------------------------//

			// ----------Validating If all listings are from Toronto-------------//

			for (Entry<String, String> postingLocationPair : postingWithLocation.entrySet()) {

				String prefix = (counter + "------" + postingLocationPair.getKey());
				String suffix = postingLocationPair.getValue();

				if (postingLocationPair.getValue().equals("TORONTO, ONTARIO, CANADA")) {
					System.out.printf(format, prefix, suffix);
				} else {
					flag = false;
					System.err.println("There is error in page in following Posting:");
					System.err.printf(format, prefix, suffix);
				}

				counter++;
			}

			if (flag) {

				System.out.println("--------------------------------------------------------------");
				System.out.println("There are " + (counter - 1) + " postings in total from Toronto");
				System.out.println("--------------------------------------------------------------");

			} else {
				System.out.println("--------------Please check the errors in the listing--------------------");
			}
			System.out.println("*******************************Scenario2*************************************");

		} catch (Exception e) {
			System.out.println("Exception Occured" + e);
		} finally {
			driver.quit();
		}
	}
}
