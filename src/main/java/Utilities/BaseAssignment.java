package Utilities;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

public class BaseAssignment {
	static File filess;
	static WebDriver driver;
	public static final String URL = "https://akhilprasad94:61cfad4d-9789-4770-821a-90f5af68bc53@ondemand.us-west-1.saucelabs.com:443/wd/hub";

	public static WebDriver returnDriver(String runtype) throws MalformedURLException
	{
	      
	    if(runtype.equals("sauce"))
	    {
		DesiredCapabilities caps = DesiredCapabilities.chrome();
	    caps.setCapability("platform", "Windows 10");
	    caps.setCapability("version", "latest");
	    caps.setCapability("extendedDebugging", "true");
	    caps.setCapability("buildNumber", "3.0");
	    caps.setCapability("screenResolution", "1920x1080");
	    driver = new RemoteWebDriver(new java.net.URL(URL), caps);
	    return driver;
	    }
	    else if(runtype.equals("local")) {
	    	System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
	    	return driver = new ChromeDriver();
	    }
		return driver;
	}

	public static void makeScreenshotFolder(String testScenarioName) throws IOException {
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
