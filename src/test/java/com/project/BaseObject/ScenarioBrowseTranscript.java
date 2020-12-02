package com.project.BaseObject;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Utilities.BaseAssignment;
import Utilities.Properties_Project;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class ScenarioBrowseTranscript {
	 WebDriver driver;
	 String baseurl;
	 String scen_number = "BrowseTranscript";
	 Properties prop = Properties_Project.returnPropsObject();
	 public static ExtentReports extent;
	 public ExtentTest test;
	 
	 
	 @BeforeTest
	 @Parameters({"runtype"})
	 public void runSetup(String runtype) throws MalformedURLException
	 {
		 driver = BaseAssignment.returnDriver(runtype);
	 }
	 

  @BeforeMethod
  @Parameters({"northeasternURL"})
  public void beforeMethod(String nURL) throws IOException {
	  driver.manage().window().maximize();
	  driver.get(nURL);
	  BaseAssignment.makeScreenshotFolder(scen_number);
  }

  @Test
  public void browseClassesSpring21() throws IOException, InterruptedException {
	  
	    extent = new ExtentReports((System.getProperty("user.dir")) + "\\"+"report4.html", true);
		test = extent.startTest("Scenario4 - Browse transcript");
		test.log(LogStatus.PASS, "Sc4.1 -  : Open myNEU website");
	 	//Click the login button
		//driver.findElement(By.xpath("//*[@id=\"portlet_com_liferay_journal_content_web_portlet_JournalContentPortlet_INSTANCE_GhAIpHlwoE3O\"]/div/div/div/div[2]/div/div[2]/div/a")).click();
		driver.findElement(By.xpath("//div[@class='row center no-margin']/div/div/div/section/div/div/div/div/div/div/div[@class='inner-box']/a[contains(text(),'Go To Login')]")).click();
		//SS
		BaseAssignment.takeScreenShot(driver, scen_number, 1);
		Thread.sleep(2000);

		//Enter the user name and the password
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys(prop.getProperty("username"));		
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(prop.getProperty("password"));
		Thread.sleep(3000);
		
		//SS
		BaseAssignment.takeScreenShot(driver, scen_number, 2);

		//log in the myneu account
		driver.findElement(By.xpath("//button[@name='_eventId_proceed']")).click();
		Thread.sleep(4000);
		
		test.log(LogStatus.PASS, "Sc4.2 -  : Login using username and password");
		BaseAssignment.takeScreenShot(driver, scen_number, 3);
		
		//Switch to child frame and switch back to parent frame
		driver.switchTo().frame("duo_iframe");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[contains(text(),'Send Me a Push ')]")).click();
		Thread.sleep(16000);
		driver.switchTo().parentFrame();
		//Thread.sleep(5000);
	
		BaseAssignment.takeScreenShot(driver, scen_number, 4);
		
		
		driver.findElement(By.xpath("//nav[@id='navigation']//li[@id='layout_2']")).click();
		Thread.sleep(4000);
		
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0,800)");
		
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//div[@class='portlet-body']//div[@class='apps-links-list cards-container'][4]//div[@class='col-xs-12 col-md-6'][2]//div[@class='item-link']//a")).click();
		
		Thread.sleep(7500);
		BaseAssignment.takeScreenShot(driver, scen_number, 5);
		//get window handlers as list
		List<String> browserTabs = new ArrayList<String> (driver.getWindowHandles());
		//switch to new tab
		driver.switchTo().window(browserTabs.get(1));
		
		Thread.sleep(3000);
		
		Select dp = new Select(driver.findElement(By.id("levl_id")));
		dp.selectByVisibleText("Graduate");
		
		Thread.sleep(3000);
		
		
		Select unofficialweb = new Select(driver.findElement(By.id("type_id")));
		unofficialweb.selectByVisibleText("Unofficial Web");
		
		Thread.sleep(4000);
		
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		test.log(LogStatus.PASS, "Sc4.3 -  : Choose term as level and type");
		
		BaseAssignment.takeScreenShot(driver, scen_number, 6);
		
		Thread.sleep(4000);
		
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0,800)");
		
		Thread.sleep(3000);
		
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0,400)");
		
		test.log(LogStatus.PASS, "Sc4.4 -  : Browsing of transcript successful");
		
		extent.endTest(test);
		extent.flush();
	
		System.out.println("SCENARIO - BROWSE UNOFFICIAL TRANSCRIPT - PASSED");
  }
  
  @AfterMethod
  public void afterMethod() {
	    driver.quit();
  }

}
