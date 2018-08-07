package ej.finsys.pages;

import java.io.IOException;
import java.net.URISyntaxException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import ej.finsys.config.Config;
import ej.finsys.config.NormaliseParameters;

public class Home {
	
	static WebDriver driver=null;
	
	public void LoadHomePage(WebDriver driver){
		PageFactory.initElements(driver, this);
		Home.driver=driver;
	}
	
	private WebElement WaitTillObjectExists(String xpath)
	{
		return Config.wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
	}
	
	public void WaitTillHomePageFullyLoaded(int TimeOutSeconds){
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
	
	
	@FindBy(how=How.XPATH,using="//div[contains(text(),'Financial Analysis')]")
	WebElement objFinancialAnalysisPanel;
	public void ExpandFinancialAnalysisPanelIfCollapsed(){
		if(!elementExists("//div[contains(text(),'Financial Analysis')]/../../div[@class='panel-header accordion-header accordion-header-selected']")){
			objFinancialAnalysisPanel.click();
		}
	}
	
	private boolean elementExists(String xpath){
		return !Config.driver.findElements(By.xpath(xpath)).isEmpty();
	}
	
	
	WebElement objCompanyParentNode; //ExpandCompanyParentNodeIfCollapsed()
	public void ExpandCompanyParentNodeIfCollapsed(){
		if(elementExists("//span[contains(text(),'Company')]/preceding-sibling::span[@class='tree-hit tree-collapsed']")){
			WebElement objCompanyParentNodeCollapsed = Config.driver.findElement(By.xpath("//span[contains(text(),'Company')]/preceding-sibling::span[@class='tree-hit tree-collapsed']"));
			objCompanyParentNodeCollapsed.click();
		}
	}
	
	
	@FindBy(how=How.XPATH,using="//a[@title='Manage Company']")
	WebElement objManageCompany;//ClickManageCompany()
	
	@Test
	public void ClickManageCompany(){
		WebElement objManageCompany = WaitTillObjectExists("//a[@title='Manage Company']");
//		System.out.println("clicking manage company");
//		System.out.println(objManageCompany);
		objManageCompany.click();	
	}
	

	@FindBy(how=How.XPATH,using="//iframe[@src='pages/company/company.html']")
	WebElement objCompanyFrame;//SwitchToCompanyFrame()

	@Test
	public void SwitchToCompanyFrame(){
//		System.out.println("switching to company frame");
		Config.driver.switchTo().frame(Config.driver.findElement(By.xpath("//iframe[@src='pages/company/company.html']")));
	}
	
	public void ExpandExpenseIfCollapsed(){
		if(elementExists("//span[contains(text(),'Expense')]//preceding-sibling::span[@class='tree-hit tree-collapsed']")){
			WebElement objExpandExpenseCollapsed = Config.driver.findElement(By.xpath("//span[contains(text(),'Expense')]//preceding-sibling::span[@class='tree-hit tree-collapsed']"));
			objExpandExpenseCollapsed.click();
		}
	}
	
	public void ExpandRevenueIfCollapsed(){
		if(elementExists("//span[contains(text(),'Revenue')]//preceding-sibling::span[@class='tree-hit tree-collapsed']")){
			WebElement objExpandRevenueCollapsed = Config.driver.findElement(By.xpath("//span[contains(text(),'Revenue')]//preceding-sibling::span[@class='tree-hit tree-collapsed']"));
			objExpandRevenueCollapsed.click();
		}
	}
	
	@FindBy(how=How.XPATH,using="//a[contains(text(),'Leasehold Improvement')]")
	WebElement objLeaseholdImprovement;//ClickLeaseholdImprovement()
	
	@Test
	public void ClickLeaseholdImprovement(){
		objLeaseholdImprovement.click();
	}
	
	public void SwitchToLeaseholdimprovementFrame(){
		Config.driver.switchTo().frame(Config.driver.findElement(By.xpath("//iframe[@src='pages/Leasehold_Improvements/lhi.html']")));
	}
	
	@Test
	public void SwitchBackToHomePage(){
	//	System.out.println("Switched back to home page");
		Config.driver.switchTo().defaultContent();
//		Assert.assertEquals(true, true);
	}
	
/*	
	@Parameters({"role"})
	@Test
	public void CheckIfHomePageIsLoadedWithRole(String role) throws IOException, URISyntaxException{// validation method
		role =  NormaliseParameters.getParameterValue(role);
		String elementXPATH="//span[contains(text(),'Welcome dummy["+role+"]')]";
		Assert.assertEquals(!Config.driver.findElements(By.xpath(elementXPATH)).isEmpty(), true);
		if(elementExists(elementXPATH)){
			System.out.println("Successfully logged in with role "+role);
			Assert.assertEquals(!Config.driver.findElements(By.xpath(elementXPATH)).isEmpty(), true);
//			return true;
		}
		Assert.assertEquals(false, true);
//		return false;

	}*/

}
