package utilities;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import pageObjects.BaseClass;

public class CommonUtils extends BaseClass {
	
	 public void clickByAction(WebElement element) {
	        Actions action = new Actions(driver);
	        action.moveToElement(element).click().build().perform();
	    }

	 public boolean iselementVisible(WebElement element) {

	        return iselementVisible(element);
	    }
	 
		public static void sleep(int second) {
			try {
				Thread.sleep(second * 1000);
			} catch (Exception ex) {
				logger.info(ex.getMessage());
			}
		}

}
