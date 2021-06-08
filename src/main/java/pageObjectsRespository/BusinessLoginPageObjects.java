package pageObjectsRespository;

import com.microsoft.playwright.Page;

public class BusinessLoginPageObjects {

	private String businessLoginMsg = "//body/div[@id='app']/main[1]/div[1]/h2[1]";

	public Page page;

	public BusinessLoginPageObjects(Page page) {

		this.page = page;
	}

	public String businessLoginMsg()

	{
		return page.textContent(businessLoginMsg);
	}

}
