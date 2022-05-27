package testClasses;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseClass;
import pomClasses.LoginPage;
import pomClasses.PinPage;
import pomClasses.Watchlist;
import utility.UtilityClass;

public class TC002_AddStockInWatchlist extends BaseClass {

	LoginPage lp;
	PinPage pp;
	Watchlist wl;
	
	@BeforeMethod
	public void loginSteps() throws IOException {
		lp = new LoginPage(driver);
		pp = new PinPage(driver);
		
		lp.enterUserId(UtilityClass.readCredentialFile("userId"));
		lp.enterPassword(UtilityClass.readCredentialFile("password"));
		lp.clickLoginButton();
		
		pp.enterPin(UtilityClass.readCredentialFile("pin"));
		pp.clickSubmitButton();
	}
	@Test
	public void addStockToWatchlist() throws EncryptedDocumentException, IOException {
		wl = new Watchlist(driver);
		
		for (int i=1; i<=50; i++) {
			wl.searchScript("TC002_AddStockInWatchlist", i, 1);
		}
		
	}
}
