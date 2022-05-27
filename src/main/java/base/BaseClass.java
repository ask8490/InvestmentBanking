package base;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import utility.UtilityClass;


// browser launch, cache/cookie cleaner, browser close
// important credentials
public class BaseClass {
	//protected static String url = "https://kite.zerodha.com/";
	//protected static String userId = "NM1806";
	protected static String password = "anvay1818";
	protected static String pin = "742695";
	protected static WebDriver driver=null;
	
	@BeforeClass
	public static void launchBrowser() throws InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver", "E:\\Testing\\AskWorkspace\\Zerodha\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get(UtilityClass.readCredentialFile("url"));
		Thread.sleep(2000);
	}
	
	/*
	public void closeBrowser() {
		driver.close();
	}*/
	
}
