package project;

import java.awt.Window;
import java.util.ArrayList;
import java.util.List;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ProjectMyntra {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.myntra.com/");
		driver.manage().window().maximize();
		

		WebElement MouseHoverMen = driver.findElement(By.xpath("//a[text()='Men']"));
		Actions action = new Actions(driver);
		action.moveToElement(MouseHoverMen).perform();

		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text()='Jackets']")).click();

		String TotalCount = driver.findElement(By.xpath("//span[@class='title-count']")).getText();
		String Replace = TotalCount.replaceAll("[^0-9]", "");
		int ReplaceInt = Integer.parseInt(Replace);
		System.out.println("Total Count of MenJacket item is : " + ReplaceInt);

		String JacketCount = driver.findElement(By.xpath("(//span[@class='categories-num'])[1]")).getText();
		String Replace1 = JacketCount.replaceAll("[^0-9]", "");
		int Replace1Int = Integer.parseInt(Replace1);
		System.out.println("Total Count of Jacket is : " + Replace1Int);

		String RainJacketCount = driver.findElement(By.xpath("//label[text()='Rain Jacket']")).getText();
		String Replace2 = RainJacketCount.replaceAll("[^0-9]", "");
		int Replace2Int = Integer.parseInt(Replace2);
		System.out.println("Total Count of RainJacket is : " + Replace2Int);

		int sum = Replace1Int + Replace2Int;
		if (Replace1Int == Replace2Int)
			System.out.println("Count Mached");
		else
			System.out.println("Count Mismatched");

		driver.findElement(By.xpath("//div[@class='brand-more']")).click();
		Thread.sleep(2000);
		WebElement Searchbar = driver.findElement(By.xpath("//input[@placeholder='Search brand']"));
		Searchbar.sendKeys("Duke");
		Thread.sleep(2000);
		WebElement Dukebox = driver.findElement(By.xpath("(//label[@class =' common-customCheckbox'])[1]"));
		Dukebox.click();

		WebElement Closebox = driver
				.findElement(By.xpath("//span[@class='myntraweb-sprite FilterDirectory-close sprites-remove']"));
		Closebox.click();

		// List<String> list = new ArrayList<String>();
		WebElement Sort = driver.findElement(By.xpath("//div[@class='sort-sortBy']"));
		Actions action1 = new Actions(driver);
		action1.moveToElement(Sort).perform();
		WebElement Sorting = driver.findElement(By.xpath("(//label[@class='sort-label '])[3]"));
		Sorting.click();
		WebElement FirstProduct = driver.findElement(By.xpath(""));

		String Price = driver.findElement(By.xpath("(//span[@class='product-discountedPrice'])[1]")).getText();
		System.out.println(" Price of the Item is : " +Price);
		
		WebElement Hover = driver.findElement(By.xpath("(//h3[@class='product-brand'])[1]"));
	
		Actions action2=new Actions(driver);
		action2.moveToElement(Hover).perform();
		Thread.sleep(3000);
		WebElement WishList = driver.findElement(By.xpath("//div[@id='mountRoot']//li[1]//div[3]//span[1][1]//span[1]"));
		WishList.click();
		driver.close();
	}

}
