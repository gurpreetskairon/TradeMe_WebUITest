package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertTrue;
import static runner.Driver.*;

import java.util.ArrayList;
import java.util.List;

public class SearchPage {

	By txtSearch = By.id("searchString");
	By btnSearch = By.className("btn btn-trademe");
	By lnkCar = By.className("tmm-search-card-list-view__listing-photo");
	By CarLabelDetails = By.xpath("//*[@id='AttributesDisplay_attributesSection']/ul/li/div[@class='key-details-attribute-label']");

	public void searchACar(String carName){
		driver.findElement(txtSearch).sendKeys(carName);
		driver.findElement(txtSearch).sendKeys(Keys.ENTER);
		driver.findElement(lnkCar).click();
	}

	public void validateCarDetails(String carDetails) {

		String[] details = carDetails.split(",");

		List<WebElement> lstCarLabelDetails = driver.findElements(CarLabelDetails);
		
		assertTrue(lstCarLabelDetails.size() > 0);
		
		List<String> actualLabels = new ArrayList<String>();
		
		for (WebElement label : lstCarLabelDetails) {
			actualLabels.add(label.getText());
		}
		
		for (String expectedLabel : details) {
			assertTrue("Unable to find the " + expectedLabel.trim() + " label under the car details!", actualLabels.contains(expectedLabel.trim()));
		}
	}

	public void load() {
		driver.get(getConfigProperty("search_page_url"));
	}
}
