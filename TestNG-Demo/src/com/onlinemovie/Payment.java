package com.onlinemovie;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Payment {
	
	WebDriver driver;
	
	@BeforeSuite
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}
	
	@Test
	public void chk() {
		driver.get("http://localhost:4200/");
		driver.findElement(By.id("cart")).click();
		driver.findElement(By.id("checkout")).click();
		driver.findElement(By.id("cardname")).sendKeys("MAX");
		driver.findElement(By.id("cr_no")).sendKeys("1234 0000 9999 4567");
		driver.findElement(By.id("exp")).sendKeys("09/28");
		driver.findElement(By.id("cvv")).sendKeys("800");
		driver.findElement(By.id("pay")).click();
	}
	
	@Test
	public void emptyCart() {
		driver.get("http://localhost:4200/");
		driver.findElement(By.id("cart")).click();
		driver.findElement(By.id("del_item")).click();
		System.out.println("It will show the shop more page");
		driver.findElement(By.id("to_products_page")).click();
	}

}
