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
	public void TC01_loginTitle() throws InterruptedException {

		driver.findElement(By.xpath("/html/body/div[2]/div[3]/a")).click();
		Thread.sleep(10000);
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

		if (driver.findElement(By.id("user_remember_me")).isSelected())
			actual = "TRUE";

		Assert.assertEquals(actual, "FALSE");

	}

	@Test(priority = 9)
	public void TC03() {

		String actual = driver.findElement(By.id("user_password")).getAttribute("type");
		Assert.assertEquals(actual, "password");

	}

	@Test(priority = 10)
	public void TC06() throws InterruptedException {
		driver.get("https://edev.framgia.vn/en");
		Thread.sleep(10000);
		driver.findElement(By.xpath("/html/body/div[2]/div[3]/a")).click();
		driver.findElement(By.id("user_email")).sendKeys(userEmail);
		driver.findElement(By.id("user_password")).sendKeys(userPassword);
		driver.findElement(By.xpath("/html/body/div[2]/div[1]/section/form/div[4]/button")).click();
		Thread.sleep(10000);
		String actual = driver.findElement(By.xpath("/html/body/div/div/div[2]/div[2]/div[1]")).getText();
		String[] parts = actual.split("\n");
		actual = parts[1];
		System.out.print(actual);
		Assert.assertEquals(actual, loginSuccessfullyMesssage);

	}

	@Test(priority = 11)
	public void TC07() {

		String actualTitle = driver.findElement(By.xpath("/html/body/div/div/div[2]/div[2]/div[2]/div[1]/div[2]/h1"))
				.getText();
		Assert.assertEquals(actualTitle, titleTimeSheet);

	}

	@Test(priority = 12)
	public void TC08() {
		driver.navigate().back();
		driver.get("https://edev.framgia.vn/vi/dashboard/user_timesheets");
		String actualTitle = driver.findElement(By.xpath("/html/body/div/div/div[2]/div[2]/div[2]/div[1]/div[2]/h1"))
				.getText();
		Assert.assertEquals(actualTitle, titleTimeSheet);

	}

	@Test(priority = 13)
	public void TC09() {

		driver.get("https://google.com.vn");
		driver.get("https://edev.framgia.vn/vi/dashboard/user_timesheets");
		driver.manage().window().maximize();
		String actualTitle = driver.findElement(By.xpath("/html/body/div/div/div[2]/div[2]/div[2]/div[1]/div[2]/h1"))
				.getText();
		Assert.assertEquals(actualTitle, titleTimeSheet);

	}

	@Test(priority = 14)
	public void TC10() {

		driver.close();
		driver = new FirefoxDriver();
		driver.get("https://edev.framgia.vn/en");
		driver.manage().window().maximize();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Click on Login
		driver.findElement(By.xpath("//a[@class='wsm-btn btn-login']")).click();
		// Enter email
		driver.findElement(By.id("user_email")).sendKeys("");
		// Enter pass
		driver.findElement(By.id("user_password")).sendKeys("");

		// click on OK
		driver.findElement(By.xpath("//button[@class='wsm-btn login-success']")).click();
		Boolean expected = true;
		Boolean actual = driver.findElement(By.xpath("//p[contains(.,'Email is required')]")).isDisplayed()
				&& driver.findElement(By.xpath("//p[contains(.,'Password is required')]")).isDisplayed();
		Assert.assertEquals(actual, expected);

	}

	@Test(priority = 15)
	public void TC11() {

		// Enter email
		driver.findElement(By.id("user_email")).sendKeys("abc@framgia.com");
		// Enter pass
		driver.findElement(By.id("user_password")).sendKeys("Framgia123");

		// click on OK
		driver.findElement(By.xpath("//button[@class='wsm-btn login-success']")).click();
		Boolean expected = true;
		Boolean actual = driver
				.findElement(By.xpath("//p[@class='alert alert-danger'][contains(.,'Invalid email or password.')]"))
				.isDisplayed();
		Assert.assertEquals(actual, expected);

	}

	@Test(priority = 16)
	public void TC12() {

		// Enter email
		driver.findElement(By.id("user_email")).sendKeys("dinhbatung@framgia.com");
		// Enter pass
		driver.findElement(By.id("user_password")).sendKeys("Framgia123");

		// click on OK
		driver.findElement(By.xpath("//button[@class='wsm-btn login-success']")).click();
		Boolean expected = true;
		Boolean actual = driver
				.findElement(By.xpath("//p[@class='alert alert-danger'][contains(.,'Invalid email or password.')]"))
				.isDisplayed();
		Assert.assertEquals(actual, expected);

	}

	@Test(priority = 17)
	public void TC13() {

		// Enter email
		driver.findElement(By.id("user_email")).sendKeys("dinhbatung@framgia.com");
		// Enter pass
		driver.findElement(By.id("user_password")).sendKeys("Framgia123");

		// click on OK
		driver.findElement(By.xpath("//button[@class='wsm-btn login-success']")).click();
		Boolean expected = true;
		Boolean actual = driver.findElement(By.xpath("//p[contains(.,'Please enter a valid email address')]"))
				.isDisplayed();
		Assert.assertEquals(actual, expected);

	}

	/*
	 * @AfterMethod public void goBackToHomepage() {
	 * driver.findElement(By.linkText("Home")).click(); }
	 * 
	 */

	// @AfterTest
	// public void terminateBrowser() {
	// driver.close();
	// }
}