package com.seleniumbasic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Test12 {

	public static void main(String [] args) {
		
	
		System.setProperty("webdriver.chrome.driver",".//driver//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com");
		
		String title = driver.getTitle();
		System.out.println(title);
		System.out.println("Hii this is your first selenium test");
		
		if(title.equalsIgnoreCase("Google"))
		{
			System.out.println("Correct Title");
		}
		
		else
		{
			System.out.println("Incorrect Title");
		}
		System.out.println(driver.getCurrentUrl());
		driver.quit();
	
		
		
	}

}
