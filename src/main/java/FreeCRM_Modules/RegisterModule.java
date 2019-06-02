package FreeCRM_Modules;

import org.openqa.selenium.WebDriver;

import FreeCRM_PO.FreeCRMLoginPO;
import FreeCRM_PO.RegisterPO;

public class RegisterModule {

	WebDriver driver;
	RegisterPO registerpage;
	FreeCRMLoginPO loginpage;
	public RegisterModule(WebDriver driver) {
		this.driver =driver;
		registerpage = new RegisterPO(driver);
		loginpage = new FreeCRMLoginPO(driver);
	}

	public boolean checkSubmitButton() {
		
		return registerpage.isSubmitButtonClickable();
	}

	public boolean checkAgreeCheckBox() {
		
		return registerpage.isAgreementCheckboxSelect();
	}

	public String registerNewUser() {

		registerpage.selectEditionDropDown();
		registerpage.enterFirstName("Himanshu");
		registerpage.enterLastName("Jain2");
		registerpage.enterEmail("himanshu.jain080290@yahoo.com");
		registerpage.enterConfirmEmail("himanshu.jain080290@yahoo.com");
		registerpage.enterUserName1("himanshujain1");
		registerpage.enterPassword("inception");
		registerpage.enterConfirmPassword("inception");
		registerpage.checkAgreeCheckbox();
		registerpage.clickSubmitButton();
		return registerpage.getPageTitle();
	}
	
	public String fillCompanyForm() {
		registerpage.enterCompanyName("Myinfoteck1");
		registerpage.enterPhoneNumber("9011930189");
		registerpage.clickOnContinueButton();
		return registerpage.getPageTitle();
	}
	
	public String completeRegistration() {
		registerpage.clickOnCompleteRegistration();
		return registerpage.getPageTitle();
	}
}
