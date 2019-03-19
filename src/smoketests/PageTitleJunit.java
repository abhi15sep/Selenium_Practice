package smoketests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import utilities.DriverFactory;

public class PageTitleJunit {
	
	WebDriver driver;
	String webURL = "http://sdettraining.com/trguitransactions/AccountManagement.aspx";
	
	@Test
	public void pageTitleTest() {
		System.out.println("Running the test");
		driver.get(webURL);
		String actualTitle = driver.getTitle();
		String expectedTitle = "SDET Training | Account Management";
		Assert.assertEquals("Test", actualTitle, expectedTitle);
	}
	
	@Before
	public void setup() {
		System.out.println("Initializing driver...");
		driver = DriverFactory.open("chrome");
	}
	
	@After
	public void teardown() {
		System.out.println("Closing driver.");
		driver.close();
	}
}
