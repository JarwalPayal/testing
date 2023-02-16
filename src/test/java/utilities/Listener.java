package utilities;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import pageObjects.BaseClass;


public class Listener extends BaseClass  implements ITestListener {
	ExtentReports report1=ExtentReport.getextentreport();
	ExtentTest etest;
	public void onTestStart(ITestResult result) {
		String testname=result.getName();
        etest=report1.createTest(testname) ;
		etest.log(Status.INFO, testname+ "has started execution");
	
	}
    
	public void onTestSuccess(ITestResult result) {
		String testname=result.getName();
		etest.log(Status.PASS, testname+ " test case passed successfully");
	}
    
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		String testname=result.getName();
		etest.log(Status.FAIL, testname+ " test case failed");
		WebDriver driver = null;
		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstanceName());
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchFieldException e) {                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e){
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			etest.addScreenCaptureFromBase64String(sreenshot(),"ninja");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		String testname=result.getName();
		etest.log(Status.SKIP, testname+ " test case skipped");
	}
       public void onFinish(ITestContext context) {
    		//ExtentReports extent=new ExtentReports();
    	  report1.flush();
       }
}
