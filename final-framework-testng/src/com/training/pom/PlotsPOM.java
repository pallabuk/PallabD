package com.training.pom;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PlotsPOM {

private WebDriver driver; 
	
	public PlotsPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "keyword_search")
	private WebElement keysearch; 
	
	@FindBy(xpath="//button[@class='button fullwidth']")
	private WebElement loginBtn; 
	
	@FindBy(xpath="//input[@type='search']")
	private WebElement sProperty;
	
	@FindBy(xpath="//a[contains(text(),'New Launches111')]")
	private WebElement nProperty;
	
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
	
	public void clickNewProperty() {
		this.nProperty.click();
	}
	
	public void sendProperty(String sProperty) {
		this.sProperty.clear();
		this.sProperty.sendKeys(sProperty);
	}
	
	public void clickLoginBtn() {
		this.loginBtn.click(); 
	}
	
	
	public void sendKeySearch(String keysearch) {
		this.keysearch.clear();
		this.keysearch.sendKeys(keysearch);
	}
	
	
	public void clickOnPlots() {
		WebElement plots = driver.findElement(By.xpath("//li[@id='menu-item-570']//a[@data-type='taxonomy']"));
		Actions act = new Actions(driver);
		act.moveToElement(plots).click().build().perform();
		}
	
	
    public void selectFromAllDates() {
		WebElement ptype=driver.findElement(By.xpath("//div[@id='_property_type_chosen']//a[@class='chosen-single chosen-default']"));
        Select selectValue = new Select(ptype);
        selectValue.selectByIndex(1);
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
	
}
