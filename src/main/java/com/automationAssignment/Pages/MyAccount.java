package com.automationAssignment.Pages;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebElement;
import com.automationAssignment.BasePackage.TestBase;

public class MyAccount extends TestBase{
	
	public MyAccount() {
		PageFactory.initElements(wd, this);
	}
	
	@FindBy(xpath="//p[@text()=]")
	WebElement messageText;
	public String getTextFromMessage() {
		return messageText.getText();
	}
	
}
	
	


