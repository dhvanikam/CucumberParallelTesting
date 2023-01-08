package parallel;

import static org.testng.Assert.assertEquals;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import driverFactory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.HomePage;
import utilities.ConfigReader;
import utilities.Loggerload;

public class Currency_SD {

	private HomePage homepage = new HomePage();
	static Properties property;
	
	

	@Given("The user opens DS Algo portal link")
	public void the_user_opens_ds_algo_portal_link() throws Throwable {
//		ConfigReader.loadConfig();
//		DriverFactory.getdriver().get(ConfigReader.geturl());
		homepage.navigatetoHomePage();
		Loggerload.info("user is on product home page");
	}
	
	@When("The user clicks the {string} button")
	public void the_user_clicks_the_button(String string) {

		Loggerload.info("User clicks on \"Getstarted link\" on Main Page");
		homepage.getStarted_link(string);
	}

	@Then("The user should be redirected to homepage")
	public void the_user_should_be_redirected_to_homepage() {
		String Title = homepage.getPageTitle();
		Loggerload.info("Title of current page is ***** " + Title + " ****");
		assertEquals(Title, "NumpyNinja", "Title do not match");

	}

	@When("user click on select currency and set currency to EUR")
	public void user_click_on_select_currency_and_set_currency_to_eur() {
		homepage.setCurrency();
	}

	@Then("currency should set to EUR")
	public void currency_is_set_to_eur() {
		homepage.verifyCurrency();
	}

}
