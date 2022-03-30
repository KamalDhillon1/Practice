package com.automationAssignment.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automationAssignment.BasePackage.TestBase;

public class SignUp extends TestBase{
	
	public SignUp() {
		PageFactory.initElements(wd, this);
	}
	@FindBy(id="customer.firstName")
	WebElement firstNameInput;
	
	@FindBy(id="customer.lastName")
	WebElement lastNameInput;
	
	@FindBy(id="customer.address.street")
	WebElement addressInput;
	
	@FindBy(id="customer.address.city")
	WebElement cityInput;
	
	@FindBy(id="customer.address.state")
	WebElement stateInput;
	
	@FindBy(id="customer.address.zipCode")
	WebElement zipCodeInput;
	
	@FindBy(id="customer.phoneNumber")
	WebElement phoneNumberInput;
	
	@FindBy(id="customer.ssn")
	WebElement sinNumberInput;
	
	@FindBy(id="customer.username")
	WebElement usernameInput;
	
	@FindBy(id="customer.password")
	WebElement passwordInput;
	
	@FindBy(id="repeatedPassword")
	WebElement confirmPasswordInput;
	
	@FindBy(css="input[type='submit']")
	WebElement registorBtn;
	
   public void enterFirstName(String firstName) {
	   firstNameInput.sendKeys(firstName);
   }
   public void enterLastName(String lastName) {
	   lastNameInput.sendKeys(lastName);
   }
   public void enterAddress(String address) {
	   addressInput.sendKeys(address);
   }
   public void enterCity(String city) {
	   cityInput.sendKeys(city);
   }
   public void enterState(String state) {
	   stateInput.sendKeys(state);
   }
   public void enterZipCode(String zipCode) {
	   zipCodeInput.sendKeys(zipCode);
   }
   public void enterPhone(String phoneNumber) {
	   phoneNumberInput.sendKeys(phoneNumber);
   }
   public void enterSinNumber(String sinNumber) {
	   sinNumberInput.sendKeys(sinNumber);
   }
   public void enterUsername(String username) {
	   usernameInput.sendKeys(username);
   }
   public void enterPassword(String password) {
	   passwordInput.sendKeys(password);
   }
   public void enterConfirmPassword(String confirmPassword) {
	   confirmPasswordInput.sendKeys(confirmPassword);
   }
   public MyAccount submitRegisterBtn() {
	   registorBtn.submit();
	   return new MyAccount();
   }

   
}
