package handson;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest {
	
WebDriver driver;
	
	@BeforeSuite
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}
	
	@Test
	public void login() {
		driver.get("http://automationpractice.com/index.php");
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
		driver.manage().window().maximize();
		driver.findElement(By.linkText("Sign in")).click();
		driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("onlinemelody4@gmail.com");
		driver.findElement(By.xpath("//*[@id=\"passwd\"]")).sendKeys("PKR@PKR");
		driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[3]/div/div/div[2]/form/div/p[2]/button/span")).click();
		String userText=driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a")).getText();
		
		  if(userText.contains("Vsoft")) {
			   System.out.println("User Verified,Test case Passed");
			  }
			  else {
			   System.out.println("User Verification Failed,Test case Failed");
			  }
	}

}
