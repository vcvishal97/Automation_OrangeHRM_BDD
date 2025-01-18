package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {

	private WebDriver driver;
	
	public WebDriver getDriver(String browser) {
		switch(browser.toLowerCase()) {
			case "chrome"	: driver = new ChromeDriver();	break;
			case "edge"		: driver = new EdgeDriver(); 	break;
			case "firefox"	: driver = new FirefoxDriver();	break;
			default			: throw new RuntimeException("Invalid browser - " + browser);
		}
		return driver;
	}
}
