package br.com.rsinet.hub_bdd.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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

	public void SelecionarProdutoDoCampo() throws InterruptedException {
		WebDriverWait wait =  new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(txtProdutoLupaNotebook));
		   
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", txtProdutoLupaNotebook);
		//txtProdutoLupaNotebook.click();
	}

}
