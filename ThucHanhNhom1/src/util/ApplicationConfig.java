package util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public final class  ApplicationConfig {
	private WebDriver driver;

	ApplicationConfig() {
		init_driver();
		this.driver = new FirefoxDriver();
	}

	public void init_driver() {
		System.setProperty(VariableSettings.LIB_GECKO, VariableSettings.PATH_GECKO);
	}

	public void quite() {
		driver.quit();
	}

	public WebDriver getDriver() {
		return driver;
	}
}
