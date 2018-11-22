package WSM_FORGOT_PASSWORD;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import util.CommonFunction;
import util.VariableSettings;

public class ForgotPassword extends CommonFunction {

	public ForgotPassword() {
		// TODO Auto-generated constructor stub
	}

	@BeforeTest
	public void launchBrowser() throws InterruptedException {
		System.setProperty(VariableSettings.LIB_GECKO, VariableSettings.PATH_GECKO);
		driver = new FirefoxDriver();
		driver.get(VariableSettings.PATH_WEBTEST);
		Thread.sleep(10000);

	}

	/*
	 * @BeforeMethod public void verifyHomepageTitle() { String expectedTitle =
	 * "Working space"; String actualTitle = driver.getTitle();
	 * Assert.assertEquals(actualTitle, expectedTitle); }
	 */

//	@Test(priority = 0)
//	public void TC01_ForgotScr() throws InterruptedException {
//		String expected = null;
//		String actual = null;
//
//		driver.findElement(By.xpath("/html/body/div[2]/div[3]/a")).click();
//		Thread.sleep(10000);
//		driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/a")).click();
//		Thread.sleep(10000);
//		expected = "FORGOT PASSWORD";
//		actual = driver.findElement(By.xpath("/html/body/div[2]/div[2]/label")).getText();
//		System.out.println(actual);
//		Assert.assertEquals(actual, expected);
//	}

//	@Test(priority = 1)
//	public void TC02_ForgotTitle() {
//		try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		String expected = null;
//		String actual = null;
//		expected = "FORGOT PASSWORD";
//		actual = driver.findElement(By.xpath("/html/body/div[2]/div[2]/label")).getText();
//		System.out.println(actual);
//		Assert.assertEquals(actual, expected);
//	}
//
//	@Test(priority = 3)
//	public void TC02_ForgotOKbtn() throws InterruptedException {
//		Boolean bexpected = true;
//		Thread.sleep(10000);
//		Boolean bactual = driver.findElement(By.xpath("/html/body/div[2]/div[2]/section/form/div[2]/button"))
//				.isDisplayed();
//		Assert.assertEquals(bactual, bexpected);
//	}
//
//	@Test(priority = 4)
//	public void TC02_ForgotCancelbtn() throws InterruptedException {
//		Boolean bexpected = true;
//		Thread.sleep(15000);
//		Boolean bactual = driver.findElement(By.xpath("/html/body/div[2]/div[2]/section/form/div[2]/a")).isDisplayed();
//		Assert.assertEquals(bactual, bexpected);
//	}
//
//	@Test(priority = 5)
//	public void TC02_ForgotBackbtn() throws InterruptedException {
//
//		Boolean bexpected = true;
//		Thread.sleep(10000);
//		Boolean bactual = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/a")).isDisplayed();
//		Assert.assertEquals(bactual, bexpected);
//	}
//
//	 @Test(priority = 6)
//	 public void TC04_BackToLogin() throws InterruptedException {
//	 	
//	 String expected = null;
//	 String actual = null;
//	 Thread.sleep(10000);
//	 driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/a")).click();
//	 Thread.sleep(10000);	
//	 expected = "LOGIN";
//	 actual =
//	 driver.findElement(By.xpath("/html/body/div[2]/div[1]/label")).getText();
//	 System.out.println(actual);
//	 Assert.assertEquals(actual, expected);	
//	 }
//	
//	 @Test(priority = 7)
//	 public void TC05_SentMessage() throws InterruptedException {
//	 
//	 Thread.sleep(10000);	 
//	
//	 String actual = null;
//	 //driver.findElement(By.xpath("//a[contains(.,'Forgot password')]")).click();
//	 
//	 Thread.sleep(10000);
//	 
//	 driver.findElement(By.xpath("(//input[@required='required'][contains(@id,'email')])[2]")).sendKeys("hoang.thi.mai@framgia.com.edev");
//	 driver.findElement(By.xpath("/html/body/div[2]/div[2]/section/form/div[2]/button")).click();
//	 
//	 Thread.sleep(5000);
//	
//	 actual = driver.findElement(By.xpath("/html/body/div[2]/div[2]/section/div")).getText();
//	 System.out.println(actual);
//	 Assert.assertEquals(actual, sentMailResetPasswordSuccessfully);
//	
//	 }
	
	 @Test(priority = 8)
	 public void TC06_BackToLogin() throws InterruptedException {
	 driver.get("http://www.yopmail.com/en/tungtestauto");
	 Thread.sleep(3000);
	 driver.switchTo().frame("ifmail");
	 driver.findElement(By.xpath("//a[@class='link-website']")).click();
	 }

}
