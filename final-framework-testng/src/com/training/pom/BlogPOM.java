package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class BlogPOM {
private WebDriver driver; 
	
	public BlogPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
		
	@FindBy(xpath="//input[@title='Search input']")
	private WebElement psearch; 
	
	@FindBy(xpath="//a[contains(text(), 'vihar')]")
	private WebElement vihar;
	
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
	
	public void clickOnVihar() {
		this.vihar.click();
	}
	
	public void sendPropertySearch(String psearch) {
		this.psearch.clear();
		this.psearch.sendKeys(psearch);
	}
	public void clickOnBlog() {
		WebElement blog = driver.findElement(By.xpath("//a[contains(text(),'Blog')]"));
		Actions act = new Actions(driver);
		act.moveToElement(blog).click().build().perform();
		}
	
	public void scrolingPage() throws InterruptedException {
    	JavascriptExecutor js= (JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,50)");
        Thread.sleep(3000);
        js.executeScript("window.scrollBy(0,50)");
        Thread.sleep(3000);
        //js.executeScript("window.scrollBy(0,-50)");
        //Thread.sleep(3000);
        //js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
      
    }
	
	
/*public void selectFromBulkActions() {
    	
    	WebElement bulkactions=driver.findElement(By.xpath("//div[@class='item asl_result_pagepost fx-none hovered']//span[@class='overlap']"));
        Select selectValue = new Select(bulkactions);
        selectValue.selectByIndex(2);
     }*/
	
	
	
    }
