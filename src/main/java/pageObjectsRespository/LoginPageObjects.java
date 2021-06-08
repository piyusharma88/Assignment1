package pageObjectsRespository;

import com.microsoft.playwright.Page;

public class LoginPageObjects {

	public Page page;

	private String lnkSignup = "//button[contains(text(),'SIGNUP')]";
	private String emailTextbox = "//input[@id='email']";
	private String passwdTextbox = "//input[@id='password']";
	private String lnkContinue = "//button[@class='css-1v30o74']";
	private String login = "//body/div[@id='app']/main[1]/div[1]/form[1]/span[1]/button[1]";
	private String lnkBusinessLogin = "//button[normalize-space()='Switch to Business Login']";
	private String lnkTerms = "a[href='https://workwolf.com/termsAndConditions']";
	private String lnkPrivacy = "a[href='https://workwolf.com/privacyPolicy']";
	private String lnkContact = "a[href='https://workwolf.com/contactSalesTeam']";
	private String chatOption = "body > div > div.Application__WidgetAppContainer-sc-1f2l0a1-0.dvBAhE.widget-app-container > span > div > button";
	private String chatMessage = "//@div[data-test-id='primary-message-content']";
	private String successMsg = "//*[@id=\'app\']/header[2]/nav/a[1]";
	private String invalidEmailMsg = "//*[@id=\"app\"]/main/div/p";

	public LoginPageObjects(Page page) {
		// TODO Auto-generated constructor stub
		this.page = page;
	}

	public String invalidEmailMsg() {
		return page.textContent(invalidEmailMsg);
	}

	public String successMsg() {
		return page.textContent(successMsg);
	}

	public void emailTextbox() {
		page.fill(emailTextbox, "piyusharma88@gmail.com");

	}

	public void invalidEmailTextbox() {
		page.fill(emailTextbox, "02sunny@gmail.com");
	}

	public void passwdTextbox() {
		page.fill(passwdTextbox, "Account@12");

	}

	public void lnkSignup() {
		page.click(lnkSignup);

	}

	public void clicklogin() {
		page.click(login);
	}

	public void lnkBusinessLogin() {
		page.click(lnkBusinessLogin);
	}

	public void lnkTerms() {
		page.click(lnkTerms);

	}

	public void lnkPrivacy() {
		page.click(lnkPrivacy);
	}

	public void lnkContact() {
		page.click(lnkContact);
	}

	public void chatOption() {
		page.waitForSelector(chatOption);
		page.click(chatOption);

	}

	public String chatMessage() {
		String actualMessage = page.textContent(chatMessage);
		return actualMessage;
	}

	public String actSuccessMsg() {
		String actualMessage = page.textContent(successMsg);
		return actualMessage;
	}

	public Page lnkcontine() {
		page.click(lnkContinue);
		return page;
	}

}
