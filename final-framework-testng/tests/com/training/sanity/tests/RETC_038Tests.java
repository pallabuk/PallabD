//Test Objective: To verify whether application allows to search details & fill enquiry details in Blog tab
//Test Case Name: RETC_038
//Test Result: Failed


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
import com.training.pom.BlogPOM;
import com.training.pom.LoginPOM;
import com.training.pom.PlotsPOM;
import com.training.pom.PostsPOM;
import com.training.pom.PropertiesPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RETC_038Tests {

	public WebDriver driver;
	public String baseUrl;
	public BlogPOM blogPOM;
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
		blogPOM = new BlogPOM(driver);
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
		blogPOM.clickOnBlog();		//Click on Blog tab
		blogPOM.sendPropertySearch("vihar");
		blogPOM.clickOnVihar();
		Thread.sleep(3000);
		blogPOM.scrolingPage();     //Scrolling page
		blogPOM.clickDropUsLine(); 	//Click on Drop Us a Line Link
		Thread.sleep(3000);
		blogPOM.sendYourName("Pallab Dutta");	//Enter valid details in Your Name textbox	
		Thread.sleep(3000);
		blogPOM.sendYourEmail("pallabuk@gmail.com");	//Enter valid details in Your Email Address textbox 
		Thread.sleep(3000);
		blogPOM.sendEmailSubject("Medium Level Script for Real State project");		//Enter valid details in subject textbox 
		Thread.sleep(3000);
		blogPOM.sendEmailMessage("Scripting Medium level test cases for Real state project is completed");		//Enter valid details in message textbox
		Thread.sleep(3000);
		blogPOM.clickOnSend();		//Click on Send button
		Thread.sleep(3000);	
		blogPOM.scrolingPage();     //Scrolling page
	    String expectedResult="Thanks you for your message";
        String actualResult=driver.findElement(By.xpath("//div[@class='wpcf7-response-output wpcf7-display-none wpcf7-mail-sent-ng']")).getText();
        Assert.assertEquals(actualResult, expectedResult);
        screenShot.captureScreenShot("RETC038");
     	}
}





