package pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminPage {
	
	private Actions actions;
	
	public AdminPage(WebDriver driver, Actions actions) {
		this.actions = actions;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//span[contains(@class,'topbar-header')]/h6[1]")
	WebElement headerFromPage;
	
	@FindBy(xpath = "//label[text()='Username']/parent::div/parent::div//input")
	WebElement username;
	
	@FindBy(xpath = "//button[@type='submit']")
	WebElement search;
	
	@FindBy(xpath = "//span[contains(normalize-space(),') Record')]")
	WebElement recordsFound;
	
	@FindBy(xpath = "//span[contains(normalize-space(),'No Records Found')]")
	WebElement noRecordsFound;
	
	public Boolean isNoRecordsFoundPresent() {
		return noRecordsFound.isDisplayed();
	}
	
	public Boolean isRecordsFoundPresent() {
		return recordsFound.isDisplayed();
	}
	
	public String getRecordsFound() {
		try {
			return recordsFound.getText();
		} catch (Exception e) {
			return "(Exception) No records found.";
		}
	}
	
	public void clickSearch() {
		this.search.click();
	}
	
	public void clearUsername() {
		this.username.click();
		actions.keyDown(Keys.CONTROL).sendKeys("A").keyUp(Keys.CONTROL).perform();
		actions.keyDown(Keys.BACK_SPACE).keyUp(Keys.BACK_SPACE);
	}
	
	public void setUsername(String username) {
		clearUsername();
		this.username.sendKeys(username);
	}
	
	public String getHeaderFromPage() {
		return headerFromPage.getText();
	}
}
