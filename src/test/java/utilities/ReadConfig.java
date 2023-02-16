package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	Properties pro;
	
	public ReadConfig() {
		try {
		    pro= new Properties();
			FileInputStream file= new FileInputStream("./Configuration/config.properties");
		    pro.load(file);
		}
		catch(Exception e) {
			System.out.println("Exception is  " +e.getMessage());
		}
	}
	
	public String getApplicationURL() {
		String url=pro.getProperty("baseURL");
		return url;
	}
	
	
	public String getuseremail() {
		String useremail=pro.getProperty("username");
		return useremail;
	}
	
	public String getuserpassword() {
		String userpassword=pro.getProperty("password");
		return userpassword;
	}
	
	  public String getChromepath() { String
	  chrome=pro.getProperty("chromepath"); 
	  return chrome;
	 
	 }
	  
	  public String getfirefoxpath() { String
			 firefoxpath=pro.getProperty("firefoxpath"); 
			  return firefoxpath;
	  } 


}
