package com.seleniumbasic;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleDynamicGoogleSearch {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", ".//driver//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.google.com");
		
		driver.findElement(By.id("lst-ib")).sendKeys("Java");
		
		List<WebElement> list = driver.findElements(By.xpath("//ul[@role='listbox']//li/descendant::div[@class='sbqs_c']"));
		
		
		System.out.println("Total no of suggesstion in seracch box >>======"+list.size());
		
		for(int i=0;i<=list.size();i++)
		{
			String suggesstion = list.get(i).getText();
			System.out.println(suggesstion);
			
			if(list.get(i).getText().equalsIgnoreCase("java tutorial")) {
				list.get(i).click();
				break;
			}
		}
		
		
		driver.quit();
	}
}
