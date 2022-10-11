package com.yourlaga.testautomationpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class CartViewPage {
	WebDriver driver;

	//create the constructor 
	public CartViewPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public String mouseOverAndSelectSubCateoryFromMainCategory1() {
	Actions action = new Actions(driver);
	action.moveToElement(driver.findElement(By.xpath("//a[@title='Women']"))).perform();
	driver.findElement(By.xpath("//a[@title='Blouses']")).click();
	return driver.findElement(By.xpath("//div[@class='cat_desc']//span[contains(text(),'Blouses')]")).getText().trim();

	}
	public String mouseOverAndSelectSubCateoryFromMainCategory2() {
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[2]"))).perform();
		driver.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[2]/a//parent::li//li[2]//a")).click();
		return driver.findElement(By.xpath("//*[@id=\"center_column\"]/div[1]/div/div/span")).getText().trim();

		}
	public String mouseOverAndSelectSubCateoryFromMainCategory3() {
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[3]/a"))).perform();
		driver.findElement(By.xpath("//a[@title='Women']")).click();
		return driver.findElement(By.xpath("//div[@class='cat_desc']//span")).getText().trim();

		}
	
}
