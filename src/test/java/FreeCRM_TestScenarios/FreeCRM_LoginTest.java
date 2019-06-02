package FreeCRM_TestScenarios;

import java.util.LinkedHashMap;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import FreeCRM_Base.baseTest;
import FreeCRM_Modules.LoginModule;

public class FreeCRM_LoginTest extends baseTest{
//This is edited
	LoginModule login;

	
	
	
	
	
	
	
	

	@BeforeMethod()
	public void setup() {
		login= new LoginModule(driver);	
	}

	@Test(dataProvider= "inputdata", description = "Sheet2")
	public void loginToFreeCRM(String TC_ID, LinkedHashMap<String, String> testCaseInputData)
	{
		
		String homepageTitle = login.LoginFreeCRMModule(testCaseInputData);
		Assert.assertEquals("CRMPRO", homepageTitle);
	}

	/*@Test()
	public void getTitleVerification() {
		//login= new LoginModule(driver);
		String title=login.loginPageTitle();
		Assert.assertEquals("CRMPRO Log In Screen", title);
	}

	@Test(priority =2)
	public void loginButtonEnabledVerification() { 
		//login= new LoginModule(driver);
		boolean loginButton =login.loginButtonClickable();
		Assert.assertEquals(true, loginButton);
	}*/


}
