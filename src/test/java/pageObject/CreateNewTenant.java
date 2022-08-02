package pageObject;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CreateNewTenant 
{
	public WebDriver driver;
	public CreateNewTenant(WebDriver driver)
	{
		this.driver=driver;
	}
	//By Tenantbtn=By.linkText("Tenants");
	
	/*By CraetenewTenantbtn=By.xpath("//button[@class='btn btn-primary btn-sm ng-tns-c257-14 ng-star-inserted']");
	
	By TenancyName=By.id("TenancyName");

	By Name=By.id("Name");

	By AthenaId=By.id("AthenaId");
	By AdminEmailAddress=By.id("AdminEmailAddress");*/
	
	public void ClickTenant()
	{
		//driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		System.out.println("you are in click tenant");

		 driver.findElement(By.linkText("Tenants"));
		//return driver.findElement(Tenantbtn);	
	}
	
	/*public WebElement CreateNewTenant()
	{
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		return driver.findElement(CraetenewTenantbtn);
	}
	public WebElement verifyTenancyname()
	{
		return driver.findElement(TenancyName);
	}
	public WebElement Name()
	{
		return driver.findElement(Name);
	}
	public WebElement AthenaId()
	{
		return driver.findElement(AthenaId);
	}
	public WebElement AdminEmailAddress()
	{
		return driver.findElement(AdminEmailAddress);
	}*/
	
	
}
