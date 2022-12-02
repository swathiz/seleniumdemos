package handson;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AddToCart {
	
	WebDriver driver;
	
	@BeforeSuite
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}
	
	@Test
	public void login() throws InterruptedException {
		driver.get("http://automationpractice.com/index.php");
		driver.manage().window().maximize();
		Actions actions=new Actions(driver);
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);
		driver.findElement(By.linkText("WOMEN")).click();
		
		WebElement SecondImg=driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[3]/div[2]/ul/li[2]/div/div[1]/div/a[1]/img"));
		WebElement MoreBtn=driver.findElement(By.xpath("/html/body[1]/div[1]/div[2]/div[1]/div[3]/div[2]/ul/li[2]/div[1]/div[2]/div[2]/a[2]"));
		actions.moveToElement(SecondImg).moveToElement(MoreBtn).click().perform();
		
		 driver.findElement(By.id("quantity_wanted")).clear();
		 driver.findElement(By.id("quantity_wanted")).sendKeys("2");
		 
		 WebElement Sizedrpdwn=driver.findElement(By.xpath("//*[@id='group_1']"));
		 Select oSelect=new Select(Sizedrpdwn);
		 oSelect.selectByVisibleText("M");
		 
		 driver.findElement(By.id("color_11")).click();
		 
		 driver.findElement(By.xpath("//p[@id='add_to_cart']//span[.='Add to cart']")).click();	

	}
 
}
