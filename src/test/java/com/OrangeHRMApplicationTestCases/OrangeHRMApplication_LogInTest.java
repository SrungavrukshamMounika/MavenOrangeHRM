package com.OrangeHRMApplicationTestCases;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.BaseTest.BaseTest;
import com.Uitility.log;


public class OrangeHRMApplication_LogInTest extends BaseTest


{
	FileInputStream testData;
	XSSFWorkbook workBook;
	XSSFSheet testDataSheet;
	
	@Test(priority=1,description = "OrangeHRMAapplication Data")
	
	public void OHRMApplicationData() throws IOException
	{
		testData=new FileInputStream("./src/main/java/com/OrangeHRMApplicationTestDataFiles/OHRMMultipleValidatingFunctionality.xlsx");
		workBook=new XSSFWorkbook(testData);
		testDataSheet=workBook.getSheet("LoginTestData");
		
		Row row =testDataSheet.createRow(1);
		
		
		
		Cell username=row.createCell(7);
		username.setCellValue("mounika");
		
		Cell password=row.createCell(8);
		password.setCellValue("Mounika@123");
		
		Row OHRMDataSecondRow =testDataSheet.createRow(2);
		
	    username=OHRMDataSecondRow.createCell(7);
		username.setCellValue("Mounika");
		
		password=OHRMDataSecondRow.createCell(8);
		password.setCellValue(" mouni@0000");
		
        Row OHRMDataThirdRow =testDataSheet.createRow(3);
		
		username=OHRMDataThirdRow.createCell(7);
		username.setCellValue("admin");
		
		password=OHRMDataThirdRow.createCell(8);
		password.setCellValue(" mahi222");
		
		Row OHRMDataforthRow =testDataSheet.createRow(4);
			
		username=OHRMDataforthRow.createCell(7);
			username.setCellValue("mounika");
			
			password=OHRMDataforthRow.createCell(8);
			password.setCellValue("Mounika@123");
			
       Row OHRMDatafifthRow =testDataSheet.createRow(5);
			
			username=OHRMDatafifthRow.createCell(7);
			username.setCellValue("super");
			
			password=OHRMDatafifthRow.createCell(8);
			password.setCellValue(" mahesh Babu");
			
	        
	}
	
	@Test(priority = 2,description = "OHRM Application Data")
	public void OHRMApplicaationData() throws IOException
	{
		
		
		int numberOfRows=testDataSheet.getLastRowNum();
		for(int rowindex=1;rowindex<=numberOfRows;rowindex++)
		{
			Row rows=testDataSheet.getRow(rowindex);
			
			Cell loginPageText=rows.createCell(0);
			loginPageText.setCellValue("LOGIN Panel");
			
			Cell invalidtext=rows.createCell(1);
			invalidtext.setCellValue("Invalid Credentials");
			
			Cell homePageTitle=rows.createCell(4);
			homePageTitle.setCellValue("orangeHRM");
			Cell adminText=rows.createCell(9);
			adminText.setCellValue("Admin");
		}
	}
    FileInputStream propertiesFile;
	
	Properties properties;
	
	
	@Test(priority = 3,description = "Validating the OHRM Data")
    public void validatingOHRMData() throws IOException
	{
		propertiesFile= new FileInputStream("./src/main/java/com/Config/OrangeHRMApplication.properties");

		properties = new Properties();

		properties.load(propertiesFile);
	    	  
	   int rowCount=testDataSheet.getLastRowNum();
	   for(int rowindex=1;rowindex<=rowCount;rowindex++)
	   {
		  Row row=testDataSheet.getRow(rowindex);
		    	   
			String Expected_OrangeHRMTitle=row.getCell(4).getStringCellValue();
			//System.out.println(Expected_OrangeHRMTitle);
			log.info(Expected_OrangeHRMTitle);
			String Actual_OrangeHRMTitle=driver.getTitle();
			//System.out.println(Actual_OrangeHRMTitle);
			log.info(Actual_OrangeHRMTitle);
			Cell orangeHRMtitle=row.createCell(5);
			orangeHRMtitle.setCellValue(Actual_OrangeHRMTitle);
			
			if(Actual_OrangeHRMTitle.equals(Expected_OrangeHRMTitle))
			{
				log.info("pass");
				//System.out.println("pass");
				Cell OHRMTitle=row.createCell(6);
				OHRMTitle.setCellValue("pass");
			}
			else
			{
				log.info("fail");
				//System.out.println("Fail");
				Cell OHRMTitle=row.createCell(6);
				OHRMTitle.setCellValue("Fail");
				
			}
			
			
			
			
	
	   String usernameTestdata=row.getCell(7).getStringCellValue();
			By usernameProperty=By.id(properties.getProperty("orangeHRMApplicationLogInPageUserNameProperty"));
			WebElement username=driver.findElement(usernameProperty);
			username.sendKeys(usernameTestdata);
			//System.out.println(usernameTestdata);
			log.info(usernameTestdata);
		String passwordTestData=row.getCell(8).getStringCellValue();
			By passwordProperty=By.id(properties.getProperty("orangeHRMApplicationLogInPagePasswordProperty"));
			WebElement password=driver.findElement(passwordProperty);
			password.sendKeys(passwordTestData);
			//System.out.println(passwordTestData);
			log.info(passwordTestData);
			By loginProperty=By.className(properties.getProperty("orangeHRMApplicationLogInPageLogInButtonProperty"));
		    WebElement Login=driver.findElement(loginProperty);
		    Login.click();
		    
		    
			
        try
        {
        	
        	   
            By adminProperty=By.id(properties.getProperty("orangeHRMApplicationHomePageAdminProperty"));
   		    WebElement admin=driver.findElement(adminProperty);
   		    String admintext=admin.getText();
   		    
   		    Cell rowOfCell=row.createCell(10);
   	    	rowOfCell.setCellValue(admintext);
   		    	 	
   		    String expected_HomePageText=row.getCell(9).getStringCellValue();
   		    //System.out.println(expected_HomePageText);
   		    log.info(expected_HomePageText);	
   		    String actual_HomePageText=row.getCell(10).getStringCellValue();
   		    System.out.println(actual_HomePageText);
   		    	if(actual_HomePageText.equals(expected_HomePageText))
   		    	{
   		    		log.info("pass");
   		    		//System.out.println("Pass");
   		    		Cell RowOfCell3=row.createCell(11);
   		    		RowOfCell3.setCellValue("Pass");
   		    	}
   		    	else
   		    	{
   		    		
   		    		log.info(actual_HomePageText);
   		    		//System.out.println("Fail");
   		    		Cell RowOfCell3=row.createCell(11);
   		    		RowOfCell3.setCellValue("Fail");
   		    	}
        
   		    	
           Cell validData=row.createCell(2);
           validData.setCellValue("Valid Credentials");
           
           String Expected_ValidData=row.getCell(1).getStringCellValue();
           //System.out.println(Expected_ValidData);
           log.info(Expected_ValidData);
           String Actual_ValidData=row.getCell(2).getStringCellValue();
           //System.out.println(Actual_ValidData);
           log.info(Actual_ValidData);
           if(Actual_ValidData.equals(Expected_ValidData))
           {
        	   log.info("pass");
        	   //System.out.println("pass");
        	   Cell validText=row.createCell(3);
        	   validText.setCellValue("pass");
        	   
           }
           else
           {
        	   log.info("fail");
        	  // System.out.println("pass");
        	   Cell validText=row.createCell(3);
        	   validText.setCellValue("pass");
        	   
           }
           
           By welcomeAdminProperty=By.id("welcome");
			WebElement welcomeAdmin=driver.findElement(welcomeAdminProperty);
			welcomeAdmin.click();
			
			

			By logoutProperty=By.linkText("Logout");
			WebElement logout=driver.findElement(logoutProperty);
			
			logout.click();
        
           
	    	
	       
        }
        catch(Exception e)
        {
        	//File screenShot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        	//FileUtils.copyFile(screenShot, new File("./TSRTC_ScreenShots/"+tsrtc_HeaderBlockLinkName+".png"));
        	
        	File screenShot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        	FileUtils.copyFile(screenShot,new File("./CapturingTheOHRMScreenShorts/orangeHRMApplication"+" "+" userName "+usernameTestdata+" Password "+passwordTestData+".png"));
        	
        	By loginPanelProperty=By.id(properties.getProperty("orangeHRMApplicationLogInPageLOGINPanelProperty"));
        	WebElement loginPanel=driver.findElement(loginPanelProperty);
        	
        	String loginPanelText=loginPanel.getText();
        	Cell loginPanelTextCell9=row.createCell(10);
        	loginPanelTextCell9.setCellValue(loginPanelText);
        	
        	String Expected_LoginPanelText=row.getCell(9).getStringCellValue();
        	//System.out.println(Expected_LoginPanelText);
        	log.info(passwordTestData);
        	String Actual_LoginPanelText=row.getCell(10).getStringCellValue();
        	//System.out.println(Actual_LoginPanelText);
        	log.info(Actual_LoginPanelText);
        	if(Actual_LoginPanelText.equals(Expected_LoginPanelText))
        	{
        		log.info("pass");
        		//System.out.println("pass");
        		Cell loginPanelTextCell10=row.createCell(11);
        		loginPanelTextCell10.setCellValue("pass");
        		
        	}
        	else
        	{
        		//System.out.println("fail");
        		log.info("fail");
        		Cell loginPanelTextCell10=row.createCell(11);
        		loginPanelTextCell10.setCellValue("fail");
        	}
        	
        	
        	
        	By invalidProperty=By.id(properties.getProperty("orangeHRMApplicationLogInPageinvalidCredentialsProperty"));
        	WebElement invalid=driver.findElement(invalidProperty);
        	String invalidText=invalid.getText();
        	Cell invalidtext=row.createCell(2);
        	invalidtext.setCellValue(invalidText);
        	
        	String Expected_invalidText=row.getCell(1).getStringCellValue();
        	//System.out.println(Expected_invalidText);
        	log.info(passwordTestData);
        	
        	String Actual_invalidText=row.getCell(2).getStringCellValue();
        	//System.out.println(Actual_invalidText);
        	log.info(Actual_invalidText);
        	
        	if(Actual_invalidText.equalsIgnoreCase(Expected_invalidText))
        	{
        		log.info("pass");
        		//System.out.println("pass");
        		Cell invalidTextResult=row.createCell(3);
        		invalidTextResult.setCellValue("pass");
        	}
        	else
        	{
        		log.info("fail");
        		//System.out.println("fail");
        		Cell invalidTextResult=row.createCell(3);
        		invalidTextResult.setCellValue("fail");
        	}
        
        }
	 }
		    
		    
			
	       
	FileOutputStream testDataResult=new FileOutputStream("./src/main/java/com/OrangeHRMApplicationTestResultFiles/OHRMMultipleValidatingFunctionality.xlsx");
    workBook.write(testDataResult); 
	
	   
		    	
	
		
}

}
