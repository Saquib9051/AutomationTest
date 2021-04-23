package com.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.FirefoxDriverManager;







//@Author= Saquib
public class TestBase {
	
	public static WebDriver driver;
	
	public static Properties prop;
	
	
	
	
	public  TestBase() {
		try {
			prop= new Properties();
			FileInputStream ip = new FileInputStream("D:\\AutomationWorkSpace\\AutomationPracticeQA\\src\\main\\java\\com\\qa\\config\\config.properties");
			prop.load(ip);
			
		}catch (FileNotFoundException e) {
			e.printStackTrace();
         System.out.println("Exception Caught"+e);
         
		}
	catch (IOException e) {
		e.printStackTrace();
}
	}
	
	public static void initialization() {
		String browserName = prop.getProperty("browser");
		if(browserName.equalsIgnoreCase(browserName)) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		
	}
	
	

}
