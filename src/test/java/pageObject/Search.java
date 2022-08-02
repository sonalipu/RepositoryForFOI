package pageObject;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import CommonFunctions.MouserHover;
import CommonFunctions.ReadExcel;
import FOITest.ValidLogin;
import FOITest.base;
import jxl.Cell;
import jxl.read.biff.BiffException;

public class Search extends base
{
	
	public void ReadDataFromExel(WebDriver driver) throws BiffException, IOException, InterruptedException
	{
		ReadExcel read=new ReadExcel();
		read.ReadExcelFile("C:\\Users\\SayaliJunawane\\Desktop\\LoginDetailofcompany.xls",2);
		
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
			//String searchValue1=user1.trim();
			String[] searchValue = user1.split(" ");
			//String test=searchValue[i];
			//System.out.println("test value"+test);
			System.out.println("patient detail array"+Arrays.toString(searchValue));
			
			Surgeries s1=new Surgeries();
			Thread.sleep(1000);
			WebElement txtbox=s1.Selectsearch(driver);
			txtbox.sendKeys(searchValue);
	
			
		
			Thread.sleep(10000);
			txtbox.clear();
			
		}

	}
	
	public void FilterByStatus(WebDriver driver) throws BiffException, IOException, InterruptedException
	{
		System.out.println("into click");
		Surgeries s1=new Surgeries();
		s1.filterbyStatus(driver).click();
		int a=driver.findElements(By.xpath("//p-multiselect[@optionlabel='name']//following-sibling::div[contains(@class,'overlayAnimation')]")).size();
		
		//list of checkboxes
		List<WebElement>checkbox=driver.findElements(By.xpath("//div[@class='p-checkbox-box']"));
		
		List<WebElement>status=driver.findElements(By.xpath("//span[@class='ng-star-inserted']//ancestor :: p-multiselectitem/li/span"));
		
		/*for( int i=1;i<=a;i++)  
 		{  
			
 			driver.findElements(By.xpath("//input[@name='vehicle']")).get(1).click();  
 		} */
		
		
		/*for(int i=0;i<status.size();i++)
		{
			if(status.get(i).getText().contains("Approved"))
			{
				checkbox.get(i).click();
				   break;
			}
		}*/
		
		
		//read excel
		
		
		ReadExcel read=new ReadExcel();
		read.ReadExcelFile("C:\\Users\\SayaliJunawane\\Desktop\\LoginDetailofcompany.xls",3);
		
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
			String searchValue1=user1.trim();
			String[] searchcriteria= searchValue1.split(",");
			//String test=searchValue[i];
			//System.out.println("test value"+test);
			System.out.println("search Criteria Array="+Arrays.toString(searchcriteria));
			if(user1.contains("Approved"))
					{
						System.out.println("you are in if");
						driver.findElement(By.xpath("//span[text()='Approved']")).click();
					}
			else {
				if(user1.contains("Unapproved"))
				{
					System.out.println("you are in else");
					driver.findElement(By.xpath("//span[text()='Unapproved']")).click();
				}
			}
			
			
			Thread.sleep(5000);
		
		}
	
	}
	

	
	
	//Move to unapproved surgery billa
	
	/*public void clickonUnapprovedSurgeryBille(WebDriver driver) throws BiffException, IOException, InterruptedException
	{
		Surgeries s=new Surgeries();
		s.ClickonUnapprovedTab(driver).click();
		
		//WebElement Search=driver.findElement(By.xpath("//span[@class='p-input-icon-right d-block']//following-sibling::input"));
		ReadDataFromExel(driver);
	}
	
	public void clickonUnbilledPerctRecords(WebDriver driver) throws BiffException, IOException, InterruptedException
	{
		Surgeries s=new Surgeries();
		s.ClickonUnbilledTab(driver).click();
		
		//WebElement Search=driver.findElement(By.xpath("//span[@class='p-input-icon-right d-block']//following-sibling::input"));
		ReadDataFromExel(driver);
	}
	
	public void clickonCancelled(WebDriver driver) throws BiffException, IOException, InterruptedException
	{
		Surgeries s=new Surgeries();
		s.ClickonCancelledTab(driver).click();
		
		//WebElement Search=driver.findElement(By.xpath("//span[@class='p-input-icon-right d-block']//following-sibling::input"));
		ReadDataFromExel(driver);
	}
	
	public void willCall(WebDriver driver) throws BiffException, IOException, InterruptedException
	{
		Surgeries s=new Surgeries();
		s.ClickonWillcall(driver).click();
		
		//WebElement Search=driver.findElement(By.xpath("//span[@class='p-input-icon-right d-block']//following-sibling::input"));
		ReadDataFromExel(driver);
	}
	
	
	*/
	
	
	public void FilterbyDate(WebDriver driver) throws InterruptedException
	{
		String MonthyearValueFrom;
		Surgeries s=new Surgeries();
		s.FilterbyDate(driver).click();
		//if today selected 
		driver.findElement(By.cssSelector(".available.ng-star-inserted.today.active.end-date.start-date")).click();
		System.out.println("today date selected");
		/*MonthyearValueFrom=driver.findElement(By.xpath("//th[@class='month drp-animate']")).getText();
		String MonthyearValueTo=driver.findElement(By.xpath("//th[@class='month']")).getText();
		System.out.println("cal1 value is"+MonthyearValueFrom);
		System.out.println("cal2 is"+MonthyearValueTo); //Aug 2022
		String Month=MonthyearValueFrom.split(" ")[0].trim();
		String Year=MonthyearValueFrom.split(" ")[1].trim();
		
		String Month1=MonthyearValueTo.split(" ")[0].trim();
		String Year1=MonthyearValueTo.split(" ")[1].trim();
		
		
		System.out.println(Month);
		
		System.out.println(Year);
		while(!(Month.equals("Sep") && Year.equals("2022")))
		{
			driver.findElement(By.xpath("//th[@class='next available ng-star-inserted']")).click();
			MonthyearValueFrom=driver.findElement(By.xpath("//th[@class='month drp-animate']")).getText();
			System.out.println("cal1 value is"+MonthyearValueFrom);
			Month=MonthyearValueFrom.split(" ")[0].trim();
			Year=MonthyearValueFrom.split(" ")[1].trim();
		}
		
		
		while(!(Month1.equals("Sep") && Year1.equals("2022")))
		{
			driver.findElement(By.xpath("//th[@class='next available ng-star-inserted']")).click();
			MonthyearValueTo=driver.findElement(By.xpath("//th[@class='month drp-animate']")).getText();
			System.out.println("cal2 value is"+MonthyearValueTo);
			Month1=MonthyearValueTo.split(" ")[0].trim();
			Year1=MonthyearValueTo.split(" ")[1].trim();
		}
		*/
		
	//to select date
		
		//driver.findElements(null)
		////tbody[@class='drp-animate']/tr/td/span
		////tbody[@class='drp-animate']//child :: tr// child :: td
		/*List<WebElement>date=driver.findElements(By.xpath("//tbody[@class='drp-animate']//child :: tr// child :: td"));
		for( int i=0;i<date.size();i++)
		{
			System.out.println(date.get(i).getText());
			
			if(date.get(i).getText().equalsIgnoreCase("14"))
			{
				 date.get(i).click();
				break;	
			}
			
		}
		System.out.println("outside for click on apply");
		driver.findElement(By.xpath("//button[text()='Apply']")).click();
	}
	*/
	
	
	
	}		
}	