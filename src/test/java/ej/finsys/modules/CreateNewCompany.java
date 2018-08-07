package ej.finsys.modules;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.concurrent.TimeUnit;


import jdk.nashorn.internal.ir.RuntimeNode.Request;
import okhttp3.Cookie;

import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.HttpServerConnection;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.openqa.selenium.remote.HttpSessionId;
import org.openqa.selenium.remote.SessionId;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.sun.net.httpserver.HttpServer;

import ej.finsys.config.Config;
import ej.finsys.config.NormaliseParameters;
import ej.finsys.pages.Company;

public class CreateNewCompany {
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
	
	/**
	 * 
	 * @param companyName
	 * @param companyType
	 * @param companySubType
	 * @param address
	 * @param phone
	 * @param email
	 * @param panDetails
	 * @param tinDetail
	 * @param mobileNum
	 * @param website
	 * @param country
	 * @param state
	 * @param city
	 * @param totalEmployees
	 * @return
	 * @throws IOException
	 * @throws URISyntaxException
	 */
	@Parameters({"companyName", "companyType", "companySubType","address", "phone", "email", "panDetails", "tinDetail", "mobileNum", "website", "country", "state", "city", "totalEmployees"})
	@Test
	public void executeCreateNewCompany(String companyName, String companyType, String companySubType, String address, String phone, String email, String panDetails, String tinDetail, String mobileNum,String website, String country, String state, String city, String totalEmployees) throws IOException, URISyntaxException{
		try{
			companyName = NormaliseParameters.getParameterValue(companyName);
			NormaliseParameters.setParameterCompanyCreated("createdCompanyName", companyName);
			companyType = NormaliseParameters.getParameterValue(companyType);
			companySubType = NormaliseParameters.getParameterValue(companySubType);
			address = NormaliseParameters.getParameterValue(address);
			phone = NormaliseParameters.getParameterValue(phone);
			email = NormaliseParameters.getParameterValue(email);
			panDetails = NormaliseParameters.getParameterValue(panDetails);
			tinDetail = NormaliseParameters.getParameterValue(tinDetail);
			mobileNum = NormaliseParameters.getParameterValue(mobileNum);
			website = NormaliseParameters.getParameterValue(website);
			country = NormaliseParameters.getParameterValue(country);
			state = NormaliseParameters.getParameterValue(state);
			city = NormaliseParameters.getParameterValue(city);
			totalEmployees = NormaliseParameters.getParameterValue(totalEmployees);
			
			Company companyPage = new Company();
			companyPage.LoadCompanyPage(Config.driver);
			WaitTillPageFullyLoaded(2);
			companyPage.ClickNewIconButton();
			WaitTillPageFullyLoaded(1);
			companyPage.EnterCompanyName(companyName);
			companyPage.SelectCompanyTypeDD(companyType);
			companyPage.SelectCompanySubTypeDD(companySubType);
			companyPage.EnterAddress(address);
			companyPage.EnterPhoneNumber(phone);
			companyPage.EnterEmailId(email);
			companyPage.EnterPanDetails(panDetails);
			companyPage.EnterTinDetails(tinDetail);
			companyPage.EnterMobileNumber(mobileNum);
			companyPage.SelectCountryDD(country);
			companyPage.SelectStateDD(state);
			companyPage.SelectCityNameDD(city);
			companyPage.EnterTotalEmployeeDetails(totalEmployees);
			companyPage.ClickSaveButton();
			WaitTillPageFullyLoaded(3);
	
			Assert.assertEquals(companyPage.CheckCompanyNameInCompanyDatagrid(companyName), true);
	//		System.out.println("After create New Company assert");
	//		return companyPage.CheckCompanyNameInCompanyDatagrid(companyName);//Validation Check if the company added successfully
			System.out.println("Successfully Executed Step: Create new company with company name: " + companyName);
			
		}catch(Exception ex){
			System.out.println("Failed to Execute Step:Create new company , Exception Occoured " + ex.getMessage());
			Assert.assertEquals(false, true);
		}
	}
}
