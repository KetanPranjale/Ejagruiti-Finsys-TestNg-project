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

public class UpdateCompany {
	public static void WaitTillPageFullyLoaded(int TimeOutSeconds)
	{
/*		int timeOut = TimeOutSeconds*1000;
		try {
			Thread.sleep(timeOut);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		//----Write a code here which will wait till login page appears
		//Config.driver.manage().timeouts().pageLoadTimeout(TimeOutSeconds, TimeUnit.SECONDS);
		Config.driver.manage().timeouts().implicitlyWait(TimeOutSeconds,TimeUnit.SECONDS);		
	}
	
	@Parameters({"uoldCompanyName","ucompanyName", "ucompanyType", "ucompanySubType","uaddress", "uphone", "uemail", "upanDetails", "utinDetail", "umobileNum", "uwebsite", "ucountry", "ustate", "ucity", "utotalEmployees"})
	@Test
	public void ExecuteUpdateCompany(String uoldCompanyName, String ucompanyName, String ucompanyType, String ucompanySubType, String ucompanyAddress, String ucompanyPhone, String ucompanyEmail, String uCompanyPan, String uCompanyTin, String uCompanyMobile, String uCompanyWebsite, String uCompanyCountry, String uCompanyState, String uCompanyCity, String uCompanyTotalEmployee) throws IOException, URISyntaxException{
		try{
			uoldCompanyName = NormaliseParameters.getParameterCompanyCreated("createdCompanyName");
			ucompanyName = NormaliseParameters.getParameterValue(ucompanyName);
			ucompanyType = NormaliseParameters.getParameterValue(ucompanyType);
			ucompanySubType = NormaliseParameters.getParameterValue(ucompanySubType);
			ucompanyAddress = NormaliseParameters.getParameterValue(ucompanyAddress);
			ucompanyPhone = NormaliseParameters.getParameterValue(ucompanyPhone);
			ucompanyEmail = NormaliseParameters.getParameterValue(ucompanyEmail);
			uCompanyPan = NormaliseParameters.getParameterValue(uCompanyPan);
			uCompanyTin = NormaliseParameters.getParameterValue(uCompanyTin);
			uCompanyMobile = NormaliseParameters.getParameterValue(uCompanyMobile);
			uCompanyWebsite = NormaliseParameters.getParameterValue(uCompanyWebsite);
			uCompanyCountry = NormaliseParameters.getParameterValue(uCompanyCountry);
			uCompanyState = NormaliseParameters.getParameterValue(uCompanyState);
			uCompanyCity = NormaliseParameters.getParameterValue(uCompanyCity);
			uCompanyTotalEmployee = NormaliseParameters.getParameterValue(uCompanyTotalEmployee);
			
			Company companyPage = new Company();
			companyPage.LoadCompanyPage(Config.driver);
			WaitTillPageFullyLoaded(2);
			companyPage.ClickPlusButtonFrontOfCompany(uoldCompanyName);
			companyPage.EditCompanyNameInCompanyDetailView(ucompanyName);
			companyPage.EditCompanyTypeInCompanyDetailView(ucompanyType);
			companyPage.EditCompanySubTypeInCompanyDetailView(ucompanySubType);
			companyPage.EditCompanyAddressInCompanyDetailView(ucompanyAddress);
			companyPage.EditCompanyPhoneInCompanyDetailView(ucompanyPhone);
			companyPage.EditCompanyEmailInCompanyDetailView(ucompanyEmail);
			companyPage.EditCompanyPanInCompanyDetailView(uCompanyPan);
			companyPage.EditCompanyTinInCompanyDetailView(uCompanyTin);
			companyPage.EditCompanyMobileInCompanyDetailView(uCompanyMobile);
			companyPage.EditCompanyWebsiteInCompanyDetailView(uCompanyWebsite);
			companyPage.EditCompanyCountryInCompanyDetailView(uCompanyCountry);
			companyPage.EditCompanyStateInCompanyDetailView(uCompanyState);
			companyPage.EditCompanyCityInCompanyDetailView(uCompanyCity);
			companyPage.EditCompanyTotalEmployeeInCompanyDetailView(uCompanyTotalEmployee);
			companyPage.ClickSaveButtonInCompanyDetailView();
			WaitTillPageFullyLoaded(2);
			
			
	//		companyPage.ClickPlusButtonFrontOfCompany(ucompanyName);
	//		System.out.println(ucompanyName + " trying to click");
			
			//Validations for the edited details, all the fields edited to be validated
	/*		boolean c1 = companyPage.CheckCompanyNameInCompanyDetailView(ucompanyName);
			boolean c2 = companyPage.CheckCompanyTypeInCompanyDetailView(ucompanyType);
			boolean c3 = companyPage.CheckCompanySubTypeInCompanyDetailView(ucompanySubType);
			boolean c4 = companyPage.CheckCompanyAddressInCompanyDetailView(ucompanyAddress);
			boolean c5 = companyPage.CheckCompanyPhoneInCompanyDetailView(ucompanyPhone);
			boolean c6 = companyPage.CheckCompanyEmailInCompanyDetailView(ucompanyEmail);
			boolean c7 = companyPage.CheckCompanyPanInCompanyDetailView(uCompanyPan);
			boolean c8 = companyPage.CheckCompanyTinInCompanyDetailView(uCompanyTin);
			boolean c9 = companyPage.CheckCompanyMobileInCompanyDetailView(uCompanyMobile);
			boolean c10 = companyPage.CheckCompanyWebsiteInCompanyDetailView(uCompanyWebsite);
			boolean c11 = companyPage.CheckCompanyCountryInCompanyDetailView(uCompanyCountry);
			boolean c12 = companyPage.CheckCompanyStateInCompanyDetailView(uCompanyState);
			boolean c13 = companyPage.CheckCompanyCityInCompanyDetailView(uCompanyCity);
			boolean c14 = companyPage.CheckCompanyTotalEmployeeInCompanyDetailView(uCompanyTotalEmployee);
			WaitTillPageFullyLoaded(2);
			Assert.assertEquals(true, c1&&c2&&c3&&c4&&c5&&c6&&c7&&c8&&c9&&c10&&c11&&c12&&c13&&c14);*/
			Assert.assertEquals(companyPage.CheckCompanyNameInCompanyDatagrid(ucompanyName), true);
			System.out.println("Successfully Executed Step: Update company with company name: "+ ucompanyName);
		}catch(Exception ex){
			System.out.println("Failed to Execute Step: Navigate to leasehold, Exception Occoured" + ex.getMessage());
			Assert.assertEquals(false, true);
		}
	}

}
