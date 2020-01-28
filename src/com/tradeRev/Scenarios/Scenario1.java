package com.tradeRev.Scenarios;

import org.openqa.selenium.WebDriver;
import com.tradeRev.Utilities.ElementLocatorAndSelector;
import com.tradeRev.Utilities.SetUpWebDriver;
import com.tradeRev.Utilities.SwitchingBetweenTabs;
import com.tradeRev.Utilities.waitStatements;

public class Scenario1 {

	public static void solution() {

		System.out.println("*******************************Scenario1*************************************");

		// --------------------Setting Up Web driver-------------------------//

		WebDriver driver = SetUpWebDriver.initializeChromeWebDriver();

		// ------------------------------------------------------------------//

		try {

			// ------------Checking If Page Loaded Successfully------------------//

			driver.get("https://www.traderev.com/en-ca/"); // Navigating to TradeRev WebSite

			if (waitStatements.waitUntilPageLoadsSuccessfully(driver, 50000)) {
				System.out.println("TradeRev Website loaded Successfully");
			} else {
				System.err.println("TradeRev Website didnt loaded Successfully in given time");
			}

			System.out.println("//------------------------------------------------------------------//");

			// ------------------------------------------------------------------//

			// -----------------------Navigating to Career-----------------------//

			String messageFromCarrerButton = ElementLocatorAndSelector
					.selectingElementFromSameClassNameByVisibleText(driver, "nav-site__item", "Careers");

			System.out.println(messageFromCarrerButton);

			System.out.println("//------------------------------------------------------------------//");

			// ------------------------------------------------------------------//

			// -----------------Switching to CareerSite Tab----------------------//

			String switchToCareerPage = SwitchingBetweenTabs.switcToNextTab(driver);

			System.out.println(switchToCareerPage + " Site loaded Successfully");

			System.out.println("//------------------------------------------------------------------//");

			// ---------------Navigating to Canadian Opportunities---------------//

			ElementLocatorAndSelector.selectingElementByClassName(driver, ".job-links__button.job-links__button--ca");

			// ------------------------------------------------------------------//

			// ---------------Switching to Canadian Opportunities---------------//

			String switcToCanadianOpportunities = SwitchingBetweenTabs.switcToNextTab(driver);

			waitStatements.waitUntilPageLoadsSuccessfully(driver, 50000);

			System.out.println(switcToCanadianOpportunities + " Canadian Job Site loaded Properly");

			// ------------------------------------------------------------------//

			System.out.println("*****************************Scenario1 Ends***********************************");

		} catch (Exception e) {
			System.out.println("Exception Occured" + e);
		} finally {
			driver.quit();
		}
	}
}
