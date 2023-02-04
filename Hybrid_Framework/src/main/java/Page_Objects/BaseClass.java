package Page_Objects;
import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;



public class BaseClass
{
public static WebDriver driver;
public static Properties prop;


public BaseClass() 
{
prop	= new Properties();
String path= "C:\\Users\\admin\\eclipse-workspace\\New_Hybrid_Framework\\Configuration\\Config.properties";
try 
{
FileInputStream fis = new FileInputStream(path);
prop.load(fis);
}
catch (Exception e) 
{
e.printStackTrace();
}

}

public static void Initialization()
{
String browser	 = prop.getProperty("Browser");
String url				 = prop.getProperty("Url");

if(browser.equalsIgnoreCase("chrome"))
{
System.setProperty("webdriver.chrome.driver", "WebDriver\\chromedriver.exe");
driver= new ChromeDriver();
driver.get(url);
driver.manage().window().maximize();
}

else
if(browser.equals("edge"))
{
System.setProperty("webdriver.edge.driver", "WebDriver\\msedgedriver.exe");
driver= new EdgeDriver();
driver.get(url);
driver.manage().window().maximize();
}

else
if(browser.equalsIgnoreCase("firefox"))
{
System.setProperty("webdriver.gecko.driver", "WebDriver\\geckodriver.exe");
driver= new FirefoxDriver();
driver.get(url);
driver.manage().window().maximize();
}
}


public void PassTestCase(String getMethodName)
{
try 
{
TakesScreenshot ts = (TakesScreenshot) driver;
File Source = ts.getScreenshotAs(OutputType.FILE);
File Destination = new File("D:\\ScreenShot\\"+"Passed_"  +getMethodName+   ".jpg");
FileUtils.copyFile(Source, Destination);
} 
catch (Exception e) 
{
e.printStackTrace();
}
}


public void FailTestCase(String getMethodName)
{
try 
{
TakesScreenshot ts = (TakesScreenshot) driver;
File Source = ts.getScreenshotAs(OutputType.FILE);
File Destination = new File("D:\\ScreenShot\\"+"Failed_"  +getMethodName+   ".jpg");
FileUtils.copyFile(Source, Destination);
} 
catch (Exception e) 
{
e.printStackTrace();
}
}


public void SkipTestCase(String getMethodName)
{
try 
{
TakesScreenshot ts = (TakesScreenshot) driver;
File Source = ts.getScreenshotAs(OutputType.FILE);
File Destination = new File("D:\\ScreenShot\\"+"Skipped_"  +getMethodName   +".jpg");
FileUtils.copyFile(Source, Destination);
} 
catch (Exception e) 
{
e.printStackTrace();
}
}

}




	


