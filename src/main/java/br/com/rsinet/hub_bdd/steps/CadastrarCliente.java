package br.com.rsinet.hub_bdd.steps;

import static br.com.rsinet.hub_bdd.utils.DriverFactory.fecharDriver;
import static br.com.rsinet.hub_bdd.utils.DriverFactory.inicializarDriver;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import br.com.rsinet.hub_bdd.pages.TelaFormularioCadastroPage;
import br.com.rsinet.hub_bdd.pages.TelaInicialPage;
import br.com.rsinet.hub_bdd.utils.ExcelDadosConfig;
import br.com.rsinet.hub_bdd.utils.ScreenshotUtils;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;

public class CadastrarCliente {

	private WebDriver driver;

	private TelaInicialPage telaInicial;
	private JavascriptExecutor js;

	private TelaFormularioCadastroPage formulario;
	private String testName;

	@Before
	public void Inicializa() throws Exception {

		driver = inicializarDriver();

		telaInicial = PageFactory.initElements(driver, TelaInicialPage.class);

		formulario = PageFactory.initElements(driver, TelaFormularioCadastroPage.class);

		ExcelDadosConfig.setExcelFile("C:\\Users\\angelica.jesus\\Desktop\\dados.xlsx", "Planilha1");


	}

	
	@Quando("^clicar em botao de login$")
	public void clicarEmBotaoDeLogin() throws Throwable {
		telaInicial.clicarEmMenuUsuario();
	}

	@Quando("^clicar em criar conta$")
	public void clicarEmCriarConta() throws Throwable {
		telaInicial.ClicarEmCriarNovaConta();
	}

	@Quando("^insere nome de usuario$")
	public void insereNomeDeUsuario() throws Throwable {
		String nomeUsuario = ExcelDadosConfig.getCellData(1, 0);
		formulario.insereNomeUsuario(nomeUsuario);
	}

	@Quando("^insere o email$")
	public void insereOEmail() throws Throwable {
		String email = ExcelDadosConfig.getCellData(1, 1);
		formulario.insereEmail(email);
		;
	}

	@Quando("^insere a senha$")
	public void insereASenha() throws Throwable {
		String senha = ExcelDadosConfig.getCellData(1, 2);
		formulario.insereSenha(senha);
	}

	@Quando("^confirma a senha$")
	public void confirmaASenha() throws Throwable {
		String confirmSenha = ExcelDadosConfig.getCellData(1, 3);
		formulario.confirmaSenha(confirmSenha);
	}

	@Quando("^insere o primeiro nome$")
	public void insereOPrimeiroNome() throws Throwable {
		String nome = ExcelDadosConfig.getCellData(1, 4);
		formulario.insereNome(nome);
	}

	@Quando("^insere o ultimo nome$")
	public void insereOUltimoNome() throws Throwable {
		String sobrenome = ExcelDadosConfig.getCellData(1, 5);
		formulario.insereSobrenome(sobrenome);
	}

	@Quando("^insere o numero do telefone$")
	public void insereONumeroDoTelefone() throws Throwable {
		String telefone = ExcelDadosConfig.getCellData(1, 6);
		formulario.insereTelefone(telefone);
	}

	@Quando("^seleciona o pais$")
	public void selecionaOPais() throws Throwable {
		String pais = ExcelDadosConfig.getCellData(1, 7);
		formulario.selecionaPais(pais);
	}

	@Quando("^insere a cidade$")
	public void insereACidade() throws Throwable {
		String cidade = ExcelDadosConfig.getCellData(1, 8);
		formulario.insereCidade(cidade);
	}

	@Quando("^insere o endereco$")
	public void insereOEndereco() throws Throwable {
		String endereco = ExcelDadosConfig.getCellData(1, 9);
		formulario.insereEndereco(endereco);
	}

	@Quando("^insere o estado$")
	public void insereOEstado() throws Throwable {
		String estado = ExcelDadosConfig.getCellData(1, 10);
		formulario.insereEstado(estado);
	}

	@Quando("^insere o CEP$")
	public void insereOCEP() throws Throwable {
		String cep = ExcelDadosConfig.getCellData(1, 11);
		formulario.insereCEP(cep);
	}

	@Quando("^clicar em aceitar termos$")
	public void clicarEmAceitarTermos() throws Throwable {
		formulario.ClicarEmAceitarTermos();
	}

	@Quando("^clicar em registrar$")
	public void clicarEmRegistrar() throws Throwable {
		formulario.ClicarEmRegistrar();
	}

	@Entao("^usuario cadastrado com sucesso$")
	public void usuarioCadastradoComSucesso() throws Throwable {
		String nomeUsuario = ExcelDadosConfig.getCellData(1, 0);
		js = (JavascriptExecutor) driver;
        js.executeAsyncScript("window.setTimeout(arguments[arguments.length - 1],2000);");
		Assert.assertEquals(nomeUsuario, driver.findElement(By.id("menuUserLink")).getText());
		testName = new Throwable().getStackTrace()[0].getMethodName();
		ScreenshotUtils.getScreenshot(driver, testName);
	}

	@Entao("^botao esta desabilitado$")
	public void botaoEstaDesabilitado() throws Throwable {
		Assert.assertFalse(formulario.verificarSeRegistrarEstaDisponivel());
		testName = new Throwable().getStackTrace()[0].getMethodName();
		ScreenshotUtils.getScreenshot(driver, testName);
	}

	@After
	public void finaliza() {

		fecharDriver();
	}
}
