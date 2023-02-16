package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.BaseClass;
import pageObjects.LandingPage;
import pageObjects.LoginPage;

public class LoginTest extends BaseClass{

	@Test(priority=1)
	public void testToVerifyLogin() {
		
		LoginPage login= new LoginPage(driver);
			login.setUserName(username);
			login.setUserPassword(password);
			login.loginBtn();
		

	}
	@Test(priority =2)
	public void testToVeriyCategory() {

		LoginPage login= new LoginPage(driver);
			login.setUserName(username);
			login.setUserPassword(password);
			login.loginBtn();
			LandingPage page=new LandingPage(driver);
			page.categoryOption();
	}
}
