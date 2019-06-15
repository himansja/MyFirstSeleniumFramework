package FreeCRM_TestScenarios;

import java.io.IOException;
import java.util.LinkedHashMap;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;
import com.aventstack.extentreports.Status;

import FreeCRM_Base.ExtentTestManager;
import FreeCRM_Base.baseTest;
import FreeCRM_Modules.LoginModule;
import utility.ScreenShot;

public class FreeCRM_LoginTest extends baseTest{
//This is edited
	LoginModule login;

	@BeforeMethod()
	public void setup() {
		login= new LoginModule(driver);	
	}

	@Test(dataProvider= "inputdata", description = "Sheet2")
	public void loginToFreeCRM(String TC_ID, LinkedHashMap<String, String> testCaseInputData) throws IOException
	{
		
		ExtentTest test=ExtentTestManager.createTest("LoginToApplication", "This test Case is responsible to validate login functionality", "smokeTest");
		
		test.log(Status.INFO, "my test case validation start from here :: login to free CRM");
		String homepageTitle = login.LoginFreeCRMModule(testCaseInputData);
		
		String finalScreenShotName=ScreenShot.captureFullPage(driver, dirStruct+"ScreenShot", "LoginTitle");
		MediaEntityModelProvider mediaModel = MediaEntityBuilder.createScreenCaptureFromPath("ScreenShot/"+finalScreenShotName).build();
		
		if(homepageTitle.equals("CRMPRO")) {
			test.log(Status.PASS, "Home page title correctly displayed Excpected:: CRMPRO Actual::"+homepageTitle,mediaModel);
		}else {
			test.log(Status.FAIL, "Home page title is not correctly displayed Excpected:: CRMPRO Actual::"+homepageTitle,mediaModel);
		}
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
