package Utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseAssignment {
	static File filess;
	static WebDriver driver;
	
	public static WebDriver returnDriver()
	{
	  System.setProperty("webdriver.chrome.driver", "C:\\chromedrivernew.exe");
	  return driver = new ChromeDriver();
	}

	public static void makeDirectoryandScreenshot(WebDriver driver, String testScenarioName) throws IOException {
		String finalpath = System.getProperty("user.dir")+"\\"+testScenarioName;
		filess = new File(finalpath);
		filess.mkdir();
	}
	
	public static void takeScreenShot(WebDriver driver, String testScenarioName, int n) throws IOException 
	{
		String abpath = null;
		File f = new File(System.getProperty("user.dir"));
		File[] ms = f.listFiles();
		for(int i=0; i<ms.length;i++)
		{
			if(ms[i].getName().contains(testScenarioName))
			{
			 abpath = ms[i].getAbsolutePath();
			}
		}
		File screenshotfile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); 
		FileUtils.copyFile(screenshotfile, new File(abpath, n+".png"));
	} 
}
