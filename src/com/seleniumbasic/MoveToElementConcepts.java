package com.seleniumbasic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MoveToElementConcepts {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver",".//driver//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("http://www.spicejet.com/");
		
		Actions action  = new Actions(driver);
		action.moveToElement(driver.findElement(By.id("highlight-addons")))
		.build().perform();
		
		Thread.sleep(3000);
		driver.findElement(By.linkText("Hot Meals")).click();
	}

}
