package driverFactory;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.Loggerload;

public class DriverFactory {

	public WebDriver driver;
	public static ThreadLocal<WebDriver> threadDriver = new ThreadLocal<>();

	public WebDriver initializeDrivers(String browser) {
		if (browser.equalsIgnoreCase("firefox")) {
			Loggerload.info("Testing on firefox");
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			threadDriver.set(driver);

		} else if (browser.equalsIgnoreCase("chrome")) {
			Loggerload.info("Testing on chrome");
			WebDriverManager.chromedriver().browserVersion("108.0.0").setup();
			driver = new ChromeDriver();
			threadDriver.set(driver);
		}
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return getdriver();
	}

	public static synchronized WebDriver getdriver() {
		return threadDriver.get();
	}

	public void closeallDriver() {
		//driver.close();
		getdriver().close();
		getdriver().quit();
	}

}
