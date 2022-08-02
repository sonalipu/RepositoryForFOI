package pageObject;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import CommonFunctions.MouserHover;
import CommonFunctions.ReadExcel;
import CommonFunctions.WebLink;
import FOITest.base;
import jxl.Cell;
import jxl.read.biff.BiffException;

public class VerifyPatients extends base
{
	WebDriver driver;
	public void ClickonSurgeriesLink(WebDriver driver)
	{
		this.driver=driver;
		
		PatientObjects p=new PatientObjects();
		WebElement link=p.clickonPatients(driver);
	
		WebLink w=new WebLink();
		w.clickLink(link);
		
		
		
	}
	
	public void search(WebDriver driver) throws BiffException, IOException, InterruptedException
	{
	
		ReadExcel read=new ReadExcel();
		read.ReadExcelFile("C:\\Users\\SayaliJunawane\\Desktop\\LoginDetailofcompany.xls",4);
		
		String user1 = "";
		String value = null;
		
		System.out.println("rows are"+read.excel_row);
		System.out.println("col are"+read.excel_col);
		System.out.println("before for loop");
		for(int i=1;i< read.excel_row;i++)  //row
		{
			
			user1 = "";
			for(int j=0;j<read.excel_col;j++) //col
			{
				//System.out.println("j value"+j);
				Cell c=read.excel_Sheet.getCell(j,i);	
				value=c.getContents();
				//user1=user1+" "+value;
			}
			user1=user1+" "+value;
			System.out.println("user1 value="+user1);
		
			String[] searchValue = user1.split(" ");
			
			System.out.println("patient detail array"+Arrays.toString(searchValue));
			
			Actions a=new Actions(driver);
			
			PatientObjects p=new PatientObjects();
			WebElement txtbox=p.clickonSearch(driver); //click on searchbox
			txtbox.sendKeys(searchValue);
			txtbox.sendKeys(Keys.RETURN);
		List<WebElement> allItems=driver.findElements(By.xpath("//tbody[@class='p-element p-datatable-tbody']//child ::tr"));
	
		for(int i1=0;i1<allItems.size();i1++)
		{
			Thread.sleep(5000);
			System.out.println("items are"+allItems.get(i1).getText());
			if(allItems.get(i1).getText().contains(user1)) 
            {
				System.out.println("items in if condition"+allItems.get(i1).getText());
				a.moveToElement(allItems.get(i1)).perform();
				allItems.get(i1).click();
				//allItems.get(i);
     
            }
	
		}
			Thread.sleep(1000);
			txtbox.clear();
			
		}
	
	}
	
	
	
	//tbody[@class='p-element p-datatable-tbody']//child ::tr
}
