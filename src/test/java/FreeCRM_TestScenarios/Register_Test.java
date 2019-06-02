package FreeCRM_TestScenarios;



import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import FreeCRM_Base.baseTest;
import FreeCRM_Modules.LoginModule;
import FreeCRM_Modules.RegisterModule;


public class Register_Test extends baseTest {
	RegisterModule register;
	LoginModule login;
	
	

	@BeforeMethod
	public void setUp() {
		register = new RegisterModule(driver);
		login= new LoginModule(driver);	

	}

	@Test()
	public void verifyNewUserRegistration() throws Exception {
		login.clickSignUpButton();
		String title =register.registerNewUser();
		Assert.assertEquals(title, "CRMPRO - CRM Pro for customer relationship management, sales, and support");
		String title1 =register.fillCompanyForm();
		System.out.println(title1);
		Assert.assertEquals(title1, "CRMPRO - CRM Pro for customer relationship management, sales, and support");
		String title3 = register.completeRegistration();
		Assert.assertEquals(title3, "CRMPRO - CRM Pro for customer relationship management, sales, and support");
	}
	
}
