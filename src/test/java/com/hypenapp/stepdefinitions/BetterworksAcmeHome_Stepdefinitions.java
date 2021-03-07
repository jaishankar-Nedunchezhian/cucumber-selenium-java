package com.hypenapp.stepdefinitions;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import com.hypen.factory.DriverFactory;
import com.hypen.pages.BetterworksAcmeHomePage;
import com.hypen.pages.BetterworksLoginPage;
import com.hypen.util.ConfigReader;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BetterworksAcmeHome_Stepdefinitions {
	
	private BetterworksLoginPage betterworksLoginPage = new BetterworksLoginPage(DriverFactory.getDriver());
	BetterworksAcmeHomePage betterworksAcmeHomePage;
	
	@Given("user has already logged in to the Acme application")
	public void user_has_already_logged_in_to_the_acme_application(DataTable dataTable) {
		List<Map<String,String>> loginList = dataTable.asMaps();
		String emailId = loginList.get(0).get("emailaddress");
		String passwd = loginList.get(0).get("verificationcode");
		
		DriverFactory.getDriver().get(new ConfigReader().init_prop().getProperty("AppURL"));
		betterworksAcmeHomePage = betterworksLoginPage.loginToAcmeApp(emailId , passwd);			
	}

	@Given("user is on the Acme Home page")
	public void user_is_on_the_acme_home_page() {
		Assert.assertTrue("users is not the Acme home page after login", betterworksAcmeHomePage.isacmeHomePageHeaderTextDisplayed());
	}
	@Then("I should see the AcmeTest home page")
	public void i_should_see_the_acme_test_home_page() {
		Assert.assertTrue(betterworksAcmeHomePage.isacmeHomePageHeaderTextDisplayed());
	}
	@Then("I should see the create a new post Button")
	public void i_should_see_the_create_a_new_post_button() {
		Assert.assertTrue("Create post Btn is not visible", betterworksAcmeHomePage.isCreatePostButtonPresent());
	}
	
	@When("I click on create new Post Button")
	public void i_click_on_create_new_post_button() {
		betterworksAcmeHomePage.clickOnCreatePostButton();
	}

	@Then("I should see the create new post -Select type modal box")
	public void i_should_see_the_create_new_post_select_type_modal_box() {
		Assert.assertTrue("Open Btn is not visible", betterworksAcmeHomePage.isPollTypeOpenButtonPresent());
		Assert.assertTrue("Multiple choice Btn is not visible",betterworksAcmeHomePage.isPollTypeMultipleChoiceButton());
	}
	
	@Then("I choose the radio button - Anonymous-Official-Named category {string}")
	public void i_choose_the_radio_button_anonymous_official_named_category(String type) throws InterruptedException {
		Assert.assertTrue("Radio button not present",betterworksAcmeHomePage.selectRadioButtonGroup(type));
	}
	
	@When("I choose the post type - Open or Multiple Choice {string}")
	public void i_choose_the_post_type_open_or_multiple_choice(String postType) throws InterruptedException {
	    betterworksAcmeHomePage.selectPostType(postType);
	}
	
	@When("I choose the co-worker groups from the drop down {string}")
	public void i_choose_the_co_worker_groups_from_the_drop_down(String groupListSelection) throws InterruptedException {
		betterworksAcmeHomePage.clickOnDropDown();
		betterworksAcmeHomePage.groupList(groupListSelection);
	}

	@When("I click on select button")
	public void i_click_on_select_button() {
		betterworksAcmeHomePage.clickOnSelectButton();
	}
	@Then("I should see the Create new post -Write post modal box")
	public void i_should_see_the_create_new_post_write_post_modal_box(){
		Assert.assertTrue("publish post Btn not present", betterworksAcmeHomePage.isPublishPostButtonDisplayed());
		Assert.assertTrue(betterworksAcmeHomePage.getWritePostheaderText().contains("Create new post -Write post"));
	}
	
	@Then("I type the question-opinion-feedback on the post {string}")
	public void i_type_the_question_opinion_feedback_on_the_post(String postInfo) {
	    betterworksAcmeHomePage.writePost(postInfo);
	}
	
	@Then("I click on publish Post")
	public void i_click_on_publish_post() throws InterruptedException {
	    betterworksAcmeHomePage.clickOnPublishPostButton();
	}
}
