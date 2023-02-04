package Login_Page_Test;


import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
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
import Page_Objects.Login_Page;
import Page_Objects.ListenerClass;


@Listeners(ListenerClass.class)
public class Login_Page_Test extends BaseClass
{
Login_Page	loginPage;
public static ExtentReports report;
public static ExtentTest test;


public 	Login_Page_Test()
{
super();
}

@BeforeTest
public void startReport()
{
report = new ExtentReports("C:\\Users\\admin\\eclipse-workspace\\BDD_Cucumber_Framework\\Report\\Title and Login Page.html", true);
report.addSystemInfo("User Name", "Vikas Khandekar");	
}


@BeforeMethod
public void Setup()
{
Initialization();
loginPage = new Login_Page();
}


@Test(priority=1)
public void Title_Test()
{
test =report.startTest("Title Test");
String getTitle = driver.getTitle();
System.out.println(getTitle);
String expectedTitle = "Welcome to Pawar Public School";
Assert.assertEquals(getTitle, expectedTitle);
}

@Test(priority=2)
public void Login_Test() throws Exception
{
test =report.startTest("Login Test");
loginPage.userName();
loginPage.passWord();
loginPage.loginBtn();
Thread.sleep(3000);
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
String screenShotPath= Login_Page_Test.ScreenShot(driver, result.getName());
test.log(LogStatus.PASS, test.addScreenCapture(screenShotPath));	
}
else if(result.getStatus()==ITestResult.FAILURE)
{
test.log(LogStatus.FAIL, "Test Case is Failed:    " +result.getName());	
String screenShotPath= Login_Page_Test.ScreenShot(driver, result.getName());
test.log(LogStatus.FAIL, test.addScreenCapture(screenShotPath));
}
else if(result.getStatus()==ITestResult.SKIP)
{
test.log(LogStatus.SKIP, "Test Case is Failed:   " +result.getName());	
String screenShotPath= Login_Page_Test.ScreenShot(driver, result.getName());
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
