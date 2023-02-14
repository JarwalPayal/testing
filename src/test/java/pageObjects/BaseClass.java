package pageObjects;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import utilities.ReadConfig;

public class BaseClass {
	
	ReadConfig config = new ReadConfig();
	
	public String baseURL=config.getApplicationURL();
	public String username=config.getuseremail();

	public String password=config.getuserpassword();
	public static WebDriver driver;
	public static Logger logger;

	 @Parameters("browser")
		@BeforeMethod
		public void setup(String browser) {
	    logger =Logger.getLogger("banking");
	    PropertyConfigurator.configure("log4j.properties");
		 
	    	if(browser.equals("chrome")) {
		System.setProperty("webdriver.chrome.driver", config.getChromepath());
		 driver=new ChromeDriver();
		 driver.manage().window().maximize();
	    	}
	    	
	    	else if(browser.equals("firefox")) {
	    		System.setProperty("webdriver.gecko.driver", config.getfirefoxpath());
	    		 driver=new FirefoxDriver();
	    	}
	        driver.get(baseURL);
	        logger.info("Browser is lauching");
	        }
		    
		@AfterMethod
		public void teardown() {
			driver.quit();
			logger.info("quit browser");
		}
}
