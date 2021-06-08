package pageObjectsRespository;

import com.microsoft.playwright.Page;

public class SignupPageObjects {
	
	private String signUpMesg = "//h3[contains(text(),'I WANT MY CREDENTIALS VERIFIED IN')]";

	public Page page;

	public SignupPageObjects(Page page) {

		this.page = page;
	}

	public String signUpmessage()

	{
		return page.textContent(signUpMesg);
	}

}
