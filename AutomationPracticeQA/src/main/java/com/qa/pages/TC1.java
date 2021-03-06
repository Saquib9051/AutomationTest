package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.qa.base.TestBase;

//@Author= Saquib Helal
public class TC1 extends TestBase {
	
	//Page Factory - OR
	@FindBy(xpath="//a[contains(text(),'Sign in')]")
	WebElement signIn;
	@FindBy(id="email")
	WebElement username;
	@FindBy(id="passwd")
	WebElement password;
	@FindBy(id="SubmitLogin")
	WebElement signInBtn;
	
	@FindBy(xpath="//div[contains(text(),'Categories')]//following-sibling::ul/li[2]/a[@title='Dresses']")
	WebElement dress;
	
	@FindBy(xpath="//ul[@class='product_list grid row']/li[1]//span[contains(text(),'Quick view')]")
	WebElement quickView;
	
	@FindBy(id="group_1")
	WebElement size;
	
	@FindBy(xpath="//span[contains(text(),'Add to cart')]")
	WebElement addTocart;
	
	@FindBy(xpath="//span[@title='Continue shopping']//span[1]")
	WebElement continueShopping;
	
	@FindBy(xpath="//ul[@class='product_list grid row']/li[2]//span[contains(text(),'Quick view')]")
	WebElement quickView2;
	
	@FindBy(xpath="//span[contains(text(),'Proceed to checkout')]")
	WebElement proceedTochcekOut;
	
	@FindBy(xpath="//a[contains(text(),'Color : Orange, Size : M')]")
	WebElement dressSize;
	
	@FindBy(xpath="//td[@class='cart_description']//a[contains(text(),'Color : Beige, Size : S')]")
	WebElement dressSize2;
	
	@FindBy(id="product_price_3_14_473842")
	WebElement unitPrice;
	
	@FindBy(id="product_price_4_16_473842")
	WebElement unitPrice2;
	
	@FindBy(id="total_product")
	WebElement totalProduct;
	
	@FindBy(id="total_shipping")
	WebElement totalShipping;
	
	@FindBy(id="total_price")
	WebElement totalPrice;
	
	@FindBy(xpath="//a[@class='button btn btn-default standard-checkout button-medium']//span[contains(text(),'Proceed to checkout')]")
	WebElement proceedToCheckout;
	
	@FindBy(name="processAddress")
	WebElement processAdd;
	
	@FindBy(id="cgv")
	WebElement termAndAgree;
	
	@FindBy(name="processCarrier")
	WebElement shipping;
	
	@FindBy(xpath="//a[@title='Pay by bank wire']")
	WebElement payBankWire;
	
	@FindBy(xpath="//span[normalize-space()='I confirm my order']")
	WebElement confirmOrder;
	
	@FindBy(xpath="//a[@title='Log me out']")
	WebElement logout;
	
	
	public TC1() {
		PageFactory.initElements(driver,this);
	}
	
	public void login(String un, String pwd) throws InterruptedException {
		signIn.click();
		username.sendKeys(un);
		password.sendKeys(pwd);
		signInBtn.click();
		
	}
	
	public void productPurchase() throws InterruptedException {
		Thread.sleep(3000);
		dress.click();
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,780)");
		Thread.sleep(3000);
		Actions act= new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("//body/div[@id='page']/div[2]/div[1]/div[3]/div[2]/ul[1]/li[1]/div[1]/div[1]/div[1]/a[1]/img[1]"))).build().perform();
		quickView.click();
		Thread.sleep(5000);
		driver.switchTo().frame(driver.findElement(By.tagName("iframe")));
		Thread.sleep(2000);
		Select select=new Select(size);
		select.selectByVisibleText("M");
		addTocart.click();
		Thread.sleep(6000);
		continueShopping.click();
		driver.navigate().back();
		Thread.sleep(2000);
		Actions actions2= new Actions(driver);
		actions2.moveToElement(driver.findElement(By.xpath("//body/div[@id='page']/div[2]/div[1]/div[3]/div[2]/ul[1]/li[2]/div[1]/div[1]/div[1]/a[1]/img[1]"))).build().perform();
		
		quickView2.click();
		Thread.sleep(2000);
		driver.switchTo().frame(driver.findElement(By.tagName("iframe")));
		Thread.sleep(4000);
		addTocart.click();
		Thread.sleep(8000);
		proceedTochcekOut.click();
		Thread.sleep(2000);
		JavascriptExecutor jse2 = (JavascriptExecutor)driver;
		jse2.executeScript("window.scrollBy(0,250)");
		String sizeOfDress= dressSize.getText();
		System.out.println(sizeOfDress);
		String sizeOfDress2= dressSize2.getText();
		System.out.println(sizeOfDress2);
		String unitCost= unitPrice.getText().substring(1);
		System.out.println(unitCost);
		Assert.assertEquals(unitCost, "26.00");
		String unitCost2= unitPrice2.getText().substring(1);
		System.out.println(unitCost2);
		Assert.assertEquals(unitCost2, "50.99");
		Double sumOfproduct= Double.parseDouble(unitCost);
		System.out.println(sumOfproduct);
		Double sumPro= Double.parseDouble(unitCost2);
		System.out.println(sumPro);
		System.out.println(Double.sum(sumOfproduct,sumPro));
		
		String productTotal= totalProduct.getText();
		System.out.println(productTotal);
		Assert.assertEquals(productTotal, "$76.99");
		String totalShippingCost= totalShipping.getText();
		System.out.println(totalShippingCost);
		Assert.assertEquals(totalShippingCost, "$2.00");
		String totalAmountOfTheProduct= totalPrice.getText();
		System.out.println(totalAmountOfTheProduct);
		Assert.assertEquals(totalAmountOfTheProduct, "$78.99");
		proceedToCheckout.click();
		Thread.sleep(2000);
		processAdd.click();
		Thread.sleep(2000);
		termAndAgree.click();
		Thread.sleep(2000);
		shipping.click();
		Thread.sleep(3000);
		payBankWire.click();
		Thread.sleep(2000);
		confirmOrder.click();
		Thread.sleep(2000);
		logout.click();
		System.out.println("Work Done");
	}

}
