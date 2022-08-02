package pageObject;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterTenantLogin 
{
	public WebDriver driver;

	public RegisterTenantLogin(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void loginTenant() throws Exception {
		// TODO Auto-generated method stub
		Thread.sleep(10000);
		driver.findElement(By.id("userNameEmailAddress")).sendKeys("test@yopmail.com");
		Thread.sleep(1000);
		driver.findElement(By.id("password")).sendKeys("test@12");
		Thread.sleep(1000);
		driver.findElement(By.id("loginBtn")).click();
		driver.close();
	}
}
