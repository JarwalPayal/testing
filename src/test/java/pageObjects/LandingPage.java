package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import utilities.CommonUtils;

public class LandingPage extends BaseClass {
	
WebDriver driver;
	
	public LandingPage(WebDriver rdriver){
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
		
	}
	CommonUtils utility= new CommonUtils();
	@FindBy(xpath="//span[text()='Shop']")
	WebElement shop;
	
	@FindBy(xpath="(//div[@class='product-list']/div/a)[1]")
	WebElement product;

	public LandingPage categoryOption() {
        shop.click();	
        logger.info("Clicking on shop :- " +shop.getText());
        
       // product.click();
        //logger.info("Clicking on product :- " +product.getText());

		return this;
		
	}
	
	
	
	

}
