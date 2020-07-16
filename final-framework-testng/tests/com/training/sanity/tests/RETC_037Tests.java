//Test Objective: To verify whether application allows to search details & fill enquiry details in Plots tab
//Test Case Name: RETC_037
//Test Result: Failed


package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.LoginPOM;
import com.training.pom.PlotsPOM;
import com.training.pom.PostsPOM;
import com.training.pom.PropertiesPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RETC_037Tests {

	public WebDriver driver;
	public String baseUrl;
	public PlotsPOM plotsPOM;
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
		plotsPOM = new PlotsPOM(driver) ;
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
		plotsPOM.clickOnPlots();    		//Click on Plots tab
		plotsPOM.sendKeySearch("New Launches111");
		plotsPOM.clickLoginBtn();
		plotsPOM.scrolingPage();			//Scrolling page
		plotsPOM.clickDropUsLine();  		//Click on Drop Us a Line Link
		Thread.sleep(3000);
		plotsPOM.sendYourName("Pallab Dutta");	//Enter valid details in Your Name textbox
		Thread.sleep(3000);
		plotsPOM.sendYourEmail("pallabuk@gmail.com");	//Enter valid details in Your Email Address textbox 
		Thread.sleep(3000);
		plotsPOM.sendEmailSubject("Selenium Project Medium Level Test Case");	//Enter valid details in subject textbox 
		Thread.sleep(3000);
		plotsPOM.sendEmailMessage("Scripting Medium level test cases for Selenium project"); 	//Enter valid details in message textbox 
		Thread.sleep(3000);
		plotsPOM.clickOnSend();		//Click on Send button
		Thread.sleep(3000);		
		plotsPOM.scrolingPage();	//Scrolling page	
	    String expectedResult="Thanks you for your message";
        String actualResult=driver.findElement(By.xpath("//div[@class='wpcf7-response-output wpcf7-display-none wpcf7-mail-sent-ng']")).getText();
        Assert.assertEquals(actualResult, expectedResult);
        screenShot.captureScreenShot("RETC037");
            
	}
}




