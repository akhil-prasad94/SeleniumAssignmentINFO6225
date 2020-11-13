package com.project.BaseObject;

import org.testng.annotations.Test;


import static org.junit.Assert.assertNotEquals;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import Utilities.BaseAssignment;


public class ScenarioOne {
  
	 WebDriver driver;
	 String baseurl;
	 String scen_number = "scenario1";
	 
  @Parameters({"northeasternURL"}) 
  @BeforeClass
  public void beforeMethod(String nUrl) throws IOException {
	 
	  driver = BaseAssignment.returnDriver();
	  driver.manage().window().maximize();
	  driver.get(nUrl);
	  BaseAssignment.makeScreenshotFolder(driver, "scenario1");
  }
  
  @Test
  public void addOptsMyFavorites() throws InterruptedException, IOException {
	  BaseAssignment.takeScreenShot(driver, scen_number, 4); // Use when screenshot needed, increment number
	  BaseAssignment.takeScreenShot(driver, scen_number, 8); 
	  
	  Assert.assertEquals(1, 0, "Nope");
	  
  }

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

}
