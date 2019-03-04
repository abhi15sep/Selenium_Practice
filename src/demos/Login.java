package demos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login {

	public static void main(String[] args) {
		//1. Define the web driver
		System.setProperty("webdriver.chrome.driver", "/Users/abhay/Documents/selenium/chromedriver");
		WebDriver driver = new ChromeDriver();
		
		//2. Open web browser and navigate to page
		//http://sdettraining.com/trguitransactions/AccountManagement.aspx
		driver.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx");
		
		// Find elements: Locate elements, determine the action, pass any parameters
		
		//3. Enter email address.
		driver.findElement(By.id("MainContent_txtUserName")).sendKeys("raviraj@yopmail.com");
		//4. Enter password
		driver.findElement(By.id("MainContent_txtPassword")).sendKeys("thbs123!");
		//5 Click Login
		driver.findElement(By.id("MainContent_btnLogin")).click();
		//6 Get confirmation
		String message = driver.findElement(By.id("conf_message")).getText();
		System.out.println("CONFIRMATION: " + message);
		
		String pageTitle = driver.getTitle();
		if (pageTitle.equals("SDET Training | Account Management")) {
			System.out.println("PAGE TITLE TEST PASSED");
		}
		
		//7 Close the browser
		driver.close();
	}

}
