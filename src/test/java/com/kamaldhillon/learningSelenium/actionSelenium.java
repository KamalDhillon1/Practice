package com.kamaldhillon.learningSelenium;



import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class actionSelenium {
	WebDriver webDriver;
	Actions action;

	@BeforeMethod
	public void setUp() {
		// setting up the chrome driver path
		System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\Chrome Driver 99\\chromedriver.exe");

		// Creating Ref. variable and intialising with Chrome driver
		webDriver = new ChromeDriver();

		// Get the URL of the page
		webDriver.get("https://demoqa.com/buttons");

		webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		// Maximise the browser
		webDriver.manage().window().maximize();
		action = new Actions (webDriver);
	}
	@Test
	public void Click() {

		// Find Element
		WebElement clickMeBtn = webDriver.findElement(By.cssSelector("div.col-12 div>div.mt-4:nth-of-type(3) button"));

		// Perform
		action.click(clickMeBtn).perform();

		WebElement successMessage = webDriver.findElement(By.id("dynamicClickMessage"));

		Assert.assertEquals("You have done a dynamic click", successMessage.getText());

	}

	

}
