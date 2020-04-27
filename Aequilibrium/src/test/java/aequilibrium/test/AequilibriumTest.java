package aequilibrium.test;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import aequilibrium.pages.LoginScreen;
import aequilibrium.utility.Actions;
import aequilibrium.utility.BrowserFactory;

public class AequilibriumTest {

	static String url = "https://www.saucedemo.com/index.html";
	static String emptyString = "";
	static String invalidUsername = "Inavlid UserName";
	static String invalidPassword = "Inavlid Password";
	static String validUsername = "standard_user";
	static String validPassword = "secret_sauce";
	static String path = "C://failTest.png";

	@BeforeMethod
	public static void openSite() {
		BrowserFactory.invokeBrowser(url);
	}

	@AfterMethod
	public static void closeBrowser() {
		BrowserFactory.quitBrowser();
	}

	@Test(priority = 1)
	public static void verifyUsernameRequiredWarning() throws IOException {
		try {
			LoginScreen.login(emptyString, validPassword);
			Assert.assertEquals(LoginScreen.isUsernameRequiredWarningDisplayed(), true);
		} catch (Exception e) {
			Actions.takeScreenShot(path);
		}
	}

	@Test(priority = 2)
	public static void verifyPasswordRequiredWarning() throws IOException {
		try {
			LoginScreen.login(validUsername, emptyString);
			Assert.assertEquals(LoginScreen.isPasswordRequiredWarningDisplayed(), true);
		} catch (Exception e) {
			Actions.takeScreenShot(path);
		}
	}

	@Test(priority = 3)
	public static void logInWithInvalidCredential() throws IOException {
		try {
			LoginScreen.login(invalidUsername, invalidPassword);
			Assert.assertEquals(LoginScreen.isInavlidCredentialWarningDisplayed(), true);
		} catch (Exception e) {
			Actions.takeScreenShot(path);
		}
	}

	@Test(priority = 4)
	public static void logInWithEmptyCredential() throws IOException {
		try {
			LoginScreen.login(emptyString, emptyString);
			Assert.assertEquals(LoginScreen.isUsernameRequiredWarningDisplayed(), true);
		} catch (Exception e) {
			Actions.takeScreenShot(path);
		}
	}

	@Test(priority = 5)
	public static void logInWithValidCredential() throws IOException {
		try {
			LoginScreen.login(validUsername, validPassword);
		} catch (Exception e) {
			Actions.takeScreenShot(path);
		}
	}
}
