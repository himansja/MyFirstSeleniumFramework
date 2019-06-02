package FreeCRM_Modules;

import java.util.LinkedHashMap;

import org.openqa.selenium.WebDriver;
import FreeCRM_PO.FreeCRMHomePagePO;
import FreeCRM_PO.FreeCRMLoginPO;

public class LoginModule  {
	
	public WebDriver driver;
	FreeCRMLoginPO loginpage;
	FreeCRMHomePagePO homepage;
	
	public LoginModule(WebDriver driver){
		this.driver= driver;
		loginpage = new FreeCRMLoginPO(driver);
		homepage = new FreeCRMHomePagePO(driver);
	}
	
	public void clickSignUpButton() {
		loginpage.clickSignUpButton();
	}
	
	public String LoginFreeCRMModule(LinkedHashMap<String, String> testCaseInputData) {		 
		loginpage.enterUsername(testCaseInputData.get("UserName"));
		loginpage.enterPassword(testCaseInputData.get("Password"));
		loginpage.submitLoginButton();
		return homepage.getHomePageTitle();
	}

	public String loginPageTitle() {
		String title = loginpage.getTitle();
		System.out.println(title);
		return title;
	}

	public boolean loginButtonClickable() {
		boolean loginbutton =loginpage.isLoginButtonClickable();
		return loginbutton;
	}

}
