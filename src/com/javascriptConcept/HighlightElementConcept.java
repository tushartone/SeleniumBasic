package com.javascriptConcept;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.io.FileHandler;

public class HighlightElementConcept {

	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.chrome.driver", ".//driver//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://www.freecrm.com");
		driver.findElement(By.name("username")).sendKeys("tushartone");
		driver.findElement(By.name("password")).sendKeys("Tush@1993");
		WebElement loginbtn = driver.findElement(By.xpath("//input[contains(@type,'submit')]"));
		
		flash(loginbtn, driver);
		drawBorder(loginbtn, driver);

		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		// now copy the scrrenshot to desired locatino using copy method
		FileHandler.copy(src, new File(".//Screenshot//element.png"));

		//genreate the alert
		//generateAlert("please enter the correct username and issue with login page", driver);
		
		//Click on element on webpage
		clickonElementbyJs(loginbtn, driver);
		
		//Getting title of the page
		System.out.println(getTitleBYJs(driver));
		
		//get the page text
		System.out.println(getInnerTextBYJs(driver));
		
		//scroll down page
		//scrollPageDownBYJs(driver);
		
		//scrollIntoView unit the specified element is not found
		WebElement scrollView = driver.findElement(By.xpath("//a[contains(text(),'Forgot Password?')]"));
		scrollIntoView(scrollView, driver);
	}

	public static void flash(WebElement element , WebDriver driver)
	{
		JavascriptExecutor js = ((JavascriptExecutor)driver); //casting the driver into the jaava script executor. i.e casting
		String bgcolor = element.getCssValue("backgroundColor");
		for (int i=0;i<10;i++)
		{
			changecolor("rgb(0,200,0)", element, driver);
			changecolor(bgcolor, element, driver);
		}
		
	}
	
	public static void changecolor(String color,WebElement element , WebDriver driver)
	{
		JavascriptExecutor js = ((JavascriptExecutor)driver); 
		js.executeScript("arguments[0].style.backgroundColor = '" +color+"'", element);
		
		try {
			Thread.sleep(20);
		}
		catch(InterruptedException e) {}
		
	}
	
	public static void drawBorder(WebElement element , WebDriver driver)
	{
		JavascriptExecutor js = ((JavascriptExecutor)driver); 
		js.executeScript("arguments[0].style.border='3px solid red' ", element);
	}
	
	public static void generateAlert(String message , WebDriver driver)
	{
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("alert('"+message+"')");
	}
	
	public static void clickonElementbyJs(WebElement element , WebDriver driver)
	{
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("arguments[0].click",element);
	}
	
	public static String getTitleBYJs(WebDriver driver)
	{
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		String title = js.executeScript("return document.title").toString();
		return title;
	}
	
	public static String getInnerTextBYJs(WebDriver driver)
	{
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		String pageText = js.executeScript("return document.documentElement.innerText").toString();
		return pageText;
	}
	
	public static void scrollPageDownBYJs(WebDriver driver)
	{
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		
	}
	
	public static void scrollIntoView(WebElement element, WebDriver driver)
	{
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("arguments[0].scrollIntoView(true)",element);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
