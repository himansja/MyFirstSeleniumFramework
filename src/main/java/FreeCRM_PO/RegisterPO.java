package FreeCRM_PO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import FreeCRM_Base.basePageObject;

public class RegisterPO extends basePageObject{
	WebDriver driver;


	By Edition = By.name("payment_plan_id");
	By firstName = By.name("first_name");
	By lastName = By.name("surname");
	By email = By.name("email");
	By confirmEmail =By.name("email_confirm");
	By userName = By.name("username");
	By password = By.name("password");
	By confirmPassword = By.name("passwordconfirm");
	By agreeCheckbox = By.name("agreeTerms");
	By submitButton = By.className("myButton");
	By companyName = By.name("company_name");
	By phone = By.name("phone");
	By companyEmail = By.name("company_email");
	By continuebutton = By.name("btnSubmit");
	By completeRegistration = By.name("finish");


	public RegisterPO(WebDriver driver){
		super(driver);
		this.driver = driver;
	}

	public void selectEditionDropDown() {
		WebElement dropdown = driver.findElement(Edition);
		Select editionDropDwon = new Select(dropdown);
		editionDropDwon.selectByVisibleText("Free Edition");

	}

	public void enterFirstName(String firtsName) {
		sendTextOnElement(firstName, firtsName);
		//driver.findElement(firstName).sendKeys(firtsName);
	}

	public void enterLastName(String ln) {
		sendTextOnElement(lastName, ln);
		//driver.findElement(lastName).sendKeys(ln);
	}


	public void enterEmail(String emailID) {
		//driver.findElement(email).sendKeys(emailID);
		sendTextOnElement(email, emailID);
	}

	public void enterConfirmEmail(String emailID) {
		//driver.findElement(confirmEmail).sendKeys(emailID);
		sendTextOnElement(confirmEmail, emailID);
		
	}

	public void enterUserName1(String un) {
		//driver.findElement(userName).sendKeys(un);
		sendTextOnElement(userName, un);
	}

	public void enterPassword(String pwd) {
		//driver.findElement(password).sendKeys(pwd);
		sendTextOnElement(password, pwd);
	}

	public void enterConfirmPassword(String pwd) {
		//driver.findElement(confirmPassword).sendKeys(pwd);
		sendTextOnElement(confirmPassword, pwd);
	}

	public void checkAgreeCheckbox() {
		//driver.findElement(agreeCheckbox).click();
		clickOnElement(agreeCheckbox);
	}

	public void clickSubmitButton() {
		//driver.findElement(submitButton).click();
		clickOnElement(submitButton);
	}

	public boolean isSubmitButtonClickable() {
		return isElementClickable(submitButton);
	}

	public boolean isAgreementCheckboxSelect() {
		return isElementSelect(agreeCheckbox);
	}
	
	public void enterCompanyName(String companyname) {
		sendTextOnElement(companyName, companyname);
	}
	
	public void enterPhoneNumber(String phoneNu) {
		sendTextOnElement(phone, phoneNu);
	}
	
	public void clickOnContinueButton() {
		clickOnElement(continuebutton);
	}
	
	public String getPageTitle() {
		return getTitleOfPage();
	}
	
	public void clickOnCompleteRegistration() {
		clickOnElement(completeRegistration);
	}
	
}
