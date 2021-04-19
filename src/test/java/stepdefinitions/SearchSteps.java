package stepdefinitions;

import static runner.Driver.*;
import io.cucumber.java.en.*;
import pages.*;


public class SearchSteps {
	
	SearchPage searchPage;
	HomePage homePage;
	
	@Given("^the user is on the home page$")
	public void the_user_is_on_the_home_page() {
		
		// initialize the appropriate browser driver 
		initializeDriver("chrome");

		// load the home page
		homePage = new HomePage();
		homePage.load();
	}

	@Given("^the user is on the used cars page$")
	public void the_user_is_on_the_used_cars_page(){
		
		// create a search page object and load the search page
		searchPage = new SearchPage();
		searchPage.load();
	}
	
	@When("^the user searches for a (.*) used car$")
	public void the_user_searches_for_a_used_car(String carName) {
		// search for a specific car
		searchPage.searchACar(carName);
	}
	
	@Then("^validate the (.*) of the car are displayed on the screen$")
	public void validate_the_car_details(String carDetails) {

		// validate the car details specified in the feature file
		searchPage.validateCarDetails(carDetails);
		
		// close all the browser windows and close the driver
		quitDriver();
	}
}
