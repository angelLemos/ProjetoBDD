package br.com.rsinet.hub_bdd.runners;

import java.io.File;


import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/features",
		glue= {"br.com.rsinet.hub_bdd.steps"},
		tags = {"@CriarCadastroComSucesso"},
		plugin = {"pretty" , "com.cucumber.listener.ExtentCucumberFormatter:Reports/reportTestes.html"},
	
		//exibir a sa�da do console de maneira muito leg�vel
		monochrome = true,

		snippets = SnippetType.CAMELCASE,
		//verifica se todas as etapas possuem a defini��o de etapa
		dryRun = false,

        //falhar� na execu��o se houver etapas indefinidas ou pendentes
		strict = false
		)
public class Runner {

	 @AfterClass
	 public static void writeExtentReport() {
	 Reporter.loadXMLConfig(new File("./extension-config.xml"));
	 }
}

