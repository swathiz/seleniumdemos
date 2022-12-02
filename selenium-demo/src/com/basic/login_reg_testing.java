package com.basic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class login_reg_testing {
	
	
	private static String loginurl = "https://www.semrush.com/login/";
	private static String signupurl = "https://www.semrush.com/signup/";
	public static void main(String[] args) {
		
		WebDriver webdriver = null;
		System.setProperty("webdriver.chrome.driver","C:\\tools\\chromedriver_win32\\chromedriver.exe");
		webdriver = new ChromeDriver();
		signup(webdriver,"andelaranjitha24@gmail.com","Rohith1234$");
		login(webdriver,"andelaranjitha24@gmail.com","Rohith1234$");
		
	}
	
	private static void login(WebDriver webdriver, String username,String password) {
		webdriver.get(loginurl);
		System.out.println(webdriver.getTitle());
		System.out.println(webdriver.getCurrentUrl());
		webdriver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys(username);
		webdriver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys(password);
		webdriver.findElement(By.xpath("/html/body/div[1]/main/div/div[1]/div/form/button[2]/span")).click();
			
	}
	
	private static void signup(WebDriver webdriver,String username,String password) {
		webdriver.get(signupurl);
		webdriver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys(username);
		webdriver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys(password);	
		webdriver.findElement(By.xpath("/html/body/div[1]/main/div/div[1]/div/form/button[2]/span")).click();
	}

}
