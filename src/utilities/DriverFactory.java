package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
	//This method returns a web driver object
	public static WebDriver open(String browserType) {
		if (browserType.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "/Users/abhay/Documents/selenium/chromedriver");
			return new ChromeDriver();
		} else if (browserType.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "/Users/abhay/Documents/selenium/geckodriver");
			return new FirefoxDriver();
		} else {
			System.setProperty("webdriver.chrome.driver", "/Users/abhay/Documents/selenium/chromedriver");
			return new ChromeDriver();
		}
	}
}
