package com.hypenapp.stepdefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.hypen.factory.DriverFactory;
import com.hypen.pages.BetterworksAcmeHomePage;
import com.hypen.pages.BetterworksLoginPage;
import com.hypen.util.ConfigReader;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class BetterworksLogin_Stepdefinitions {

	private BetterworksLoginPage betterworksLoginPage = new BetterworksLoginPage(DriverFactory.getDriver());
	private BetterworksAcmeHomePage betterworksAcmeHomePage;
	
	@Given("^I am on the gethypen login page application$")
	public void i_am_on_the_gethypen_login_page_application() {
		DriverFactory.getDriver().get(new ConfigReader().init_prop().getProperty("AppURL"));
	}

	@Then("^I should see the email text box and verification code button$")
	public void i_should_see_the_email_text_box_and_verification_code_button() {
		Assert.assertTrue(betterworksLoginPage.isEmailAddressFieldPresent());
		Assert.assertTrue(betterworksLoginPage.isVerificationCodeButtonPresent());
	}
	
	@Then("I should see the verification code Text box")
	public void i_should_see_the_verification_code_text_box() {
		betterworksLoginPage.isVerficationCodeButtonDisplayed();
	}
	
	@And("^I enter the work email address (.+)$")
	public void i_enter_the_work_email_address(String emailaddress) {
		betterworksLoginPage.enterEmailAddress(emailaddress);
	}

	@And("^I click on the send me the verification code Button$")
    public void i_click_on_the_send_me_the_verification_code_button()  {
        betterworksLoginPage.clickOnVerificationCodeButton();
    }

	@And("^I enter the verification code (.+)$")
	public void i_enter_the_verification_code(String verificationcode) throws InterruptedException {
		betterworksLoginPage.enterVerificationCode(verificationcode);
	}

	@And("^I click on the Login Button$")
	public void i_click_on_the_login_button() throws InterruptedException{
		betterworksAcmeHomePage = betterworksLoginPage.clickOnLoginButton();
	}
	@Then("I am seeing the acme home page")
	public void i_am_seeing_the_acme_home_page() {
		Assert.assertTrue(betterworksAcmeHomePage.isacmeHomePageHeaderTextDisplayed());
	}
}
