package testClasses;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseClass;
import pomClasses.LoginPage;
import pomClasses.PinPage;
import utility.UtilityClass;

public class TC001_LoginToZerodhaKite extends BaseClass{

	LoginPage lp;
	PinPage pp;
	
	@BeforeClass
	public void browserLaunch() throws InterruptedException, IOException {
		BaseClass.launchBrowser();
	}
	
	@BeforeMethod
	public void loginSteps() throws IOException {
		lp = new LoginPage(driver);
		pp = new PinPage(driver);
		
		//lp.enterUserId();
		lp.enterUserId(UtilityClass.readCredentialFile("userId"));
		//lp.enterPassword();
		lp.enterPassword(UtilityClass.readCredentialFile("password"));
		lp.clickLoginButton();
		
		//pp.enterPin();
		pp.enterPin(UtilityClass.readCredentialFile("pin"));
		pp.clickSubmitButton();
	}
	@Test
	public void verifyDashboardTitle() {
		String DashboardTitle = driver.getTitle();
		
		if (DashboardTitle.equals("Dashboard / Kite")) {
			Assert.assertTrue(true);
		}
		else {
			Assert.assertFalse(false);
		}
	}
}
