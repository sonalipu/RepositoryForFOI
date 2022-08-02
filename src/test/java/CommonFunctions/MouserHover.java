package CommonFunctions;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import FOITest.base;

public class MouserHover extends base
{
	Actions action;
	
	
	public void performMouseHover(WebElement element)
	{
		action.moveToElement(element).build().perform();
	
	}
	
	public void clickUsingJavaScript(WebElement element,WebDriver driver)
	{
		JavascriptExecutor executor=(JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click()",element);
	}
	
	public void clickEnter(WebDriver driver)
	{
	
		this.driver=driver;
		action.sendKeys(Keys.ENTER).build().perform();
		System.out.println("enter pressed");
	}
}
