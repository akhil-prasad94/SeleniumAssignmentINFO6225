package com.project.BaseObject;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Utilities.BaseAssignment;
import Utilities.Properties_Project;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class ScenarioAddToCartNEUStore {

	 WebDriver driver;
	 String baseurl;
	 String scen_number = "AddToCartNEUStore";
	 Properties prop = Properties_Project.returnPropsObject();
	 public static ExtentReports extent;
	 public ExtentTest test;
	 SoftAssert softassert = new SoftAssert();
	 
	 @BeforeTest
	 @Parameters({"runtype"})
	 public void runSetup(String runtype) throws MalformedURLException
	 {
		 driver = BaseAssignment.returnDriver(runtype);
	 }
	 
  @BeforeMethod
  @Parameters({"northeasternBookstoreURL,runtype"})
  public void beforeMethod(String nUrl, String runtype) throws IOException {
	  driver.manage().window().maximize();
	  driver.get(nUrl);
	  BaseAssignment.makeScreenshotFolder(scen_number);
  }
  
  @Test
  public void addToCartNEUStore() throws IOException, InterruptedException {

	  extent = new ExtentReports((System.getProperty("user.dir")) + "\\"+"report2.html", true);
	  test = extent.startTest("Scenario3 - Add items to cart in NEU store ");
	  test.log(LogStatus.PASS, "Sc3.1 -  : Open NEU bookstore website");

	  driver.findElement(By.xpath("//input[@title='Dismiss Anouncement']")).click();
	  Thread.sleep(3000);
	  driver.findElement(By.xpath("//a[@class='title signInButMargin']")).click();
	  Thread.sleep(3000);
	  
	  BaseAssignment.takeScreenShot(driver,scen_number, 1);
	  
	  
	  driver.findElement(By.xpath("//input[@id='logonId']")).sendKeys(prop.getProperty("bookusrn"));
	  Thread.sleep(3000);
	  driver.findElement(By.xpath("//input[@id='logonPassword']")).sendKeys(prop.getProperty("bookpass"));
	  Thread.sleep(3000);
	  driver.findElement(By.xpath("//input[@name='login']")).click();
	  Thread.sleep(4000);
	  
	  BaseAssignment.takeScreenShot(driver,scen_number, 2);
	  test.log(LogStatus.PASS, "Sc3.2 -  : Login NEU bookstore website success");
	  
	  String verifyAccountName = driver.findElement(By.xpath("//div[@class='login']/span/span/a[@title='Account Details']")).getText();
	  System.out.println("Account name is : "+verifyAccountName);
	  Assert.assertEquals(verifyAccountName, "Hello, Ruchi", "Account Name is not verified to be Ruchi" );
	  driver.findElement(By.id("topNavSearch")).sendKeys("hoodie");
	  Thread.sleep(3000);
	  driver.findElement(By.id("searchbutton")).click();
	  Thread.sleep(3000);
	  driver.findElement(By.xpath("//h3/a[contains(text(),'LADIES MAINSTREAM HOODIE')]")).click();
	  Thread.sleep(3000);
	  String SelectedproductName = driver.findElement(By.xpath("//h1[contains(text(),'LADIES MAINSTREAM HOODIE')]")).getText();
	  System.out.println("Product name is : "+SelectedproductName);
	  Thread.sleep(3000);
	  
	  BaseAssignment.takeScreenShot(driver,scen_number, 3);
	  
	  
	  Assert.assertEquals(SelectedproductName, "LADIES MAINSTREAM HOODIE", "The item added to card is not "+SelectedproductName);
	  driver.findElement(By.xpath("//a[@title='SMALL']")).click();
	  Thread.sleep(3000);
	  String selectedQuantity = driver.findElement(By.xpath("//input[@name='quantity']")).getText();
	  driver.findElement(By.xpath("//input[@title='ADD TO CART']")).click();
	  Thread.sleep(3000);
	  driver.findElement(By.xpath("//button/span[contains(text(),'VIEW CART')]")).click();
	  Thread.sleep(3000);
	  String ViewCartPage = driver.findElement(By.xpath("//h1[contains(text(),'YOUR SHOPPING CART')]")).getText();
	  softassert.assertEquals(ViewCartPage, "YOUR SHOPPING CART", "View Cart is not displayed");
	  test.log(LogStatus.PASS, "Sc3.3 -  : Item has been added to cart in Bookstore");
	  BaseAssignment.takeScreenShot(driver,scen_number, 4);
	  
	  
	  String itemAddedToCart = driver.findElement(By.xpath("//span[contains(text(),'LADIES MAINSTREAM HOODIE')]")).getText();
	  Assert.assertEquals(SelectedproductName, itemAddedToCart, "The item added and visible in the cart are not same");
	  String addedQty = driver.findElement(By.xpath("//td[@class='prodQuty']/span[@class='tbQtyLabel']")).getText();
	 // softassert.assertEquals(selectedQuantity, addedQty, "The quantity and added item and qty of item visible in the cart are not same");
	  
	  JavascriptExecutor js = (JavascriptExecutor) driver;  
	  js.executeScript("window.scrollBy(0,800)");
	  
	  BaseAssignment.takeScreenShot(driver,scen_number, 5);
	  
	 // softassert.assertAll();
	  extent.endTest(test);
	  extent.flush();
	  
	  System.out.println("SCENARIO - ADD ITEM TO NEU BOOK STORE CART -  PASSED");
  }


  @AfterMethod
  public void afterMethod() {
  driver.quit();
  }

}
