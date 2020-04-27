package aequilibrium.utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserFactory {

	public static WebDriver driver;

	public static void invokeBrowser(String url) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get(url);
	}
	
	public static void quitBrowser() {
		driver.quit();
	}

}
