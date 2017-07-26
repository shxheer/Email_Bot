package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleMailPage extends Page {
	static WebDriver driver;
	
	@FindBy(css = "div.T-I.J-J5-Ji.T-I-KE.L3")
	private static WebElement composeButton;
	@FindBy(id = ":o7")
	private static WebElement toField;
	@FindBy(id= ":nq")
	private static WebElement subjectField;
	@FindBy(id = ":ou")
	private static WebElement messageField;
	@FindBy(className = "Am Al editable LW-avf")
	private static WebElement insertFileButton;
	@FindBy(id = ":ng")
	private static WebElement sendButton;
	
	public GoogleMailPage(WebDriver driver){
		super(driver);
		driver.get("https://mail.google.com");
		PageFactory.initElements(driver,this);
		
	}
	
	public WebElement getComposeButton() throws InterruptedException{
		Thread.sleep(1500);
		return composeButton;
	}
	
	public WebElement getTo() throws InterruptedException{
		Thread.sleep(1500);
		return toField;
	}
	
	public WebElement getSubject() throws InterruptedException {
		Thread.sleep(1500);
		return subjectField;
	}
	
	public WebElement getMessageField() throws InterruptedException{
		Thread.sleep(1500);
		return messageField;
	}
	
	public static WebElement getInsertFileButton() throws InterruptedException{
		Thread.sleep(1500);
		return insertFileButton;
	}
	
	public WebElement getSendButton() throws InterruptedException{
		Thread.sleep(1500);
		return sendButton;
	}
	
	
	
	
	
	
	
	
}
