package com.kamaldhillon.learningSelenium;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SeleniumAssignment {
	WebDriver wd;

	@BeforeMethod
	// Setting up the chrome driver path
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\ChromeD\\chromedriver.exe");
		wd = new ChromeDriver();
		wd.get("http://automationpractice.com/index.php?controller=authentication&back=my-account#account-creation");
		// Creating Ref. variable & intialising with Chrome Driver

		wd.manage().window().maximize();
		wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void verifycreateAccount() {

		WebElement emailInput = wd.findElement(By.id("email_create"));
		Random str = new Random();
		String emailRandom = "emailInput" + str.nextDouble() + "@gmail.com";
		emailInput.sendKeys(emailRandom);

		WebElement createAccountButton = wd.findElement(By.id("SubmitCreate"));
		createAccountButton.submit();

		WebElement title = wd.findElement(By.cssSelector("label[for='id_gender2']"));
		title.click();

		WebElement firstName = wd.findElement(By.id("customer_firstname"));
		firstName.sendKeys("Komal");

		WebElement lastName = wd.findElement(By.id("customer_lastname"));
		lastName.sendKeys("Dhillon");

		WebElement password = wd.findElement(By.id("passwd"));
		password.sendKeys("Kam123");

		WebElement birthDate = wd.findElement(By.id("days"));
		Select select = new Select(birthDate);
		select.selectByIndex(5);

		WebElement birthmonth = wd.findElement(By.id("months"));
		Select select1 = new Select(birthmonth);
		select1.selectByIndex(3);

		WebElement birthyear = wd.findElement(By.id("years"));
		Select select2 = new Select(birthyear);
		select2.selectByValue("1997");

		WebElement newsLetter = wd.findElement(By.id("uniform-newsletter"));
		newsLetter.isSelected();

		WebElement specialOffers = wd.findElement(By.id("uniform-optin"));
		specialOffers.isSelected();

		WebElement Name1st = wd.findElement(By.id("firstname"));
		Name1st.sendKeys("Komal");

		WebElement NameLast = wd.findElement(By.id("lastname"));
		NameLast.sendKeys("Dhiilon");

		WebElement company = wd.findElement(By.id("company"));
		company.sendKeys("Siemens Energy");

		WebElement address1 = wd.findElement(By.id("address1"));
		address1.sendKeys("16 Rednor Drive");

		WebElement address2 = wd.findElement(By.id("address2"));
		address2.sendKeys("16 Rednor Drive");

		WebElement city = wd.findElement(By.id("city"));
		city.sendKeys("New York");

		WebElement state = wd.findElement(By.id("id_state"));
		Select selectState = new Select(state);
		selectState.selectByVisibleText("Alaska");

		WebElement postalCode = wd.findElement(By.id("postcode"));
		postalCode.sendKeys("99703");

		WebElement additionalInformation = wd.findElement(By.id("other"));
		additionalInformation.sendKeys("It's my info here");

		WebElement homePhone = wd.findElement(By.id("phone"));
		homePhone.sendKeys("6479999999");

		WebElement mobilePhone = wd.findElement(By.id("phone_mobile"));
		mobilePhone.sendKeys("4567892442");

		WebElement addressAlias = wd.findElement(By.id("alias"));
		addressAlias.sendKeys("16 Rednor Drive,245678");

		WebElement registerButton = wd.findElement(By.id("submitAccount"));
		registerButton.click();

		Assert.assertEquals(wd.getCurrentUrl(), "http://automationpractice.com/index.php?controller=my-account",
				"Error");
		
		
	}

	@AfterMethod
	public void tearDown() {
		wd.quit();
	}
}
