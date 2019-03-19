package tests;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import utilities.DriverFactory;

public class Expedia {
	WebDriver driver;
	String browserType = "chrome";
	String city = "Bengaluru, Karnataka, India";
	String checkIn = "02/04/2019";
	String checkOut = "09/04/2019";
	String starRating = "star4";
	String searchResult = "2";
	
	@Test
	public void hotelReservation() throws InterruptedException {
		
		//Search
		driver.findElement(By.id("tab-hotel-tab-hp")).click();
		driver.findElement(By.id("hotel-destination-hp-hotel")).clear();
		driver.findElement(By.id("hotel-destination-hp-hotel")).sendKeys(city);
		driver.findElement(By.id("hotel-checkin-hp-hotel")).clear();
		driver.findElement(By.id("hotel-checkin-hp-hotel")).sendKeys(checkIn);
		driver.findElement(By.id("hotel-checkout-hp-hotel")).clear();
		driver.findElement(By.id("hotel-checkout-hp-hotel")).sendKeys(checkOut);
		//traveller selector
		driver.findElement(By.xpath("//*[@id=\"traveler-selector-hp-hotel\"]/div/ul/li/button")).click();
		//Adult selection
		driver.findElement(By.xpath("//*[@id=\"traveler-selector-hp-hotel\"]/div/ul/li/div/div/div[1]/div[2]/div[2]/button")).click();
		//child selction
		//driver.findElement(By.xpath("//*[@id=\"traveler-selector-hp-hotel\"]/div/ul/li/div/div/div[1]/div[3]/div[1]/div[4]/button")).click();
		driver.findElement(By.xpath("//*[@id=\"gcw-hotel-form-hp-hotel\"]/div[10]/label/button")).click();
		
		
		//print name of the city
		String city = driver.findElement(By.xpath("//*[@id=\"hotelResultTitle\"]/h1")).getText();
		System.out.println("CITY: " + city);
		// Modify the search result page, give criteria
		driver.findElement(By.cssSelector("input[name='star'][id='" + starRating +"']")).click();
		
		
		
		//Analyze the result and make selection
		//driver.findElement(By.xpath("//*[@id=\"34035064\"]/div[2]/div/a")).click();
		Thread.sleep(8000);
		WebDriverWait wait = new WebDriverWait(driver, 20);
		//driver.findElement(By.xpath("//*[@id=\"resultsContainer\"]/section/article[" + searchResult + "]/div[2]/div/a")).click();
		WebElement selectedHotel = wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"resultsContainer\"]/section/article["+ searchResult + "]/div[2]/div/a")));
				selectedHotel.click();
				
				
		//Switch the window to the popup
		ArrayList<String> windows = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(windows.get(1));
		
		//Print hotel name and star rating
		String hotelName = driver.findElement(By.id("hotel-name")).getText();
		String hotelRating = driver.findElement(By.cssSelector("span[class='rating-scale']")).getText();
		System.out.println("HOTEL: " + hotelName);
		System.out.println("RATING: " + hotelRating);
		
		
		// Book reservation
		driver.findElement(By.xpath("//*[@id=\"rooms-and-rates\"]/div/article/table/tbody[1]/tr[1]/td[3]/div/div[1]/button")).click();
		//select popup
		driver.findElement(By.id("pay-now-button")).click();
		
		String hotelPrice = driver.findElement(By.cssSelector("span[class='summary-total amount-value']")).getText();
		System.out.println("PRICE: " + hotelPrice);
		
		
		//Fill out contact/ billing
		
		//Get confirmation
		String pageTitle = driver.getTitle();
		Assert.assertTrue(pageTitle.contains("Payment"));
	}
	
	@BeforeMethod
	public void setUp() {
		driver = DriverFactory.open(browserType);
		driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
		driver.get("https://www.expedia.co.in/");
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
