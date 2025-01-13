package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjects.HomePage;
import pageObjects.LoginPage;

public class DependecyInjector {

	private WebDriver driver;
	private LoginPage loginPage;
	private HomePage homePage;
	
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
