package Workwolf.Assignment1TestCases;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.microsoft.playwright.Page;

import pageObjectsRespository.BusinessLoginPageObjects;
import pageObjectsRespository.LoginPageObjects;
import pageObjectsRespository.SignupPageObjects;
import resources.Utilities;

public class WebPageTest extends Utilities {

	static ExtentReports extent;
	Page page;
	ExtentTest test = null;
	@BeforeSuite // Create Extent report and Initialize the browser
	public void browserInitialize() throws IOException {
		String path = System.getProperty("user.dir") + "\\reports\\index.html";
		ExtentSparkReporter report = new ExtentSparkReporter(path);
		report.config().setDocumentTitle("Login Page Automation Results");
		report.config().setReportName("Test Results");
		extent = new ExtentReports();
		extent.attachReporter(report);
		extent.setSystemInfo("Automation Tester", "Priyanka");
		page = initializeBrowser();

	}

	@Test // Verify if the Sign-up link is working
	public void pageNavigation() throws IOException {
		test = extent.createTest("Signup-page Navigation");
		page.navigate(URL);
		LoginPageObjects p = new LoginPageObjects(page);
		p.lnkSignup();
		SignupPageObjects s = new SignupPageObjects(page);
		String actualMessage = s.signUpmessage();
		assertEquals(actualMessage, expSignupVeri);

	}

	@Test // Verify if the business login- link is working
	public void businessLogin() throws IOException {
		test = extent.createTest("Businesslogin-page Navigation");
		page.navigate(URL);
		LoginPageObjects p = new LoginPageObjects(page);
		p.lnkBusinessLogin();
		BusinessLoginPageObjects bl = new BusinessLoginPageObjects(page);
		String actualMessge = bl.businessLoginMsg();
		assertEquals(actualMessge, expBusinessLogin);

	}

	@Test // Verify if the chat option is working as intended
	public void chatOption() throws IOException {
		test = extent.createTest("chatOption");
		page.navigate(URL);
		LoginPageObjects p = new LoginPageObjects(page);
		p.chatOption();
		String actualMessage = p.chatMessage();
		assertEquals(actualMessage, expChatMessage);
	}

	@Test // Verify if the Terms and Conditions link is directing to the right URL
	public void terms() throws IOException {
		test = extent.createTest("Terms and Conditions");
		page.navigate(URL);
		LoginPageObjects p = new LoginPageObjects(page);
		p.lnkTerms();
		String urlActual = page.url();
		assertEquals(urlActual, expUrlTerms);

	}

	@Test // Verify if the Privacy Policy link is directing to the right URL
	public void privacy() throws IOException {
		test = extent.createTest("Privacy Policy");
		page.navigate(URL);
		LoginPageObjects p = new LoginPageObjects(page);
		p.lnkPrivacy();
		String urlActual = page.url();

		assertEquals(urlActual, expUrlPrivacy);

	}

	@Test // Verify if the Contact us link is directing to the right URL
	public void contactUs() throws IOException {
		test = extent.createTest("Contact Us link");
		page.navigate(URL);
		LoginPageObjects p = new LoginPageObjects(page);
		p.lnkContact();
		String urlActual = page.url();

		assertEquals(urlActual, expUrlContact);

	}

	@Test // Verify if the valid login credentials direct you to the expected page
	public void validLogin() throws IOException {
		test = extent.createTest("Valid login credentials");
		page.navigate(URL);
		LoginPageObjects p = new LoginPageObjects(page);
		p.emailTextbox();
		p.lnkcontine();
		p.passwdTextbox();
		p.clicklogin();
		assertEquals(p.actSuccessMsg(), expSuccessMessage);

	}

	@Test // Verify if the user can sign-up with unregistered credentials
	public void invalidLogin() {
		test = extent.createTest("Invalid login Credentials");
		page.navigate(URL);
		LoginPageObjects p = new LoginPageObjects(page);
		p.invalidEmailTextbox();
		p.lnkcontine();
		assertEquals(p.invalidEmailMsg(), expInvalidEmailMsg);
	}

	@AfterSuite // Close the browser once all the tests in this class are run
	public void browserClose() {
		page.close();
		extent.flush();
	}

}
