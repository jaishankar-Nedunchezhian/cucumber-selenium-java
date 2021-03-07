package com.hypen.util;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import okio.Timeout;


public class WaitUtil {
	
	private WebDriver driver;
	private WebDriverWait wait;
	
	
	public WaitUtil(WebDriver driver) {
		this.driver = driver;
	}
	
	/**
	 * This wait declarations make sure that there is only one instance - Singleton Pattern
	 * @return
	 */
	public WebDriverWait getWebDriverWait() {
		if (wait == null) {
			wait = new WebDriverWait(driver,20);
		}
		return wait;
	}
	public void waitForElementby(By locator) {
		  this.getWebDriverWait().until(ExpectedConditions.or(
		          ExpectedConditions.visibilityOfElementLocated(locator)));
		}
}
