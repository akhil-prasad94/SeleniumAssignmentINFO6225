package com.project.BaseObject;

import org.testng.annotations.Test;

import Utilities.BaseAssignment;

import org.testng.annotations.BeforeTest;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

public class ScenarioThree {
	 WebDriver driver;
	 String baseurl;
	 String scen_number = "scenario3";
	
  @BeforeMethod
  public void beforeMethod() throws IOException {
	  driver = BaseAssignment.returnDriver();
	  driver.manage().window().maximize();
	  driver.get("http://s3.amazonaws.com/co.tulip.cdn/memtracking/index.html");
	  BaseAssignment.makeDirectoryandScreenshot(driver, scen_number);
  }

  @Test
  public void seleniumAssignmentScenario_3() throws IOException {
	  
	  
	  BaseAssignment.takeScreenShot(driver, scen_number, 90);
  }
  
  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

}
