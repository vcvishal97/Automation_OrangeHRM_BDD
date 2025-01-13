package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//i[contains(@class,'userdropdown')]")
	WebElement userDropdown;
	
	@FindBy(xpath = "//a[normalize-space()='Logout']")
	WebElement logoutButton;
	
	public void clickUserDropdown() {
		userDropdown.click();
	}
	
	public void clickLogout() {
		logoutButton.click();
	}
	
	public boolean isUserDropdownPresent() {
		return userDropdown.isDisplayed();
	}
}
