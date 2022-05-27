package pomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BaseClass;
import utility.UtilityClass;

public class LoginPage extends BaseClass{
	@FindBy(id = "userid") private WebElement userIdField;
	@FindBy(id = "password") private WebElement passwordField;
	@FindBy(xpath = "//button[@type='submit']") private WebElement loginButton;
	
	public LoginPage(WebDriver driver ) {
		PageFactory.initElements(driver, this);
	}
	
	
	
	public void enterUserId(String key) {
		userIdField.sendKeys(key);
	}
	
	public void enterPassword(String key) {
		passwordField.sendKeys(key);
	}
	
	public void clickLoginButton() {
		loginButton.click();
	}
}
