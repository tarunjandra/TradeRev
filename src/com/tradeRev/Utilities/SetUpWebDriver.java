package com.tradeRev.Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SetUpWebDriver {

	public static WebDriver initializeChromeWebDriver() {

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		return driver;

	}

	public static WebDriver initializeFireFoxWebDriver() {

		WebDriverManager.firefoxdriver().setup();

		WebDriver driver = new FirefoxDriver();

		return driver;

	}

	public static WebDriver initializeEdgeWebDriver() {
		
		WebDriverManager.edgedriver().setup();

		WebDriver driver = new EdgeDriver();

		return driver;

	}

}
