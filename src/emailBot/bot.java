package emailBot;

import java.io.File;
import java.io.IOException;
import org.apache.commons.logging.Log;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.google.common.base.Charsets;
import com.google.common.io.Files;
import Pages.GoogleHomePage;
import Pages.GoogleMailPage;

public class bot {

	// fields
	private static Logger log = Logger.getLogger(Log.class.getName());
	static WebDriver driver;
	private static String url = "https://www.wikipedia.com";

	public static void initialize() {
		System.setProperty("webdriver.chrome.driver", "/Users/breinhard/Desktop/chromedriver");
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		GoogleHomePage p = new GoogleHomePage(driver);
		log.info("Test");
	}

	public static void start() {
		initialize();
	}

	public static void setStartUrl(String inUrl) {
		url = inUrl;
	}

	public static void closeDriver() {
		System.out.println("Driver was closed!");
		driver.close();
	}

	/*
	 * Signs into a google account based on params. Uses the GoogleHomePage
	 * class to get all the web elements needed.
	 */
	public static void signInGoogle(String user, String pass) throws InterruptedException {
		setStartUrl("https://www.google.com");
		start();
		GoogleHomePage p = new GoogleHomePage(driver);
		p.getSignIn().click();
		p.getEmail().sendKeys(user);
		p.getNextButton1().click();
		p.getPassword().click();
		p.getPassword().sendKeys(pass);
		p.getNextButton2().click();
	}

	public static void goToMail() throws InterruptedException {
		GoogleHomePage.getGmail().click();
	}

	/*
	 * Signs into google, goes to mail page, loads in the GoogleMailPage class,
	 * and then passes in params to the email fields.
	 */
	public static void composeGmailFromMessage(String emailSignIn, String passwordSignIn, String message, String to,
			String subject) throws InterruptedException {
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

	/*
	 * Signs into google, goes to mail page, loads in the GoogleMailPage class,
	 * and then passes in params to the email fields. This one doesn't need a
	 * message param because it takes the contents of file "newMessage.txt". The
	 * file path is below.
	 */
	public static void sendGmailFromFile(String emailSignIn, String passwordSignIn, String to, String subject)
			throws InterruptedException, IOException {
		setStartUrl("https://www.google.com");
		start();
		String content = Files.toString(new File("newMessage.txt"), Charsets.UTF_8);
		String path = "/Users/breinhard/Desktop/Eclipse Workspace/emailBot/newMessage.txt";
		System.out.println("Path to file is: " + path);
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
		p.getMessageField().sendKeys(content);
		Thread.sleep(1500);
		p.getSendButton().click();
	}

}
