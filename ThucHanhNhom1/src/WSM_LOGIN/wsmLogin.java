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

<<<<<<< HEAD

=======
>>>>>>> Luyen update Login and add new logout
import util.CommonFunction;
import util.VariableSettings;

@Test
public class wsmLogin extends CommonFunction {

	public WebDriver driver;

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

		String actual = driver.getTitle();
		Assert.assertEquals(actual, titleHomePage);

	}

	@Test(priority = 1)
	public void TC01_loginTitle() {


		driver.findElement(By.xpath("/html/body/div[2]/div[3]/a")).click();
		String actual = driver.findElement(By.xpath("/html/body/div[2]/div[1]/label")).getText();
		Assert.assertEquals(actual, "LOGIN");

	}

	@Test(priority = 2)
	public void TC01_emailTextbox() {

		String actual = "";
		if (driver.findElement(By.id("user_email")).isDisplayed())
			actual = "TRUE";
		Assert.assertEquals(actual, "TRUE");

	}

	@Test(priority = 3)
	public void TC01_passTextbox() {


		String actual = "";
		if (driver.findElement(By.id("user_password")).isDisplayed())
			actual = "TRUE";
		Assert.assertEquals(actual, "TRUE");

	}

	@Test(priority = 4)
	public void TC01_OKbtn() {


		String actual = "";
		if (driver.findElement(By.xpath("/html/body/div[2]/div[1]/section/form/div[4]/button")).isDisplayed())
			actual = "TRUE";
		Assert.assertEquals(actual, "TRUE");

	}

	@Test(priority = 5)
	public void TC01_CANCELbtn() {


		String actual = "";

		if (driver.findElement(By.xpath("/html/body/div[2]/div[1]/section/form/div[4]/a")).isDisplayed())
			actual = "TRUE";
		Assert.assertEquals(actual, "TRUE");

	}

	@Test(priority = 6)
	public void TC01_Rememberbtn() {


		String actual = "";
		if (driver.findElement(By.xpath("/html/body/div[2]/div[1]/section/form/div[3]/label/span")).isDisplayed())
			actual = "TRUE";
		Assert.assertEquals(actual, "TRUE");

	}

	@Test(priority = 7)
	public void TC01_Forgotbtn() {

		String actual = "";

		if (driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/a")).isDisplayed())
			actual = "TRUE";
		Assert.assertEquals(actual, "TRUE");

	}

	@Test(priority = 8)
	public void TC02() {


		String actual = "";

		if (driver.findElement(By.id("user_remember_me")).isSelected())
			actual = "TRUE";

		Assert.assertEquals(actual, "FALSE");

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