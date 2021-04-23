package com.qa.testcases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.TC1;
import com.qa.pages.TC2;

public class TC1Test2 extends TestBase {

	TC2 tc2;
	
	public TC1Test2() {
		super();
	}
	
	
	@BeforeClass
	public void setUp() {
		initialization();
		tc2=new TC2();
	}
	
	@Test(priority=1)
	public void login() throws InterruptedException {
		tc2.login(prop.getProperty("username"),prop.getProperty("password"));
	}
	
	@Test(priority=2)
	public void viewMsg() throws InterruptedException {
		//tc2.viewPreviousOrder();
	}
	
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
	
	
	
	
	
}
