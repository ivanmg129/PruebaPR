package PayRetailers.driver;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.Scenario;

public class WebDriverPR {

	private WebDriver driver = null;
	private WebDriverWait myWaitVar = null;

	public WebDriverPR(WebDriver driver, WebDriverWait myWaitVar) {
		super();
		this.driver = driver;
		this.myWaitVar = myWaitVar;
	}

	public WebDriverPR() {
		super();
	}

	public void setUpTestTools(WebDriver driver, WebDriverWait myWaitVar) {
		this.driver = null;
		this.myWaitVar = null;
		this.driver = driver;
		this.myWaitVar = myWaitVar;
	}

	public String getAbsolutPathToFileResource(String pathResource) {
		return new File("").getAbsolutePath() + pathResource;
	}

	public void createScreenShotScrollUp(Scenario scenario) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,0)");
		createScreenShot(scenario);
	}

	public void createScreenShot(Scenario scenario) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss");
		String[] escenario = scenario.getName().split("-");
		String sPath = "/screenshots/" + escenario[0] + "-" + escenario[1] + "/" + escenario[0] + "-" + escenario[1] + "--" + dtf.format(LocalDateTime.now())
				+ ".png";
		File screenShotfile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(screenShotfile, new File(getAbsolutPathToFileResource(sPath)));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void wait(int seconds) {
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
			navegatorClose();
			Thread.currentThread().interrupt();
		}
	}

	public WebDriverWait getMyWaitVar() {
		return myWaitVar;
	}

	public void setMyWaitVar(WebDriverWait myWaitVar) {
		this.myWaitVar = myWaitVar;
	}

	public void navegatorClose() {
		driver.quit();
		driver = null;
	}

	public WebElement findElementById(String id) {
		return driver.findElement(By.id(id));
	}

	public WebElement findElementByXpath(String xpath) {
		return driver.findElement(By.xpath(xpath));
	}

	public WebElement findElementByName(String name) {
		return driver.findElement(By.name(name));
	}

	public WebElement findElementByTagName(String tagname) {
		return driver.findElement(By.tagName(tagname));
	}

	public WebElement findElementByClassName(String className) {
		return driver.findElement(By.className(className));
	}

	public List<WebElement> findElementsById(String id) {
		return driver.findElements(By.id(id));
	}

	public List<WebElement> findElementsByXpath(String xpath) {
		return driver.findElements(By.xpath(xpath));
	}

	public List<WebElement> findElementsByName(String name) {
		return driver.findElements(By.name(name));
	}

	public List<WebElement> findElementsByTagName(String tagname) {
		return driver.findElements(By.tagName(tagname));
	}

	public List<WebElement> findElementsByClassName(String className) {
		return driver.findElements(By.className(className));
	}

	public void navegatorConfigAndOpen() {
		driver = WebDriverCreator.create();
		driver.manage().window().maximize();
		myWaitVar = new WebDriverWait(driver, 60);
		setUpTestTools(driver, myWaitVar);
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
	}

	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	public boolean get(WebDriverPR webDriverPR, String sUrl) {
		boolean result = Boolean.FALSE;
		int status = HttpResponseCode.httpResponseCodeViaGet(sUrl);
		if (200 == status) {
			driver.get(sUrl);
			result = Boolean.TRUE;
		} else {
			System.out.println("Url incorrecta, error: " + status);
		}

		return result;

	}

}
