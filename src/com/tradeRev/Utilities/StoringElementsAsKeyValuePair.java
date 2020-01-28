package com.tradeRev.Utilities;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class StoringElementsAsKeyValuePair {

	public static HashMap<String, String> store(WebDriver driver, String tagLocator, String classLocator) {

		HashMap<String, String> hashMap = new LinkedHashMap<String, String>();

		List<WebElement> listOfElement1 = ElementLocatorAndSelector.gettingAllElementsWithSameTag(driver, tagLocator);

		List<WebElement> listOfElement2 = ElementLocatorAndSelector.gettingAllElementsWithSameClass(driver,
				classLocator);

		for (int i = 0; i < listOfElement1.size(); i++) {
			hashMap.put(listOfElement1.get(i).getText(), listOfElement2.get(i).getText());
		}
		
		return hashMap;

	}

}
