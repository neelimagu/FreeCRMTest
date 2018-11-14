package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.crm.qa.util.TestUtil;

//Basic initialization. This class is base class for all the other classes we create 
//to use the common properties mentioned in this class using inheritance.

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	
	public TestBase() {
		
		try{
		prop = new Properties();
		FileInputStream ip = new FileInputStream("C:\\Users\\neeli\\Agama\\Sep24thBatch"
				+ "\\FreeCRMTest\\src\\main\\java\\com\\crm\\qa\\config\\config.properties");
		prop.load(ip);
	}catch(FileNotFoundException e){
		e.printStackTrace();
	}catch(IOException e){
		e.printStackTrace();
	}
	}
	
	public static void intialization(){
		
		String browserName = prop.getProperty("browser");
		if(browserName.equals("chrome")){
			
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\neeli\\Downloads\\chromedriver_win32\\chromedriver.exe");
		    driver = new ChromeDriver();
			
	}
		else if(browserName.equals("Firefox")){
		
		System.setProperty("webdriver.gecko.driver","C:\\Users\\neeli\\Downloads\\geckodriver-v0.23.0-win64\\geckodriver.exe");
	    driver = new FirefoxDriver();
	
	}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		//here we are reading page load timeout and implicit wait from TestUtil class.
		//Instead of hard coding the values we are reading from the class.
		//In future if we want to increase the time out values, we can just do changes in one class.
		
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
		
		
	}
}
