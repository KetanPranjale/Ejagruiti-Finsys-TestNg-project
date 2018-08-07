package ej.finsys.modules;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import ej.finsys.config.Config;
import ej.finsys.config.NormaliseParameters;
import ej.finsys.pages.Company;

public class DeleteCompany {
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
	
	@Parameters({"companyNameDelete","expectedDeleteResult"})
	@Test
	public void ExecuteDeleteCompany(String companyNameDelete, String expectedDeleteResult) throws IOException, URISyntaxException{
		try{
			companyNameDelete = NormaliseParameters.getParameterCompanyCreated("createdCompanyName");
	//		System.out.println("executing delete company");
			Company companyPage = new Company();
			companyPage.LoadCompanyPage(Config.driver);
			WaitTillPageFullyLoaded(1);
			companyPage.SelectCompanyNameInCompanyDatagrid(companyNameDelete);
			companyPage.ClickDestroyButton();
			WaitTillPageFullyLoaded(1);
			companyPage.ClickOnOkButton();
			WaitTillPageFullyLoaded(2);
			boolean expectedResult = Boolean.parseBoolean(expectedDeleteResult);
			Assert.assertEquals(!companyPage.CheckCompanyNameInCompanyDatagrid(companyNameDelete),expectedResult);
	//		return !companyPage.CheckCompanyNameInCompanyDatagrid(companyNameDelete);
			System.out.println("Successfully Executed Step: Delete Company with company name: " + companyNameDelete);
			}catch(Exception ex){
				Assert.assertEquals(false, true);
				System.out.println("Failed to Execute Step: Delete Company , Exception Occoured" + ex.getMessage());
			}
	}

}
