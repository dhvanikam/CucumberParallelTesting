//package runner;
//
//import org.testng.annotations.DataProvider;
//
//import io.cucumber.testng.AbstractTestNGCucumberTests;
//import io.cucumber.testng.CucumberOptions;
//
//@CucumberOptions(plugin = { "pretty", "html:target/TS_001.html" }, // reporting purpose
//		monochrome = false, // console output
//		tags = "", // tags from feature file
//		features = { "src/test/resources/features" }, // location of feature files
//		glue = {"stepDefinition","appHooks"}) // location of step definition files
//
//public class TestRunner1 extends AbstractTestNGCucumberTests {
//	@Override
//	@DataProvider(parallel = true)
//	public Object[][] scenarios() {
//
//		return super.scenarios();
//	}
//}