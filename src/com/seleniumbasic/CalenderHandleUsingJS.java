package com.seleniumbasic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CalenderHandleUsingJS {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", ".//driver//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		//Spice Jet
		//driver.get("http://www.spicejet.com/");
		//WebElement date = driver.findElement(By.id("ctl00_mainContent_txt_Fromdate"));
		
		//Redbus
		driver.get("http://www.redbus.in/");
		WebElement date = driver.findElement(By.id("onward_cal"));
		
		String dataValue ="03-May-2018";
		selectDateByJS(driver, date, dataValue);

		Thread.sleep(5000);
		driver.quit();
	}

	public static void selectDateByJS(WebDriver driver ,WebElement element, String dataValue)
	{
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("arguments[0].setAttribute('value','"+dataValue+"');", element);
		
	}
	
}
