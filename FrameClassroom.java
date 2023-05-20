package s;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class FrameClassroom {
	public static void main(String[] args) throws InterruptedException {
		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(opt);
		driver.manage().window().maximize();
		driver.get("https://buythevalue.in/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.switchTo().frame("dummy-chat-button-iframe");
		driver.findElement(By.id("dummy-chat-button")).click();
		driver.switchTo().frame("ShopifyChat");
		driver.findElement(By.xpath("//div[@class='composer-bar__box']/textarea")).sendKeys("Hai");
		//Thread.sleep(2000);
		driver.findElement(By.xpath("//button[contains(@class,'chat-app')]")).click();
		driver.switchTo().defaultContent();
		Thread.sleep(2000);
		driver.findElement(By.className("product-title")).click();
		String urbanText = driver.findElement(By.xpath("//span[@class='price on-sale']")).getText();
		String replacedString = urbanText.replaceAll("₹ ", "").replaceAll(",", "");
	    double price = Double.parseDouble(replacedString);
	   // System.out.println(price);
		driver.findElement(By.id("wk_zipcode")).sendKeys("600050");
		//Thread.sleep(2000);
		WebElement a = driver.findElement(By.xpath("//input[@class='btn']"));
        driver.executeScript("arguments[0].click();", a);
        //Thread.sleep(2000);
        WebElement addToCart = driver.findElement(By.id("product-add-to-cart"));
        driver.executeScript("arguments[0].click();", addToCart);
		driver.findElement(By.xpath("(//a[contains(text(),'View Cart')])[2]")).click();
		driver.findElement(By.id("checkout")).click();
		//Thread.sleep(2000);
		Alert alert = driver.switchTo().alert();
	    String text = alert.getText();
	    System.out.println("Alert Message: "+text);
	    alert.accept();
	    driver.findElement(By.id("agree")).click();
	    driver.findElement(By.id("checkout")).click();
	    Thread.sleep(3000);
	    String cartText = driver.findElement(By.xpath("(//span[@class='price-cart-mini'])[2]")).getText();
	    String replaceAll= cartText.replaceAll("₹ ", "").replaceAll(",", "");
	    double priceIntheCart = Double.parseDouble(replaceAll);
	    //System.out.println(priceIntheCart);
	    if (price==priceIntheCart) {
			System.out.println("Item added successfully");
		}
	    else {
	    	System.out.println("Not added");
	    }
	    driver.quit();
		
	}

}
