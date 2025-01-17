package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import pageObjects.AdminPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;

public class DependecyInjector {

	private WebDriver driver;
	private LoginPage loginPage;
	private HomePage homePage;
	private AdminPage adminPage;
	private Actions actions;
	
	public Actions getActions(WebDriver driver) {
		if(actions == null)
			actions = new Actions(getDriver());
		return actions;
	}
	
	public AdminPage getAdminPage() {
		if(adminPage == null)
			adminPage = new AdminPage(getDriver(), getActions(getDriver()));
		return adminPage;
	}
	
	public HomePage getHomePage() {
		if(homePage == null)
			homePage = new HomePage(getDriver());
		return homePage;
	}
	
	public WebDriver getDriver() {
		if(driver == null)
			driver = new ChromeDriver();
		return driver;
	}
	
	public LoginPage getLoginPage() {
		if(loginPage == null)
			loginPage = new LoginPage(getDriver());
		return loginPage;
	}

	public void quitDriver() {
		if(driver != null) {
			driver.quit();
			driver = null;
		}
	}
}
