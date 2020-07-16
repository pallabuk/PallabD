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
import com.training.pom.PostsPOM;
import com.training.pom.PropertiesPOM;
import com.training.pom.UsersPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RETC_074_ManuallyEnterData {

	public WebDriver driver;
	public String baseUrl;
	public LoginPOM loginPOM;
	public UsersPOM usersPOM;
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
		usersPOM=new UsersPOM(driver);
	    baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}
	
	@AfterClass
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		//driver.quit();
	}
	@Test
	public void validLoginTest() throws InterruptedException {
		loginPOM.sendUserName("pallabuk1@gmail.com");
		loginPOM.sendPassword("password@12345");
		loginPOM.clickLoginBtn(); 
		usersPOM.clickOnUsers();
		usersPOM.clickOnAllUsers();
		usersPOM.sendSearchUser("Manzoor");
		usersPOM.clickSearchUserBttn();
		Thread.sleep(1000);
		usersPOM.clickCheckBoxManzoorMehadi();;
		Thread.sleep(1000);
		usersPOM.selctFromChangeRoleToAgent();
		Thread.sleep(3000);
		usersPOM.clickChangeIt();
		Thread.sleep(1000);
		usersPOM.sendSearchUser("Alex Hales");
		Thread.sleep(1000);
		usersPOM.clickSearchUserBttn();
		Thread.sleep(1000);
		usersPOM.clickCheckBoxAlexHalse();
		Thread.sleep(1000);
		usersPOM.selctFromChangeRoleToCustomer();
		Thread.sleep(3000);
		usersPOM.clickChangeIt();
		Thread.sleep(1000);
		usersPOM.sendSearchUser("mariya");
		Thread.sleep(1000);
		usersPOM.clickSearchUserBttn();
		Thread.sleep(1000);
		usersPOM.clickCheckBoxMariya();
		Thread.sleep(1000);
		usersPOM.selctFromChangeRoleToShopManager();
		Thread.sleep(3000);
		usersPOM.clickChangeIt();
		Thread.sleep(1000);
			
	    String expectedResult="Changed roles.";
        String actualResult=driver.findElement(By.xpath("//div[@id='message']//p")).getText();
        Assert.assertEquals(actualResult, expectedResult);
            
	}
}

