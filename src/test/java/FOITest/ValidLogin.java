package FOITest;

import java.io.FileInputStream;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import pageObject.ClickRole;
import pageObject.LoginPage;
import pageObject.ValidateCPTCode;
import pageObject.ValidateUsers;
import CommonFunctions.LoginWithValidCred;

public class ValidLogin extends base {
	@Test
/*	public void TestRoles() throws BiffException, IOException, InterruptedException
	{
		//this.driver=driver;
		LoginWithValidCred lg = new LoginWithValidCred();
		lg.testLogin();
		ClickRole rl = new ClickRole();
		rl.ClickAdministration(driver);
		rl.ClickRoles(driver);
		rl.DeleteRoles(driver, "testroleauto");
	}*/
	public void testLogin(WebDriver driver,int caseNumber) throws IOException, BiffException, InterruptedException
	{
		
		
		//driver=initialize();
		FileInputStream fis=new FileInputStream("C:\\Users\\SonaliPujari\\CommonFiles\\LoginDetails1.xls");
		//workbook>>sheets>>cells>>content
		Workbook workbook=Workbook.getWorkbook(fis);
		Sheet sheet=workbook.getSheet(0);
	
		int row=sheet.getRows();
		int col=sheet.getColumns();
	
		String user1 = "";
		String value = null;
		for(int i=1;i<row;i++)  //row
		{
			user1 = "";
			for(int j=0;j<col;j++) //col
			{
				
				Cell c=sheet.getCell(j,i);	
				value=c.getContents();
				user1=user1+" "+value;
				
			}
		
			System.out.println(user1.trim());
			String[] NameArray = user1.split(" ");
			String uname=NameArray[1];
			String password=NameArray[2];
			System.out.println(NameArray[1]);
			System.out.println(NameArray[2]);
			if (driver == null)
			{
			driver=initialize();
			
			driver.get(p.getProperty("url"));
			driver.manage().window().maximize();
			
			}
			LoginPage lp=new LoginPage(driver); 
			Thread.sleep(3000);
			lp.getemail().sendKeys(uname);
			Thread.sleep(3000);
			lp.getpassword().sendKeys(password);
			Thread.sleep(3000);
			lp.Login().click();
			
			Thread.sleep(3000);
			try
			{
				//If credentials are invalid then find the invalid credential message and click ok
				driver.findElement(By.xpath("//*[@id=\"kt_body\"]/div/div/div[6]/button[1]")).click();
				driver.close();
			}
			catch(Exception e)
			  {
				//If credentials are valid then follow the valid credential flow
				switch(caseNumber) {
				case 1: 
					ClickRole rl = new ClickRole();
					rl.ClickAdministration(driver);
					rl.ClickRoles(driver);
					//rl.AddNewRoles(driver,"C:\\Users\\SonaliPujari\\CommonFiles\\InputValues.xls");
					rl.DeleteRoles(driver, "UserRoleA");
					break;
				case 2: 
					ValidateCPTCode vcc = new ValidateCPTCode();
					vcc.ClickAdministration(driver);
					vcc.ClickCPTCode(driver);
					//vcc.SearchCPTCode(driver, "C:\\Users\\SonaliPujari\\CommonFiles\\InputValues.xls",0);
					//Thread.sleep(10000);
					vcc.AddCPTCode(driver, "C:\\Users\\SonaliPujari\\CommonFiles\\InputValues.xls");
					break;
					
				case 3:
					ValidateUsers vu = new ValidateUsers();
					vu.ClickAdministration(driver);
					vu.ClickUsers(driver);
					//vu.SearchUsers(driver, "C:\\Users\\SonaliPujari\\CommonFiles\\InputValues.xls");
					//vu.AddUser(driver, "C:\\Users\\SonaliPujari\\CommonFiles\\InputValues.xls");
					//vu.DeleteUsers(driver, "C:\\Users\\SonaliPujari\\CommonFiles\\InputValues.xls");
					vu.SearchUsers(driver, "C:\\Users\\SonaliPujari\\CommonFiles\\InputValues.xls");
					break;
					
				case 4: 
					break;

				default:
				}

				/*ClickRole rl = new ClickRole();
				rl.ClickAdministration(driver);
				rl.ClickRoles(driver);
				rl.AddNewRoles(driver,"netestrole");
				Thread.sleep(3000);
				//rl.EditRole(driver, "rolefortest");
				rl.DeleteRoles(driver, "netestrole");*/
				
			  }
	
		}
			
	

	}
}
