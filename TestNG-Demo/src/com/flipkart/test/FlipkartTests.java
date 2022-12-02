package com.flipkart.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FlipkartTests {
	
WebDriver driver;
	
	@BeforeSuite
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}
	
	@Test
	public void chk() {
		
		/* PAGE LAOD TIME */
		/* To calculate the load time of the web page */
		long start = System.currentTimeMillis();

		/* NAVIGATION */
		/* To navigate to flipkart home page */
		driver.get("https://www.flipkart.com/");

		long finish = System.currentTimeMillis();
		long totalTime = finish - start; 
		System.out.println("Total Time for page load - "+totalTime); 
		
		/* To maximize the browser window */
		driver.manage().window().maximize();
		Actions actions=new Actions(driver);
		
		/* To exit the pop up window */
		driver.findElement(By.xpath("/html/body/div[2]/div/div/button")).click();
		
		/* SEARCH */
		/* To select mobiles and tablets button */
		String searchitem = "iphone13";
		//driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div/div[2]/a/div[1]/div/img")).click();
		
		/* To pass the "iphone13" to search bar */
		driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div[1]/div[2]/div[2]/form/div/div/input")).sendKeys(searchitem);
		
		/* then to click the search button */
		driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div[1]/div[2]/div[2]/form/div/button")).click();
		
		System.out.println("search complete");
		
		/* IMAGE LOADING */
		/* To check if the image is loaded on to webpage */
		WebElement imageWebElement = driver.findElement(By.cssSelector("img[class='_396cs4 _3exPp9']"));
		Boolean isImageLoaded = (Boolean) ((JavascriptExecutor)driver).executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", imageWebElement);
		if(isImageLoaded) {
			System.out.println("Image is loaded");
		}else {
			System.out.println("Image is not loaded");
		}
		
		
		
		/* SCROLL To Bottom */
		
		 try {
			 	boolean flag = true;
	            long temp = 0;
	            while (flag) {
	                ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");
	               
	                driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
	                long begin = (Long) ((JavascriptExecutor) driver).executeScript("return document.body.scrollHeight");
	                if (begin == temp) {
	                    break;
	                }
	                temp = begin;
	            }
	            System.out.println("Yes this page has scroll feature");
	            System.out.println("scroll complete");  
	        } catch (Exception e) {
	            e.printStackTrace();
	           
	        }
		 
	      
		 
		 
	}

}
