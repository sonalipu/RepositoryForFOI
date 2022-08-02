package pageObject;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SwitchTenant 
{
	public WebDriver driver;
	public SwitchTenant(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void ChangeTenant(String tenantName) throws Exception
	{
		System.out.println("you are in chng tenant mtd");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//span[@class='ng-star-inserted']/following-sibling::a")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@name='SwitchToTenant']")).click();   //click toggle button
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@name='tenancyNameInput']")).sendKeys(tenantName);
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[@class='btn btn-primary btn-sm save-button']")).click();//switch to tenant
	}

}
