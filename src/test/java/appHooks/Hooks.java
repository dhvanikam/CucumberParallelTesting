package appHooks;

import java.io.ByteArrayInputStream;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import driverFactory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;
import utilities.ConfigReader;
import utilities.Loggerload;

public class Hooks {
	private DriverFactory driverfactory;
	private  WebDriver driver;
	private ConfigReader configreader;
	Properties prop;
	//private static final ThreadLocal<WebDriver> drivers = new ThreadLocal<>();

	@Before(order=0)
	public void before() throws Throwable {		
		Loggerload.info("Loading Config file");
		configreader= new ConfigReader();
		configreader.loadConfig();
//		String browser = ConfigReader.getBrowserType();
//		Loggerload.info("I am executing from hook before");	
//		driverfactory = new DriverFactory();
//		driver = driverfactory.initializeDrivers(browser);
//		drivers.set(driver);
		
	}
	@Before(order=1)
	public void launchbrowser() throws Throwable {		
		Loggerload.info("Loading Config file");
		String browser = prop.getProperty("browser");
		Loggerload.info("I am executing from hook before");	
		driverfactory = new DriverFactory();
		driver = driverfactory.initializeDrivers(browser);
		//drivers.set(driver);
		
	}

	@AfterStep
	public void afterstep(Scenario scenario) {
		if (scenario.isFailed()) {
			final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", "My screenshot");
			Allure.addAttachment("Myscreenshot",
					new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
		}
	}

	@After
	public void afterall() {
		driverfactory.closeallDriver();
	}
}
