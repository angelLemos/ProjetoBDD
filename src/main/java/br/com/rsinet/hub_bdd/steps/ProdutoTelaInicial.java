package br.com.rsinet.hub_bdd.steps;

import static br.com.rsinet.hub_bdd.utils.DriverFactory.inicializarDriver;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import br.com.rsinet.hub_bdd.pages.TelaInicialPage;
import br.com.rsinet.hub_bdd.pages.TelaListaProdutosPage;
import cucumber.api.java.Before;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;

public class ProdutoTelaInicial {
	WebDriver driver;
	
	TelaInicialPage telaInicial;
	TelaListaProdutosPage telaLista;
	

	@Before
	public void Inicializa() throws Exception {

		driver = inicializarDriver();

		telaInicial = PageFactory.initElements(driver, TelaInicialPage.class);
		telaLista = PageFactory.initElements(driver, TelaListaProdutosPage.class);
	}
	

	@Quando("^clicar na opcao desejada na tela home$")
	public void clicarNaOpcaoDesejadaNaTelaHome() throws Throwable {
	   telaInicial.ClicarProdutoTelaInicial();
	}

	@Quando("^escolher produto desejado na lista de produtos$")
	public void escolherProdutoDesejadoNaListaDeProdutos() throws Throwable {
	   telaLista.SelecionarProdutoDaTela();
	}

	@Entao("^estou na tela da opcao escolhida$")
	public void estouNaTelaDaOpcaoEscolhida() throws Throwable {
		Assert.assertEquals("http://www.advantageonlineshopping.com/#/product/31", driver.getCurrentUrl());
	}
	
	@Quando("^escolhe produto na tela inicial$")
	public void escolheProdutoNaTelaInicial() throws Throwable {
		telaInicial.ClicaEmNotebookTelaInicial();
	}

	@Entao("^abre produto diferente do que consta na  tela inicial$")
	public void abreProdutoDiferenteDoQueConstaNaTelaInicial() throws Throwable {
		String textoElement = driver.findElement(By.xpath("/html[1]/body[1]/div[3]/section[1]/article[1]/div[2]/div[2]/h1[1]")).getText();
		Assert.assertEquals( textoElement, "HP CHROMEBOOK 14 G1(ES)");
	}


}
