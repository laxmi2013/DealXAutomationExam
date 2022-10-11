package com.yourlaga.testautomationpages;

import org.testng.annotations.Test;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {
	WebDriver driver;
	private String[] commaSeparateds;
	private BufferedReader br;

	
	@BeforeTest
	public void beforeMethod() {
		System.setProperty("webdriver.chrome.driver","./chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);

	}
	
	@Test(priority = 1)
	public void TestCase1() throws InterruptedException {
		System.out.println("-----TestCase1-----------");
		driver.get("http://automationpractice.com/");
		driver.manage().window().maximize();
		SearchPage test = new SearchPage(driver);
		commaSeparateds = new String[] { "Printed Chiffon Dress" };
		for (String actualSearchString : commaSeparateds) {
			System.out.println(actualSearchString);
			test.searchString(actualSearchString);
			test.clickOnSearchIcon();
			String ExpectedValue = test.verifySerachResults(actualSearchString);
			Assert.assertEquals(actualSearchString, ExpectedValue);
		}
	}

	@Test(priority = 2)
	public void TestCase2() throws InterruptedException {
		System.out.println("------TestCase2----------------");
		driver.get("http://automationpractice.com/");
		driver.manage().window().maximize();
		SearchPage test = new SearchPage(driver);
		commaSeparateds = new String[] { "Printed Chiffon Dress", "Blouse", "Faded Short Sleeve T-shirts" };
		for (String actualSearchString : commaSeparateds) {
			System.out.println(actualSearchString);
			test.searchString(actualSearchString);
			test.clickOnSearchIcon();
			String ExpectedValue = test.verifySerachResults(actualSearchString);
			Assert.assertEquals(actualSearchString, ExpectedValue);
		}
	}

	@Test(priority = 3)
	public void TestCase3() throws InterruptedException, IOException {
		File file = new File("./testdata.txt");
		br = new BufferedReader(new FileReader(file));
		String st;
		String val = null;
		while ((st = br.readLine()) != null) {
			System.out.println(st);
			val = st;
		}
		System.out.println("--------Before TestCase3----------------");
		driver.get("http://automationpractice.com/");
		driver.manage().window().maximize();
		SearchPage test = new SearchPage(driver);
		test.searchString(val);
		test.clickOnSearchIcon();
		String ExpectedValue = test.verifySerachResults(val);
		Assert.assertEquals(ExpectedValue, val);

	}

	@Test(priority = 4)
	public void TestCase4() throws InterruptedException, IOException {
		System.out.println("--------Before TestCase4----------------");
		driver.get("http://automationpractice.com/");
		driver.manage().window().maximize();
		LoginPage page = new LoginPage(driver);
		page.clickOnLogin();
		page.email("swapna.gnk@gmail.com");
		page.password("Garla@1985");
		page.Signin();

	}

	@Test(priority = 5)
	public void TestCase5() throws InterruptedException, IOException {
		System.out.println("--------Before TestCase5----------------");
		driver.get("http://automationpractice.com/");
		driver.manage().window().maximize();

		CartPage page = new CartPage(driver);
		page.selectProduct();
		page.clickOnAddToCart();
		page.clickOnProceedToCheckout();
		page.clickOnpLusIcon();
		String unitPrice = page.getUnitPrice();
		String unitPriceValue = unitPrice.replace("$", "");
		double unitPriceIntegerValue = Double.parseDouble(unitPriceValue);

		Thread.sleep(5000);
		String totalPrice = page.getTotalPrice();
		String totalPriceValue = totalPrice.replace("$", "");
		System.out.println("Total Value" + totalPriceValue);

		Assert.assertEquals(String.valueOf(2 * unitPriceIntegerValue), totalPriceValue);

	}
	@Test(priority = 6)
	public void Testcase6() throws InterruptedException, IOException {
		System.out.println("--------Before TestCase6----------------");
		driver.get("http://automationpractice.com/");
		driver.manage().window().maximize();
		CartViewPage page = new CartViewPage(driver);
		String ActualResult = page.mouseOverAndSelectSubCateoryFromMainCategory1();
		Assert.assertEquals("Blouses", ActualResult);
		driver.navigate().back();
		driver.navigate().refresh();

		String ActualResult2 = page.mouseOverAndSelectSubCateoryFromMainCategory2();
		Assert.assertEquals("Evening Dresses", ActualResult2);

		driver.navigate().back();
		driver.navigate().refresh();
		String ActualResult3 = page.mouseOverAndSelectSubCateoryFromMainCategory3();
		Assert.assertEquals("Women", ActualResult3);

	}

	@AfterTest
	public void afterMethod() {
		// close and quit the browser
		driver.quit();
	}

}
