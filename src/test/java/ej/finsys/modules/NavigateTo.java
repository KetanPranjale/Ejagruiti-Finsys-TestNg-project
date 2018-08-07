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

public class NavigateTo {

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
	 * Navigate to specified panel and frame 
	 * @param panel
	 * @param frame
	 * @param frameIndex
	 * @return
	 * @throws IOException
	 * @throws URISyntaxException
	 */
	
	@Parameters({"panel","frame","frameIndex"})
	@Test
	public void ExecuteNavigateTo(String panel, String frame, int frameIndex) throws IOException, URISyntaxException{
		panel = NormaliseParameters.getParameterValue(panel);
		frame = NormaliseParameters.getParameterValue(frame);
		
		Home homePage = new Home();
		homePage.LoadHomePage(Config.driver);
		WaitTillPageFullyLoaded(2);
		homePage.SwitchBackToHomePage();
		switch (panel) {
		
		case "West":
			
			break;
		
		case "Financial Analysis":
			try{
				homePage.ExpandFinancialAnalysisPanelIfCollapsed();
				homePage.ExpandCompanyParentNodeIfCollapsed();
				homePage.ExpandExpenseIfCollapsed();
				homePage.ExpandRevenueIfCollapsed();
				String navigateXPATH = "//a[contains(text(),'"+frame+"')]";
				WebElement objToClick = Config.driver.findElement(By.xpath(navigateXPATH));
				objToClick.click();
				WaitTillPageFullyLoaded(2);
				String elementInFrame = "//span[contains(text(),'"+frame+"')]";
				List<WebElement> objListElementInFrame = Config.driver.findElements(By.xpath(elementInFrame));
	//			Config.driver.switchTo(). //How to switch frame 
				Config.driver.switchTo().frame(frameIndex);
	//			System.out.println("switching to company frame");
				WaitTillPageFullyLoaded(2);
	//			homePage.SwitchToCompanyFrame();
	
				Assert.assertEquals(!objListElementInFrame.isEmpty(), true);
	//			System.out.println("After NavigateTo assert");
	//			return !Config.driver.findElements(By.xpath(elementInFrame)).isEmpty();
				System.out.println("Successfully Executed Step: Navigate to "+ frame);
			}catch(Exception ex){
				System.out.println("Failed to Execute Step: Navigate to" + frame +" , Exception Occoured" + ex.getMessage());
				Assert.assertEquals(false, true);
			}
			
		case "Title3":
			
			break;
			
		case "East":
			
			break;

		default:
			System.out.println("wrong parameter passed");
			Assert.assertEquals(true, false);
//			return false;
		}
//		return false;
	}
}
