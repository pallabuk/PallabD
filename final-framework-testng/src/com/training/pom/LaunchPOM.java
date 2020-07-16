package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LaunchPOM {
private WebDriver driver; 
	
	public LaunchPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
		
	@FindBy(id="keyword_search")
	private WebElement address;
	
	
	@FindBy(xpath="//div[@class='col-md-12']//button")
	private WebElement searchadd;
	
	@FindBy(xpath="//button[@class='button fullwidth']")
	private WebElement loginBtn;
	
	@FindBy(xpath="//a[@class='button fullwidth margin-top-20']")
	private WebElement dropLine;
	
	@FindBy(xpath="//input[@placeholder='Your Name']")
	private WebElement yourName;
	
	@FindBy(xpath="//input[@placeholder='Email Address']")
	private WebElement yourEmail;
	
	@FindBy(xpath="//input[@placeholder='Subject']")
	private WebElement emailSubject;
	
	@FindBy(xpath="//textarea[@placeholder='Message']")
	private WebElement emailMessage;
	
	@FindBy(xpath="//input[@type='submit']")
	private WebElement clickSend;
	
	public void clickOnSend () {
		this.clickSend.click();
	}
	
	public void sendEmailMessage(String emailMessage) {
		this.emailMessage.clear();
		this.emailMessage.sendKeys(emailMessage);
	}
	
	public void sendEmailSubject(String emailSubject) {
		this.emailSubject.clear();
		this.emailSubject.sendKeys(emailSubject);
	}
	
	public void sendYourEmail(String yourEmail) {
		this.yourEmail.click();
		this.yourEmail.sendKeys(yourEmail);
	}
	
	public void sendYourName(String yourName) {
		this.yourName.clear();
		this.yourName.sendKeys(yourName);
	}


	public void clickDropUsLine() {
		this.dropLine.click();
	}

	public void clickLoginBtn() {
		this.loginBtn.click(); 
	}
	
	 public void scrolingPage() throws InterruptedException {
	    	JavascriptExecutor js= (JavascriptExecutor)driver;
	    	//js.executeScript("window.scrollTo(0,-document.body.scrollHeight)");
	    	//js.executeScript("window.scrollTo(0,document.body.scrollTop)");
	    	//js.executeScript("window.scrollBy(0,70)");
	        //Thread.sleep(3000);
	        js.executeScript("window.scrollBy(0,-50)");
	        //Thread.sleep(3000);
	}
	
	 public void sendAdress(String address) {
		this.address.sendKeys(address);
	}
	
	public void clickOnLanuch() {
		WebElement launch=driver.findElement(By.xpath("//li[@id='menu-item-354']//a"));
		Actions act=new Actions(driver);
		act.moveToElement(launch).click().build().perform();
	}
}
