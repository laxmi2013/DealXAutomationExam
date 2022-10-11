package com.yourlaga.testautomationpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchPage {
	WebDriver driver;

	//create the constructor 
	public SearchPage(WebDriver driver) {
		this.driver = driver;
	}

	// Locator for login button
	
	By search = By.xpath("//form[@id='searchbox']//input[@type='text']");
	By searchIcon = By.xpath("//form[@id='searchbox']//button[@type='submit']");
	By loginbutton=By.xpath("//a[@title='Log in to your customer account']");

	
	public void searchString(String str) {
		driver.findElement(search).clear();
		driver.findElement(search).sendKeys(str);
	}
	public void clickOnSearchIcon() {
		driver.findElement(searchIcon).click();
	}
	public String verifySerachResults(String actualSearchString)
	{

	    return driver.findElement(By.xpath("//h5//a[@title='"+actualSearchString+"']")).getText().trim();

}
	
	
}
