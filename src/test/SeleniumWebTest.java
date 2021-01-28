package test;

import java.io.File;
import java.io.InputStream;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.reporters.EmailableReporter;

/*import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;*/


public class SeleniumWebTest{
	
	/*ExtentReports report;
	ExtentTest logger;*/
	
	
	public static InputStream getJsonFileAsStream(String jsonFile)
	{
	    return ClassLoader.getSystemResourceAsStream("/jsonFiles/" + jsonFile);
	} 
	
    WebDriver driver;
    
    
	@BeforeMethod
	@Parameters({"browser"})
	  public void setUp(@Optional("chrome") String browser) throws MalformedURLException
	  {
		
	   if (browser.equalsIgnoreCase("firefox")) 
	   {
	    System.out.println("Running Firefox");
	    System.setProperty("webdriver.gecko.driver",".\\geckodriver.exe");
        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		capabilities.setCapability("marionette", true);
		 driver = new FirefoxDriver(capabilities);
	    // driver = new FirefoxDriver();
	    } 
	   
	   else if (browser.equalsIgnoreCase("chrome")) 
	   {
	    System.out.println("Running Chrome");
	    System.setProperty("webdriver.chrome.driver",".\\chromedriver.exe");    
	    driver = new ChromeDriver();
	    } 
	   else if (browser.equalsIgnoreCase("ie")) 
	   {
	    System.out.println("Running IE");
	    System.setProperty("webdriver.ie.driver",".\\IEDriverServer.exe");    
	    driver = new InternetExplorerDriver();
	    }
	   else if (browser.equalsIgnoreCase("edge")) 
	   {
		   System.out.println("Running Edge");
	   System.setProperty("webdriver.edge.driver", ".\\MicrosoftWebDriver.exe");
	    driver = new EdgeDriver();
	  //  driver.get("xpath.html");
	   }
	  /* driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	   driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);*/
	   driver.manage().window().maximize();
	  }


    
}
