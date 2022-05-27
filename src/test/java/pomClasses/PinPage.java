package pomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BaseClass;

public class PinPage extends BaseClass{

	@FindBy(id = "pin") private WebElement pinField;
	@FindBy(xpath = "//button[@type='submit']") private WebElement submitButton;
	
	public PinPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void enterPin(String key) {
		pinField.sendKeys(key);
	}
	
	public void clickSubmitButton() {
		submitButton.click();
	}
}
