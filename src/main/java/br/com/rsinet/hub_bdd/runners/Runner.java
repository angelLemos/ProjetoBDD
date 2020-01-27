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
		//tags = {"@pesquisarProdutoInexistente"},
		plugin = {"pretty" , "com.cucumber.listener.ExtentCucumberFormatter:Reports/reportTestes.html"},
		monochrome = true,
		snippets = SnippetType.CAMELCASE,
		dryRun = false,
		strict = false
		)
public class Runner {

	 @AfterClass
	 public static void writeExtentReport() {
	 Reporter.loadXMLConfig(new File("./extension-config.xml"));
	 }
}

