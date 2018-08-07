package ej.finsys.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import ej.finsys.config.Config;

public class Login {
	
	static WebDriver driver=null;
	@FindBy(how=How.XPATH,using="//input[@placeholder='Username']")
	WebElement objUserName;
	
	@FindBy(how=How.XPATH, using="//input[@placeholder='Password']")
	WebElement objPassword;
	
	@FindBy(how=How.XPATH, using="//span[contains(text(),'Login')]")
	WebElement objLoginButton;
	
	public void LoadLoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		Login.driver=driver;
	}
	
	public void Enterusername(String username){
		objUserName.sendKeys(username);
	}
	
	public void EnterPassword(String password){
		objPassword.sendKeys(password);
	}
	
	public void ClickLoginButton(){
		objLoginButton.click();
	}

	public void WaitTillLoginPageFullyLoaded(int TimeOutSeconds){
		int timeOut = TimeOutSeconds*1000;
		try {
			Thread.sleep(timeOut);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Config.driver.manage().timeouts().pageLoadTimeout(TimeOutSeconds, TimeUnit.SECONDS);
	}

}