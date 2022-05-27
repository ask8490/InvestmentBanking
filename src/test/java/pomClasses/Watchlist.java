package pomClasses;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.UtilityClass;

public class Watchlist {

	@FindBy(xpath="//ul[@class='marketwatch-selector list-flat']/li[3]") private WebElement watchlistNumber;
	@FindBy(xpath="//input[@placeholder= 'Search eg: infy bse, nifty fut weekly, gold mcx']") private WebElement scriptSearchField;
	@FindBy(xpath="//li[@class='search-result-item selected']/span[@class='symbol']") private WebElement searchOutput;
	
	public Watchlist(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void searchScript(String sheetName, int rowNumber, int cellNumber) throws EncryptedDocumentException, IOException {
		watchlistNumber.click();
		scriptSearchField.sendKeys(UtilityClass.readExcelFile(sheetName, rowNumber, cellNumber));
		searchOutput.click();
	}
}
