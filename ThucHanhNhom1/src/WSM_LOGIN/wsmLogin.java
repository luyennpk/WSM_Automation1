package WSM_LOGIN;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import util.VariableSettings;

@Test
public class wsmLogin {

	public WebDriver driver;
	public String expected = null;
	public String actual = null;

	@BeforeTest
	public void launchBrowser() {
		System.setProperty(VariableSettings.LIB_GECKO, VariableSettings.PATH_GECKO);
		driver = new FirefoxDriver();
		driver.get(VariableSettings.PATH_WEBTEST);
	}

	/*
	 * @BeforeMethod public void verifyHomepageTitle() { String expectedTitle =
	 * "Working space"; String actualTitle = driver.getTitle();
	 * Assert.assertEquals(actualTitle, expectedTitle); }
	 */
	@Test(priority = 0)
	public void TC01_openpage() {

		expected = "Working space";
		actual = driver.getTitle();
		Assert.assertEquals(actual, expected);
	}

	@Test(priority = 1)
	public void TC01_loginTitle() {

		driver.findElement(By.xpath("//a[@class='wsm-btn btn-login']")).click();
		expected = "LOGIN";
		actual = driver.findElement(By.xpath("//label[@class='login-title'][contains(.,'LOGIN')]")).getText();
		Assert.assertEquals(actual, expected);
	}

	@Test(priority = 2)
	public void TC01_emailTextbox() {

		expected = "TRUE";

		if (driver.findElement(By.id("user_email")).isDisplayed())
			actual = "TRUE";
		Assert.assertEquals(actual, expected);
	}

	@Test(priority = 3)
	public void TC01_passTextbox() {

		expected = "TRUE";

		if (driver.findElement(By.id("user_password")).isDisplayed())
			actual = "TRUE";
		Assert.assertEquals(actual, expected);
	}

	@Test(priority = 4)
	public void TC01_OKbtn() {

		expected = "TRUE";

		if (driver.findElement(By.xpath("//button[@class='wsm-btn login-success']")).isDisplayed())
			actual = "TRUE";
		Assert.assertEquals(actual, expected);
	}

	@Test(priority = 5)
	public void TC01_CANCELbtn() {

		expected = "TRUE";

		if (driver.findElement(By.xpath("(//a[@class='wsm-btn login-cancel'])[1]")).isDisplayed())
			actual = "TRUE";
		Assert.assertEquals(actual, expected);
	}

	@Test(priority = 6)
	public void TC01_Rememberbtn() {

		expected = "TRUE";

		if (driver.findElement(By.xpath("//span[contains(@class,'span-remember')]")).isDisplayed())
			actual = "TRUE";
		Assert.assertEquals(actual, expected);
	}

	@Test(priority = 7)
	public void TC01_Forgotbtn() {

		expected = "TRUE";

		if (driver.findElement(By.xpath("//a[@class='btn-forgot-password'][contains(.,'Forgot password')]"))
				.isDisplayed())
			actual = "TRUE";
		System.out.println(actual);
		Assert.assertEquals(actual, expected);
	}

	@Test(priority = 8)
	public void TC02() {

		expected = "FALSE";

		if (driver.findElement(By.id("user_remember_me")).isSelected())
			actual = "TRUE";
		System.out.println(actual);
		Assert.assertEquals(actual, expected);
	}

	/*
	 * @AfterMethod public void goBackToHomepage() {
	 * driver.findElement(By.linkText("Home")).click(); }
	 * 
	 */

	@AfterTest
	public void terminateBrowser() {
		driver.close();
	}
}