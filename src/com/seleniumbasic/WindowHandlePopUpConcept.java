package com.seleniumbasic;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandlePopUpConcept {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", ".//driver//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://www.popuptest.com/goodpopups.html");

		driver.findElement(By.xpath("//a[contains(text(),'Good PopUp #3')]")).click();
		
		Set<String> handler = driver.getWindowHandles();
		
		Iterator<String> it = handler.iterator();
		String parentwindowiID = it.next();
		System.out.println("Parent windoe id "+parentwindowiID);
		
		String childwindowiID = it.next();
		System.out.println("Parent windoe id "+childwindowiID);
		
		driver.switchTo().window(childwindowiID);
		System.out.println("Child window title is "+driver.getTitle() );
		
		driver.close();
		driver.switchTo().window(parentwindowiID);
		System.out.println("Praent windoe title is :"+driver.getTitle());
		
		
		
		// driver.quit();

	}

}
