package br.com.rsinet.hub_bdd.steps;

import org.openqa.selenium.WebDriver;

import br.com.rsinet.hub_bdd.utils.DriverFactory;
import cucumber.api.java.pt.Dado;

public class Contexto {
	private WebDriver driver;

	@Dado("^que usuario esta na pagina inicial do site Advantage$")
	public void queUsuarioEstaNaPaginaInicialDoSiteAdvantage() throws Throwable {
		driver = DriverFactory.inicializarDriver();
		driver.manage().window().maximize();
	}
}
