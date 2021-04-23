package com.qa.pages;

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

//@Author= Saquib 
public class TC2 extends TestBase {
	
	//Page Factory - OR
	@FindBy(xpath="//a[contains(text(),'Sign in')]")
	WebElement signIn;
	@FindBy(id="email")
	WebElement username;
	@FindBy(id="passwd")
	WebElement password;
	@FindBy(id="SubmitLogin")
	WebElement signInBtn;
	
	@FindBy(xpath="//span[normalize-space()='Order history and details']")
	WebElement orderHist;
	
	@FindBy(xpath="//body[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[7]/a[1]/span[1]")
	WebElement orderRef;
	
	@FindBy(xpath="//body/div[@id='page']/div[2]/div[1]/div[3]/div[1]/div[1]/div[1]/form[2]/p[3]/textarea[1]")
	WebElement message;
	
	@FindBy(xpath="//span[contains(text(),'Send')]")
	WebElement sendBtn;
	
	@FindBy(xpath="//p[@class='alert alert-success']")
	WebElement msgvalidation;
	
	@FindBy(xpath="(//td[contains(text(),'order confirmed')])[1]")
	WebElement messageVerification;
	
	@FindBy(xpath="//body[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]/div[1]/div[5]/table[1]/tbody[1]/tr[1]/td[1]")
	WebElement timeVerification;
	
	
	public TC2() {
		PageFactory.initElements(driver,this);
	}
	
	public void login(String un, String pwd) throws InterruptedException {
		
		signIn.click();
		username.sendKeys(un);
		password.sendKeys(pwd);
		signInBtn.click();
	}
	
	public void viewPreviousOrder() throws InterruptedException {
		Thread.sleep(3000);
		orderHist.click();
		Thread.sleep(2000);
		orderRef.click();
		Thread.sleep(2000);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,1100)");
		Thread.sleep(2000);
		message.sendKeys(prop.getProperty("message"));
		Thread.sleep(2000);
		sendBtn.click();
		Thread.sleep(6000);
		String actualMsg= msgvalidation.getText();
		Assert.assertEquals(actualMsg, "Message successfully sent");
		System.out.println("Work done");
		String msgVerification= messageVerification.getText();
		Assert.assertEquals(msgVerification, "order confirmed");
		System.out.println("Work Done");
		String timeVerify= timeVerification.getText();
		System.out.println(timeVerify);
		String date= timeVerify.substring(13,23);
		System.out.println(date);
		DateTimeFormatter dtf=DateTimeFormatter.ofPattern("MM/dd/uuuu");
		LocalDate localDate=LocalDate.now();
		System.out.println(dtf.format(localDate));
		System.out.println("Work Done");
		
	}

}
