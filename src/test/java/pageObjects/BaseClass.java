package pageObjects;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.ReadConfig;

public class BaseClass   {
	
	ReadConfig config = new ReadConfig();
	
	public String baseURL=config.getApplicationURL();
	public String username=config.getuseremail();

	public String password=config.getuserpassword();
	public static WebDriver driver;
	public static Logger logger;

	
	
	  
	  @BeforeMethod
	  @Parameters({"browser"})
	  public void setup(String getbrowser) {
		  logger=Logger.getLogger("banking");
	  PropertyConfigurator.configure("log4j.properties");
	  
	  if(getbrowser.equals("chrome")) {
	  //ChromeOptions options = new ChromeOptions();
	  //options.addArguments("--headless");
	  System.setProperty("webdriver.chrome.driver", config.getChromepath());
	  
	  driver=new ChromeDriver(); driver.manage().window().maximize();
	  logger.info("Chrome browser is lauching");  
	  }
	  
	  else if(getbrowser.equals("firefox")) {
	  System.setProperty("webdriver.gecko.driver", config.getfirefoxpath());
	  driver=new FirefoxDriver(); } driver.get(baseURL);
	  logger.info("Browser is lauching"); 
	  }

	/*
	 * @BeforeMethod public void setup() { WebDriverManager.chromedriver().setup();
	 * WebDriver driver = new ChromeDriver();
	 * driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); }
	 */
		@AfterMethod
		public void teardown() {
			driver.quit();
			logger.info("quit browser");
		}
		 public static String  sreenshot() throws IOException {
	    	 
				String base64screenshot  = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BASE64);
			    
			     return base64screenshot  ;
	}
		 

		}
