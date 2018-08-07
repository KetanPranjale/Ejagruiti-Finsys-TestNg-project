package ej.finsys.modules;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import ej.finsys.config.Config;
import ej.finsys.config.NormaliseParameters;
import ej.finsys.pages.Home;

public class NavigateToCompany {
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
	
	@Test
	public void ExecuteNavigateToCompany(){
		try{
			Home homePage = new Home();
			homePage.LoadHomePage(Config.driver);
			WaitTillPageFullyLoaded(2);
			homePage.ExpandFinancialAnalysisPanelIfCollapsed();
			homePage.ExpandCompanyParentNodeIfCollapsed();
			homePage.ExpandExpenseIfCollapsed();
			homePage.ClickLeaseholdImprovement();
			WaitTillPageFullyLoaded(2);
			
			String elementInFrame = "//span[contains(text(),'Manage Company')]";
			List<WebElement> objListElementInFrame = Config.driver.findElements(By.xpath(elementInFrame));
			
			homePage.SwitchToCompanyFrame();
			WaitTillPageFullyLoaded(2);
//			System.out.println("Switched to Company frame");
			Assert.assertEquals(!objListElementInFrame.isEmpty(), true);		
			System.out.println("Successfully Executed Step: Navigate to company ");
		}catch(Exception ex){
			System.out.println("Failed to Execute Step: Navigate to company , Exception Occoured" + ex.getMessage());
			Assert.assertEquals(false, true);
		}
		
	}

}
