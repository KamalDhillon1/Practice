package com.automationAssignments.Tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.automationAssignment.BasePackage.TestBase;
import com.automationAssignment.Pages.MyAccount;
import com.automationAssignment.Pages.NewAccount;
import com.automationAssignment.Pages.SignUp;
import com.automationAssignment.Pages.TransferMoney;

public class MyAccountTest extends TestBase {
	
	SignUp signup;
	MyAccount myAccount;
	NewAccount newAccount;
	TransferMoney transferMoney;
	
@BeforeMethod
public void setUp() {
	intialsation();
	signup=new SignUp();
}
@Test
public void verifUserCanRegister() {
	
signup.enterFirstName(prop.getProperty("firstName"));
signup.enterLastName(prop.getProperty("lastName"));
signup.enterAddress(prop.getProperty("address"));
signup.enterCity(prop.getProperty("city"));
signup.enterZipCode(prop.getProperty("zipCode"));
signup.enterState(prop.getProperty("state"));
signup.enterPhone(prop.getProperty("phoneNumber"));
signup.enterSinNumber(prop.getProperty("sinNumber"));
signup.enterUsername(prop.getProperty("username"));

signup.enterPassword(prop.getProperty("password"));
signup.enterConfirmPassword(prop.getProperty("confirmPassword"));

myAccount=signup.submitRegisterBtn();

String messageActual=myAccount.getTextFromMessage();
Assert.assertEquals(messageActual, prop.getProperty("successMessageOnMyAccount"));


}
}
