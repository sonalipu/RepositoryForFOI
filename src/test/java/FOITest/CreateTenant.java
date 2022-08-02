package FOITest;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import pageObject.CreateNewTenant;

public class CreateTenant extends base
{
	@Test
	public void NewTenant(WebDriver driver) throws BiffException, IOException, InterruptedException
	{
		
		FileInputStream fis=new FileInputStream("C:\\Users\\SonaliPujari\\CommonFiles\\LoginDetails.xls");
		//workbook>>sheets>>cells>>content
		Workbook workbook=Workbook.getWorkbook(fis);
		Sheet sheet=workbook.getSheet(1);
	
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
				
				//System.out.println(j+" "+i+" "+value);
				
				user1=user1+" "+value;
				
				//System.out.println("value is="+user1);
			}
			
			
			//System.out.println(user1.trim());
			String[] TenantArray = user1.split(" ");
			String TenancyName=TenantArray[1];
			String TenantName=TenantArray[2];
			String AthenaId=TenantArray[3];
			String AdminEmail=TenantArray[4];
			
			System.out.println("Tenancy Name="+TenantArray[1]);
			System.out.println(TenantArray[2]);
			System.out.println(TenantArray[3]);
			System.out.println(TenantArray[4]);
			//driver=initialize();
			
			CreateNewTenant t=new CreateNewTenant(driver);
			//Thread.sleep(2000);
			t.ClickTenant();
			
		}
	}

}
