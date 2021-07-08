package PayRetailers.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import PayRetailers.driver.WebDriverPR;
import junit.framework.Assert;

public class PR_Home_PageObject{
	
	private WebDriverPR driver;
	
	public PR_Home_PageObject(WebDriverPR driver) {
		this.driver=driver;
	} 
	
	private WebElement Bttn_empezarAhora() {return driver.findElementByXpath("//a[contains(text(),'Empezar ahora')]"); } 
	private WebElement Enl_nuestraSolucion() {return driver.findElementByXpath("//a[@title='Nuestra solución']");};
	private WebElement Txbx_nombre() {return driver.findElementByXpath("//*[@id='frm_name']");}
	private WebElement Bttn_comenzarAhora() {return driver.findElementByXpath("//a[contains(text(),'Comenzar ahora')]");}
	private WebElement Enl_Soluciones() {return driver.findElementByXpath("//a[contains(text(),'Soluciones')]");};
	
	public void ClickEmpezarAhora() {
		Bttn_empezarAhora().click();
	}
	
	public void comprobarAccesoEmpezarAhora() {
		Assert.assertNotNull(Txbx_nombre());
	}
	
	public void ClickNuestraSolucion() {
		new Actions(driver.getDriver()).moveToElement(Enl_Soluciones()).perform();
		Enl_nuestraSolucion().click();
	}
	
	public void comprobarAccesoNuestraSolucion() {
		Assert.assertNotNull(Bttn_comenzarAhora());
	}
	
}
