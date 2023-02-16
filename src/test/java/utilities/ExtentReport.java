package utilities;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReport extends Listener{
	public static ExtentReports getextentreport() {
		
		
		ExtentReports report=new ExtentReports();
		File file=new File(System.getProperty("user.dir")+"//report//report.html");
	    ExtentSparkReporter spark=new ExtentSparkReporter(file);
	    report.attachReporter(spark);
		return report;
	}
}
