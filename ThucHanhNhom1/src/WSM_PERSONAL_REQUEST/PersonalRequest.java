package WSM_PERSONAL_REQUEST;

import org.junit.After;
import org.omg.CORBA.Current;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import util.CommonFunction;
import util.VariableSettings;

import static org.testng.Assert.assertEquals;

import java.awt.print.Printable;

import javax.print.attribute.standard.DateTimeAtCompleted;

import org.testng.annotations.Test;

import bsh.StringUtil;

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
		Thread.sleep(10000);

	}

	@Test(priority = 0)
	public void TC01_openOvertimeScreen() {
		driver.findElement(By.xpath("/html/body/div/div/div[1]/div/div/ul/li[4]/a/span")).click();
		driver.findElement(By.xpath("/html/body/div/div/div[1]/div/div/ul/li[4]/ul/li[1]/a")).click();
		String actual = driver.findElement(By.xpath("/html/body/div/div/div[2]/div[2]/h1")).getText();
		assertEquals(actual, titleOvertimeRequest);
	}

	@Test(priority = 1)
	public void TC02_openOvertimeScreenWithoutLogin() {
		logout();
		driver.get("https://edev.framgia.vn/en/dashboard/users/805/request_ots");
		String actual = driver.getCurrentUrl().toString();
		Assert.assertEquals(actual, "https://edev.framgia.vn/users/sign_in");
	}

	@Test(priority = 2)
	public void TC03_newOverTimeRequestScreenTitle() throws InterruptedException {
		Thread.sleep(10000);
		login();
		Thread.sleep(10000);
		driver.get("https://edev.framgia.vn/en/dashboard/users/805/request_ots");
		driver.findElement(By.xpath("/html/body/div/div/div[2]/div[2]/div[2]/a")).click();
		String actual = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div[2]/div/div/div[1]/h3"))
				.getText();
		Assert.assertEquals(actual, titleNewOvertimeRequest);
	}

	@Test(priority = 3)
	public void TC04_checkTheFieldOnNewRequestForm_StaffName() {
		checkNameOfITem("/html/body/div[1]/div/div[2]/div[2]/div[2]/div/div/div[2]/form/div[1]/div[1]/label",
				"Staff name");
		String actual = "";
		if (driver.findElement(By.id("employee_name")).isDisplayed())
			actual = "TRUE";
		Assert.assertEquals(actual, "TRUE");
	}

	@Test(priority = 4)
	public void TC04_checkTheFieldOnNewRequestForm_StaffCode() {
		checkNameOfITem("/html/body/div[1]/div/div[2]/div[2]/div[2]/div/div/div[2]/form/div[1]/div[2]/label",
				"Staff code");
		String actual = "";
		if (driver.findElement(By.id("employee_code")).isDisplayed())
			actual = "TRUE";
		Assert.assertEquals(actual, "TRUE");
	}

	@Test(priority = 5)
	public void TC04_checkTheFieldOnNewRequestForm_Branch() {
		checkNameOfITem("/html/body/div[1]/div/div[2]/div[2]/div[2]/div/div/div[2]/form/div[2]/div[1]/div/label",
				"Branch");
		String actual = "";
		if (driver.findElement(By.id("s2id_request_ot_workspace_id")).isDisplayed())
			actual = "TRUE";
		Assert.assertEquals(actual, "TRUE");
	}

	@Test(priority = 6)
	public void TC04_checkTheFieldOnNewRequestForm_Group() {
		checkNameOfITem("/html/body/div[1]/div/div[2]/div[2]/div[2]/div/div/div[2]/form/div[2]/div[2]/div/label",
				"Group");
		String actual = "";
		if (driver.findElement(By.id("s2id_group-selection")).isDisplayed())
			actual = "TRUE";
		Assert.assertEquals(actual, "TRUE");
	}

	@Test(priority = 7)
	public void TC04_checkTheFieldOnNewRequestForm_OTForOtherGroup() {
		checkNameOfITem("/html/body/div[1]/div/div[2]/div[2]/div[2]/div/div/div[2]/form/div[3]/label/span",
				"Do you OT for other group?");
		String actual = "";
		if (driver
				.findElement(
						By.xpath("/html/body/div[1]/div/div[2]/div[2]/div[2]/div/div/div[2]/form/div[3]/label/span"))
				.isDisplayed())
			actual = "TRUE";
		Assert.assertEquals(actual, "TRUE");

	}

	@Test(priority = 8)
	public void TC04_checkTheFieldOnNewRequestForm_From() {
		checkNameOfITem("/html/body/div[1]/div/div[2]/div[2]/div[2]/div/div/div[2]/form/div[6]/div[1]/label", "From");
		String actual = "";
		if (driver.findElement(By.id("request_ot_from_time")).isDisplayed())
			actual = "TRUE";
		Assert.assertEquals(actual, "TRUE");

	}

	@Test(priority = 9)
	public void TC04_checkTheFieldOnNewRequestForm_To() {
		checkNameOfITem("/html/body/div[1]/div/div[2]/div[2]/div[2]/div/div/div[2]/form/div[6]/div[2]/label", "To");
		String actual = "";
		if (driver.findElement(By.id("request_ot_end_time")).isDisplayed())
			actual = "TRUE";
		Assert.assertEquals(actual, "TRUE");

	}

	@Test(priority = 10)
	public void TC04_checkTheFieldOnNewRequestForm_Reason() {
		checkNameOfITem("/html/body/div[1]/div/div[2]/div[2]/div[2]/div/div/div[2]/form/div[7]/label", "Reason");
		String actual = "";
		if (driver.findElement(By.id("request_ot_reason")).isDisplayed())
			actual = "TRUE";
		Assert.assertEquals(actual, "TRUE");

	}

	@Test(priority = 11)
	public void TC05_checkTheFieldOnNewRequestForm_OTForOtherGroupDefaultValue() {
		String actual = "";
		if (driver.findElement(By.id("choose_other_group")).isSelected())
			actual = "TRUE";
		else
			actual = "FALSE";
		Assert.assertEquals(actual, "FALSE");

	}

	@Test(priority = 12)
	public void TC06_checkTheFieldOnNewRequestForm_StaffNameValue() {
		String expected = "Hoang Thi Mai";
		String actual = driver.findElement(By.cssSelector("#employee_name")).getAttribute("value");
		Assert.assertEquals(actual, expected);

	}

	@Test(priority = 13)
	public void TC07_checkTheFieldOnNewRequestForm_StaffCodeValue() {
		String expected = "P120057";
		String actual = driver.findElement(By.cssSelector("#employee_code")).getAttribute("value");
		Assert.assertEquals(actual, expected);

	}

	@Test(priority = 14)
	public void TC08_checkTheFieldOnNewRequestForm_BranchValue() {
		String expected = "Da Nang Office";
		String actual = driver.findElement(By.xpath("//*[@id=\"select2-chosen-1\"]")).getText();
		Assert.assertEquals(actual, expected);

	}

	@Test(priority = 15)
	public void TC09_checkTheFieldOnNewRequestForm_OtherGroup() {
		driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div[2]/div/div/div[2]/form/div[3]/label/span"))
				.click();
		String actual = "";
		if (driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div[2]/div/div/div[2]/form/div[4]/label"))
				.isDisplayed())
			actual = "TRUE";
		Assert.assertEquals(actual, "TRUE");
	}

	@Test(priority = 16)
	public void TC10_checkTheFieldOnNewRequestForm_OtherGroupData() {
		driver.get("https://edev.framgia.vn/en/dashboard/users/805/request_ots");
		driver.findElement(By.xpath("/html/body/div/div/div[2]/div[2]/div[2]/a")).click();
		WebElement OTForOtherGroup = driver.findElement(
				By.xpath("/html/body/div[1]/div/div[2]/div[2]/div[2]/div/div/div[2]/form/div[3]/label/span"));
		// if (!(OTForOtherGroup.isSelected()))
		OTForOtherGroup.click();

		driver.findElement(By.xpath("//*[@id=\"s2id_request_ot_other_group_id\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"s2id_autogen3_search\"]")).sendKeys("Back office");
		driver.findElement(By.xpath("//*[@id=\"select2-results-3\"]")).click();
		String actual = driver.findElement(By.xpath("//*[@id=\"s2id_request_ot_other_group_id\"]")).getText();
		String[] parts = actual.split("\n");
		actual = parts[0];
		Assert.assertEquals(actual, "Back office");

	}

	@Test(priority = 17)
	public void TC11_createOTRequest_OTForCurrentGroupSuccessfully() throws InterruptedException {
		driver.get("https://edev.framgia.vn/en/dashboard/users/805/request_ots");
		driver.findElement(By.xpath("/html/body/div/div/div[2]/div[2]/div[2]/a")).click();
		WebElement OTForOtherGroup = driver.findElement(
				By.xpath("/html/body/div[1]/div/div[2]/div[2]/div[2]/div/div/div[2]/form/div[3]/label/span"));
		if (OTForOtherGroup.isSelected())
			OTForOtherGroup.click();

		driver.findElement(By.id("request_ot_project_name")).sendKeys("Automation");

		WebElement toDate = driver.findElement(By.xpath("//*[@id='request_ot_end_time']"));
		toDate.sendKeys("2020/02/10 18:20");
		Thread.sleep(1000);

		WebElement fromDate = driver.findElement(By.xpath("//*[@id='request_ot_from_time']"));
		fromDate.sendKeys("2020/02/10 18:11");
		Thread.sleep(1000);

		driver.findElement(By.id("request_ot_reason")).sendKeys("test");
		driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div[2]/div/div/div[2]/form/input[3]")).click();
		// Thread.sleep(3000);
		String actual = driver.findElement(By.xpath("//*[@id=\"flash-message\"]")).getText();
		String[] message = actual.split("×");
		actual = message[1].replace("\n", "");

		Assert.assertEquals(actual, createOTRequestSucessfully);

	}

	@Test(priority = 18)
	public void TC12_createOTRequest_OTForOtherGroupSuccessfully() throws InterruptedException {
		driver.get("https://edev.framgia.vn/en/dashboard/users/805/request_ots");
		driver.findElement(By.xpath("/html/body/div/div/div[2]/div[2]/div[2]/a")).click();
		WebElement OTForOtherGroup = driver.findElement(
				By.xpath("/html/body/div[1]/div/div[2]/div[2]/div[2]/div/div/div[2]/form/div[3]/label/span"));
		if (!OTForOtherGroup.isSelected())

			OTForOtherGroup.click();
		Thread.sleep(1000);

		driver.findElement(By.xpath("//*[@id=\"s2id_request_ot_other_group_id\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"s2id_autogen3_search\"]")).sendKeys("Back office");
		driver.findElement(By.xpath("//*[@id=\"select2-results-3\"]")).click();

		driver.findElement(By.id("request_ot_project_name")).sendKeys("Automation");

		WebElement toDate = driver.findElement(By.xpath("//*[@id='request_ot_end_time']"));
		toDate.sendKeys("2020/02/11 18:20");
		Thread.sleep(1000);

		WebElement fromDate = driver.findElement(By.xpath("//*[@id='request_ot_from_time']"));
		fromDate.sendKeys("2020/02/11 18:11");
		Thread.sleep(1000);
		driver.findElement(By.id("request_ot_reason")).sendKeys("test");
		driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div[2]/div/div/div[2]/form/input[3]")).click();
		String actual = driver.findElement(By.xpath("//*[@id=\"flash-message\"]")).getText();
		String[] message = actual.split("×");
		actual = message[1].replace("\n", "");
		Assert.assertEquals(actual, createOTRequestSucessfully);

	}

	@Test(priority = 19)
	public void TC13_createOTRequest_OTForCurrentGroupThisMonthSuccessfully() throws InterruptedException {
		driver.get("https://edev.framgia.vn/en/dashboard/users/805/request_ots");
		driver.findElement(By.xpath("/html/body/div/div/div[2]/div[2]/div[2]/a")).click();
		WebElement OTForOtherGroup = driver.findElement(
				By.xpath("/html/body/div[1]/div/div[2]/div[2]/div[2]/div/div/div[2]/form/div[3]/label/span"));
		if (OTForOtherGroup.isSelected())
			OTForOtherGroup.click();

		driver.findElement(By.id("request_ot_project_name")).sendKeys("Automation");

		WebElement toDate = driver.findElement(By.xpath("//*[@id='request_ot_end_time']"));
		toDate.sendKeys("2018/11/10 19:20");
		Thread.sleep(1000);

		WebElement fromDate = driver.findElement(By.xpath("//*[@id='request_ot_from_time']"));
		fromDate.sendKeys("2018/11/10 19:10");
		Thread.sleep(1000);

		driver.findElement(By.id("request_ot_reason")).sendKeys("test");
		driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div[2]/div/div/div[2]/form/input[3]")).click();
		String actual = driver.findElement(By.xpath("//*[@id=\"flash-message\"]")).getText();
		String[] message = actual.split("×");
		actual = message[1].replace("\n", "");
		Assert.assertEquals(actual, createOTRequestSucessfully);

	}

	@Test(priority = 20)
	public void TC14_createOTRequest_OTForCurrentGroupFutureSuccessfully() throws InterruptedException {
		driver.get("https://edev.framgia.vn/en/dashboard/users/805/request_ots");
		driver.findElement(By.xpath("/html/body/div/div/div[2]/div[2]/div[2]/a")).click();
		WebElement OTForOtherGroup = driver.findElement(
				By.xpath("/html/body/div[1]/div/div[2]/div[2]/div[2]/div/div/div[2]/form/div[3]/label/span"));
		if (OTForOtherGroup.isSelected())
			OTForOtherGroup.click();

		driver.findElement(By.id("request_ot_project_name")).sendKeys("Automation");

		WebElement toDate = driver.findElement(By.xpath("//*[@id='request_ot_end_time']"));
		toDate.sendKeys("2020/02/12 18:59");
		Thread.sleep(1000);

		WebElement fromDate = driver.findElement(By.xpath("//*[@id='request_ot_from_time']"));
		fromDate.sendKeys("2020/02/12 18:51");
		Thread.sleep(1000);

		driver.findElement(By.id("request_ot_reason")).sendKeys("test");
		driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div[2]/div/div/div[2]/form/input[3]")).click();
		String actual = driver.findElement(By.xpath("//*[@id=\"flash-message\"]")).getText();
		String[] message = actual.split("×");
		actual = message[1].replace("\n", "");
		Assert.assertEquals(actual, createOTRequestSucessfully);

	}

	@Test(priority = 21)
	public void TC15_createOTRequest_AfterSaveButton() throws InterruptedException {
		driver.get("https://edev.framgia.vn/en/dashboard/users/805/request_ots");
		driver.findElement(By.xpath("/html/body/div/div/div[2]/div[2]/div[2]/a")).click();
		WebElement OTForOtherGroup = driver.findElement(
				By.xpath("/html/body/div[1]/div/div[2]/div[2]/div[2]/div/div/div[2]/form/div[3]/label/span"));
		if (OTForOtherGroup.isSelected())
			OTForOtherGroup.click();

		driver.findElement(By.id("request_ot_project_name")).sendKeys("Automation");

		WebElement toDate = driver.findElement(By.xpath("//*[@id='request_ot_end_time']"));
		toDate.sendKeys("2020/02/13 18:50");
		Thread.sleep(1000);

		WebElement fromDate = driver.findElement(By.xpath("//*[@id='request_ot_from_time']"));
		fromDate.sendKeys("2020/02/13 18:41");
		Thread.sleep(1000);

		driver.findElement(By.id("request_ot_reason")).sendKeys("test");
		driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div[2]/div/div/div[2]/form/input[3]")).click();
		Thread.sleep(3000);
		String actual = driver.findElement(By.xpath("/html/body/div/div/div[2]/div[2]/h1")).getText();
		Assert.assertEquals(actual, titleOvertimeRequest);

	}

	@Test(priority = 22)
	public void TC16_createOTRequest_CheckFirstRecord() throws InterruptedException {
		driver.get("https://edev.framgia.vn/en/dashboard/users/805/request_ots");
		driver.findElement(By.xpath("/html/body/div/div/div[2]/div[2]/div[2]/a")).click();
		WebElement OTForOtherGroup = driver.findElement(
				By.xpath("/html/body/div[1]/div/div[2]/div[2]/div[2]/div/div/div[2]/form/div[3]/label/span"));
		if (OTForOtherGroup.isSelected())
			OTForOtherGroup.click();

		driver.findElement(By.id("request_ot_project_name")).sendKeys("Automation");

		WebElement toDate = driver.findElement(By.xpath("//*[@id='request_ot_end_time']"));
		toDate.sendKeys("2020/02/14 19:10");
		Thread.sleep(1000);

		WebElement fromDate = driver.findElement(By.xpath("//*[@id='request_ot_from_time']"));
		fromDate.sendKeys("2020/02/14 19:00");
		Thread.sleep(1000);

		driver.findElement(By.id("request_ot_reason")).sendKeys("test");
		driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div[2]/div/div/div[2]/form/input[3]")).click();
		Thread.sleep(3000);

		// Open edit screen
		driver.findElement(
				By.xpath("/html/body/div/div/div[2]/div[2]/div[4]/div[1]/div[2]/div/table/tbody/tr[1]/td[11]/a[1]"))
				.click();

		// // Check Time on edit screen

		String toDateValue = driver.findElement(By.xpath("//*[@id='request_ot_end_time']")).getAttribute("value");
		Thread.sleep(1000);
		Assert.assertEquals(toDateValue, "2020/02/14 19:10");

		String fromDateValue = driver.findElement(By.xpath("//*[@id='request_ot_from_time']")).getAttribute("value");
		Thread.sleep(1000);
		Assert.assertEquals(fromDateValue, "2020/02/14 19:00");

	}

	@Test(priority = 23)
	public void TC17_createOTRequest_CheckFirstRecordData() throws InterruptedException {
		driver.get("https://edev.framgia.vn/en/dashboard/users/805/request_ots");
		driver.findElement(By.xpath("/html/body/div/div/div[2]/div[2]/div[2]/a")).click();

		String staffName = "Hoang Thi Mai";
		String employeeCode = "P120057";
		String projectName = "Automation";
		String toDateValue = "2020/02/15 23:00";
		String fromDateValue = "2020/02/15 22:00";
		String reason = "test";
		String status = "Pending";
		String beingHandleBy = "Education section(Hoang Dang Khanh, Hoang Nhac Trung, Pham Van Chien, Nguyen Van Giang, Nguyen Binh Dieu)";
		String requestHours = "1.0";

		WebElement OTForOtherGroup = driver.findElement(
				By.xpath("/html/body/div[1]/div/div[2]/div[2]/div[2]/div/div/div[2]/form/div[3]/label/span"));
		if (OTForOtherGroup.isSelected())
			OTForOtherGroup.click();

		driver.findElement(By.id("request_ot_project_name")).sendKeys(projectName);

		WebElement toDate = driver.findElement(By.xpath("//*[@id='request_ot_end_time']"));
		toDate.sendKeys(toDateValue);
		Thread.sleep(1000);

		WebElement fromDate = driver.findElement(By.xpath("//*[@id='request_ot_from_time']"));
		fromDate.sendKeys(fromDateValue);
		Thread.sleep(1000);

		driver.findElement(By.id("request_ot_reason")).sendKeys(reason);
		driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div[2]/div/div/div[2]/form/input[3]")).click();
		Thread.sleep(3000);

		// check data of the first record
		Assert.assertEquals(staffName,
				driver.findElement(
						By.xpath("/html/body/div/div/div[2]/div[2]/div[4]/div[1]/div[2]/div/table/tbody/tr[1]/td[2]"))
						.getText());
		Assert.assertEquals(employeeCode,
				driver.findElement(
						By.xpath("/html/body/div/div/div[2]/div[2]/div[4]/div[1]/div[2]/div/table/tbody/tr[1]/td[1]"))
						.getText());
		Assert.assertEquals(projectName,
				driver.findElement(
						By.xpath("/html/body/div/div/div[2]/div[2]/div[4]/div[1]/div[2]/div/table/tbody/tr[1]/td[6]"))
						.getText());
		Assert.assertEquals(reason,
				driver.findElement(
						By.xpath("/html/body/div/div/div[2]/div[2]/div[4]/div[1]/div[2]/div/table/tbody/tr[1]/td[7]"))
						.getText());
		Assert.assertEquals(status,
				driver.findElement(By.xpath(
						"/html/body/div/div/div[2]/div[2]/div[4]/div[1]/div[2]/div/table/tbody/tr[1]/td[8]/span"))
						.getText());
		Assert.assertEquals(beingHandleBy,
				driver.findElement(
						By.xpath("/html/body/div/div/div[2]/div[2]/div[4]/div[1]/div[2]/div/table/tbody/tr[1]/td[9]"))
						.getText());
		Assert.assertEquals(requestHours,
				driver.findElement(
						By.xpath("/html/body/div/div/div[2]/div[2]/div[4]/div[1]/div[2]/div/table/tbody/tr[1]/td[10]"))
						.getText());

		// check the action icon
		Boolean editIconAvailable = driver
				.findElement(By.xpath(
						"/html/body/div/div/div[2]/div[2]/div[4]/div[1]/div[2]/div/table/tbody/tr[1]/td[11]/a[1]/i"))
				.isDisplayed();
		Assert.assertEquals(editIconAvailable.toString(), "true");
		Boolean viewIconAvailable = driver
				.findElement(By.xpath(
						"/html/body/div/div/div[2]/div[2]/div[4]/div[1]/div[2]/div/table/tbody/tr[1]/td[11]/button"))
				.isDisplayed();
		Assert.assertEquals(viewIconAvailable.toString(), "true");
		Boolean deleteIconAvailable = driver
				.findElement(By.xpath(
						"/html/body/div/div/div[2]/div[2]/div[4]/div[1]/div[2]/div/table/tbody/tr[1]/td[11]/a[2]/i"))
				.isDisplayed();
		Assert.assertEquals(deleteIconAvailable.toString(), "true");

		// Check Date From-To
		String[] fromDateTimeSplit = fromDateValue.split(" ");
		String[] fromDateSplit = fromDateTimeSplit[0].split("/");
		String expectedFromDate = fromDateTimeSplit[1] + " " + fromDateSplit[1] + "-" + fromDateSplit[2] + "-"
				+ fromDateSplit[0];
		Assert.assertEquals(expectedFromDate,
				driver.findElement(
						By.xpath("/html/body/div/div/div[2]/div[2]/div[4]/div[1]/div[2]/div/table/tbody/tr[1]/td[4]"))
						.getText());

		String[] toDateTimeSplit = toDateValue.split(" ");
		String[] toDateSplit = toDateTimeSplit[0].split("/");
		String expectedtoDate = toDateTimeSplit[1] + " " + toDateSplit[1] + "-" + toDateSplit[2] + "-" + toDateSplit[0];
		Assert.assertEquals(expectedtoDate,
				driver.findElement(
						By.xpath("/html/body/div/div/div[2]/div[2]/div[4]/div[1]/div[2]/div/table/tbody/tr[1]/td[5]"))
						.getText());

	}

	@Test(priority = 24)
	public void TC18_createOTRequestUnsuccessfully_TimeInThePast() throws InterruptedException {

		// driver.findElement(By.xpath("/html/body/div/div/div[2]/div[2]/div[2]/a")).click();
		WebElement OTForOtherGroup = driver.findElement(
				By.xpath("/html/body/div[1]/div/div[2]/div[2]/div[2]/div/div/div[2]/form/div[3]/label/span"));
		if (OTForOtherGroup.isSelected())
			OTForOtherGroup.click();

		driver.findElement(By.id("request_ot_project_name")).sendKeys("Automation");

		WebElement toDate = driver.findElement(By.xpath("//*[@id='request_ot_end_time']"));
		toDate.sendKeys("2018/07/03 21:00");
		Thread.sleep(1000);

		WebElement fromDate = driver.findElement(By.xpath("//*[@id='request_ot_from_time']"));
		fromDate.sendKeys("2018/07/03 18:00");
		Thread.sleep(1000);

		driver.findElement(By.id("request_ot_reason")).sendKeys("test");
		driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div[2]/div/div/div[2]/form/input[3]")).click();
		String actual = driver
				.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div[2]/div/div/div[2]/form/div[1]/ul/li"))
				.getText();
		Assert.assertEquals(actual, "Timekeeping data of 07/2018 is not available, use can not access for this month!");

	}

	@Test(priority = 25)
	public void TC19_createOTRequestUnsuccessfully_BlankProject() throws InterruptedException {
		driver.get("https://edev.framgia.vn/en/dashboard/users/805/request_ots");
		driver.findElement(By.xpath("/html/body/div/div/div[2]/div[2]/div[2]/a")).click();
		WebElement OTForOtherGroup = driver.findElement(
				By.xpath("/html/body/div[1]/div/div[2]/div[2]/div[2]/div/div/div[2]/form/div[3]/label/span"));
		if (OTForOtherGroup.isSelected())
			OTForOtherGroup.click();

		WebElement toDate = driver.findElement(By.xpath("//*[@id='request_ot_end_time']"));
		toDate.sendKeys("2019/12/28 18:10");
		Thread.sleep(1000);

		WebElement fromDate = driver.findElement(By.xpath("//*[@id='request_ot_from_time']"));
		fromDate.sendKeys("2019/12/28 18:00");
		Thread.sleep(1000);

		driver.findElement(By.id("request_ot_reason")).sendKeys("test");
		driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div[2]/div/div/div[2]/form/input[3]")).click();
		String actual = driver.findElement(By.xpath("//*[@id=\"request_ot_project_name-error\"]")).getText();
		Assert.assertEquals(actual, projectBlank);

	}

	@Test(priority = 26)
	public void TC20_createOTRequestUnsuccessfully_BlankFromTime() throws InterruptedException {
		driver.get("https://edev.framgia.vn/en/dashboard/users/805/request_ots");
		driver.findElement(By.xpath("/html/body/div/div/div[2]/div[2]/div[2]/a")).click();
		WebElement OTForOtherGroup = driver.findElement(
				By.xpath("/html/body/div[1]/div/div[2]/div[2]/div[2]/div/div/div[2]/form/div[3]/label/span"));
		if (OTForOtherGroup.isSelected())
			OTForOtherGroup.click();
		driver.findElement(By.id("request_ot_project_name")).sendKeys("Automation");

		WebElement fromDate = driver.findElement(By.xpath("//*[@id='request_ot_from_time']"));
		fromDate.sendKeys("");
		Thread.sleep(1000);

		driver.findElement(By.id("request_ot_reason")).sendKeys("test");
		driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div[2]/div/div/div[2]/form/input[3]")).click();
		String actual = driver.findElement(By.xpath("//*[@id=\"request_ot_from_time-error\"]")).getText();
		Assert.assertEquals(actual, fromTimeBlank);

	}

	@Test(priority = 27)
	public void TC21_createOTRequestUnsuccessfully_BlankToTime() throws InterruptedException {
		driver.get("https://edev.framgia.vn/en/dashboard/users/805/request_ots");
		driver.findElement(By.xpath("/html/body/div/div/div[2]/div[2]/div[2]/a")).click();
		WebElement OTForOtherGroup = driver.findElement(
				By.xpath("/html/body/div[1]/div/div[2]/div[2]/div[2]/div/div/div[2]/form/div[3]/label/span"));
		if (OTForOtherGroup.isSelected())
			OTForOtherGroup.click();
		driver.findElement(By.id("request_ot_project_name")).sendKeys("Automation");

		WebElement toDate = driver.findElement(By.xpath("//*[@id='request_ot_end_time']"));
		toDate.sendKeys("");
		Thread.sleep(1000);

		WebElement fromDate = driver.findElement(By.xpath("//*[@id='request_ot_from_time']"));
		fromDate.sendKeys("2019/11/22 18:00");
		Thread.sleep(1000);

		driver.findElement(By.id("request_ot_reason")).sendKeys("test");
		driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div[2]/div/div/div[2]/form/input[3]")).click();
		String actual = driver.findElement(By.xpath("//*[@id=\"request_ot_end_time-error\"]")).getText();
		Assert.assertEquals(actual, endTimeBlank);

	}

	@Test(priority = 28)
	public void TC22_createOTRequestUnsuccessfully_BlankReason() throws InterruptedException {
		driver.get("https://edev.framgia.vn/en/dashboard/users/805/request_ots");
		driver.findElement(By.xpath("/html/body/div/div/div[2]/div[2]/div[2]/a")).click();
		WebElement OTForOtherGroup = driver.findElement(
				By.xpath("/html/body/div[1]/div/div[2]/div[2]/div[2]/div/div/div[2]/form/div[3]/label/span"));
		if (OTForOtherGroup.isSelected())
			OTForOtherGroup.click();
		driver.findElement(By.id("request_ot_project_name")).sendKeys("Automation");

		WebElement toDate = driver.findElement(By.xpath("//*[@id='request_ot_end_time']"));
		toDate.sendKeys("2019/11/17 21:00");
		Thread.sleep(1000);

		WebElement fromDate = driver.findElement(By.xpath("//*[@id='request_ot_from_time']"));
		fromDate.sendKeys("2019/11/17 18:00");
		Thread.sleep(1000);

		driver.findElement(By.id("request_ot_reason")).sendKeys("");
		driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div[2]/div/div/div[2]/form/input[3]")).click();
		String actual = driver.findElement(By.xpath("//*[@id=\"request_ot_reason-error\"]")).getText();
		Assert.assertEquals(actual, reasonBlank);

	}

	@Test(priority = 29)
	public void TC23_createOTRequestUnsuccessfully_DuplicatedOTTime() throws InterruptedException {
		driver.get("https://edev.framgia.vn/en/dashboard/users/805/request_ots");
		driver.findElement(By.xpath("/html/body/div/div/div[2]/div[2]/div[2]/a")).click();
		WebElement OTForOtherGroup = driver.findElement(
				By.xpath("/html/body/div[1]/div/div[2]/div[2]/div[2]/div/div/div[2]/form/div[3]/label/span"));
		if (OTForOtherGroup.isSelected())
			OTForOtherGroup.click();

		driver.findElement(By.id("request_ot_project_name")).sendKeys("Automation");

		WebElement toDate = driver.findElement(By.xpath("//*[@id='request_ot_end_time']"));
		toDate.sendKeys("2020/01/01 18:40");
		Thread.sleep(1000);

		WebElement fromDate = driver.findElement(By.xpath("//*[@id='request_ot_from_time']"));
		fromDate.sendKeys("2020/01/01 18:31");
		Thread.sleep(1000);

		driver.findElement(By.id("request_ot_reason")).sendKeys("test");
		driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div[2]/div/div/div[2]/form/input[3]")).click();
		String actual = driver
				.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div[2]/div/div/div[2]/form/div[1]/ul/li"))
				.getText();
		Assert.assertEquals(actual, duplicatedOTTime);

	}

	@Test(priority = 30)
	public void TC24_createOTRequestUnsuccessfully_invalidOTTime() throws InterruptedException {
		driver.get("https://edev.framgia.vn/en/dashboard/users/805/request_ots");
		driver.findElement(By.xpath("/html/body/div/div/div[2]/div[2]/div[2]/a")).click();
		WebElement OTForOtherGroup = driver.findElement(
				By.xpath("/html/body/div[1]/div/div[2]/div[2]/div[2]/div/div/div[2]/form/div[3]/label/span"));
		if (OTForOtherGroup.isSelected())
			OTForOtherGroup.click();

		driver.findElement(By.id("request_ot_project_name")).sendKeys("Automation");

		WebElement toDate = driver.findElement(By.xpath("//*[@id='request_ot_end_time']"));
		toDate.sendKeys("2020/01/01 08:40");
		Thread.sleep(1000);

		WebElement fromDate = driver.findElement(By.xpath("//*[@id='request_ot_from_time']"));
		fromDate.sendKeys("2020/01/01 08:31");
		Thread.sleep(1000);

		driver.findElement(By.id("request_ot_reason")).sendKeys("test");
		driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div[2]/div/div/div[2]/form/input[3]")).click();
		String actual = driver
				.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div[2]/div/div/div[2]/form/div[1]/ul/li[1]"))
				.getText();
		Assert.assertEquals(actual, invalidTimeRequest);

	}

	@Test(priority = 31)
	public void TC25_createOTRequestUnsuccessfully_KeepNewRequestForm() throws InterruptedException {
		driver.get("https://edev.framgia.vn/en/dashboard/users/805/request_ots");
		driver.findElement(By.xpath("/html/body/div/div/div[2]/div[2]/div[2]/a")).click();
		WebElement OTForOtherGroup = driver.findElement(
				By.xpath("/html/body/div[1]/div/div[2]/div[2]/div[2]/div/div/div[2]/form/div[3]/label/span"));
		if (OTForOtherGroup.isSelected())
			OTForOtherGroup.click();

		// driver.findElement(By.id("request_ot_project_name")).sendKeys("Automation");

		WebElement toDate = driver.findElement(By.xpath("//*[@id='request_ot_end_time']"));
		toDate.sendKeys("2020/01/11 08:40");
		Thread.sleep(1000);

		WebElement fromDate = driver.findElement(By.xpath("//*[@id='request_ot_from_time']"));
		fromDate.sendKeys("2020/01/11 08:31");
		Thread.sleep(1000);

		driver.findElement(By.id("request_ot_reason")).sendKeys("test");
		driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div[2]/div/div/div[2]/form/input[3]")).click();
		String actual = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div[2]/div/div/div[1]/h3"))
				.getText();
		Assert.assertEquals(actual, titleNewOvertimeRequest);

	}

	@Test(priority = 31)
	public void TC26_createOTRequestUnsuccessfully_failRequestNotExistInList() throws InterruptedException {
		String actual = "";
		driver.get("https://edev.framgia.vn/en/dashboard/users/805/request_ots");
		String totalBefore = driver.findElement(By.xpath("//*[@id=\"total_time_ot\"]")).getText().toString();
		driver.findElement(By.xpath("/html/body/div/div/div[2]/div[2]/div[2]/a")).click();
		driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div[2]/div/div/div[2]/form/input[3]")).click();
		driver.get("https://edev.framgia.vn/en/dashboard/users/805/request_ots");
		String totalAfter = driver.findElement(By.xpath("//*[@id=\"total_time_ot\"]")).getText().toString();
		if (totalBefore.equals(totalAfter)) {
			actual = "TRUE";
		}
		Assert.assertEquals(actual, "TRUE");

	}

}
