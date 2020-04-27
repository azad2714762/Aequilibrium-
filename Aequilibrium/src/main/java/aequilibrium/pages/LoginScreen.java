package aequilibrium.pages;



import org.openqa.selenium.By;
import aequilibrium.utility.Actions;
import aequilibrium.utility.BrowserFactory;

public class LoginScreen extends BrowserFactory{
	
	static By userNameInputFieldLocator = By.id("user-name");
	static By passwordInputFieldLocator = By.id("password");
	static By loginbuttonLocator = By.xpath("//input[@value='LOGIN']");
	static By userNameRequiredWarningLocator = By.xpath("//h3[contains(.,'Username is required')]");
	static By passwordRequiredWarningLocator = By.xpath("//h3[contains(.,'Password is required')]");
	static By ivalidCredentialWarningLocator = By.xpath("//h3[contains(.,'Username and password do not match any user in this service')]");
	static int waitPeriod = 10;
	
	public static void setUsernameValue(String value) {
		Actions.setValue(userNameInputFieldLocator, value);
	}
	
	public static void setPasswordValue(String value) {
		Actions.setValue(passwordInputFieldLocator, value);
	}
	
	public static void clickLoginButton() {
		Actions.clickElement(loginbuttonLocator);
	}
	
	public static void login(String username, String password) {
		setUsernameValue(username);
		setPasswordValue(password);
		clickLoginButton();
	}
	
	public static boolean isUsernameRequiredWarningDisplayed() {
		Actions.waitForVisible(userNameRequiredWarningLocator, waitPeriod);
		return Actions.isDisplayed(userNameRequiredWarningLocator);
	}
	
	public static boolean isPasswordRequiredWarningDisplayed() {
		Actions.waitForVisible(passwordRequiredWarningLocator, waitPeriod);
		return Actions.isDisplayed(passwordRequiredWarningLocator);
	}
	
	public static boolean isInavlidCredentialWarningDisplayed() {
		Actions.waitForVisible(ivalidCredentialWarningLocator, waitPeriod);
		return Actions.isDisplayed(ivalidCredentialWarningLocator);
	}
}


	
	

