package resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Properties;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.BrowserType.LaunchOptions;


public class Utilities {

	public static final String URL = "https://app.front.workwolf.com/login";
	public static final String expSignupVeri = "I WANT MY CREDENTIALS VERIFIED IN";
	public static final String expBusinessLogin = "Workwolf Business";
	public static final String expChatMessage = "Hi! Thanks for checking out Workwolf. Ask us anything about our platform and we'll be happy to assist. So... how can we help you out?";
	public static final String expSuccessMessage = "Dashboard";
	public static final String expUrlTerms = "https://workwolf.com/termsAndConditions";
	public static final String expUrlPrivacy = "https://workwolf.com/privacyPolicy";
	public static final String expUrlContact = "https://workwolf.com/contactSalesTeam";
	public static final String expInvalidEmailMsg = "Couldn't find your Workwolf account. Please sign up first.";
 	Page page;
	BrowserType browserType;
	Browser browser;

	public Page initializeBrowser() throws IOException {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\data.properties");
		prop.load(fis);
		String browserName = prop.getProperty("browser");

		if (browserName.equals("chrome")) {
			Playwright playwright = Playwright.create();

			browserType = playwright.chromium();

			browser = browserType.launch(new LaunchOptions().setHeadless(true));

			page = browser.newPage();
		} else if (browserName.equals("firefox")) {
			Playwright playwright = Playwright.create();

			browserType = playwright.firefox();

			browser = browserType.launch(new LaunchOptions().setHeadless(false));

			page = browser.newPage();
		} else if (browserName.equals("webkit")) {

			Playwright playwright = Playwright.create();

			browserType = playwright.webkit();

			browser = browserType.launch(new LaunchOptions().setHeadless(false));

			page = browser.newPage();
		}
		return page;
	}
 public void getScreenshotPath(String testcaseName, Page page)
 {
	 page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("image" + testcaseName + ".png")).setFullPage(true));
 }
 
 }
