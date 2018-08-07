package ej.finsys.modules;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import ej.finsys.config.Config;
import ej.finsys.config.NormaliseParameters;
import ej.finsys.pages.LeaseholdImprovement;

public class CreateLeasehold {
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
	
	@Parameters({"LcompanyName","Lfeedback1","Lfeedback2","Lfeedback3","Lfeedback4"})
	@Test
	public void ExecuteCreateLeasehold(String LcompanyName, String Lfeedback1, String Lfeedback2, String Lfeedback3, String Lfeedback4) throws IOException, URISyntaxException{
		try{	
			LcompanyName = NormaliseParameters.getParameterCompanyCreated("createdCompanyName");
			Lfeedback1 = NormaliseParameters.getParameterValue(Lfeedback1);
			Lfeedback2 = NormaliseParameters.getParameterValue(Lfeedback2);
			Lfeedback3 = NormaliseParameters.getParameterValue(Lfeedback3);
			Lfeedback4 = NormaliseParameters.getParameterValue(Lfeedback4);
	//		System.out.println("ExecuteCreateLeasehold");
			LeaseholdImprovement leaseholdImprovementPage=new LeaseholdImprovement();
			leaseholdImprovementPage.LoadLeaseholdImprovementPage(Config.driver);
			WaitTillPageFullyLoaded(3);
			leaseholdImprovementPage.ClickNewButton();
			WaitTillPageFullyLoaded(3);
			leaseholdImprovementPage.SelectCompanyNameFromDropDown(LcompanyName);
			leaseholdImprovementPage.EnterLevelingFeedback(Lfeedback1);
			leaseholdImprovementPage.EnterElectricWorkFeedback(Lfeedback2);
			leaseholdImprovementPage.EnterWaterWorkFeedback(Lfeedback3);
			leaseholdImprovementPage.EnterOtherFeedback(Lfeedback4);
			leaseholdImprovementPage.ClickSaveButton();
			WaitTillPageFullyLoaded(2);
			Assert.assertEquals(leaseholdImprovementPage.CheckNewlyAddedLeaseholdImprovement(LcompanyName), true);
			System.out.println("Successfully Executed Step: :Creare Leasehold with leasehold company: " + LcompanyName);
			//return leaseholdImprovementPage.CheckNewlyAddedLeaseholdImprovement(LcompanyName);
		}catch(Exception ex){
			System.out.println("Failed to Execute Step:Creare Leasehold, Exception Occoured" + ex.getMessage());
			Assert.assertEquals(false, true);
		}
	}
}
