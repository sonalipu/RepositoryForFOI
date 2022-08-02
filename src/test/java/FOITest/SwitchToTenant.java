package FOITest;

import java.io.IOException;

import org.testng.annotations.Test;

import pageObject.SwitchTenant;
import FOITest.ValidLogin;

public class SwitchToTenant extends base

{
	@Test
	public void switchtotenant() throws Exception
	{
		driver=initialize();
		driver.get(p.getProperty("url2"));
		driver.manage().window().maximize();
		//Thread.sleep(5000);
		SwitchTenant t=new SwitchTenant(driver);
		t.ChangeTenant("Default");
		
		//ClientLogin c=new ClientLogin();
		//c.RegisterdedClientLogin(driver);
		ValidLogin vc = new ValidLogin();
		vc.testLogin(driver,2);
	}
	
	
	


}
