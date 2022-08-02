package FOITest;

import java.io.FileInputStream;
import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import pageObject.CreateNewTenant;
import pageObject.LoginPage;

public class homePage extends base
{

	@Test(dataProvider="getdata")
	
	public void hitURL(String uname,String password) throws IOException, InterruptedException, BiffException
	{
	
		driver=initialize();
		FileInputStream fis=new FileInputStream("C:\\Users\\SonaliPujari\\CommonFiles\\LoginDetails.xls");
		//workbook>>sheets>>cells>>content
		Workbook workbook=Workbook.getWorkbook(fis);
		Sheet sheet=workbook.getSheet(0);
		
		int row=sheet.getRows();
		int col=sheet.getColumns();
	
	
		driver.get(p.getProperty("url"));
		
		LoginPage lp=new LoginPage(driver);
		Thread.sleep(1000);
		lp.getemail().sendKeys(uname);
		Thread.sleep(2000);
		lp.getpassword().sendKeys(password);
		Thread.sleep(1000);
		lp.Login().click();
		
		/*CreateNewTenant t=new CreateNewTenant(driver);
		t.ClickTenant();
		t.CreateNewTenant();
		t.verifyTenancyname().sendKeys(TenancyName);
		t.Name().sendKeys(TenantName);
		t.AthenaId().sendKeys(AthenaId);
		t.AdminEmailAddress().sendKeys(AdminEmail);*/
	}

	@DataProvider
	public Object[][] getdata()
	{
		//oth row
		Object[][] data =new Object[2][2];
		data[0][0]="admin";
		data[0][1]="123qwe";
		//1st row
		data[1][0]="admin12";
		data[1][1]="1q2w3e*";
		
		return data;
	}
}
