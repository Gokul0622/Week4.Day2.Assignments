package week4.Day2.Assignments;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Selectable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/selectable/");
		String Title = driver.getTitle();
		System.out.println(Title);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.switchTo().frame(0);
	List<WebElement> Selectable = driver.findElements(By.xpath("//ol[@id='selectable']/li"));

		Actions actions = new Actions(driver);
		actions.keyDown(Keys.CONTROL).click(Selectable.get(0)).click(Selectable.get(1)).click(Selectable.get(2)).build().perform();

	}

}
