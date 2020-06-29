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
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RETC026Tests {
	public WebDriver driver;
	public String baseUrl;
	public LoginPOM loginPOM;
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
		screenShot.captureScreenShot("First");
		WebElement property=driver.findElement(By.xpath("//div[contains(text(),'Properties')]"));
	    Actions act=new Actions(driver);
	    act.moveToElement(property).build().perform();
	    //Thread.sleep(3000);
        WebElement allproperty=driver.findElement(By.xpath("//a[contains(text(),'All Properties')]"));
        act.moveToElement(allproperty).click().build().perform();
        boolean checkbox=driver.findElement(By.id("cb-select-9914")).isSelected();
        System.out.println("remember checkbos is selected "+checkbox);
        driver.findElement(By.id("cb-select-9914")).click();
        WebElement bulkactions=driver.findElement(By.id("bulk-action-selector-top"));
        Select selectValue = new Select(bulkactions);
        selectValue.selectByIndex(2);
        driver.findElement(By.id("doaction")).click();
        String expectedResult="1 post moved to the Trash";
        String actualResult=driver.findElement(By.xpath("//p[contains(text(),'1 post moved to the Trash.')]")).getText();
        Assert.assertEquals(actualResult, expectedResult);
            
	}
}


