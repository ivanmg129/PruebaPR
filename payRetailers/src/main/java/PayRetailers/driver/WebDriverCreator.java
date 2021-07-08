package PayRetailers.driver;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebDriverCreator {
	
	public static WebDriver create() {
		System.setProperty("webdriver.chrome.logfile", ".\\chromedriver.log");
		System.setProperty("webdriver.chrome.driver", "Drivers\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--lang=es");
		options.addArguments("test-type");
		options.addArguments("start-maximized");
		HashMap<String, Object> prefs = new HashMap<>();
		prefs.put("profile.default_content_settings.popups", 0);
		prefs.put("download.prompt_for_download", false);
		prefs.put("safebrowsing.enabled", false); // to disable security check eg. Keep or cancel button
		options.setExperimentalOptions("prefs", prefs);
		return new ChromeDriver(options);
	}

}
