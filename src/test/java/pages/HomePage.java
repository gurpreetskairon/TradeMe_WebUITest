package pages;

import static runner.Driver.*;

public class HomePage {
	
	public void load() {
		driver.get(getConfigProperty("home_page_url"));
	}
	
}
