package com.kamaldhillon.learningSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class learningSeleniumScript {
	WebDriver wd;

	@BeforeMethod
	// Setting up the chrome driver path
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\ChromeD\\chromedriver.exe");

		// Creating Ref. variable & intialising with Chrome Driver
		wd = new ChromeDriver();

		// URL of the page
		wd.get("http://automationpractice.com/index.php?controller=contact");

		// Maximize the browser
		wd.manage().window().maximize();

	}

	@Test
	public void sendMessage() {
		WebElement subjectHeading = wd.findElement(By.id("id_contact"));
		Select select = new Select(subjectHeading);
		select.selectByVisibleText("Customer service");
		
		WebElement email = wd.findElement(By.cssSelector("#email"));
		email.sendKeys("dhillon@gmail.com");
		
		WebElement orderReference = wd.findElement(By.id("id_order"));
		orderReference.sendKeys("abd125");
		
		WebElement message = wd.findElement(By.cssSelector("#message"));
		message.sendKeys("Order Inquiry");
		
		WebElement sendMessageButton = wd.findElement(By.cssSelector("#submitMessage"));
		sendMessageButton.submit();

	}

	@AfterMethod
	public void tearDown() {
		wd.quit();
	}

}
