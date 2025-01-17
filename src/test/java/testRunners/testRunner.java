package testRunners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.CucumberOptions.SnippetType;

@CucumberOptions(
			dryRun = !true,
			monochrome = true,
			snippets = SnippetType.CAMELCASE,
			features = "src/test/java/features/",
			glue = {"stepDefinitions", "hooks"},
			tags = "@smoke",
			plugin = {"pretty", "html:cucumberReports/report.html"}
		)

public class testRunner extends AbstractTestNGCucumberTests {

}
