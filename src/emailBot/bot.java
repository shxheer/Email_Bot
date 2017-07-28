package emailBot;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import Pages.GoogleHomePage;
import Pages.GoogleMailPage;

public class bot {
	
	//fields
	private static String recipientAddress = "reinhard.bryce.21@gmail.com";
	static WebDriver driver;
	private static String url = "https://www.wikipedia.com";
	
	public static void initialize(){
		System.setProperty("webdriver.chrome.driver", "/Users/breinhard/Desktop/chromedriver");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		driver = new ChromeDriver(options);
		recipientAddress = "reinhard.bryce.21@gmail.com";
		driver.get(url);
		driver.manage().window().maximize();
		GoogleHomePage p = new GoogleHomePage(driver);
	}
	public static void start(){
		initialize();
	}
	
	public static void setStartUrl(String inUrl){
		url = inUrl;
	}
	
	public static void closeDriver(){
		System.out.println("Driver was closed!");
		driver.close();
	}
	
	public static void signInGoogle(String user, String pass) throws InterruptedException{
		GoogleHomePage p = new GoogleHomePage(driver);
		p.getSignIn().click();
		p.getEmail().sendKeys(user);
		p.getNextButton1().click();
		p.getPassword().click();
		p.getPassword().sendKeys(pass);
		p.getNextButton2().click();
	}
	
	public static void goToMail() throws InterruptedException{
		GoogleHomePage.getGmail().click();
	}

	public static void composeGmailFromMessage(String emailSignIn, String passwordSignIn, String message, String to, String subject) throws InterruptedException{
		setStartUrl("https://www.google.com");
		start();
		signInGoogle(emailSignIn, passwordSignIn);
		goToMail();
		GoogleMailPage p = new GoogleMailPage(driver);
		Thread.sleep(1500);
		p.getComposeButton().click();
		
		Thread.sleep(1500);
		p.getTo().sendKeys(to);
		
		Thread.sleep(1500);
		p.getSubject().sendKeys(subject);
		
		Thread.sleep(1500);
		p.getMessageField().sendKeys(message);
		
		Thread.sleep(1500);
		p.getSendButton().click();
	}
	
//	public static void sendGmailFromFile(String emailSignIn, String passwordSignIn, String send) throws InterruptedException{
//		setStartUrl("https://www.google.com");
//		start();
//		signInGoogle(emailSignIn, passwordSignIn);
//		goToMail();
//		GoogleMailPage p = new GoogleMailPage(driver);
//		Thread.sleep(1500);
//		p.getComposeButton().click();
//		
//		
//	}
	
	
	
	
}	
