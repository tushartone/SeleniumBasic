package com.seleniumbasic;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindElementsConcept {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver",".//driver//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www.flipkart.com");
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		//1.get the total count of all links
		//2.get the text of each links on the page
		
		List<WebElement> linklist = driver.findElements(By.tagName("a"));
		
		//Size of linklist
		System.out.println(linklist.size());

		for(int i=0 ; i<linklist.size();i++)
		{
			String linkText = linklist.get(i).getText();
			System.out.println(linkText);
		}
		
		driver.quit();
	}

}
