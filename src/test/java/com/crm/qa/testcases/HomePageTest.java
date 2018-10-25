package com.crm.qa.testcases;

import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.DealsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactsPage;
	DealsPage dealsPage;
	
	public HomePageTest() {
		super();
	}
	
	//Test cases should be separated -- independent with each other
	// before each test case -- launch the browser and login
	// after each test case -- close the browser
	
	
	@BeforeMethod
	public void setUp() {
		initialization();
		testUtil=new TestUtil();
		loginPage=new LoginPage();
		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test (priority=1)
	public void verifyHomePageTitleTest() {
		String homePageTitle=homePage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle, "CRMPRO", "Homepage title not matched");
		driver.close();
	}
	@Test (priority=2)
	  public void verifyuserNameTest() {
		  testUtil.switchToFrame();
		  Assert.assertTrue(homePage.verifyCorrectUserName()); 
		  driver.close();
	  }
	  
	  @Test (priority=3)
	  public void verifyContactsLinkTest() {
		  testUtil.switchToFrame();
		  contactsPage=homePage.clickOnContactsLink();
		  driver.close();
	  }
	  
	  @Test (priority=4)
	  public void verifyDealsLinkTest() {
		  testUtil.switchToFrame();
		  dealsPage=homePage.clickOnDealsLink();
	  }
	
	
	@AfterMethod
	public void tearDown() {
		//driver.quit();
	}

}
