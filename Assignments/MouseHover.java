package project;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MouseHover {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/pages/mouseOver.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(3000);
		
		
		WebElement MouseHover = driver.findElement(By.xpath("//a[@class='btnMouse']"));
		Actions actions = new Actions(driver);
		actions.moveToElement(MouseHover).perform();
		List<WebElement> list = driver.findElements(By.xpath("//body//div[@id='wrapper']//li//li"));
		System.out.println(list);
		driver.findElement(By.xpath("//a[normalize-space()='Selenium']")).click();
		Alert alert = driver.switchTo().alert();
		alert.accept();
		
	}
	

}
