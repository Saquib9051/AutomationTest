package com.qa.testcases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.TC1;

public class TC1Test extends TestBase {

	TC1 tc1;
	
	public TC1Test() {
		super();
	}
	
	
	@BeforeClass
	public void setUp() {
		initialization();
		tc1=new TC1();
		
	}
	
	@Test(priority=1)
	public void login() throws InterruptedException {
		tc1.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority=2)
	public void productPurchased() throws InterruptedException {
		//tc1.productPurchase();
	}
	
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
	
	
	
	
	
}
