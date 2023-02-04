package Page_Objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomeWork_Page extends Login_Page
{
	
public 	HomeWork_Page()
{
PageFactory.initElements(driver, this );	
}
	
//Object Repository
@FindBy(xpath="//i[@data-animattion='bounce']")
WebElement Menu;
public void menu() 
{
Menu.click();
}


//Object Repository
@FindBy(xpath="//a[@id='ctl00_MainBody_HyperLink82']")
WebElement Homework;
public void homework()
{
Homework.click();
}

}
