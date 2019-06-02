package FreeCRM_PO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import FreeCRM_Base.basePageObject;


public class FreeCRMLoginPO extends basePageObject {
	public WebDriver driver;

	public FreeCRMLoginPO(WebDriver driver){
		super(driver);
		this.driver= driver;

	}

	By username = By.xpath("//input[@name='username']");
	By password = By.xpath("//input[@name='password']");
	By loginButton = By.xpath("//input[@type='submit']");
	By signUp = By.xpath("//a[contains(text(), 'Sign Up')]");


	public void clickSignUpButton() {
		clickOnElement(signUp);
	}

	public void enterUsername(String userNM) {
		sendTextOnElement(username, userNM);
	}

	public void enterPassword(String pwd) {
		sendTextOnElement(password, pwd);
	}

	public void submitLoginButton() {
		clickOnElement(loginButton);
	}

	public String getTitle() {
		String pageTitle= driver.getTitle();
		return pageTitle;
	}

	public boolean isLoginButtonClickable() {
		return driver.findElement(loginButton).isEnabled();              
	}
}
