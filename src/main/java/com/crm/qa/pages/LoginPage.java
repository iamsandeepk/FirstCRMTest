package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {

	//Page Factory - Object Repo
	
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement loginBtn;
	
	@FindBy(xpath="//button[contains(text(),'Sign Up')]")
	WebElement SignUpBtn;
	
	@FindBy(xpath="//img[contains(@class,'img-responsive')]")
	WebElement crmLogo;
	//save karo kr diya
	// Initializing the page objects 
	public LoginPage(){
		PageFactory.initElements(driver, this); // how to initialize the pagefactory
		
	}
	//Actions
	public String validateLoginPageTitle() {
		return driver.getTitle();
		
	}
	public boolean validateCRMImage() {
		return crmLogo.isDisplayed();
	}
	public HomePage login(String un,String pwd) {
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginBtn.submit();
		return new HomePage();
	}
	
}
