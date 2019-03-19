package demos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateAccount {

	public static void main(String[] args) {
		//1. Create Web driver
		System.setProperty("webdriver.gecko.driver", "/Users/abhay/Documents/selenium/geckodriver");
		WebDriver driver = new FirefoxDriver();
		
		//2. Open browser to account Management page >> click to Create Account
		driver.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx");
		driver.findElement(By.linkText("CREATE ACCOUNT")).click();
		
		//3. Fill out the form
			//How to locate elements
			driver.findElement(By.id("MainContent_txtFirstName")).sendKeys("John");
			driver.findElement(By.name("ctl00$MainContent$txtEmail")).sendKeys("ravi@yopmail.com");
			
			driver.findElement(By.xpath("//*[@id='MainContent_txtHomePhone']")).sendKeys("07123456781");
			
			driver.findElement(By.cssSelector("input[type='password'][id='MainContent_txtPassword']")).sendKeys("password");
			
			driver.findElement(By.name("ctl00$MainContent$txtVerifyPassword")).sendKeys("password");
			
			//How to interact with other html elements
			driver.findElement(By.id("MainContent_Male")).click();
			new Select(driver.findElement(By.id("MainContent_menuCountry"))).selectByVisibleText("India");
			driver.findElement(By.id("MainContent_checkUpdates")).click();
			driver.findElement(By.id("MainContent_btnSubmit")).click();

		//4. Get Confirmation
		String conf = driver.findElement(By.id("MainContent_lblTransactionResult")).getText();
		System.out.println("CONFIRMATION " + conf);
		//5. Close the browser.
		driver.close();
	}

}
