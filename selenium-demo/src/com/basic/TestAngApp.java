package com.basic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class TestAngApp {
	
	private static String url = "http://localhost:4200";
	public static void main(String[] args) {
		WebDriver webdriver = null;
		System.setProperty("webdriver.chrome.driver","C:\\tools\\chromedriver_win32\\chromedriver.exe");
		webdriver = new ChromeDriver();
		
//		clickAccountsButton(webdriver);
		
//		addProductToShoppingCart(webdriver,"ecomm","headphones","2");
		
		tformsEmailValidation(webdriver,"tforms","hah");
//		webdriver.quit();
	}
	
	private static void clickAccountsButton(WebDriver webdriver) {
		webdriver.get(url);
		System.out.println(webdriver.getTitle());
		System.out.println(webdriver.getCurrentUrl());
		webdriver.findElement(By.id("accounts1")).click();		
	}
	
	private static void addProductToShoppingCart(WebDriver webdriver, String route, String productname,String quantity) {
		webdriver.get(url+"/"+route);
		webdriver.findElement(By.name("productName")).sendKeys(productname);
		webdriver.findElement(By.name("quantity")).sendKeys(quantity);
		webdriver.findElement(By.name("addproduct")).click();
		webdriver.findElement(By.name("productName")).sendKeys("");
		webdriver.findElement(By.name("quantity")).sendKeys("");
	}
	
	private static void tformsEmailValidation(WebDriver webdriver, String route, String username) {
		webdriver.get(url+"/"+route);
		webdriver.findElement(By.name("username")).sendKeys(username);
		webdriver.findElement(By.name("email")).click();
		webdriver.findElement(By.id("tforms_div")).click();
		System.out.println(webdriver.findElement(By.name("email_err")).getText());
		
	}
	
	private static void addProductToShoppingCartXPath(WebDriver webdriver, String route, String productname, String quantity) {
		webdriver.get(url + "/" + route);
		webdriver.findElement(By.xpath("//input[@placeholder='Product Name']")).sendKeys(productname);
		webdriver.findElement(By.cssSelector("input[placeholder='Quantity']")).sendKeys(quantity);
		webdriver.findElement(By.name("addProduct")).click();
		webdriver.findElement(By.name("productName")).sendKeys("");
		webdriver.findElement(By.name("quantity")).sendKeys("");

	}
	
	private static void addPosts(WebDriver webdriver, String route, String email, String quantity) {
		webdriver.get(url + "/" + route);
		webdriver.findElement(By.xpath("//form/div[2]/div/input")).sendKeys(email);
//		webdriver.findElement(By.cssSelector("form input:nth-child(2)")).sendKeys(quantity);
		webdriver.findElement(By.xpath("//form/input[2]")).sendKeys(quantity);
//		webdriver.findElement(By.name("addProduct")).click();
//		webdriver.findElement(By.name("productName")).sendKeys("");
//		webdriver.findElement(By.name("quantity")).sendKeys("");

	}

	

}
