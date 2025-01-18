package utilities;

import java.io.FileInputStream;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import pageObjects.AdminPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;

public class DependencyInjector {

	private LoginPage loginPage;
	private HomePage homePage;
	private AdminPage adminPage;
	private Actions actions;
	private Properties properties;
	private String configFilePath = "src/test/resources/config.properties";
	private BrowserFactory browserFactory;
	private static ThreadLocal<String> browser = new ThreadLocal<>();
	private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
	
	public static void setBrowser(String browserName) {
		browser.set(browserName);
	}
	
	public static String getBrowser() {
		return browser.get();
	}
	
	public BrowserFactory getBrowserFactory() {
		if(browserFactory == null)
			browserFactory = new BrowserFactory();
		return browserFactory;
	}
	
	public Properties getProperties() {
		if(properties == null)
			properties = new Properties();
		try {
			properties.load(new FileInputStream(configFilePath));
		} catch (Exception e) {
			throw new RuntimeException("config.properties file not found.");
		}
		return properties;
	}
	
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
		if(driver.get() == null)
			driver.set(getBrowserFactory().getDriver(getBrowser()));
		return driver.get();
	}
	
	public LoginPage getLoginPage() {
		if(loginPage == null)
			loginPage = new LoginPage(getDriver());
		return loginPage;
	}

	public void quitDriver() {
		if(driver.get() != null) {
			driver.get().quit();
			driver.remove();
		}
	}
}
