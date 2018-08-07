package ej.finsys.steps;

import java.io.IOException;
import java.net.URISyntaxException;



import cucumber.api.java.en.When;
import ej.finsys.config.NormaliseParameters;
import ej.finsys.modules.LaunchApplication;

public class LoginBackground {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	@When ("^user opens the \"(.*)\" browser$")
	public static boolean Step1(String browser){
		try {
			LaunchApplication.OpenBrowser(browser);
			return true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	@When ("^user enter the url \"(.*)\"$")
	public static boolean Step2(String url){
		//url = NormaliseParameters.getParameterValue("prm_url");
		LaunchApplication.EnterURL(url);
		LaunchApplication.WaitTillPageFullyLoaded(5);
		return true;
	}
}
