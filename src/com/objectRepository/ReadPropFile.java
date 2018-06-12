package com.objectRepository;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ReadPropFile {
	static WebDriver driver;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("E:\\Tushar\\eclipse-workspace\\SeleniumProject\\src\\com\\objectRepository\\config.properties");
		prop.load(fis);
		
		System.out.println(prop.getProperty("name"));
		
		String url = prop.getProperty("URl");
		System.out.println(url);
		
		String browserName = prop.getProperty("browser");
		System.out.println(browserName);
		
		if(browserName.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", ".//driver//chromedriver.exe");
			driver = new ChromeDriver();
			
			
		}
		driver.get(url);
		
		//Now read the data from property file using object repositry
		
		driver.findElement(By.id(prop.getProperty("firstname_id"))).sendKeys(prop.getProperty("firstname"));
		
	}

}
