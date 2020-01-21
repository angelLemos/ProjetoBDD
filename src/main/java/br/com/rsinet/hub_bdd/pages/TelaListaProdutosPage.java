package br.com.rsinet.hub_bdd.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class TelaListaProdutosPage {

	final WebDriver driver;

	@FindBy(how = How.ID, using = "31")
	private  WebElement txtProdutoDaTelaMouse;

	@FindBy(how = How.ID, using = "11")
	private WebElement txtProdutoLupaNotebook;

	public TelaListaProdutosPage(WebDriver driver) {
		this.driver = driver;
	}

	public void SelecionarProdutoDaTela() {
		txtProdutoDaTelaMouse.click();
	}

	public void SelecionarProdutoDoCampo() {
		txtProdutoLupaNotebook.click();
	}

}
