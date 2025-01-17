package stepDefinitions;

import org.testng.Assert;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.AdminPage;
import pageObjects.HomePage;
import utilities.DependecyInjector;

public class SearchUsersSteps {

	private HomePage homepage;
	private AdminPage adminPage;
	
	public SearchUsersSteps(DependecyInjector injector) {
		homepage = injector.getHomePage();
		adminPage = injector.getAdminPage();
	}
	
	@When("user clicks the admin button")
	public void userClicksTheAdminButton() {
	    homepage.clickAdminButton();
	}

	@When("user enters the username {string}")
	public void userEntersTheUsername(String username) {
	    adminPage.setUsername(username);
	}
	
	@When("user clicks the search button")
	public void userClicksTheSearchButton() {
	    adminPage.clickSearch();
	}

	@Then("record should appear")
	public void recordShouldAppear() {
	    Assert.assertTrue(adminPage.isRecordsFoundPresent(), "NO RECORDS FOUND.");
	}
	
	@Then("no record should appear")
	public void noRecordShouldAppear() {
		Assert.assertTrue(adminPage.isNoRecordsFoundPresent(), "SEARCHED WITH VALID DATA INSTEAD OF VALID.");
	}

}
