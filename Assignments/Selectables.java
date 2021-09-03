package week4.Day2.Assignments;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Selectables {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/pages/selectable.html");
		String Title = driver.getTitle();
		System.out.println(Title);
		// driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		List<WebElement> Selectable = driver.findElements(By.xpath("//div[@id='mydiv']//ol/li"));
		int Size = Selectable.size();
		System.out.println("List of Selectable Size :" + Size);
		
		Actions action = new Actions(driver);
		action.keyDown(Keys.CONTROL).click(Selectable.get(0)).click(Selectable.get(1)).click(Selectable.get(2)).build().perform();
		

	}

}
