package com.hypen.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import com.hypen.util.WaitUtil;

public class BetterworksLoginPage {
	
	private WebDriver driver;
	private WaitUtil waitUtil;
	
	//constructor initialize with WebDriver
	public BetterworksLoginPage(WebDriver driver) {
		this.driver = driver;
		waitUtil = new WaitUtil(driver);
		PageFactory.initElements(driver, this);
	}
	
	//locators for the Login page 	
	private By emailAddresstextField = By.id("inputGroupField");
	private By sendVerifCodeBtn = By.xpath("//span[contains(text(), 'Send me a verification code')]");
	private By verificationCodeTextbox = By.xpath("//input[@id='inputGroupField'][@type='password']");
	private By loginButton = By.xpath("//button[@class='hyphenButton btn btn-primary'][@type='submit']");
	
	
	//page actions required
	public void enterEmailAddress(String emailaddress) {
		driver.findElement(emailAddresstextField).sendKeys(emailaddress);
	}
	
	public void clickOnVerificationCodeButton() {
		waitUtil.waitForElementby(sendVerifCodeBtn);
		driver.findElement(sendVerifCodeBtn).click();
	}
		
	public boolean isEmailAddressFieldPresent() {
		return driver.findElement(emailAddresstextField).isDisplayed();
	}
	
	public boolean isVerificationCodeButtonPresent() {
		waitUtil.waitForElementby(sendVerifCodeBtn);
		return driver.findElement(sendVerifCodeBtn).isDisplayed();
	}
	
	public void enterVerificationCode(String verificationCode) throws InterruptedException {
		waitUtil.waitForElementby(verificationCodeTextbox);    
		driver.findElement(verificationCodeTextbox).sendKeys(verificationCode);
	}
	
	public BetterworksAcmeHomePage clickOnLoginButton(){
		waitUtil.waitForElementby(loginButton);
		driver.findElement(loginButton).click();
		return new BetterworksAcmeHomePage(driver);
	}
	
	public boolean isVerficationCodeTextAreaDisplayed() {
		waitUtil.waitForElementby(verificationCodeTextbox);
		return driver.findElement(verificationCodeTextbox).isDisplayed();
	}
	
	public BetterworksAcmeHomePage loginToAcmeApp(String emailId , String passwd) {
		driver.findElement(emailAddresstextField).sendKeys(emailId);
		waitUtil.waitForElementby(sendVerifCodeBtn);
		driver.findElement(sendVerifCodeBtn).click();
		
		waitUtil.waitForElementby(verificationCodeTextbox);    
		driver.findElement(verificationCodeTextbox).sendKeys(passwd);
		waitUtil.waitForElementby(loginButton);
		driver.findElement(loginButton).click();
		
		return new BetterworksAcmeHomePage(driver);
	}
}
