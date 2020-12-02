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
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class ScenarioBrowseCourseSpring21 {
	 WebDriver driver;
	 String baseurl;
	 String scen_number = "BrowsingClassesSpring21";
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
  @Parameters({"northeasternURL,runtype"})
  public void beforeMethod(String nbookURL, String runtype) throws IOException {
	  driver.manage().window().maximize();
	  driver.get(nbookURL);
	  BaseAssignment.makeScreenshotFolder(scen_number);
  }

  @Test
  public void browseClassesSpring21() throws IOException, InterruptedException {
	  
	    extent = new ExtentReports((System.getProperty("user.dir")) + "\\"+"report3.html", true);
		test = extent.startTest("Scenario2 - Browse courses for Spring 2021 term");
		test.log(LogStatus.PASS, "Sc2.1 -  : Open myNEU website");
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
		
		test.log(LogStatus.PASS, "Sc2.2 -  : Login using username and password");
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
		
		driver.findElement(By.xpath("//div[@class='portlet-body']//div[@class='apps-links-list cards-container'][4]//div[@class='item-link'][2]//a")).click();
		
		Thread.sleep(7500);
		BaseAssignment.takeScreenShot(driver, scen_number, 5);
		//get window handlers as list
		List<String> browserTabs = new ArrayList<String> (driver.getWindowHandles());
		//switch to new tab
		driver.switchTo().window(browserTabs.get(1));
		
		
		
		driver.findElement(By.xpath("//a[@id='classSearchLink']")).click();
		Thread.sleep(3000);
		
		
		
		test.log(LogStatus.PASS, "Sc2.3 -  : Choose term as Spring 2021");
		driver.findElement(By.xpath("//div[@id='s2id_txt_term']//a")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//div[@id='202130']")).click();
		BaseAssignment.takeScreenShot(driver, scen_number, 6);
		
		Thread.sleep(4000);
		driver.findElement(By.id("term-go")).click();
		
		
		Thread.sleep(3000);
		
		String courseterm = driver.findElement(By.xpath("//div[@id='search']//label")).getText();
		
		Assert.assertEquals(courseterm, "Term: Spring 2021 Semester");
		
		
		
		System.out.println("The term being browsed is  " + courseterm);
		
		driver.findElement(By.id("s2id_autogen1")).sendKeys("Information");;
		Thread.sleep(3000);
		driver.findElement(By.id("INFO")).click();
		BaseAssignment.takeScreenShot(driver, scen_number, 7);
		driver.findElement(By.id("search-go")).click();
		Thread.sleep(3000);
		
		test.log(LogStatus.PASS, "Sc2.4 -  : Search for stream -- Information Systems");
		
		
		driver.findElement(By.linkText("Application Modeling and Design")).click();
		String el = driver.findElement(By.linkText("Application Modeling and Design")).getText();
		System.out.println("The course being browsed is  " + el);
		Thread.sleep(3000);
		
		BaseAssignment.takeScreenShot(driver, scen_number, 8);
		driver.findElement(By.id("courseDescription")).click();
		Thread.sleep(3000);
		
		driver.findElement(By.id("facultyMeetingTimes")).click();
		Thread.sleep(3000);
		
		BaseAssignment.takeScreenShot(driver, scen_number, 9);
		driver.findElement(By.id("preReqs")).click();
		// Create object of actions class
		Actions act=new Actions(driver);
		// find element which we need to drag
		WebElement drag=driver.findElement(By.xpath("//div[@class='ui-dialog-titlebar ui-widget-header ui-corner-all ui-helper-clearfix']"));
		// calling the method and x,y cordinates are random
		act.dragAndDropBy(drag, 0, 150).build().perform();
		
		Thread.sleep(4000);
	
		driver.findElement(By.xpath("//div[@class='ui-dialog-buttonset']//button")).click();

		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//div[@class='paging-container']//button[3]")).click();
		
		Thread.sleep(5000);
		
		driver.findElement(By.linkText("Data Science Engineering Methods and Tools")).click();
		String el3 = driver.findElement(By.linkText("Data Science Engineering Methods and Tools")).getText();
		System.out.println("The course being browsed is  " + el3);
		Thread.sleep(3000);
		
		BaseAssignment.takeScreenShot(driver, scen_number, 10);
		driver.findElement(By.id("courseDescription")).click();
		Thread.sleep(3000);
		
		driver.findElement(By.id("facultyMeetingTimes")).click();
		Thread.sleep(3000);
		
		BaseAssignment.takeScreenShot(driver, scen_number, 11);
		driver.findElement(By.id("preReqs")).click();
		
		
		// find element which we need to drag
		WebElement draeg=driver.findElement(By.xpath("//div[@class='ui-dialog-titlebar ui-widget-header ui-corner-all ui-helper-clearfix']"));
		// calling the method and x,y cordinates are random
		act.dragAndDropBy(drag, 0, 150).build().perform();
		
		Thread.sleep(4000);
	
		driver.findElement(By.xpath("//div[@class='ui-dialog-buttonset']//button")).click();
		
		test.log(LogStatus.PASS, "Sc2.5 -  : Browse one course with specific details");
		
		extent.endTest(test);
		extent.flush();
	
		System.out.println("SCENARIO - BROWSE COURSES FOR SPRING 2021 - PASSED");
  }
  
  @AfterMethod
  public void afterMethod() {
	    driver.quit();
  }

}
