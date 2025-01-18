package testRunners;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.CucumberOptions.SnippetType;
import utilities.DependencyInjector;

@CucumberOptions(
			dryRun = !true,
			monochrome = true,
			snippets = SnippetType.CAMELCASE,
			features = "src/test/java/features/",
			glue = {"stepDefinitions", "hooks"},
			tags = "@smoke",
			plugin = {"pretty", "html:cucumberReports/report.html", "json:cucumberReports/report.json"}
		)
public class TestRunner extends AbstractTestNGCucumberTests {

	@Parameters("browser")
	@BeforeTest
	public void setBrowser(String browser) {
		DependencyInjector.setBrowser(browser);
	}
}
