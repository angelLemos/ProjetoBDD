package br.com.rsinet.hub_bdd.steps;

import static br.com.rsinet.hub_bdd.utils.DriverFactory.inicializarDriver;
import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.rsinet.hub_bdd.pages.TelaInicialPage;
import br.com.rsinet.hub_bdd.pages.TelaListaProdutosPage;
import br.com.rsinet.hub_bdd.utils.ScreenshotUtils;
import cucumber.api.java.Before;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;

public class ProdutoTelaInicial {
	private WebDriver driver;
	
	private TelaInicialPage telaInicial;
	private TelaListaProdutosPage telaLista;
	private String testName;
	private WebDriverWait wait;

	@Before
	public void Inicializa() throws Exception {

		driver = inicializarDriver();

		telaInicial = PageFactory.initElements(driver, TelaInicialPage.class);
		telaLista = PageFactory.initElements(driver, TelaListaProdutosPage.class);
	}
	
	@Dado("^que usuario esta na pagina inicial do site Advantage$")
	public void queUsuarioEstaNaPaginaInicialDoSiteAdvantage() throws Throwable {
		driver.get("http://www.advantageonlineshopping.com/#/");
		driver.manage().window().maximize();
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
		assertEquals(driver.getCurrentUrl(), "http://www.advantageonlineshopping.com/#/product/31");
		wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html[1]/body[1]/div[3]/section[1]/article[1]/div[2]/div[2]/h1[1]")));
		testName = new Throwable().getStackTrace()[0].getMethodName();
		ScreenshotUtils.getScreenshot(driver, testName);
	}
	
	@Quando("^escolhe produto na tela inicial$")
	public void escolheProdutoNaTelaInicial() throws Throwable {
		telaInicial.ClicaEmNotebookTelaInicial();
	}

	@Entao("^abre produto diferente do que consta na  tela inicial$")
	public void abreProdutoDiferenteDoQueConstaNaTelaInicial() throws Throwable {
		String textoElement = driver.findElement(By.xpath("/html[1]/body[1]/div[3]/section[1]/article[1]/div[2]/div[2]/h1[1]")).getText();
		Assert.assertEquals( textoElement, "HP CHROMEBOOK 14 G1(ES)");
		testName = new Throwable().getStackTrace()[0].getMethodName();
		ScreenshotUtils.getScreenshot(driver, testName);
	}


}
