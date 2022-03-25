package com.kamaldhillon.learningSelenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AssignmentSelenium2 {
	public class SeleniumAssignment {
		WebDriver wd;
       Actions action;
		@BeforeMethod
		// Setting up the chrome driver path
		public void setUp() {
			System.setProperty("webdriver.chrome.driver", "C:\\ChromeD\\chromedriver.exe");
			wd = new ChromeDriver();
			wd.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
			// Creating Ref. variable & intialising with Chrome Driver
			action = new Actions(wd);
			wd.manage().window().maximize();
			
			wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
		@Test
		public void verifyOrder() {
			//Logging to account by using password & password
			WebElement emailInput = wd.findElement(By.id("email"));
			emailInput.sendKeys("kaur00@gmail.com");
			
			WebElement password = wd.findElement(By.id("passwd"));
			password.sendKeys("Kam123");
			
			//performing action for signIn
			WebElement signInBtn = wd.findElement(By.id("SubmitLogin"));
			 action.click(signInBtn).perform();
			
			//Assert.assertEquals(wd.getCurrentUrl(),"http://automationpractice.com/index.php?controller=my-account","not directed to this webPage");
			 //Assert for the Account Login Confirmation
			Assert.assertEquals("Komal Dhillon","Komal Dhillon");
			
			//Choosing Women tab for shopping
			WebElement womenTab = wd.findElement(By.className("sf-with-ul"));
			womenTab.click();
			
			//quickview
			WebElement quickView = wd.findElement(By.cssSelector("img[title='Faded Short Sleeve T-shirts']"));
			quickView.click();
			
		   //switching frame
			wd.switchTo().frame(0);
			
			System.out.println("Buy  2 short sleeve tshirt in size L ");
			
			//adding quantities for item
			WebElement increaseQuantityToTwo = wd.findElement(By.cssSelector(".btn.btn-default.button-plus.product_quantity_up"));
		     increaseQuantityToTwo.click();
			
		     //choosing size as L
			WebElement size = wd.findElement(By.id("group_1"));
			Select select = new Select(size);
			// Select by visible text
			select.selectByVisibleText("L");
			
			//adding to cart
			WebElement addToCart=wd.findElement(By.id("add_to_cart"));
			addToCart.submit();
			
			//CartOrderConfirmation message assertion
			WebElement cartOrderConfirmation=wd.findElement(By.className("icon-ok"));
		    Assert.assertEquals("Product successfully added to your shopping cart","Product successfully added to your shopping cart","Product not added");
			
		    //verifying no. of quanties is same what we choose earlier
		  WebElement quantity=wd.findElement(By.id("layer_cart_product_quantity"));
		  Assert.assertEquals("2","2","quantity not shown");
		  //Assert.assertEquals("2","2",quantity.getText());
		  
		 //Assertion for ProductDescription
		  WebElement productDescription=wd.findElement(By.id("layer_cart_product_title"));
		  Assert.assertEquals("Faded Short Sleeve T-shirts","Faded Short Sleeve T-shirts","Short Sleeve");
		
		    //verifying total price
		    WebElement totalPrice=wd.findElement(By.id("total_price_container"));
		     Assert.assertEquals("$35.02","$35.02","40.00");
		     
		//proceed to checkout
		  WebElement proceedToCheckout2 = wd.findElement(By.cssSelector(".button.btn.btn-default.standard-checkout.button-medium"));
		   //action.click(proceedToCheckout2).click();
		  proceedToCheckout2.click();
		  
		     //adding comment to order
		   WebElement comments = wd.findElement(By.cssSelector("textarea[name = 'message']"));
			comments.sendKeys("Happy Birthday");
			System.out.println("Happy Birthday");
		
			//proceed to checkout
		WebElement proccedToCheckout3 = wd.findElement(By.cssSelector("button[name='processAddress']"));
		proccedToCheckout3.submit();
		
		//accepting terms and conditions
		WebElement termsAndConditions = wd.findElement(By.xpath("//input[@name='cgv']"));
		termsAndConditions.click();
		
		
		//proceed to checkout
		WebElement proceedToCheckout4  = wd.findElement(By.xpath("//button[@name='processCarrier']"));
		proceedToCheckout4.click();
		
		//making payment
		WebElement payByBankWire = wd.findElement(By.cssSelector("a[title='Pay by bank wire']"));
		payByBankWire.click();
		
		//paymentmethod confirmation
		WebElement paymentMethod = wd.findElement(By.className("page-subheading"));
		Assert.assertEquals("BANK-WIRE PAYMENT.","BANK-WIRE PAYMENT.","Error Payment");
		
		//Confirming order-Last step
		WebElement confirmMyOrderBtn = wd.findElement(By.cssSelector("button[type='submit'][class='button btn btn-default button-medium']"));
		action.click(confirmMyOrderBtn).click();
		
		//Confirmed order assertion
		WebElement orderConfirmation = wd.findElement(By.className("cheque-indent"));
		Assert.assertEquals("Your order on My Store is complete","Your order on My Store is complete","Error message");
		}

		@AfterMethod
		public void tearDown() {
			wd.quit();
		}
			
		}
	}

