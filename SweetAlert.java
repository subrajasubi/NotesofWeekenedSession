package week3.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SweetAlert {
	public static void main(String[] args) throws InterruptedException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.irctc.co.in/nget/train-search");
		driver.findElement(By.xpath("//input[contains(@class,'ng-tns-c57-8')]")).sendKeys("MS");
		driver.findElement(By.xpath("//span[text()='CHENNAI EGMORE - MS']")).click();
		driver.findElement(By.xpath("//input[contains(@class,'ng-tns-c57-9')]")).sendKeys("MDU");
		driver.findElement(By.xpath("//span[text()='MADURAI JN - MDU']")).click();
		driver.findElement(By.xpath("//button[@class='search_btn train_Search']")).click();
		driver.findElement(By.xpath("//div[contains(text(),'Refresh')]")).click();
		driver.findElement(By.xpath("//div[@class='WL col-xs-12']")).click();
		driver.findElement(By.xpath("//button[contains(text(),'Book Now')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='No']")).click();
	}

}
