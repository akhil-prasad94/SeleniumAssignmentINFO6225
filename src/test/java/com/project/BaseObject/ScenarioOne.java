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
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

import Utilities.BaseAssignment;


public class ScenarioOne {
  
	 WebDriver driver;
	 String baseurl;
	 String scen_number = "scenario1";
	 
  @BeforeMethod
  public void beforeMethod() throws IOException {
	 
	  driver = BaseAssignment.returnDriver();
	  driver.manage().window().maximize();
	  driver.get("http://s3.amazonaws.com/co.tulip.cdn/memtracking/index.html");
	  BaseAssignment.makeDirectoryandScreenshot(driver, "scenario1");
  }
  
  @Test
  public void seleniumAssignmentScenario_1() throws InterruptedException, IOException {
	  BaseAssignment.takeScreenShot(driver, scen_number, 4);
	  
	  
	  
	  
  }

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

}
