package FOITest;

import org.testng.annotations.Test;

import pageObject.SwitchTenant;


public class HandleRoles extends base {

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
		vc.testLogin(driver,1);
	}
	
}
