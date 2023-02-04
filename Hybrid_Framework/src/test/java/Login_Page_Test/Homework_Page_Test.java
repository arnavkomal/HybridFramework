package Login_Page_Test;



import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Page_Objects.BaseClass;
import Page_Objects.HomeWork_Page;
import Page_Objects.ListenerClass;



@Listeners(ListenerClass.class)
public class Homework_Page_Test extends BaseClass
{
HomeWork_Page hp;
public static ExtentReports report;
public static ExtentTest test;


public 	Homework_Page_Test()
{
super();
}

@BeforeTest
public void startReport()
{
report = new ExtentReports("C:\\Users\\admin\\eclipse-workspace\\New_Hybrid_Framework\\Reports\\Home Work Page.html", true);
report.addSystemInfo("User Name", "Vikas Khandekar");	
}


@BeforeMethod
public void Setup()
{
hp = new HomeWork_Page();
}

@Test(priority=3)
public void HomeWork_Page_Test() throws Exception
{
test =report.startTest("Home Work Page Test");
hp.menu();
hp.homework();
}

public static String ScreenShot(WebDriver driver, String screenShotName) throws Exception
{
TakesScreenshot ts = (TakesScreenshot) driver;
File Source = ts.getScreenshotAs(OutputType.FILE);
File Destination = new File("D:\\ScreenShot\\" +System.currentTimeMillis() +screenShotName +".jpg");
String ScreenShotPath = Destination.getAbsolutePath();
FileUtils.copyFile(Source, Destination);
return ScreenShotPath;
}

@AfterMethod
public void Report_Attach_ScreenShot(ITestResult result) throws Exception
{
if(result.getStatus()==ITestResult.SUCCESS)
{
test.log(LogStatus.PASS, "Test Case is Passed:     " +result.getName());	
String screenShotPath= Homework_Page_Test.ScreenShot(driver, result.getName());
test.log(LogStatus.PASS, test.addScreenCapture(screenShotPath));	
}
else if(result.getStatus()==ITestResult.FAILURE)
{
test.log(LogStatus.FAIL, "Test Case is Failed:    " +result.getName());	
String screenShotPath= Homework_Page_Test.ScreenShot(driver, result.getName());
test.log(LogStatus.FAIL, test.addScreenCapture(screenShotPath));
}
else if(result.getStatus()==ITestResult.SKIP)
{
test.log(LogStatus.SKIP, "Test Case is Failed:   " +result.getName());	
String screenShotPath= Homework_Page_Test.ScreenShot(driver, result.getName());
test.log(LogStatus.SKIP, test.addScreenCapture(screenShotPath));
}
}

@AfterTest
public void endReport()
{
report.flush();
report.endTest(test);
}
}



