package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import utilities.DependecyInjector;

public class LoginSteps {

	private final WebDriver driver;
	private LoginPage loginPage;
	private HomePage homePage;
	private final String URL = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
	
	public LoginSteps(DependecyInjector injector) {
		driver = injector.getDriver();
		loginPage = injector.getLoginPage();
		homePage = injector.getHomePage();
	}
	
	@Given("user launches the applicatio")
	public void userLaunchesTheApplicatio() {
	    driver.get(URL);
	}

	@Given("user enters the credentials {string} {string}")
	public void userEntersTheCredentials(String username, String password) {
	    loginPage.setUsername(username);
	    loginPage.setPassword(password);
	}

	@When("user clicks login button")
	public void userClicksLoginButton() {
	    loginPage.clickLoginButton();
	}

	@Then("user should be logged in")
	public void userShouldBeLoggedIn() {
	    Assert.assertTrue(homePage.isUserDropdownPresent(), "Couldn't login");
	}

	@Then("login should fail")
	public void loginShouldFail() {
		Assert.assertTrue(loginPage.isInvalidCredentialsPresent(), "Credentials aren't invalid.");
	}
	
	@Then("user should logout")
	public void userShouldLogout() {
	    homePage.clickUserDropdown();
	    homePage.clickLogout();
	}
}
