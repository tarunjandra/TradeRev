package com.tradeRev.Utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class waitStatements {

	public static Boolean waitUntilPageLoadsSuccessfully(WebDriver driver, Integer maxWaitTime) {

		WebDriverWait wait = new WebDriverWait(driver, maxWaitTime);

		ExpectedCondition<Boolean> condition = new ExpectedCondition<Boolean>() {

			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
			}
		};
		return wait.until(condition);
	}

	public static WebElement waitUntilElementAppearsOnPage(WebDriver driver, Integer maxWaitTime, WebElement elementToBeLocated) {

		WebDriverWait wait = new WebDriverWait(driver, maxWaitTime);

		return wait.until(ExpectedConditions.visibilityOf(elementToBeLocated));
	}
}
