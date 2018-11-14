package com.crm.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase{
	
	
	//define page factory of login page(or object repository)
	
	@FindBy(name = "username")
	
	WebElement username;
	
	@FindBy(name="password")
	
	WebElement password;
	
	@FindBy(xpath="//input [@type = 'submit']")
	
	WebElement loginBtn;
	
	@FindBy(xpath = "//button[contains(text(),'Sign Up')]") 
	
	WebElement signUpBtn;
	
	
	@FindBy(xpath ="//img[contains(@class,'img-responsive')]")
	
	WebElement crmLogo;
	
	//to initialize page objects
	public LoginPage(){
		//driver is coming from base class
		//PageFactory elements are initialized using the initElements method -- interview 
		//this down here points to current class object
		
		PageFactory.initElements(driver, this);
	}
	
	//actions
	public String validateLoginPageTitle(){
		
		return driver.getTitle();
	}
	
	public boolean validateCRMImage(){
		
		return crmLogo.isDisplayed();
		
	}
	
	public HomePage login(String un, String pwd){
		//System.out.println("I am printing username:"+un+pwd);
		username.sendKeys(un);
		password.sendKeys(pwd);
		//loginBtn.click();
		//home page is landing page of login page 
		//System.out.println("I am printing username:"+un+pwd);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", loginBtn);
		//System.out.println("I am printing username:"+un+pwd);
		return new HomePage();
	}

}
