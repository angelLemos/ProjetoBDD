package br.com.rsinet.hub_bdd.steps;

import static br.com.rsinet.hub_bdd.utils.DriverFactory.inicializarDriver;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.rsinet.hub_bdd.pages.TelaInicialPage;
import br.com.rsinet.hub_bdd.pages.TelaListaProdutosPage;
import br.com.rsinet.hub_bdd.utils.ScreenshotUtils;
import cucumber.api.java.Before;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;

public class ProdutoPelaLupa {

	private WebDriver driver;

	private TelaInicialPage telaInicial;
	private TelaListaProdutosPage telaLista;
	private JavascriptExecutor js;
	private String testName;
	private WebDriverWait wait;

	@Before
	public void Inicializa() throws Exception {

		driver = inicializarDriver();

		telaInicial = PageFactory.initElements(driver, TelaInicialPage.class);
		telaLista = PageFactory.initElements(driver, TelaListaProdutosPage.class);
	}

	@Quando("^clicar na lupa$")
	public void clicarNaLupa() throws Throwable {
		telaInicial.clicarNaLupa();
	}

	@Quando("^digitar o que deseja na lupa$")
	public void digitar_o_que_deseja_na_lupa() throws Throwable {
		telaInicial.insereProduto("Laptops");
	}

	@Quando("^selecionar produto desejado na lista de produtos$")
	public void selecionar_produto_desejado_na_lista_de_produtos() throws Throwable {
		telaLista.SelecionarProdutoDoCampo();
	}

	@Entao("^abre a pagina da opcao escolhida$")
	public void abre_a_pagina_da_opcao_escolhida() throws Throwable {
		wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/section/article[1]/div[2]/div[2]/h1")));
        String textoElement = driver.findElement(By.xpath("/html/body/div[3]/section/article[1]/div[2]/div[2]/h1")).getText();
		Assert.assertEquals(textoElement, "HP PAVILION X360 - 11T TOUCH LAPTOP");
		
		testName = new Throwable().getStackTrace()[0].getMethodName();
		ScreenshotUtils.getScreenshot(driver, testName);
	}

	@Quando("^digitar um produto inexistente no site$")
	public void digitar_um_produto_inexistente_no_site() throws Throwable {
		telaInicial.insereProduto("smartphones");
	}

	@Entao("^constata que o produto nao existe$")
	public void constata_que_o_produto_nao_existe() throws Throwable {		
		//Só tira a screenshot corretamente com o tempo
		js = (JavascriptExecutor) driver;
		js.executeAsyncScript("window.setTimeout(arguments[arguments.length - 1], 2000);");
		
//		wait = new WebDriverWait(driver, 10);
//      wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html[1]/body[1]/div[3]/section[1]/article[1]/div[3]/div[1]/label[1]/span[1]")));
		Assert.assertTrue(driver.getPageSource().contains("No results for \"smartphones\""));
		testName = new Throwable().getStackTrace()[0].getMethodName();
		ScreenshotUtils.getScreenshot(driver, testName);

	}

}
