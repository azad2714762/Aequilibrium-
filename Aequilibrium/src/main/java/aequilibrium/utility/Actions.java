package aequilibrium.utility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Actions extends BrowserFactory {

	public static void clickElement(By element) {
		driver.findElement(element).click();
	}

	public static void setValue(By element, String value) {
		driver.findElement(element).sendKeys(value);
	}
	
	public static boolean isDisplayed(By element) {
		try {
			return driver.findElement(element).isDisplayed();
		} catch (Exception NoSuchElementException) {
			return false;
		}		
	}
	
	public static void waitForVisible(By locator, int seconds) {
		WebDriverWait wait = new WebDriverWait(driver, seconds);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	public static void waitForClickable(By locator, int seconds) {
		WebDriverWait wait = new WebDriverWait(driver, seconds);
		wait.until(ExpectedConditions.elementToBeClickable(locator));
	}
	
	public static void takeScreenShot(String path) throws IOException {
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); //Taking ScreenShot 							under src file and it will stored in Selenium
		FileUtils.copyFile(src, new File(path)); 
	}

}
