package com.hypen.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.hypen.util.WaitUtil;

public class BetterworksAcmeHomePage {

	private WebDriver driver;
	private WaitUtil waitUtil;

	public BetterworksAcmeHomePage(WebDriver driver) {
		this.driver = driver;
		waitUtil = new WaitUtil(driver);
		PageFactory.initElements(driver, this);
	}

	private By acmeHomePageHeaderText = By.xpath("//div[@class='sidebar-company-header']");
	private By createPostButton = By.xpath("//button[@id='create-button']");
	private By pollTypeOpenButton = By.xpath("//button[contains(text(),'OPEN')]");
	private By pollTypeMultipleChoiceButton = By.xpath("//button[contains(text(),'MULTIPLE CHOICE')]");
	private By radioButtonGroup = By.xpath("//div[@class='ant-radio-group']//label");
	private By dropDownButton = By.xpath("//span[@class='Select-arrow-zone']");
	private By selectGroupList = By
			.xpath("//div[@class='Select-menu-outer']/div/div[@class='Select-option-group']//div");
	private By selectGroupAll = By.xpath("//div[@class='Select-menu-outer']//div[text()='All']");
	private By selectButton = By.xpath("//button[contains(text(),'Select')]");
	private By writePostHeaderInfo = By.xpath("//h3[contains(text(),'Create new post -Write post')][@class='modal-title']");
	private By writePosttextArea = By.xpath("//textarea[@class='textArea form-control'][@id='textAreaField']");
	private By publishPostButton = By.xpath("//button[@class='hyphenButton smallButton btn btn-default'][@type='submit']");
	
	
	public boolean isacmeHomePageHeaderTextDisplayed() {
		waitUtil.waitForElementby(acmeHomePageHeaderText);
		waitUtil.waitForElementby(createPostButton);
		return driver.findElement(acmeHomePageHeaderText).isDisplayed();
	}

	public boolean isCreatePostButtonPresent() {
		waitUtil.waitForElementby(createPostButton);
		return driver.findElement(createPostButton).isDisplayed();
	}

	public String getAskCeotext() {
		return driver.findElement(createPostButton).getText();
	}

	public void clickOnCreatePostButton() {
		waitUtil.waitForElementby(createPostButton);
		driver.findElement(createPostButton).click();
	}

	public boolean selectRadioButtonGroup(String type) throws InterruptedException {
		List<WebElement> radioButtonList = driver.findElements(radioButtonGroup);
		for (WebElement webElement : radioButtonList) {
			if (webElement.getText().equalsIgnoreCase(type)) {
				if (!webElement.isSelected()) {
					webElement.click();
				}else {
					return false;
				}
			}
		}
		
		return true;
	}

	public boolean isPollTypeOpenButtonPresent() {
		waitUtil.waitForElementby(pollTypeOpenButton);
		return driver.findElement(pollTypeOpenButton).isDisplayed();
	}

	public boolean isPollTypeMultipleChoiceButton() {
		waitUtil.waitForElementby(pollTypeMultipleChoiceButton);
		return driver.findElement(pollTypeMultipleChoiceButton).isDisplayed();
	}

	public void selectPostType(String postType) throws InterruptedException {
		if (postType.equalsIgnoreCase("OPEN")) {
			driver.findElement(pollTypeOpenButton).click();
		} else if (postType.equalsIgnoreCase("MULTIPLE CHOICE")) {
			driver.findElement(pollTypeMultipleChoiceButton).click();
			System.out.println("Click on the Multiple Type post button");
		} else {
			System.out.println("Invalid post type value");
		}
	}

	public void clickOnDropDown() throws InterruptedException {
		waitUtil.waitForElementby(dropDownButton);
		driver.findElement(dropDownButton).click();
	}

	public void groupList(String groupListChosen) {
		if(groupListChosen.equalsIgnoreCase("All")) {
			waitUtil.waitForElementby(selectGroupAll);
			driver.findElement(selectGroupAll).click();
		} 
		else{		
			List<WebElement> groupList = driver.findElements(selectGroupList);
			for (WebElement webElement : groupList) {				
				if (webElement.getText().equalsIgnoreCase(groupListChosen)) {
					webElement.click();
					break;
				}
			}	
		}
	}
	
	public void clickOnSelectButton() {
		waitUtil.waitForElementby(selectButton);
		driver.findElement(selectButton).click();
	}
	
	public boolean isPublishPostButtonDisplayed() {
		waitUtil.waitForElementby(publishPostButton);
		return driver.findElement(publishPostButton).isDisplayed();
	}
	
	public String getWritePostheaderText(){
		waitUtil.waitForElementby(writePostHeaderInfo);
		return driver.findElement(writePostHeaderInfo).getText();
	}
	
	public void writePost(String postInfo){
		driver.findElement(writePosttextArea).sendKeys(postInfo);
	}
	
	public void clickOnPublishPostButton() throws InterruptedException {
		driver.findElement(publishPostButton).click();
	}
}
