package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import utilities.CommonUtils;

public class LoginPage extends BaseClass{
	WebDriver driver;
	CommonUtils utility= new CommonUtils();

	public LoginPage(WebDriver rdriver){
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
		
	}
	
	@FindBy(xpath="//input[@id='CustomerEmail']")
	WebElement username;
	
	@FindBy(xpath="//input[@id='CustomerPassword']")
	WebElement password;
	
	@FindBy(xpath="//input[@value='Sign In']")
	WebElement loginbtn;
	
	@FindBy(xpath="//div[@class='recaptcha-checkbox-border']")
    WebElement captcha;
	
	@FindBy(xpath="//input[@value='Submit']")
	WebElement submit;
	
	public LoginPage setUserName(String uname) {
		username.sendKeys(uname);
		logger.info("Enter a email" +username.getText());
		
		
		return this;
		
	}
	public LoginPage setUserPassword(String upassword) {
		password.sendKeys(upassword);
		logger.info("Enter a password :-" +password.getText());

		return this;
	}
	public LoginPage loginBtn() {
         loginbtn.click();	
 		logger.info("clicking on login btn");

		return this;
	}
}
