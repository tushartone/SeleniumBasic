package com.seleniumbasic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CustomXpath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver",".//driver//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www.ebay.in");
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
//		driver.findElement(By.xpath("//input[@id='gh-ac']")).sendKeys("Java");
//		driver.findElement(By.xpath("//input[@name='_nkw']")).sendKeys("Java"); //by using name	
		
		//Contains() is function inside as selenium library to find the xpath
		driver.findElement(By.xpath("//input[contains(@id,'gh-ac')]")).sendKeys("Java"); 
		
		
		//Starts-with
		//Dynamic id : type : input
		//id = test_456
		//id = test_678

		//Ends-with
		//id =1564_test_t
		//id= 48989_test_t
//		driver.findElement(By.xpath("//input[contains(@id,'test_')]")).sendKeys("Test");
//		driver.findElement(By.xpath("//input[starts-with(@id,'test_')]")).sendKeys("t");
//		driver.findElement(By.xpath("//input[ends-with(@id,'test_')]")).sendKeys("t");
		
		//all links are referd by <a> tag
		driver.findElement(By.xpath("//a[contains(text(),'My eBay')]")).click(); 
	}

}
