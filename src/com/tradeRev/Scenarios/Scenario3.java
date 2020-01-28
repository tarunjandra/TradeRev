package com.tradeRev.Scenarios;

import java.util.HashMap;
import org.openqa.selenium.WebDriver;
import com.tradeRev.Utilities.ElementLocatorAndSelector;
import com.tradeRev.Utilities.SetUpWebDriver;
import com.tradeRev.Utilities.StoringElementsAsKeyValuePair;
import com.tradeRev.Utilities.waitStatements;

public class Scenario3 {

	public static void solution() {

		int counter = 1;
		boolean flag = true;
		String format = "%-60s%s%n";

		System.out.println("*******************************Scenario3*************************************");

		// --------------------Setting Up Web driver-------------------------//

		WebDriver driver = SetUpWebDriver.initializeChromeWebDriver();

		// ------------------------------------------------------------------//

		try {

			// ------------Checking If Page Loaded Successfully------------------//

			driver.get("https://jobs.lever.co/traderev"); // Navigating to TradeRev Canadian Opportunities WebSite

			if (waitStatements.waitUntilPageLoadsSuccessfully(driver, 50000)) {
				System.out.println("TradeRev Website loaded Successfully");
			} else {
				System.err.println("TradeRev Website didnt loaded Successfully in given time");
			}

			System.out.println("//------------------------------------------------------------------//");

			// ------------------------------------------------------------------//

			// --------Capturing Engineering Opportunities in Toronto -----------//

			String selectingDropDownForCity = ElementLocatorAndSelector
					.selectingElementFromSameClassNameByVisibleText(driver, "filter-button-wrapper", "CITY");

			System.out.println(selectingDropDownForCity);

			System.out.println("//------------------------------------------------------------------//");

			ElementLocatorAndSelector.selectingElementByTag(driver,
					"[href='?location=Toronto%2C%20Ontario%2C%20Canada']");

			System.out.println("Filtering Job Opportunities for Toronto");

			System.out.println("//------------------------------------------------------------------//");

			String selectingDropDownForTeam = ElementLocatorAndSelector
					.selectingElementFromSameClassNameByVisibleText(driver, "filter-button-wrapper", "TEAM");

			System.out.println(selectingDropDownForTeam);

			System.out.println("//------------------------------------------------------------------//");

			ElementLocatorAndSelector.selectingElementByXpath(driver,
					"/html/body/div[2]/div/div/div/div[1]/div[2]/div[2]/ul/li[2]/a");

			System.out.println("Filtering Job Opportunities for Engineering Team");

			System.out.println("//------------------------------------------------------------------//");

			System.out.println(
					"S.No--Posting Name------------------------------------------Location---------------------Team");

			HashMap<String, String> postingWithLocation = StoringElementsAsKeyValuePair.store(driver,
					"[data-qa='posting-name']", ".sort-by-location.posting-category.small-category-label");

			HashMap<String, String> postingWithTeam = StoringElementsAsKeyValuePair.store(driver,
					"[data-qa='posting-name']", ".sort-by-team.posting-category.small-category-label");

			// ------------------------------------------------------------------//

			// ----Validating If all listings are from Toronto and Engineering---//

			for (String postingLocationPair : postingWithLocation.keySet()) {

				String prefix = (counter + "     " + postingLocationPair);
				String suffix = postingWithLocation.get(postingLocationPair) + "     "
						+ postingWithTeam.get(postingLocationPair);

				if (postingWithLocation.get(postingLocationPair).equals("TORONTO, ONTARIO, CANADA")
						&& postingWithTeam.get(postingLocationPair).contains("ENGINEERING")) {
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
				System.out.println(
						"There are " + (counter - 1) + " postings in total from Toronto from Engineering Team");
				System.out.println("--------------------------------------------------------------");

			} else {
				System.out.println("--------------Please check the errors in the listing--------------------");
			}
			System.out.println("*******************************Scenario3*************************************");

		} catch (Exception e) {
			System.out.println("Exception Occured" + e);
		} finally {
			driver.quit();
		}
	}

}
