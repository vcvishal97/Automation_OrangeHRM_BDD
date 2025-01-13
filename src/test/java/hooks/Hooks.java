package hooks;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import utilities.DependecyInjector;

public class Hooks {

	private final DependecyInjector injector;
	
	public Hooks(DependecyInjector injector) {
		this.injector = injector;
	}
	
	@Before
	public void setUp() {
		WebDriver driver = injector.getDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@After
	public void tearDown() {
		injector.quitDriver();
	}
}
