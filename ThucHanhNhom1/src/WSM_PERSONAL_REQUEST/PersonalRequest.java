package WSM_PERSONAL_REQUEST;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import util.CommonFunction;
import util.VariableSettings;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

@Test
public class PersonalRequest extends CommonFunction {

	public PersonalRequest() {
		// TODO Auto-generated constructor stub
	}

	@BeforeTest
	public void launchBrowser() throws InterruptedException {
		System.setProperty(VariableSettings.LIB_GECKO, VariableSettings.PATH_GECKO);
		driver = new FirefoxDriver();
		driver.get(VariableSettings.PATH_WEBTEST);
		login();

	}

	@Test(priority = 0)
	public void TC01_openOvertimeScreen() {
		driver.findElement(By.xpath("/html/body/div/div/div[1]/div/div/ul/li[4]/a/span")).click();
		driver.findElement(By.xpath("/html/body/div/div/div[1]/div/div/ul/li[4]/ul/li[1]/a")).click();
		String actual = driver.findElement(By.xpath("/html/body/div/div/div[2]/div[2]/h1")).getText();
		assertEquals(actual, titleOvertimeRequest);
	}

}
