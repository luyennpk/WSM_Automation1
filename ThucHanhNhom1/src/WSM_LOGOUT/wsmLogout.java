package WSM_LOGOUT;

import org.apache.xalan.xsltc.compiler.sym;
>>>>>>> Luyen update Login and add new logout
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import util.CommonFunction;
import util.VariableSettings;

@Test
public class wsmLogout extends CommonFunction {

	// public WebDriver driver;
	// public String expected = null;
	

	@BeforeTest
	public void launchBrowser() throws InterruptedException {
		System.setProperty(VariableSettings.LIB_GECKO, VariableSettings.PATH_GECKO);
		driver = new FirefoxDriver();
		driver.get(VariableSettings.PATH_WEBTEST);
		login();
		Thread.sleep(10000);
		logout();
	}

	@Test(priority = 0)
	public void TC01_MessageLogout() {
		WebElement message = driver.findElement(By.id("flash-message"));
		String actual = message.getText();
		Assert.assertEquals(actual, logoutSuccessfullyMessage);
	}

	@Test(priority = 1)
	public void TC02_LoginScreen() {
		String actual = driver.findElement(By.className("wsm-slogan")).getText();
		Assert.assertEquals(actual, titleLogin);
	}

	@Test(priority = 2)
	public void TC03_ErrorMessage() throws InterruptedException {
		driver.get("https://wsm.framgia.vn/en/dashboard/user_settings/edit");
		WebElement message = driver.findElement(By.id("flash-message"));
		String actual = message.getText();
		Assert.assertEquals(actual, requiredLoginMesssage);
	}

	@Test(priority = 3)
	public void TC04_LogoutAtAnyPage() throws InterruptedException {
		driver.close();
		driver = new FirefoxDriver();
		driver.get(VariableSettings.PATH_WEBTEST);
		login();
		Thread.sleep(10000);
		driver.get("https://edev.framgia.vn/en/dashboard/user_settings/edit");
		Thread.sleep(10000);
		logout();
		TC01_MessageLogout();
		TC02_LoginScreen();
	}

	@Test(priority = 4)
	public void TC05_NavigateAfterLogout() {
		driver.navigate().back();
		String actual = driver.getCurrentUrl().toString();
		Assert.assertEquals(actual, VariableSettings.PATH_WEBTEST);
	}

}
