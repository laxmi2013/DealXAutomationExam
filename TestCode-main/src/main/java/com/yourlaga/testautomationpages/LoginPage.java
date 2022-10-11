package com.yourlaga.testautomationpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LoginPage {
	WebDriver driver;

	//create the constructor 
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}


	By loginbutton=By.xpath("//a[@title='Log in to your customer account']");
	By email = By.xpath("//input[@name='email']");
	By password = By.xpath("//input[@name='passwd']");
	By Signin = By.xpath("//button[@id='SubmitLogin']");

	
	
	public void clickOnLogin() {
		driver.findElement(loginbutton).click();
	}
	public void email(String str) {
		driver.findElement(email).sendKeys(str);
	}
	public void password(String str) {
		driver.findElement(password).sendKeys(str);
	}


	public void Signin() {
		driver.findElement(Signin).click();
	}
	

}
