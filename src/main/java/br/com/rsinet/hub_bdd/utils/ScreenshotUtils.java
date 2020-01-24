package br.com.rsinet.hub_bdd.utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.junit.Rule;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtils {

//	@Rule
//	public static String getTimeStamp() {
//		String timestamp = new SimpleDateFormat("ddMMyyyy_HHmmss").format(Calendar.getInstance().getTime());
//		return timestamp;
//	}

	public static String getScreenshot(WebDriver driver, String nomeScreen) {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		String caminhoDoArquivo = System.getProperty("user.dir") + "/Screenshot/" + nomeScreen + ".png";

		File destino = new File(caminhoDoArquivo);

		try {
			FileUtils.copyFile(src, destino);
		} catch (IOException e) {
			System.out.println(" O print falhou " + e.getMessage());
		}

		return caminhoDoArquivo;
	}
}