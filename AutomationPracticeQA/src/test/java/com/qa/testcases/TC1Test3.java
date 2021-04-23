package com.qa.testcases;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.TC1;
import com.qa.pages.TC2;
import com.qa.pages.TC3;

public class TC1Test3 extends TestBase {

	TC3 tc3;
	
	public TC1Test3() {
		super();
	}
	
	
	@BeforeClass
	public void setUp() {
		initialization();
		tc3=new TC3();
	}
	
	@Test(priority=1)
	public void login() throws InterruptedException {
		tc3.login(prop.getProperty("username"),prop.getProperty("password"));
	}
	
	@Test(priority=2)
	public void captureImageTest() throws InterruptedException, IOException {
		tc3.captureImagecolor();
	}
	
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
	
	
	
	
	
}
