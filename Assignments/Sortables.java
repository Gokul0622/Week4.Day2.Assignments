package week4.Day2.Assignments;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Sortables {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/sortable/");
		String Title = driver.getTitle();
		System.out.println(Title);
		// driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.switchTo().frame(0);
		List<WebElement> sortable = driver.findElements(By.xpath("//ul[@id='sortable']/li"));
		WebElement FromElement = sortable.get(1);
		WebElement ToElement = sortable.get(6);

		Actions action = new Actions(driver);
		action.clickAndHold(FromElement);
		action.moveToElement(ToElement);
		action.release(ToElement);
		action.build().perform();

	}

}
