package com.seleniumbasic;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CalenderHandleConcept {

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
		
		String date = "10-May-2018";
		String dataArr[] = date.split("-");
		String day = dataArr[0];
		String month= dataArr[1];
		String year= dataArr[2];
		
		Select slcMonth = new Select(driver.findElement(By.name("slctMonth")));
		slcMonth.selectByVisibleText(month);
		
		Select slcYear = new Select(driver.findElement(By.name("slctYear")));
		slcYear.selectByVisibleText(year);
		
		final int totalWeekDays = 7;
	
		//*[@id='crmcalendar']/table/tbody/tr[2]/td/table/tbody/tr[2]/td[1]
		//*[@id='crmcalendar']/table/tbody/tr[2]/td/table/tbody/tr[2]/td[4]
		//*[@id='crmcalendar']/table/tbody/tr[2]/td/table/tbody/tr[3]/td[3]
		String befoerXpath ="//*[@id='crmcalendar']/table/tbody/tr[2]/td/table/tbody/tr[";
		String afterXpath ="]/td[";
		
		Thread.sleep(5000);
		boolean flag =false;
		String dayval=null ;
		for(int rownum=2;rownum<=7;rownum++)
		{
			for(int colnum=1; colnum<=totalWeekDays; colnum++)
			{
				
				
					try {
						dayval = driver.findElement(By.xpath(befoerXpath +rownum+ afterXpath +colnum+ "]")).getText();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						System.out.println("Please enter the correct date");
						flag = false;
						break;
					}
				
				System.out.println(dayval);
				if(dayval.equals(day))
				{
					driver.findElement(By.xpath(befoerXpath +rownum+ afterXpath +colnum+ "]")).click();
					flag =true;
					break;
					
				}
			}
			if(flag)
			{
				break;
			}
			
		}
		//driver.quit();
	}

}
