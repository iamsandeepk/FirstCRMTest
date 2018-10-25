package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {

	@FindBy(xpath="//td[contains(text(), 'User: Naveen K')]")
	WebElement userNameLabel;
	
	@FindBy(xpath="//a[contains(text(),'Contacts')]")
	WebElement contactslink;
	
	@FindBy(xpath="//a[contains(text(),'Deals')]")
	WebElement dealslink;
	
	@FindBy(xpath="//a[contains(text(),'Task')]")
	WebElement tasklink;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
		
	}
	public String verifyHomePageTitle() {
		return driver.getTitle();
		
	}
	
	public boolean verifyCorrectUserName() {
		return userNameLabel.isDisplayed();
	}
	
	public ContactsPage clickOnContactsLink() {
		contactslink.click();
		return new ContactsPage();
	}
	public DealsPage clickOnDealsLink() {
		dealslink.click();
		return new DealsPage();
	}
	public TaskPage clickOnTaskLink() {
		tasklink.click();
		return new TaskPage();
	}
}
