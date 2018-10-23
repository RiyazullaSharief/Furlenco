package furlenco;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class LivingAddToCart
{
	public static void main(String[] args) throws InterruptedException
	{
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.furlenco.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.findElement(By.xpath("//div[contains(text(),'Bengaluru')]")).click();
		Thread.sleep(5000);
		try
		{
			Assert.assertEquals(driver.getTitle(),"Rent Award Winning Furniture from Furlenco | Free Delivery within 3 Days | Furlenco","Title is not matching in home page...");
			System.out.println("Title is matching in home page...");
		}
		catch(AssertionError a)
		{
			System.out.println(a.getMessage());
		}
		driver.findElement(By.xpath("//span[contains(text(),'LOGIN')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[contains(@placeholder,'Email ID or Mobile Number')]")).sendKeys("8861538394"); //Enter Mob No.
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[contains(text(),'Next')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("riyaz560022"); //Enter password
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//span[contains(text(),'Login')])[1]")).click();
		Thread.sleep(5000);
		try
		{
			Assert.assertEquals(driver.getTitle(),"Rent Award Winning Furniture from Furlenco | Free Delivery within 3 Days | Furlenco","Title is not matching and unable to login...");
			System.out.println("Logged in successfully...!!");
		}
		catch(AssertionError a)
		{
			System.out.println(a.getMessage());
		}		
		driver.findElement(By.xpath("(//a[contains(@href,'living')])[2]")).click();
		Thread.sleep(2000);
		try
		{
			Assert.assertEquals(driver.getTitle(),"Award Winning Furniture for Living Room, Bedroom, Dining Room & Kids Room","Title is not matching in Living page...");
			System.out.println("Title is matching in Living page...");
		}
		catch(AssertionError a)
		{
			System.out.println(a.getMessage());
		}
		driver.findElements(By.xpath("//span[contains(text(),'Starts')]")).get(4).click();
		Thread.sleep(5000);
		try
		{
			Assert.assertEquals(driver.getTitle(),"Pico Three Seater Living Room | Furlenco","Title is not matching and unable to select 5th Item...");
			System.out.println("5th Item selected and,Title is matching and page loaded successfully...!!");
		}
		catch(AssertionError a)
		{
			System.out.println(a.getMessage());
		}
		
		//Printing product info
		System.out.println();
		System.out.println("Product details:");
		System.out.println("Product Name: "+driver.findElement(By.xpath("//h1[@itemprop='name']")).getText());
		System.out.println("Product Description: "+driver.findElement(By.xpath("//div[@itemprop='description']")).getText());
		System.out.println("Base Pack Monthly Rental: ₹ "+driver.findElement(By.xpath("//strong[@class='package-price ng-scope ng-binding']")).getText());
		System.out.println("Value Pack: ₹ "+driver.findElement(By.xpath("(//span[@class='u-display-bl u-font-size-m-higher ng-binding'])[2]")).getText().substring(2));
		System.out.println(driver.findElement(By.xpath("//span[contains(text(),'Minimum tenure')]")).getText());
		System.out.println();
		Thread.sleep(2000);

		//Adding Item to cart
		driver.findElement(By.xpath("//button[text()='Add To Cart']")).click();
		try
		{
			Assert.assertEquals(driver.getTitle(),"Pico Three Seater Living Room | Furlenco","Title is not matching in cart page...");
			System.out.println("Title is matching in cart page and Item added to cart successfully...!!");
		}
		catch(AssertionError a)
		{
			System.out.println(a.getMessage());
		}
		Thread.sleep(5000);
		Actions act=new Actions(driver);
		WebElement account=driver.findElement(By.xpath("//div[@class='offers-icon-container']"));
		act.moveToElement(account).perform();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[.='Logout']")).click();
		Thread.sleep(5000);
		try
		{
			Assert.assertEquals(driver.getTitle(),"Pico Three Seater Living Room | Furlenco","Title is not matching in home page...");
			System.out.println("Title is matching in home page, and Logged out successfully...!!");
		}
		catch(AssertionError a)
		{
			System.out.println(a.getMessage());
		}
		driver.close();
	}
}
