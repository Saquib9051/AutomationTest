package com.qa.pages;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.qa.base.TestBase;
import com.qa.utils.TestUtil;

//@Author= Saquib 
public class TC3 extends TestBase {
	
	//Page Factory - OR
	@FindBy(xpath="//a[contains(text(),'Sign in')]")
	WebElement signIn;
	@FindBy(id="email")
	WebElement username;
	@FindBy(id="passwd")
	WebElement password;
	@FindBy(id="SubmitLogin")
	WebElement signInBtn;
	
	@FindBy(xpath="//span[@class='cat-name']")
	WebElement dresses;
	
	@FindBy(xpath="//header/div[3]/div[1]/div[1]/div[6]/ul[1]/li[2]/a[1]")
	WebElement dressheader;
	
	
	
	public TC3() {
		PageFactory.initElements(driver,this);
	}
	
	public void login(String un, String pwd) throws InterruptedException {
		
		signIn.click();
		username.sendKeys(un);
		password.sendKeys(pwd);
		signInBtn.click();
	}
	
	public void captureImagecolor() throws InterruptedException, IOException {
		dressheader.click();
		Thread.sleep(3000);
		String dressTextValidation= dresses.getText();
		if(dressTextValidation.equals("Dresses")) {
			TestUtil.takeScreenshotAtEndOfTest();
		}
		else {
			TestUtil.takeScreenshotAtEndOfTest();
			System.out.println("Take Fail screenshot");
		}
	}

}
