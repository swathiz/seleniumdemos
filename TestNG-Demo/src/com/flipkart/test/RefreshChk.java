package com.flipkart.test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RefreshChk {
	
	WebDriver driver;
	
	@BeforeSuite
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}
	
	@Test
	public void chkk() {
		
	driver.get("https://www.flipkart.com/");
	FluentWait<WebDriver> wait= new FluentWait<WebDriver>(driver)
            .withTimeout(Duration.ofSeconds(30L))
            .pollingEvery(Duration.ofSeconds(5L))
            .ignoring(NoSuchElementException.class);
   
    WebElement element =wait.until(new Function<WebDriver, WebElement>() {
        @Override
        public WebElement apply(WebDriver driver) {
            
            WebElement element= driver.findElement(By.id("container"));
            String ele = driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div[1]/div[2]/div[3]/div/div/div[1]/a")).getText();
            
            if(ele.equals("Login")) {
                System.out.println(ele);
                return element;
            }
            else {
                System.out.println("Fluent Wait Fail!, Element Not Loaded Yet");
                return null;
            } 
        }      
    });
	}
}