package br.com.rsinet.hub_bdd.steps;

import static br.com.rsinet.hub_bdd.utils.DriverFactory.fecharDriver;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import br.com.rsinet.hub_bdd.pages.TelaFormularioCadastroPage;
import br.com.rsinet.hub_bdd.pages.TelaInicialPage;
import br.com.rsinet.hub_bdd.utils.DriverFactory;
import br.com.rsinet.hub_bdd.utils.ExcelDadosConfig;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;

public class CadastrarCliente {

	WebDriver driver;
//	ExtentReports extensao;
//	ExtentTest logger;

	TelaInicialPage telaInicial;

	TelaFormularioCadastroPage formulario;

	@Before
	public void Inicializa() throws Exception {

		driver = DriverFactory.inicializarDriver();

		telaInicial = PageFactory.initElements(driver, TelaInicialPage.class);

		formulario = PageFactory.initElements(driver, TelaFormularioCadastroPage.class);

		ExcelDadosConfig.setExcelFile("target/Excel/dados.xlsx", "Planilha1");

//		ExtentHtmlReporter reporte = new ExtentHtmlReporter("./Reports/cadastroCliente.html");
//
//		extensao = new ExtentReports();
//
//		extensao.attachReporter(reporte);
//
//		logger = extensao.createTest("Cadastro Realizado!");

	}

	@Dado("^que usuario esta na pagina inicial do site Advantage$")
	public void queUsuarioEstaNaPaginaInicialDoSiteAdvantage() throws Throwable {
		driver.get("http://www.advantageonlineshopping.com/#/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
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
		Thread.sleep(3000);
		Assert.assertEquals(nomeUsuario, driver.findElement(By.id("menuUserLink")).getText());
	}

	@Entao("^botao esta desabilitado$")
	public void botaoEstaDesabilitado() throws Throwable {
		Assert.assertFalse(formulario.verificarSeRegistrarEstaDisponivel());
	}

	@After
	public void finaliza() {

		fecharDriver();
	}
}
