package ej.finsys.modules;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import ej.finsys.config.Config;
import ej.finsys.config.NormaliseParameters;
import ej.finsys.pages.Login;

public class LoginToApplication {
	
	public static void WaitTillPageFullyLoaded(int TimeOutSeconds)
	{
		int timeOut = TimeOutSeconds*1000;
		try {
			Thread.sleep(timeOut);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//----Write a code here which will wait till login page appears
		//Config.driver.manage().timeouts().pageLoadTimeout(TimeOutSeconds, TimeUnit.SECONDS);
		//Config.driver.manage().timeouts().implicitlyWait(TimeOutSeconds,TimeUnit.SECONDS);
	}
	
/*	@DataProvider(name="ExecuteLoginToApplicationDataProvider")
	public static String[][] CredentialsForLoginAppliction(){
		String[][] loginDetails={{"dummycfo","passw0rd"},{"dummyFM","passw0rd"},{"dummyCOH","passw0rd"},{"dummyITM","passw0rd"},{"dummyRM","passw0rd"},{"dummyFM","passw0rd"},{"dummyABM","passw0rd"}}; 
		return loginDetails;
	}*/
	
//	@Test(dataProvider="ExecuteLoginToApplicationDataProvider")
	@Parameters({"username","password"})
	@Test
	public void ExecuteLoginToApplication(String userName, String password) throws IOException, URISyntaxException{
		try
		{
		userName = NormaliseParameters.getParameterValue(userName);
		password = NormaliseParameters.getParameterValue(password);
		Login loginPage = new Login();
		loginPage.LoadLoginPage(Config.driver);
		WaitTillPageFullyLoaded(1);
		loginPage.Enterusername(userName);
		loginPage.EnterPassword(password);
		loginPage.ClickLoginButton();
		WaitTillPageFullyLoaded(2);
		Assert.assertEquals(!Config.driver.findElements(By.xpath("//span[contains(text(),'Welcome dummy')]")).isEmpty(),true);
		System.out.println("Successfully Executed Step: Login operation with username: " + userName + " & Password: "+password);
		}//end of try
		catch(Exception ex)
		{
			System.out.println("Failed to Execute Step:Login Operation, Exception Occoured:"+ex.getMessage());
			Assert.assertEquals(true,false);
			
		}
//		return !Config.driver.findElements(By.xpath("//span[contains(text(),'Welcome dummy')]")).isEmpty(); // True: Application Logged in, false: Application not Logged in
	}
}
