package FOITest;

import org.testng.annotations.Test;

import pageObject.SwitchTenant;

public class HandleCPTCode extends base

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
		//Temp chage for test  sdfsdf
		//ClientLogin c=new ClientLogin();
		//c.RegisterdedClientLogin(driver);
		ValidLogin vc = new ValidLogin();
		vc.testLogin(driver,2);
	}
	
}