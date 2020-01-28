package com.tradeRev.Utilities;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByClassName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ElementLocatorAndSelector {

	public static String selectingElementFromSameClassNameByVisibleText(WebDriver driver, String className,
			String VisibleTextOnElement) {

		List<WebElement> allElements = driver.findElements(new ByClassName(className));

		String message = "Element Not Found";

		for (WebElement element : allElements) {
			if (element.getText().equals(VisibleTextOnElement)) {
				message = ("Selecting " + VisibleTextOnElement);
				element.click();
			}
		}
		return message;
	}

	public static void selectingElementByClassName(WebDriver driver, String className) {

		driver.findElement(By.cssSelector(className)).click();

	}

	public static List<WebElement> gettingAllElementsWithSameTag(WebDriver driver, String tag) {

		List<WebElement> allElements = driver.findElements(By.cssSelector(tag));

		return allElements;
	}

	public static List<WebElement> gettingAllElementsWithSameClass(WebDriver driver, String className) {

		List<WebElement> allElements = driver.findElements(By.cssSelector(className));

		return allElements;
	}

	public static void selectingElementByTag(WebDriver driver, String tag) {

		WebElement element = driver.findElement(By.cssSelector(tag));

		element.click();
	}

	public static void selectingElementByLinkedText(WebDriver driver, String linkText) {

		WebElement element = driver.findElement(new By.ByLinkText(linkText));

		element.click();
	}

	public static void selectingElementByXpath(WebDriver driver, String xPath) {

		WebElement element = driver.findElement(new By.ByXPath(xPath));

		element.click();
	}
}
