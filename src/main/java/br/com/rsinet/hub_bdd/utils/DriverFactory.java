package br.com.rsinet.hub_bdd.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {

	static WebDriver driver;

	private DriverFactory() {
	}

	public static WebDriver inicializarDriver() {
		if (driver == null) {
			driver = new ChromeDriver();
		}
		return driver;
	}

	public static void fecharDriver() {
		if (driver != null)
			driver.quit();
		driver = null;
	}
}
