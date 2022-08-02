package FOITest;

import org.openqa.selenium.WebDriver;

import pageObject.RegisterTenantLogin;

public class ClientLogin extends base

{
	public void RegisterdedClientLogin(WebDriver driver) throws Exception
	{
		System.out.println("you are in client login");
		RegisterTenantLogin t=new RegisterTenantLogin(driver);
		t.loginTenant();
	}

}