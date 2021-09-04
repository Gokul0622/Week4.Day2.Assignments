package week4.Day2.Assignments;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Droppable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/droppable/");
		String Title = driver.getTitle();
		System.out.println(Title);
		 driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.switchTo().frame(0);
		WebElement Draggable = driver.findElement(By.xpath("//div[@id='draggable']"));
		WebElement Dropppable = driver.findElement(By.xpath("//div[@id='droppable']"));
		
		Actions actions = new Actions(driver);
		actions.clickAndHold(Draggable).moveToElement(Dropppable).release(Dropppable).build().perform();

	}

}
