package com.yourlaga.testautomationpages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class CartPage {

	WebDriver driver;

	// create the constructor
	public CartPage(WebDriver driver) {
		this.driver = driver;
	}

	By addtocart = By.xpath("(//span[text()='Add to cart'])[1]");
	By proceedtocheckout = By.xpath("//a[@title='Proceed to checkout']");
	By plusIcon = By.xpath("//a//i[@class='icon-plus']");

	By UnitPrice = By.xpath("(//table//span[@class='price'])[1]");
	By TotalPricee = By.xpath("//td[@data-title='Total']");

	public void clickOnAddToCart() {
		driver.findElement(addtocart).click();
	}

	public void clickOnProceedToCheckout() {
		driver.findElement(proceedtocheckout).click();
	}

	public void clickOnpLusIcon() {
		driver.findElement(plusIcon).click();
	}

	public String getTotalPrice() {
		return driver.findElement(TotalPricee).getText();
	}

	public String getUnitPrice() {
		return driver.findElement(UnitPrice).getText();
	}

	public void selectProduct() {
		JavascriptExecutor js = (JavascriptExecutor) driver;

		WebElement element = driver.findElement(By.xpath("(//div[@class='product-image-container']//a)[1]"));
		js.executeScript("arguments[0].scrollIntoView();", element);
		Actions actions = new Actions(driver);
		actions.click().perform();

		actions.moveToElement(element).perform();
	}

}
