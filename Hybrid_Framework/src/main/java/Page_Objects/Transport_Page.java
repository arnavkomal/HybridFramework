package Page_Objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Transport_Page extends HomeWork_Page
{
	
public Transport_Page()
{
PageFactory.initElements(driver, this);	
}

//Object Repository
@FindBy(linkText = "Transport")
WebElement TransportTab;
public void transport_tab() 
{
Actions action = new Actions(driver);
action.moveToElement(TransportTab).build().perform();
}


//Object Repository
@FindBy(xpath="//a[normalize-space()='TRANSPORT']")
WebElement TransportBtn;
public void transport_btn() 
{
TransportBtn.click();
}

}
