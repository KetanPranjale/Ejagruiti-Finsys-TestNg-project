package ej.finsys.modules;

import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import Temp.TempAccess;
import ej.finsys.config.Config;
import ej.finsys.config.NormaliseParameters;
import ej.finsys.pages.Company;
import ej.finsys.pages.Home;
import ej.finsys.pages.LeaseholdImprovement;
import ej.finsys.pages.Login;

public class LaunchApp {

	public static String OpenBrowser(String browserName) throws IOException
	{
		String output_message=null;
		if(browserName.equalsIgnoreCase("ff32"))
		{
			System.setProperty("webdriver.gecko.driver",Config.getParameterValue("firefox_driver_exe_path_32bit"));
			Config.driver=new FirefoxDriver();			
			output_message="Browser Successfully Open.BrowserName:"+browserName+",WebDriver Exe Path:"+Config.getParameterValue("firefox_driver_exe_path_32bit");

		}
		if(browserName.equalsIgnoreCase("ch32"))
		{
			System.setProperty("webdriver.chrome.driver",Config.getParameterValue("chrome_driver_exe_path_32bit"));
			Config.driver=new ChromeDriver();
			output_message="Browser Successfully Open.BrowserName:"+browserName+",WebDriver Exe Path:"+Config.getParameterValue("chrome_driver_exe_path_32bit");

		}
		if(browserName.equalsIgnoreCase("ie32"))
		{
			System.setProperty("webdriver.ie.driver",Config.getParameterValue("ie_driver_exe_path_32bit"));
			Config.driver=new InternetExplorerDriver();
			output_message="Browser Successfully Open.BrowserName:"+browserName+",WebDriver Exe Path:"+Config.getParameterValue("ie_driver_exe_path_32bit");

		}
		if(browserName.equalsIgnoreCase("ff64"))
		{
			System.setProperty("webdriver.gecko.driver",Config.getParameterValue("firefox_driver_exe_path_64bit"));
			Config.driver=new FirefoxDriver();
			Config.wait=new WebDriverWait(Config.driver, 5);
			output_message="Browser Successfully Open.BrowserName:"+browserName+",WebDriver Exe Path:"+Config.getParameterValue("firefox_driver_exe_path_64bit");
		}
		if(browserName.equalsIgnoreCase("ch64"))
		{
			System.setProperty("webdriver.chrome.driver",Config.getParameterValue("chrome_driver_exe_path_64bit"));
			Config.driver=new ChromeDriver();
			Config.wait=new WebDriverWait(Config.driver, 5);
			output_message="Browser Successfully Open.BrowserName:"+browserName+",WebDriver Exe Path:"+Config.getParameterValue("chrome_driver_exe_path_64bit");

		}
		if(browserName.equalsIgnoreCase("ie64"))
		{
			System.setProperty("webdriver.ie.driver",Config.getParameterValue("ie_driver_exe_path_64bit"));
			Config.driver=new InternetExplorerDriver();
			Config.wait=new WebDriverWait(Config.driver, 5);
			output_message="Browser Successfully Open.BrowserName:"+browserName+",WebDriver Exe Path:"+Config.getParameterValue("ie_driver_exe_path_64bit");

		}
		return output_message;
	}
	public static String EnterURL(String ApplicationURL)
	{
		//-----write a code here which will launch the application url on the opened browser
		Config.driver.get(ApplicationURL);
		return "";
	}
	public static String WaitTillPageFullyLoaded(int TimeOutSeconds)
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
		return "";
	}
	public static String MaximizeLoginPage()
	{
		//----Write a code here which will maximize the login page
		Config.driver.manage().window().maximize();
		return "";
	}
	
	
	public static void main(String[] args) throws IOException, URISyntaxException {
		//---------------------------suppose user wants to open the browser in Firefox on 32 bit OS
/*		String op_from_OpenBrowserMethod_for_ff32=LaunchApp.OpenBrowser("FF32");
		String op_from_enterurl_method=LaunchApp.EnterURL("http://server:1979/ejagruti");
		String op_from_WaitTillLoginPageFullyLoaded= LaunchApp.WaitTillLoginPageFullyLoaded(30);
		String op_from_maximize_method=LaunchApp.MaximizeLoginPage();
										//or
		//---------------------------suppose user wants to open the browser in Internet Explorer on 32 bit OS
		String op_from_OpenBrowserMethod_for_ie32=LaunchApp.OpenBrowser("IE32");
		String op_from_enterurl_method_ie=LaunchApp.EnterURL("http://server:1979/ejagruti");
		String op_from_WaitTillLoginPageFullyLoaded_ie= LaunchApp.WaitTillLoginPageFullyLoaded(10);
		String op_from_maximize_method_ie=LaunchApp.MaximizeLoginPage();
									  //or
*/		//---------------------------suppose user wants to open the browser in chrome on 64 bit OS
/*		String op_from_OpenBrowserMethod_for_ch64=LaunchApp.OpenBrowser("ch64");
		String op_from_enterurl_method_ch=LaunchApp.EnterURL("http://localhost:90/finsys/login.html");
		String op_from_WaitTillLoginPageFullyLoaded_ch= LaunchApp.WaitTillPageFullyLoaded(1);
		String op_from_maximize_method_ch=LaunchApp.MaximizeLoginPage();
		//-----llike wise you can do it for CH32,FF64,IE64
*/		

//	TC86 Execution of  starts here
/*		
		Login loginPage=new Login();
 
		loginPage.LoadLoginPage(Config.driver);
		loginPage.Enterusername("dummycfo");
		loginPage.EnterPassword("passw0rd");
		loginPage.ClickLoginButton();
		
		LaunchApp.WaitTillPageFullyLoaded(2);
		
		Home homePage=new Home();
		homePage.LoadHomePage(Config.driver);
		homePage.ExpandFinancialAnalysisPanelIfCollapsed();
		homePage.ExpandCompanyParentNodeIfCollapsed();
		homePage.ClickManageCompany();
		LaunchApp.WaitTillPageFullyLoaded(5);
		WebDriverWait wait = new WebDriverWait(Config.driver,3);
		homePage.SwitchToCompanyFrame();
		
		Company companyPage=new Company();
		companyPage.LoadCompanyPage(Config.driver);//Load company page elements when page newly created
		companyPage.ClickNewIconButton();
		LaunchApp.WaitTillPageFullyLoaded(1);
		companyPage.EnterCompanyName("TSYS");
		companyPage.SelectCompanyTypeDD("IT");
		//LaunchApp.WaitTillPageFullyLoaded(1);
		companyPage.SelectCompanySubTypeDD("Development");
		
		companyPage.EnterAddress("Kalyani nagar 2, Pune");
		companyPage.EnterPhoneNumber("8142238138");
		companyPage.EnterEmailId("kdiks@gmail.com");
		companyPage.EnterPanDetails("5937576473");
		companyPage.EnterTinDetails("4563847532");
		companyPage.EnterMobileNumber("9283847374");
		companyPage.SelectCountryDD("INDIA");
		//LaunchApp.WaitTillPageFullyLoaded(1);
		companyPage.SelectStateDD("MAHARASHTRA");
		//LaunchApp.WaitTillPageFullyLoaded(1);
		companyPage.SelectCityNameDD("PUNE");
		companyPage.EnterTotalEmployeeDetails("958");
		companyPage.ClickSaveButton();
		LaunchApp.WaitTillPageFullyLoaded(1);
		LaunchApp.WaitTillPageFullyLoaded(1);
		
		companyPage.CheckCompanyNameInCompanyDatagrid("TSYS");//Validation Check if the company added successfully
		
		homePage.SwitchBackToHomePage();
		homePage.ClickLeaseholdImprovement();
		LaunchApp.WaitTillPageFullyLoaded(1);
		homePage.SwitchToLeaseholdimprovementFrame();
		LeaseholdImprovement leaseholdImprovementPage=new LeaseholdImprovement();
		leaseholdImprovementPage.LoadLeaseholdImprovementPage(Config.driver);
		LaunchApp.WaitTillPageFullyLoaded(1);
		leaseholdImprovementPage.ClickNewButton();
		leaseholdImprovementPage.SelectCompanyNameFromDropDown("TSYS");
		leaseholdImprovementPage.EnterLevelingFeedback("6");
		leaseholdImprovementPage.EnterElectricWorkFeedback("3");
		leaseholdImprovementPage.EnterWaterWorkFeedback("3");
		leaseholdImprovementPage.EnterOtherFeedback("5");
		leaseholdImprovementPage.ClickSaveButton();
		LaunchApp.WaitTillPageFullyLoaded(1);
		
		homePage.SwitchBackToHomePage();
		LaunchApp.WaitTillPageFullyLoaded(1);
		LaunchApp.WaitTillPageFullyLoaded(1);
		homePage.ClickManageCompany();
		LaunchApp.WaitTillPageFullyLoaded(1);
		homePage.SwitchToCompanyFrame();
		LaunchApp.WaitTillPageFullyLoaded(1);
		LaunchApp.WaitTillPageFullyLoaded(1);
		companyPage.SelectCompanyNameInCompanyDatagrid("TSYS");
		companyPage.ClickDestroyButton();
		LaunchApp.WaitTillPageFullyLoaded(1);
		companyPage.ClickOnOkButton();
		LaunchApp.WaitTillPageFullyLoaded(1);
		if(companyPage.CompareMessageForDeletionOfCompanyIfLeaseholdIsThere(companyPage.GetResultMessageOnCompanyFrameTopPaneView())){
			System.out.println("TC86passed");
		}
		else{
			System.out.println("TC86 failed");
		}*/
		//Execution of TC 86 Ends here
		 
	
	//TC 82 Execcution of starts here
/*		
		Login loginPage=new Login();
		 
		loginPage.LoadLoginPage(Config.driver);
		loginPage.Enterusername("dummyfm");
		loginPage.EnterPassword("passw0rd");
		loginPage.ClickLoginButton();
		
		LaunchApp.WaitTillPageFullyLoaded(2);
		
		Home homePage=new Home();
		homePage.LoadHomePage(Config.driver);
		if(homePage.CheckIfHomePageIsLoadedWithRole("FM")){
			System.out.println("TC82 passed");
		}else{
			System.out.println("TC82 failed");
		}*/
		//TC82 execution ends here
		
		
//TC 84 Execution starts here
/*		
		Login loginPage=new Login();
		 
		loginPage.LoadLoginPage(Config.driver);
		loginPage.Enterusername("dummycfo");
		loginPage.EnterPassword("passw0rd");
		loginPage.ClickLoginButton();
		
		LaunchApp.WaitTillPageFullyLoaded(2);
		
		Home homePage=new Home();
		homePage.LoadHomePage(Config.driver);
		homePage.ExpandFinancialAnalysisPanelIfCollapsed();
		homePage.ExpandCompanyParentNodeIfCollapsed();
		homePage.ClickManageCompany();
		LaunchApp.WaitTillPageFullyLoaded(5);
		homePage.SwitchToCompanyFrame();
		
		Company companyPage=new Company();
		companyPage.LoadCompanyPage(Config.driver);//Load company page elements when page newly created
		LaunchApp.WaitTillPageFullyLoaded(1);
		companyPage.ClickNewIconButton();
		LaunchApp.WaitTillPageFullyLoaded(1);
		companyPage.EnterCompanyName("TSYS");
		companyPage.SelectCompanyTypeDD("IT");
		//LaunchApp.WaitTillPageFullyLoaded(1);
		companyPage.SelectCompanySubTypeDD("Development");
		
		companyPage.EnterAddress("Kalyani nagar 2, Pune");
		companyPage.EnterPhoneNumber("8142238138");
		companyPage.EnterEmailId("kdiks@gmail.com");
		companyPage.EnterPanDetails("5937576473");
		companyPage.EnterTinDetails("4563847532");
		companyPage.EnterMobileNumber("9283847374");
		companyPage.SelectCountryDD("INDIA");
		//LaunchApp.WaitTillPageFullyLoaded(1);
		companyPage.SelectStateDD("MAHARASHTRA");
		//LaunchApp.WaitTillPageFullyLoaded(1);
		companyPage.SelectCityNameDD("PUNE");
		companyPage.EnterTotalEmployeeDetails("958");
		companyPage.ClickSaveButton();
		LaunchApp.WaitTillPageFullyLoaded(1);
		LaunchApp.WaitTillPageFullyLoaded(1);
		
		companyPage.CheckCompanyNameInCompanyDatagrid("TSYS");//Validation Check if the company added successfully
		
		companyPage.ClickPlusButtonFrontOfCompany("TSYS");
		companyPage.EditCompanyNameInCompanyDetailView("TSOS");
		companyPage.EditCompanyTypeInCompanyDetailView("Manufacturing");
		companyPage.EditCompanySubTypeInCompanyDetailView("Toys");
		companyPage.EditCompanyAddressInCompanyDetailView("viman nagar 3");
		companyPage.EditCompanyPhoneInCompanyDetailView("9309196459");
		companyPage.EditCompanyEmailInCompanyDetailView("ketanpranjale86@gmail.com");
		companyPage.EditCompanyPanInCompanyDetailView("A123456789");
		companyPage.EditCompanyTinInCompanyDetailView("G453456789");
		companyPage.EditCompanyMobileInCompanyDetailView("1234565491");
		companyPage.EditCompanyWebsiteInCompanyDetailView("www.dell.com");
//		companyPage.EditCompanyCountryInCompanyDetailView("Select Country");
		companyPage.EditCompanyCountryInCompanyDetailView("INDIA");
		companyPage.EditCompanyStateInCompanyDetailView("KERALA");
		companyPage.EditCompanyCityInCompanyDetailView("TALIPARAMBA");
		companyPage.EditCompanyTotalEmployeeInCompanyDetailView("533");
		companyPage.ClickSaveButtonInCompanyDetailView();
		LaunchApp.WaitTillPageFullyLoaded(1);
		
		companyPage.ClickPlusButtonFrontOfCompany("TSOS");
		LaunchApp.WaitTillPageFullyLoaded(1);
		
		//Validations for the edited details
		companyPage.CheckCompanyNameInCompanyDetailView("TSOS");
		companyPage.CheckCompanyTypeInCompanyDetailView("Manufacturing");
		companyPage.CheckCompanySubTypeInCompanyDetailView("Toys");
		companyPage.CheckCompanyAddressInCompanyDetailView("viman nagar 3");
		companyPage.CheckCompanyPhoneInCompanyDetailView("9309196459");
		companyPage.CheckCompanyEmailInCompanyDetailView("ketanpranjale86@gmail.com");
		companyPage.CheckCompanyPanInCompanyDetailView("A123456789");
		companyPage.CheckCompanyTinInCompanyDetailView("G453456789");
		companyPage.CheckCompanyMobileInCompanyDetailView("1234565491");
		companyPage.CheckCompanyWebsiteInCompanyDetailView("www.dell.com");
		companyPage.CheckCompanyCountryInCompanyDetailView("INDIA");
		companyPage.CheckCompanyStateInCompanyDetailView("KERALA");
		companyPage.CheckCompanyCityInCompanyDetailView("TALIPARAMBA");
		companyPage.CheckCompanyTotalEmployeeInCompanyDetailView("533");
*/		
		// TC84 execution ends here
		

//TC85 execution begins here
/*		
		Login loginPage=new Login();
		 
		loginPage.LoadLoginPage(Config.driver);
		loginPage.Enterusername("dummycfo");
		loginPage.EnterPassword("passw0rd");
		loginPage.ClickLoginButton();
		
		LaunchApp.WaitTillPageFullyLoaded(2);
		
		Home homePage=new Home();
		homePage.LoadHomePage(Config.driver);
		homePage.ExpandFinancialAnalysisPanelIfCollapsed();
		homePage.ExpandCompanyParentNodeIfCollapsed();
		homePage.ClickManageCompany();
		LaunchApp.WaitTillPageFullyLoaded(5);
		homePage.SwitchToCompanyFrame();
		
		Company companyPage=new Company();
		companyPage.LoadCompanyPage(Config.driver);//Load company page elements when page newly created
		LaunchApp.WaitTillPageFullyLoaded(1);
		companyPage.ClickNewIconButton();
		LaunchApp.WaitTillPageFullyLoaded(1);
		companyPage.EnterCompanyName("TSYS");
		companyPage.SelectCompanyTypeDD("IT");
		//LaunchApp.WaitTillPageFullyLoaded(1);
		companyPage.SelectCompanySubTypeDD("Development");
		
		companyPage.EnterAddress("Kalyani nagar 2, Pune");
		companyPage.EnterPhoneNumber("8142238138");
		companyPage.EnterEmailId("kdiks@gmail.com");
		companyPage.EnterPanDetails("5937576473");
		companyPage.EnterTinDetails("4563847532");
		companyPage.EnterMobileNumber("9283847374");
		companyPage.SelectCountryDD("INDIA");
		//LaunchApp.WaitTillPageFullyLoaded(1);
		companyPage.SelectStateDD("MAHARASHTRA");
		//LaunchApp.WaitTillPageFullyLoaded(1);
		companyPage.SelectCityNameDD("PUNE");
		companyPage.EnterTotalEmployeeDetails("958");
		companyPage.ClickSaveButton();
		LaunchApp.WaitTillPageFullyLoaded(1);
		LaunchApp.WaitTillPageFullyLoaded(1);
		
		companyPage.CheckCompanyNameInCompanyDatagrid("TSYS");//Validation Check if the company added successfully
		
		companyPage.SelectCompanyNameInCompanyDatagrid("TSYS");
		companyPage.ClickDestroyButton();
		LaunchApp.WaitTillPageFullyLoaded(1);
		companyPage.ClickOnOkButton();
		LaunchApp.WaitTillPageFullyLoaded(1);
		if(companyPage.CompareMessageForDeletionOfCompanyIfNoLeasehold()){//Validation for checking the deletion message
			System.out.println("TC85 passed");
		}else{
			System.out.println("TC85 failed");
		}
*/		
		//TC85 execution ends here
		

//TC83 execution begins here
/*		
		Login loginPage=new Login();
		 
		loginPage.LoadLoginPage(Config.driver);
		loginPage.Enterusername("dummycfo");
		loginPage.EnterPassword("passw0rd");
		loginPage.ClickLoginButton();
		
		LaunchApp.WaitTillPageFullyLoaded(2);
		
		Home homePage=new Home();
		homePage.LoadHomePage(Config.driver);
		homePage.ExpandFinancialAnalysisPanelIfCollapsed();
		homePage.ExpandCompanyParentNodeIfCollapsed();
		homePage.ClickManageCompany();
		LaunchApp.WaitTillPageFullyLoaded(5);
		WebDriverWait wait = new WebDriverWait(Config.driver,3);
		homePage.SwitchToCompanyFrame();
		
		Company companyPage=new Company();
		companyPage.LoadCompanyPage(Config.driver);//Load company page elements when page newly created
		companyPage.ClickNewIconButton();
		LaunchApp.WaitTillPageFullyLoaded(1);
		companyPage.EnterCompanyName("TSYS");
		companyPage.SelectCompanyTypeDD("IT");
		//LaunchApp.WaitTillPageFullyLoaded(1);
		companyPage.SelectCompanySubTypeDD("Development");
		
		companyPage.EnterAddress("Kalyani nagar 2, Pune");
		companyPage.EnterPhoneNumber("8142238138");
		companyPage.EnterEmailId("kdiks@gmail.com");
		companyPage.EnterPanDetails("5937576473");
		companyPage.EnterTinDetails("4563847532");
		companyPage.EnterMobileNumber("9283847374");
		companyPage.SelectCountryDD("INDIA");
		//LaunchApp.WaitTillPageFullyLoaded(1);
		companyPage.SelectStateDD("MAHARASHTRA");
		//LaunchApp.WaitTillPageFullyLoaded(1);
		companyPage.SelectCityNameDD("PUNE");
		companyPage.EnterTotalEmployeeDetails("958");
		companyPage.ClickSaveButton();
		LaunchApp.WaitTillPageFullyLoaded(1);
		LaunchApp.WaitTillPageFullyLoaded(1);
		
		if(companyPage.CheckCompanyNameInCompanyDatagrid("TSYS")){//Validation Check if the company added successfully
			System.out.println("TC83 passed");
		}else{
			System.out.println("TC83 failed");
		}
*/		
//TC83 execution ends here
		
		
		
//TC88 execution starts here
/*
		Login loginPage=new Login();
		 
		loginPage.LoadLoginPage(Config.driver);
		loginPage.Enterusername("dummycfo");
		loginPage.EnterPassword("passw0rd");
		loginPage.ClickLoginButton();
		
		LaunchApp.WaitTillPageFullyLoaded(2);
		
		Home homePage=new Home();
		homePage.LoadHomePage(Config.driver);
		homePage.ExpandFinancialAnalysisPanelIfCollapsed();
		homePage.ExpandCompanyParentNodeIfCollapsed();
		homePage.ClickManageCompany();
		LaunchApp.WaitTillPageFullyLoaded(5);
		WebDriverWait wait = new WebDriverWait(Config.driver,3);
		homePage.SwitchToCompanyFrame();
		
		Company companyPage=new Company();
		companyPage.LoadCompanyPage(Config.driver);//Load company page elements when page newly created
		companyPage.ClickNewIconButton();
		LaunchApp.WaitTillPageFullyLoaded(1);
		companyPage.EnterCompanyName("TSYS");
		companyPage.SelectCompanyTypeDD("IT");
		//LaunchApp.WaitTillPageFullyLoaded(1);
		companyPage.SelectCompanySubTypeDD("Development");
		
		companyPage.EnterAddress("Kalyani nagar 2, Pune");
		companyPage.EnterPhoneNumber("8142238138");
		companyPage.EnterEmailId("kdiks@gmail.com");
		companyPage.EnterPanDetails("5937576473");
		companyPage.EnterTinDetails("4563847532");
		companyPage.EnterMobileNumber("9283847374");
		companyPage.SelectCountryDD("INDIA");
		//LaunchApp.WaitTillPageFullyLoaded(1);
		companyPage.SelectStateDD("MAHARASHTRA");
		//LaunchApp.WaitTillPageFullyLoaded(1);
		companyPage.SelectCityNameDD("PUNE");
		companyPage.EnterTotalEmployeeDetails("958");
		companyPage.ClickSaveButton();
		LaunchApp.WaitTillPageFullyLoaded(1);
		LaunchApp.WaitTillPageFullyLoaded(1);
		
		companyPage.CheckCompanyNameInCompanyDatagrid("TSYS");//Validation Check if the company added successfully
		
		homePage.SwitchBackToHomePage();
		homePage.ClickLeaseholdImprovement();
		LaunchApp.WaitTillPageFullyLoaded(1);
		homePage.SwitchToLeaseholdimprovementFrame();
		LeaseholdImprovement leaseholdImprovementPage=new LeaseholdImprovement();
		leaseholdImprovementPage.LoadLeaseholdImprovementPage(Config.driver);
		LaunchApp.WaitTillPageFullyLoaded(1);
		leaseholdImprovementPage.ClickNewButton();
		leaseholdImprovementPage.SelectCompanyNameFromDropDown("TSYS");
		leaseholdImprovementPage.EnterLevelingFeedback("6");
		leaseholdImprovementPage.EnterElectricWorkFeedback("3");
		leaseholdImprovementPage.EnterWaterWorkFeedback("3");
		leaseholdImprovementPage.EnterOtherFeedback("5");
		leaseholdImprovementPage.ClickSaveButton();
		LaunchApp.WaitTillPageFullyLoaded(1);
		
		if(leaseholdImprovementPage.CheckNewlyAddedLeaseholdImprovement("TSYS")){//Validation to check if company added in Leasehold Improvements
			System.out.println("TC88 passed");
		}else{
			System.out.println("TC88 failed");
		}
*/		
		//TC88 execution ends here

/**
 * For Modules testing
 */
		
/*
		LaunchApplication.ExecuteLaunchApplication("prm_url");
		LoginToApplication.ExecuteLoginToApplication("prm_usernamecfo","passw0rd");
		String panel = "Financial Analysis";
		String frame = "Manage Company";
		NavigateTo.ExecuteNavigateTo(panel, frame,0);
		//---- Check if unique parameters we are getting at runtime
//		System.out.println(NormaliseParameters.getParameterValue("#prm_companyName"));
//		System.out.println(NormaliseParameters.getParameterValue("prm_companyName"));
//		CreateNewCompany.executeCreateNewCompany("#prm_companyName", "prm_companyType", "prm_companySubType", "prm_address", "prm_phone", "prm_email", "prm_panDetails", "prm_tinDetail", "prm_mobileNum", "prm_CompanyWebsite", "prm_country", "prm_state", "prm_city", "prm_totalEmployees");
//		System.out.println(NormaliseParameters.getParameterValue("uprm_companyName"));
		DeleteCompany.ExecuteDeleteCompany("TSYS");*/
//
//		TempAccess temp = new TempAccess();
//		temp.WriteTemp();
//		Set<String> windowHandles = Config.driver.getWindowHandles();
//		Config.driver.switchTo().window();
		
	}
}
