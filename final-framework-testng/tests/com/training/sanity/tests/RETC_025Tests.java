//Test Objective: The objective of this test is to verify whether application allows admin to filter properties details based on the search criteria
//Test Case Name: RETC_025
//Test Result: Passed

package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.LoginPOM;
import com.training.pom.PropertiesPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RETC_025Tests {
	public WebDriver driver;
	public String baseUrl;
	public LoginPOM loginPOM;
	public PropertiesPOM propertiesPOM;
	public static Properties properties;
	public ScreenShot screenShot;

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}
	
	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new LoginPOM(driver); 
	    propertiesPOM = new PropertiesPOM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}
	
	@AfterClass
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	@Test
	public void validLoginTest() throws InterruptedException {
		loginPOM.sendUserName("pallabuk1@gmail.com");       //Enter valid credentials in UserName textbox
		loginPOM.sendPassword("password@12345");    		//Enter valid credentials in password textbox
		loginPOM.clickLoginBtn();    						//Click on Sign in Button
		Thread.sleep(3000);
		propertiesPOM.hoverOnProperties();    				//Click on Properties link
		propertiesPOM.clickOnAllProperties();   			//Click on All Properties link
		Thread.sleep(3000);
		propertiesPOM.selectFromAllDatea();    				//Click and select valid credentials in All Dates list box  
		Thread.sleep(3000);
		propertiesPOM.clickFilterBtn();    					//Click on Filter button
		Thread.sleep(3000);
		String expectedResult="Published";    				//To validate the actual result with the expected.
        String actualResult=driver.findElement(By.xpath("//table[@class='wp-list-table widefat fixed striped posts']/tbody/tr[1]/td[4]")).getText();
        Boolean actualtext = actualResult.contains(expectedResult);
        Assert.assertTrue(actualtext);
        screenShot.captureScreenShot("RETC025");			//To capture the screenshot.
            
	}
}

