package demos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import utilities.DriverFactory;

public class NewAccount {

	public static void main(String[] args) {
		
		String name = "John";
		String email = "ravi@yopmail.com";
		String password = "password";
		String country = "India";
		String phoneNumber = "07123456781";
		String browserType = "firefox";
		String gender = "Male";
		boolean weeklyEmail = true;
		boolean monthlyEmail = false;
		boolean OccassionalEmail = false;
		
		//Define Webdriver
		WebDriver driver = DriverFactory.open(browserType);
		
		//1. Open browser to account Management page >> click to Create Account
		
		driver.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx");
		driver.findElement(By.linkText("CREATE ACCOUNT")).click();
		
		//Define Web Elements
		WebElement nameElement = driver.findElement(By.id("MainContent_txtFirstName"));
		WebElement emailElement = driver.findElement(By.name("ctl00$MainContent$txtEmail"));
		WebElement phoneElement = driver.findElement(By.xpath("//*[@id='MainContent_txtHomePhone']"));
		WebElement passwordElement = driver.findElement(By.cssSelector("input[type='password'][id='MainContent_txtPassword']"));
		WebElement verifyPasswordElement = driver.findElement(By.name("ctl00$MainContent$txtVerifyPassword"));
		WebElement countryElement = driver.findElement(By.id("MainContent_menuCountry"));
		WebElement maleRadio = driver.findElement(By.id("MainContent_Male"));
		WebElement femaleRadio = driver.findElement(By.id("MainContent_Female"));
		WebElement weeklyCheckbox = driver.findElement(By.id("MainContent_checkWeeklyEmail"));
		
		//3. Fill out the form
		nameElement.sendKeys(name);
		emailElement.sendKeys(email);
		phoneElement.sendKeys(phoneNumber);
		passwordElement.sendKeys(password);
		verifyPasswordElement.sendKeys(password);
		new Select(countryElement).selectByVisibleText(country);
		
		//Gender radio button
		if (gender.equalsIgnoreCase("Male")) { maleRadio.click(); } 
		else { femaleRadio.click(); }
		
		//Check box
		if (weeklyEmail) {
			if (!weeklyCheckbox.isSelected()) {
				weeklyCheckbox.click();
			}
		} else {
			if (weeklyCheckbox.isSelected()) {
				weeklyCheckbox.click();
			}
		}
		driver.findElement(By.id("MainContent_checkUpdates")).click();
		driver.findElement(By.id("MainContent_btnSubmit")).click();

		//4. Get Confirmation & Close Browser
		String conf = driver.findElement(By.id("MainContent_lblTransactionResult")).getText();
		String expected = "Customer information added successfully";
		if (conf.contains(expected)) {
			System.out.println("CONFIRMATION " + conf);
		} else {
			System.out.println("TEST FAILED!!");
		}
		driver.close();

	}

}
