package ej.finsys.steps;

import java.io.IOException;
import java.net.URISyntaxException;

import org.openqa.selenium.By;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import ej.finsys.config.Config;
import ej.finsys.config.NormaliseParameters;
import ej.finsys.pages.Login;
import ej.finsys.modules.LaunchApplication;

public class LoginTest {
	public static Login loginPage = new Login();
	
	@Given ("^user is on the application login page$")
	public static void Step0(){
		
	}
	
	@When ("^user enters \"(.*)\" as username$")
	public static void Step1(String userName){
		loginPage.LoadLoginPage(Config.driver);
		loginPage.WaitTillLoginPageFullyLoaded(5);
		//String userName = NormaliseParameters.getParameterValue("prm_usernamecfo");
//		System.out.println(userName);
		loginPage.Enterusername(userName);
		//System.out.println("login step1");
//		return true; 
	}
	
	@When ("^user enters \"(.*)\" as password$")
	public static boolean Step2(String password){
		loginPage.EnterPassword(password);
//		System.out.println(password);
		return true;
	}
	
	@When ("^user clicks on login button$")
	public static boolean Step3(){
		loginPage.ClickLoginButton();
		loginPage.WaitTillLoginPageFullyLoaded(6);
		System.out.println("in step 3 login");
		return true;
	}
	
	@Then ("^user is on the application home page$")
	public static boolean Step4(){
		return !Config.driver.findElements(By.xpath("//span[contains(text(),'Welcome dummy')]")).isEmpty();
	}
	
	@Then ("^user gets the message starting with \"(.*)\" on the top$")
	public static boolean Step5(){
		return !Config.driver.findElements(By.xpath("//span[contains(text(),'Welcome dummy')]")).isEmpty();
	}
}
