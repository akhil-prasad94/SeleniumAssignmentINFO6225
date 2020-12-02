package com.project.BaseObject;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import static org.junit.Assert.assertNotEquals;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import Utilities.BaseAssignment;
import Utilities.Properties_Project;



public class ScenarioScheduleTestWellnessPortal {
  
	 WebDriver driver;
	 String baseurl;
	 String scen_number = "AddingOptsToMyFavorites";
	 Properties prop = Properties_Project.returnPropsObject();
	 JavascriptExecutor js = (JavascriptExecutor) driver;
	 public static ExtentReports extent;
	 public ExtentTest test;
	 
   
  @BeforeMethod
  @Parameters({"northeasternURL,runtype"})
  public void beforeMethod(String nUrl, String runtype) throws IOException {
	 
	  driver = BaseAssignment.returnDriver(runtype);
	  driver.manage().window().maximize();
	  driver.get(nUrl);
	  BaseAssignment.makeScreenshotFolder(scen_number);
  }
  
  @Test
  public void addOptsMyFavorites() throws InterruptedException, IOException {
	  
	  
	    extent = new ExtentReports((System.getProperty("user.dir")) + "\\"+"report.html", true);
		test = extent.startTest("Scenario1 - Add  Options to My Favorites");
		test.log(LogStatus.PASS, "Sc1.1 -  : Open myNEU website");
	  
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
		Thread.sleep(1000);
		test.log(LogStatus.PASS, "Sc1.2 -  : Login using username and password");
		
		BaseAssignment.takeScreenShot(driver, scen_number, 3);
		
		//Switch to child frame and switch back to parent frame
		driver.switchTo().frame("duo_iframe");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[contains(text(),'Call Me ')]")).click();
		Thread.sleep(18000);
		driver.switchTo().parentFrame();
	
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0,500)");

		test.log(LogStatus.PASS, "Sc1.3 -  : Two Factor authentication");
		BaseAssignment.takeScreenShot(driver, scen_number, 4);
		
		
		driver.findElement(By.xpath("//nav[@id='navigation']//li[@id='layout_2']")).click();
		Thread.sleep(4000);
		
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0,800)");
		

		driver.findElement(By.xpath("//div[@class='portlet-body']//div[@class='apps-links-list cards-container'][5]//div[@class='col-xs-12 col-md-6'][2]//div[@class='item-link'][3]//a")).click();
		
		Thread.sleep(7500);
		BaseAssignment.takeScreenShot(driver, scen_number, 5);
		//get window handlers as list
		List<String> browserTabs = new ArrayList<String> (driver.getWindowHandles());
		//switch to new tab
		driver.switchTo().window(browserTabs.get(1));
		
		Thread.sleep(6000);
		
		driver.findElement(By.xpath("//a[@class='color_box  icon-link-background-default text-white'][2]")).click();
		
		
		extent.endTest(test);
		extent.flush();
		
		System.out.println("SCENARIO1 - ADD OPTIONS TO MY FAVORITES - PASSED");
  }

  @AfterMethod
  public void afterMethod() {
	 driver.quit();
  }

}
