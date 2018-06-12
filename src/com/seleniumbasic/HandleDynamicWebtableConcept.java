package com.seleniumbasic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleDynamicWebtableConcept {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", ".//driver//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://www.freecrm.com");
		driver.findElement(By.name("username")).sendKeys("tushartone");
		driver.findElement(By.name("password")).sendKeys("Tush@1993");
		driver.findElement(By.xpath("//input[contains(@type,'submit')]")).click();
		
		driver.switchTo().frame("mainpanel");
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//a[contains(text(),'Contacts')]")).click();
		
		//Method : 1
		
		//*[@id='vContactsForm']/table/tbody/tr[4]/td[1]/input
		//*[@id='vContactsForm']/table/tbody/tr[5]/td[1]/input
		//*[@id='vContactsForm']/table/tbody/tr[6]/td[1]/a
		
		//*[@id='vContactsForm']/table/tbody/tr[5]/td[2]/a
		
		String beforeXpath="//*[@id='vContactsForm']/table/tbody/tr[";
		String afterXpath ="]/td[2]/a";
		
//		for(int i=4;i<=7;i++)
//		{
//			String name = driver.findElement(By.xpath(beforeXpath + i + afterXpath)).getText();
//			System.out.println(name);
//			
//			if(name.contains("testing purpose"))
//			{
//				//*[@id='vContactsForm']/table/tbody/tr[6]/td[1]/input
//				driver.findElement(By.xpath("//*[@id='vContactsForm']/table/tbody/tr[" + i + "]/td[1]/input")).click();
//			}
//		}
		
		//Method 2:
		
		driver.findElement(By.xpath("//a[contains(text(),'testing purpose')]/parent::td//preceding-sibling::td//input[@name='contact_id']")).click();
		driver.findElement(By.xpath("//a[contains(text(),'demo test')]/parent::td//preceding-sibling::td//input[@name='contact_id']")).click();
		
	}

}
