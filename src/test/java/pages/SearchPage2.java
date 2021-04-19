package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.WebElement;

import static runner.Driver.driver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SearchPage2 {
	
	String url = "https://www.tmsandbox.co.nz/motors/used-cars";
	String NumberPlate;
	String Kilometres;
	String Body;
	String Seats;
	
	By txtSearch = By.id("searchString");
	By btnSearch = By.className("btn btn-trademe");
	By lnkCar = By.className("tmm-search-card-list-view__listing-photo");
	By lstCarDetails = By.xpath("//*[@id='AttributesDisplay_attributesSection']/ul/li");
	
	public void searchACar(String carName){

		driver.findElement(txtSearch).sendKeys(carName);
		//driver.findElement(btnSearch).click();
		driver.findElement(txtSearch).sendKeys(Keys.ENTER);
		driver.findElement(lnkCar).click();
	}

	public void validateCarDetails(String carDetails) {
		List<WebElement> lstDetails = driver.findElements(lstCarDetails);

		for (WebElement e : lstDetails) {
			String prevTag = "NotInterested";
			
			for (WebElement x : e.findElements(By.tagName("div"))) {
				switch (prevTag) {
				case "NumberPlate":
					this.NumberPlate = x.getText(); 
					break;
				case "Kilometres":
					this.Kilometres = x.getText();
					break;
				case "Body":
					this.Body = x.getText();
					break;
				case "Seats":
					this.Seats= x.getText();
					break;
				}
				
				if (x.getText().strip().equals("Number plate"))
					prevTag = "NumberPlate";
				else if (x.getText().strip().equals("Kilometres"))
					prevTag = "Kilometres";
				else if (x.getText().strip().equals("Body"))
					prevTag = "Body";
				else if (x.getText().strip().equals("Seats"))
					prevTag = "Seats";
				else
					prevTag = "NotInterested";
			}
		}

		// print the values
		System.out.println("Number Plate: " + this.NumberPlate);
		System.out.println("Kilometers: " + this.Kilometres);
		System.out.println("Body: " + this.Body);
		System.out.println("Seats: " + this.Seats);

	}

	public void load() {
		driver.get(url);
	}
}
