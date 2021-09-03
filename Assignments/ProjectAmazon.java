package project;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ProjectAmazon {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(3000);
		String parentWindowHandle=driver.getWindowHandle();
		
		WebElement SearchBar = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
		SearchBar.sendKeys("oneplus 9 pro", Keys.ENTER);
		Thread.sleep(3000);
		driver.findElement(By.partialLinkText("OnePlus 9 Pro 5G ")).click();	
		
		Set<String> WindowHandles = driver.getWindowHandles();
		for (String NewWindows : WindowHandles) {
			driver.switchTo().window(NewWindows);
		
		}
		Thread.sleep(2000);
		String Price = driver.findElement(By.xpath("//span[@id='priceblock_ourprice']")).getText();
		System.out.println("Price of the First Displayed Phone is : " + Price );		
		
		String Ratings = driver.findElement(By.xpath("(//span[@id='acrCustomerReviewText'])[1]")).getText();
		System.out.println("Price of the First Dsiplayed Phone is : " +Ratings );	
	
		WebElement mouseHover = driver.findElement(By.xpath("//div[@id='averageCustomerReviews_feature_div']//i[@class='a-icon a-icon-star a-star-4']"));
		Actions action = new Actions(driver);
		action.moveToElement(mouseHover).perform();
		
	}
	
}
