//Test Objective: To Verify whether application allows admin to Add New Feature in the application
//Test Case Name: RETC_027



package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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

public class RETC027Tests {

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
		loginPOM.sendUserName("pallabuk1@gmail.com");  
		loginPOM.sendPassword("password@12345");
		loginPOM.clickLoginBtn(); 
		Thread.sleep(3000);
		propertiesPOM.hoverOnProperties();   				//Click on Properties link
		propertiesPOM.clickOnFeatures();					//Click on Features link
        propertiesPOM.sendFeatureName("New Launches152");	//Enter Valid Credentials in Name textbox
        propertiesPOM.sendSlug("Launche152");				//Enter Valid Credentials in Slug textbox
        propertiesPOM.sendDescription("New Launches of vilas, apartments, flats"); //Enter Valid Credentials in Description textbox
        propertiesPOM.clickSubmitBtn();						//Click on Add New Feature button
        propertiesPOM.sendFeatureSearch("New Launches152");
        propertiesPOM.clickSearchFeatureBtn();
        String expectedResult="New Launches152";
        String actualResult=driver.findElement(By.xpath("//tr[@id='tag-1418']//td[1]//strong//a")).getText();
        Assert.assertEquals(actualResult, expectedResult);
	            
	}
}

