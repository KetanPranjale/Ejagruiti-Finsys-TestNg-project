package ej.finsys.pages;

import java.util.List;

import ej.finsys.config.Config;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class LeaseholdImprovement {
	static WebDriver driver = null;
	
	private WebElement WaitTillObjectExists(String xpath){
		return Config.wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
	}
	
	public void LoadLeaseholdImprovementPage(WebDriver driver){
		PageFactory.initElements(driver, this);
		LeaseholdImprovement.driver = driver;
	}
	

	@FindBy(how=How.XPATH,using="//span[contains(text(),'New')]")
	WebElement objNewButton;//ClickNewButton()
	
	public void ClickNewButton(){
		objNewButton.click();
	}
	
	public void SelectCompanyNameFromDropDown(String companyName){
//		System.out.println(" in Lesehold, select from dd "+companyName);
		WebElement objCompanyID = WaitTillObjectExists("//select[@name='companyid']");//SelectCompanyNameFromDropDown(String companyName)
		
		String xpathForDDCompany="//select[@name='companyid']//option[contains(text(),'" + companyName + "')]";//Get XPATH for company name to be selected
//		System.out.println(xpathForDDCompany);	
		WebElement availableConpanyValues=Config.driver.findElement(By.xpath(xpathForDDCompany));//Company name from select drop down
//		System.out.println(" in leasehold, select from dd "+ availableConpanyValues.getAttribute("value"));
		
		Select companyNameDD = new Select(objCompanyID);
		companyNameDD.selectByValue(availableConpanyValues.getAttribute("value"));//use attribute value of company name from select drop down
	}
	
	public void EnterLevelingFeedback(String feedback){
		WebElement objLeveling = WaitTillObjectExists("//input[@name='leveling']/preceding-sibling::input[@type='text']");//EnterLevelingFeedback(String feedback)
		objLeveling.sendKeys(feedback);
	}
	
	public void EnterElectricWorkFeedback(String feedback){
		WebElement objElectricWork = WaitTillObjectExists("//input[@name='electric_work']/preceding-sibling::input[@type='text']");//EnterElectriWorkFeedback(String feedback)
		objElectricWork.sendKeys(feedback);
	}
	
	public void EnterWaterWorkFeedback(String feedback){
		WebElement objWaterWork = WaitTillObjectExists("//input[@name='water_work']/preceding-sibling::input[@type='text']");//EnterWaterWorkFeedback(String feedback)
		objWaterWork.sendKeys(feedback);
	}
	
	public void EnterOtherFeedback(String feedback){
		WebElement objOther = WaitTillObjectExists("//input[@name='other']/preceding-sibling::input[@type='text']");//EnterOtherFeedback(String feedback)
		objOther.sendKeys(feedback);
	}
	
	public void ClickSaveButton(){
		WebElement objSaveButton = WaitTillObjectExists("//span[contains(text(),'Save')]");//ClickSaveButton()
		objSaveButton.click();
	}

	public void ClickDestroyButton(){
		WebElement objDestroyButton = WaitTillObjectExists("//span[contains(text(),'Save')]");
		objDestroyButton.click();
	}

	
	public boolean CheckNewlyAddedLeaseholdImprovement(String companyName){
		String xpath = "//div[contains(text(),'" + companyName + "')]";
//		WebElement objLeaseholdImprovementCompany = Config.driver.findElement(By.xpath(xpath));
		if(WebelementExists(xpath)){
			//System.out.println("TC88 passed");
			return true;
		}
		return false;
	}
	
	public void SelectCompanyNameInLeaseholdDatagrid(String companyName){ // Method need to be modified to be in synch with POM
		String xpath="//div[contains(text(),'"+companyName+"')]/../..";
		WebElement objCompanyNameRow = Config.driver.findElement(By.xpath(xpath));
		objCompanyNameRow.click();
	}
	
	
	private boolean WebelementExists(String xpath){
		return !Config.driver.findElements(By.xpath(xpath)).isEmpty();
	}
}
