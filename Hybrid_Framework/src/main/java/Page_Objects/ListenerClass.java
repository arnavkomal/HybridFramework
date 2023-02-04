package Page_Objects;

import org.testng.ITestListener;
import org.testng.ITestResult;


public class ListenerClass extends BaseClass implements ITestListener
{
	
@Override
public void onTestSuccess(ITestResult result)
{
PassTestCase(result.getMethod().getMethodName());
System.out.println("Test Case Pass");
}
	
@Override
public void onTestFailure(ITestResult result)
{
FailTestCase(result.getMethod().getMethodName());
System.out.println("Test Case Fail");
}

@Override
public void onTestSkipped(ITestResult result)
{
FailTestCase(result.getMethod().getMethodName());
System.out.println("Test Case Skipped");
}

}
