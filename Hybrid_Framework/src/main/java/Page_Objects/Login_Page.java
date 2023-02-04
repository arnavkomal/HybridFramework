package Page_Objects;




import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class Login_Page extends BaseClass
{
	
//Class Constructor
public 	Login_Page()
{
PageFactory.initElements(driver, this );
}


//Object Repository
@FindBy(xpath="//input[@id='txtUserName']")
WebElement UserName;
public void userName() 
{
String userValue= prop.getProperty("User");
UserName.sendKeys(userValue);
}


//Object Repository
@FindBy(xpath="//input[@id='txtPassword']")
WebElement Password;
public void passWord()
{
String userPass= prop.getProperty("Pass");
Password.sendKeys(userPass);	
}

//Object Repository
@FindBy(xpath="//input[@id='btnLogin']")
WebElement LoginBtn;
public void loginBtn()
{
LoginBtn.click();
}

}
