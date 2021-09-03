package week4.Day2.Assignments;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.collections4.Get;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Sortable {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/pages/sortable.html");
		String Title = driver.getTitle();
		System.out.println(Title);
		//driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
		List<WebElement> sortable = driver.findElements(By.xpath("//div[@id='mydiv']//ul/li"));
		WebElement FromElement = sortable.get(0);
		WebElement ToElement = sortable.get(4);
		
		Actions action = new Actions(driver);
		
		action.clickAndHold(FromElement);
		action.moveToElement(ToElement);
		action.release(ToElement);
		action.build().perform();
		

	}

}
