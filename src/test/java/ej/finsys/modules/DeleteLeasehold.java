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

public class DeleteLeasehold {
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
	
	@Parameters({"LcompanyName"})
	@Test
	public void ExecuteDeleteLeasehold(String companyName) throws IOException, URISyntaxException{
		try{
			companyName = NormaliseParameters.getParameterValue(companyName);
			
			LeaseholdImprovement leaseholdImprovementPage=new LeaseholdImprovement();
			leaseholdImprovementPage.LoadLeaseholdImprovementPage(Config.driver);
			WaitTillPageFullyLoaded(1);
			leaseholdImprovementPage.SelectCompanyNameInLeaseholdDatagrid(companyName);
			leaseholdImprovementPage.ClickDestroyButton();
			WaitTillPageFullyLoaded(1);
			//return !leaseholdImprovementPage.CheckNewlyAddedLeaseholdImprovement(companyName);
			Assert.assertEquals(!leaseholdImprovementPage.CheckNewlyAddedLeaseholdImprovement(companyName), true);
			System.out.println("Successfully Executed Step: Delete leasehold with company name: " + companyName);
		}catch(Exception ex){
			System.out.println("Failed to Execute Step: Delete leasehold , Exception Occoured" + ex.getMessage());
			Assert.assertEquals(false, true);
		}
	}

}
