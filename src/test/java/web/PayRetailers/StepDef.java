package web.PayRetailers;

import java.io.IOException;

import PayRetailers.driver.WebDriverPR;
import PayRetailers.pages.PR_Home_PageObject;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;

public class StepDef {

	protected WebDriverPR driver;
	protected PR_Home_PageObject homePO;

	@Before()
	public void abrirNavegador(Scenario scenario) throws IOException, InterruptedException {
		driver = new WebDriverPR();
		driver.navegatorConfigAndOpen();
		homePO = new PR_Home_PageObject(driver);
	}

	@AfterStep
	public void takeScreenshot(Scenario scenario) throws Exception {
		driver.createScreenShot(scenario);
	}

	@After()
	public void cerrarNavegador() {
		driver.navegatorClose();
	}

	// -----------------------------------------------------------------------------------------------------------------------------------

	@Dado("el navegador abierto, el usuario se dirige a la aplicación PayRetailers")
	public void abreTerminalFinanciero() {
		driver.get(driver, "https://payretailers.com/es/");
	}

	@Entonces("click en empezar ahora")
	public void ClickEmpezarAhora() {
		homePO.ClickEmpezarAhora();
	}
	
	@Entonces("click en Nuestra Solución")
	public void ClickNuestraSolucion() {
		homePO.ClickNuestraSolucion();
	}
	
	@Y("comprobar que se ha accedido correctamente a Nuestra Solución")
	public void comprobarAccesoNuestraSolucion() {
		homePO.comprobarAccesoNuestraSolucion();
	}
	
	@Y("comprobar que se ha accedido correctamente a Empezar ahora")
	public void comprobarAccesoEmpezarAhora() {
		homePO.comprobarAccesoEmpezarAhora();
	}
}
