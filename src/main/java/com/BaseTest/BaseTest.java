package com.BaseTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.Uitility.log;



public class BaseTest 
{
	public WebDriver driver;
	String applicationUrlAddress="http://127.0.0.1/orangehrm-4.2.0.1/symfony/web/index.php/auth/login";
	
	@BeforeTest
	public void applicationLaunch()
	{
		System.setProperty("webdriver.chrome.driver","./BrowserFiles/chromedriver.exe");
		driver =new ChromeDriver();
		log.info("*****Chrome Browser Launch Successfully***********");

		driver.get(applicationUrlAddress);
		log.info("Navigated to OrangeHRM Application WebPage");

		//driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
	
    @AfterTest
	public void applicationClose()
	{
		driver.close();
		
		log.info(" **** Chrome Browser along with the Application Closed Successfully ****");

	}

}
