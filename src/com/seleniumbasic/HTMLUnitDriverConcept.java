package com.seleniumbasic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class HTMLUnitDriverConcept {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", ".//driver//chromedriver.exe");
		
		//WebDriver driver = new ChromeDriver();
		
		//Advantages of html driver
		//1.testing is happening behin the scene = no browser is launched
		//2.fast execution ==fast performance
		//3.not availbale  for action class and useraction
		//4.ghost driver == headless browser
			//htmlunitdrive ==java
			//phantomjs ==javascript based
		
		WebDriver driver = new HtmlUnitDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://www.freecrm.com");
		
		System.out.println("AFter login Title is"+driver.getTitle());
		
		driver.findElement(By.name("username")).sendKeys("tushartone");
		driver.findElement(By.name("password")).sendKeys("Tush@1993");
		driver.findElement(By.xpath("//input[contains(@type,'submit')]")).click();
		
		System.out.println("AFter login Title is"+driver.getTitle());

	}

}
