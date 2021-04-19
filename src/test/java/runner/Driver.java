package runner;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Driver {

	public static WebDriver driver;

	public static void initializeDriver(String driverName){
		// load the appropriate browser driver 
		switch (driverName){
		case "chrome":
		default:
			// pick the driver path from the config.properties file
			System.setProperty("webdriver.chrome.driver", getConfigProperty("chrome_driver_path"));
			driver = new ChromeDriver();
			break;
		}
		
		// set the implicit timeout waits for every statement and page loads
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

		// maximize the browser window
		driver.manage().window().maximize();
	}
	
	public static void quitDriver() {
		
		// close all the open browser windows opened by the test
		driver.close();

		// close the browser driver 
		driver.quit();
	}

	public static String getConfigProperty(String propertyName) {

		// this method reads the property values and returns it as a string
		Properties prop  = new Properties();
		try {
			File configProperties = new File("src/test/resources/config.properties");
			prop.load(new FileInputStream(configProperties));
		}
		catch(FileNotFoundException e) {}
		catch (IOException e) {}

		return prop.getProperty(propertyName);

	}
}
