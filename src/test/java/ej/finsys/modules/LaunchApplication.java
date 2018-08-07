package ej.finsys.modules;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import ej.finsys.config.Config;
import ej.finsys.config.NormaliseParameters;

public class LaunchApplication {
	

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
			Config.wait=new WebDriverWait(Config.driver, 2);
			output_message="Browser Successfully Open.BrowserName:"+browserName+",WebDriver Exe Path:"+Config.getParameterValue("firefox_driver_exe_path_64bit");
		}
		if(browserName.equalsIgnoreCase("ch64"))
		{
			System.setProperty("webdriver.chrome.driver",Config.getParameterValue("chrome_driver_exe_path_64bit"));
			Config.driver=new ChromeDriver();
			Config.wait=new WebDriverWait(Config.driver, 2);
			output_message="Browser Successfully Open.BrowserName:"+browserName+",WebDriver Exe Path:"+Config.getParameterValue("chrome_driver_exe_path_64bit");

		}
		if(browserName.equalsIgnoreCase("ie64"))
		{
			System.setProperty("webdriver.ie.driver",Config.getParameterValue("ie_driver_exe_path_64bit"));
			Config.driver=new InternetExplorerDriver();
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
//		System.out.println("Login Page Successfully Loaded. Wait for:"+TimeOutSeconds);
		//----Write a code here which will wait till login page appears
		//Config.driver.manage().timeouts().pageLoadTimeout(TimeOutSeconds, TimeUnit.SECONDS);
		//Config.driver.manage().timeouts().implicitlyWait(TimeOutSeconds,TimeUnit.SECONDS);
		return "";
	}
	public static String MaximizeLoginPage()
	{
		//----Write a code here which will maximize the login page
		Config.driver.manage().window().maximize();
		return "";
	}
	
	@Parameters({"url"})
	@Test
	public void ExecuteLaunchApplication(String url)throws IOException, URISyntaxException{
		try{
			url = NormaliseParameters.getParameterValue(url);
			String op_from_OpenBrowserMethod_for_ch64=LaunchApplication.OpenBrowser("ch64");
			String op_from_enterurl_method_ch=LaunchApplication.EnterURL(url);
			String op_from_WaitTillLoginPageFullyLoaded_ch= LaunchApplication.WaitTillPageFullyLoaded(1);
			String op_from_maximize_method_ch=LaunchApplication.MaximizeLoginPage();
			WaitTillPageFullyLoaded(2);
			//Add Validation if browser is launched
			Assert.assertEquals(!Config.driver.findElements(By.xpath("//div[contains(text(),'Login to SBDC')]")).isEmpty(), true);
			System.out.println("Successfully Executed Step: Launch application with URL: " + url);
//			URL sessurl = getClass().getClassLoader().getResource(url);
			
			
		}catch(Exception ex){
			System.out.println("Failed to Execute Step:Launch application, Exception Occoured "+ ex.getMessage());
			Assert.assertEquals(false, true);
		}
//		return !Config.driver.findElements(By.xpath("//div[contains(text(),'Login to SBDC')]")).isEmpty(); // True: Application Launched, false: Application not launched 
	}

}
