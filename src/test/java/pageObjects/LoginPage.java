package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//input[@name='username']")
	WebElement username;
	
	@FindBy(xpath = "//input[@name='password']")
	WebElement password;
	
	@FindBy(xpath = "//button[contains(normalize-space(),'Login')]")
	WebElement loginButton;
	
	@FindBy(xpath = "//p[contains(normalize-space(),'Invalid credentials')]")
	WebElement invalidCredentials;
	
	@FindBy(xpath = "//a[@class='oxd-main-menu-item']/span[text()='Admin']")
	WebElement adminTab;
	
	public void clickAdmin() {
		adminTab.click();
	}
	
	public boolean isInvalidCredentialsPresent() {
		return invalidCredentials.isDisplayed();
	}
	
	public void clickLoginButton() {
		loginButton.click();
	}
	
	public void setPassword(String password) {
		this.password.sendKeys(password);
	}
	
	public void setUsername(String username) {
		this.username.sendKeys(username);
	}
}
