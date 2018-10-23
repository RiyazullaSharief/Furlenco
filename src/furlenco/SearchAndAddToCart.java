package furlenco;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
public class SearchAndAddToCart
{
	public static void main(String[] args) throws InterruptedException
	{
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.furlenco.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.findElement(By.xpath("//div[contains(text(),'Bengaluru')]")).click();
		try
		{
			Assert.assertEquals(driver.getTitle(),"Rent Award Winning Furniture from Furlenco | Free Delivery within 3 Days | Furlenco","Title is not matching");
			System.out.println("Title is matching in home page, Logged in successfully...!!");
		}
		catch(AssertionError a)
		{
			System.out.println(a.getMessage());
		}
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@name='search']")).sendKeys("Washing Machine");
		driver.findElement(By.xpath("(//img[@alt='Search'])[3]")).click();
		driver.findElement(By.xpath("//h1[contains(text(),'Wardrobe Washing Machine')]")).click();
		Thread.sleep(3000);
		try
		{
			Assert.assertEquals(driver.getTitle(),"Rent Washing Machine & Lana Wardrobe I Delivery in 72 hours - Furlenco","Title is not matching");
			System.out.println("Title is matching in washing machine page...");
		}
		catch(AssertionError a)
		{
			System.out.println(a.getMessage());
		}
		driver.findElement(By.xpath("//button[text()='Add To Cart']")).click();
		Thread.sleep(7000);
		WebElement checkout=driver.findElement(By.xpath("//a[@data-action='checkout']"));
		Actions act=new Actions(driver);
		act.moveToElement(checkout).perform();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//a[text()='CHECKOUT']")).click();
		Thread.sleep(3000);
		WebElement frame=driver.findElement(By.xpath("//iframe[@id='hulk-login']"));
		driver.switchTo().frame(frame);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[contains(@placeholder,'Email ID')]")).sendKeys("8861538394"); //Enter Mob No.
		driver.findElement(By.xpath("//span[contains(text(),'Next')]")).click();
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("riyaz560022"); //Enter password
		driver.findElement(By.xpath("(//span[contains(text(),'Login')])[1]")).click();
		driver.switchTo().defaultContent();
		try
		{
			Assert.assertEquals(driver.getTitle(),"Cart - Furlenco","Title is not matching");
			System.out.println("Title is matching in Cart page and Item added to cart successfully...!!");
		}
		catch(AssertionError a)
		{
			System.out.println(a.getMessage());
		}
		Thread.sleep(10000);
		driver.navigate().back();
		Thread.sleep(5000);
		try
		{
			Assert.assertEquals(driver.getTitle(),"Rent Washing Machine & Lana Wardrobe I Delivery in 72 hours - Furlenco","Title is not matching");
			System.out.println("Title is matching in washing machine page...");
		}
		catch(AssertionError a)
		{
			System.out.println(a.getMessage());
		}
		WebElement account=driver.findElement(By.xpath("//div[@class='offers-icon-container']"));
		act.moveToElement(account).perform();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//span[.='Logout']")).click();
		Thread.sleep(5000);
		try
		{
			Assert.assertEquals(driver.getTitle(),"Rent Washing Machine & Lana Wardrobe I Delivery in 72 hours - Furlenco","Title is not matching");
			System.out.println("Title is matching in home page, Logged out successfully...!!");
		}
		catch(AssertionError a)
		{
			System.out.println(a.getMessage());
		}
		driver.close();
	}
}
