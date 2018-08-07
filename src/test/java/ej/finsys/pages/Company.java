package ej.finsys.pages;

import java.awt.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Sleeper;

import ej.finsys.config.Config;

public class Company {

	static WebDriver driver=null;
	
	private WebElement WaitTillObjectExists(String xpath)
	{
		return Config.wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
	}
	public void LoadCompanyPage(WebDriver driver){
		PageFactory.initElements(driver, this);
		Company.driver = driver;
	}
	
	public void WaitTillCompanyPageFullyLoaded(int TimeOutSeconds){
		Config.driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
	}
	
	@FindBy(how=How.XPATH,using="//span[contains(text(),'New')]")
	WebElement objNewIconButton;//ClickNewIconButton()
	public void ClickNewIconButton(){
		objNewIconButton.click();
	}
	
	
	public void EnterCompanyName(String companyName){		
		WebElement objCompanyName=WaitTillObjectExists("//input[@name='name']");
		objCompanyName.sendKeys(companyName);
	}
	
	public void SelectCompanyTypeDD(String companyType){
//		objCompanyType.click();
//		objCompanyType.findElements(By.tagName("option")).get(1).click();
	 // Select sel=new Select(Config.driver.findElement(By.id("companytype")));
	 // sel.selectByValue("FMCG");
//	objCompanyType.sendKeys(companyType);
//		System.out.println(objCompanyType.getAttribute("outerHTML"));
				
		WebElement objCompanyType=WaitTillObjectExists("//select[@id='companytype']");		
		Select companyTypeDD=new Select(objCompanyType);
		companyTypeDD.selectByVisibleText(companyType);
//		companyTypeDD.selectByValue("IT");
//		companyTypeDD.selectByVisibleText("IT");
	}
	
	public void SelectCompanySubTypeDD(String companySubType){
//		objCompanySubType.sendKeys(companySubType);
		WebElement companySubTypeDDElement=WaitTillObjectExists("//select[@name='subtype']");
		Select companySubTypeDD=new Select(companySubTypeDDElement);
		companySubTypeDD.selectByVisibleText(companySubType);
	}
	
	public void EnterAddress(String address){
		WebElement objAddress=WaitTillObjectExists("//input[@name='address']/preceding-sibling::textarea[contains(@class,'textbox')]");//EnterAddress(String address);
		objAddress.sendKeys(address);
	}
	
	public void EnterPhoneNumber(String phone){
		WebElement objPhone=WaitTillObjectExists("//input[@name='phone']/preceding-sibling::*[1]");//EnterPhoneNumber(String phone)
		objPhone.sendKeys(phone);
	}
	
	public void EnterEmailId(String email){
		WebElement objEmail=WaitTillObjectExists("//input[@name='email']|input[@validtype='email']");//EnterEmailId(String email)
		objEmail.sendKeys(email);
	}
	
	public void EnterPanDetails(String pandetails){
		WebElement objPanDetails=WaitTillObjectExists("//input[@name='pan']");//EnterPanDetails(String pandetails)
		objPanDetails.sendKeys(pandetails);
	}
	
	public void EnterTinDetails(String tinDetail){
		WebElement objTinDetails=WaitTillObjectExists("//input[@name='tin']");//EnterTinDetails(String tinDetail)
		objTinDetails.sendKeys(tinDetail);
	}
	
	public void EnterMobileNumber(String mobileNum){
		WebElement objMobile=WaitTillObjectExists("//input[@name='mobile']/preceding-sibling::*[1]");//EnterMobileNumber(int mobileNum)
		objMobile.sendKeys(mobileNum);
	}
	
	public void EnterWebsite(String website){
		WebElement objWebsite = WaitTillObjectExists("//input[@name='website']");
		objWebsite.sendKeys(website);
	}
	
	public void SelectCountryDD(String country){
		WebElement objCountry=WaitTillObjectExists("//select[@name='countryname']");//SelectCountryDD(String country)
		Select countryDD=new Select(objCountry);
		countryDD.selectByVisibleText(country);
//		objCountry.sendKeys(country);
	}
	
	public void SelectStateDD(String state){
		WebElement stateDDElement= WaitTillObjectExists("//select[@name='state']");
		Select stateDD=new Select(stateDDElement);
	    stateDD.selectByVisibleText(state);
//	    stateDD.selectByValue(state);
	}
	
	public void SelectCityNameDD(String city){
		WebElement cityDDElement= WaitTillObjectExists("//select[@name='city']");
		Select cityDD=new Select(cityDDElement);
//		cityDD.selectByVisibleText("Select City");
	    cityDD.selectByVisibleText(city);
	}
	
	public void EnterTotalEmployeeDetails(String totalEmployees){
		WebElement objTotalEmployee=WaitTillObjectExists("//input[@name='totalemployee']/preceding-sibling::*[1]");//EnterTotalEmployeeDetails(String totalEmployees)
		objTotalEmployee.sendKeys(totalEmployees);
	}
	
	public void ClickSaveButton(){
		WebElement objSaveButton=WaitTillObjectExists("//span[contains(text(),'Save')]");//ClickSaveButton()
		objSaveButton.click();
	}
	
	
	public boolean CheckCompanyNameInCompanyDatagrid(String companyName){// Method need to be modified to be in synch with POM
		//Get number of rows In table.
/*		int row_Count = Config.driver.findElements(By.xpath("//table[contains(@class,'datagrid-btable')]/tbody/tr[contains(@id,'datagrid-row-r1-1')]")).size();
		
		 //divided xpath In three parts to pass Row_count and Col_count values.
		 String first_part = "//table[contains(@class,'datagrid-btable')]/tbody/tr[contains(@datagrid-row-index,'";
		 String second_part = "')]/td[@field='name']";
		
		// //table[contains(@class,'datagrid-btable')]/tbody/tr[contains(@datagrid-row-index,'0')]/td[@field='name']
		 
		 for(int i=0;i < row_Count;i++){
			 String final_xpath=first_part+i+second_part;
			 String table_data=Config.driver.findElement(By.xpath(final_xpath)).getText();
//			 System.out.println(table_data);
			 if(table_data.equals(companyName)){
//				 System.out.println("Company "+table_data+" found in datagrid");				 
				 return true;
			 }
		 }*/
		
//		//div[contains(text(),'Spencer29')] // Xpath of the element to be found
		String first_xpath_part = "//div[contains(text(),'";
		String last_xpath_part = "')]";
		String xpath_CompanyInDatagrid= first_xpath_part+companyName+last_xpath_part;
		return !Config.driver.findElements(By.xpath(xpath_CompanyInDatagrid)).isEmpty();
//		 System.out.println(" Company not found in datagrid");
	}
	
	public void SelectCompanyNameInCompanyDatagrid(String companyName){ // Method need to be modified to be in synch with POM
		String xpath="//div[contains(text(),'"+companyName+"')]/../..";
		WebElement objCompanyNameRow = Config.driver.findElement(By.xpath(xpath));
		objCompanyNameRow.click();
	}
	

	@FindBy(how=How.XPATH,using="//span[contains(text(),'Destroy')]")
	WebElement objDestroyButton;
	
	public void ClickDestroyButton(){
		objDestroyButton.click();
	}
	
	public void ClickOnOkButton(){
		WebElement objOkConfirmationButton=WaitTillObjectExists("//span[contains(text(),'Ok')]");
		try{
		Config.wait.until(ExpectedConditions.alertIsPresent());}
		catch (UnhandledAlertException | NoAlertPresentException e) {
			// TODO: handle exception
			System.out.println("Alert is not present");
		}
		objOkConfirmationButton.click();
	}
	
	public void WaitTillConfirmAlertFullyLoaded(int TimeOutSeconds){
		
	}
	
	public String GetResultMessageOnCompanyFrameTopPaneView(){
		WebElement objCompanyPageTopPaneView=WaitTillObjectExists("//div[@id='result']/h1");
		return objCompanyPageTopPaneView.getText();
	}
	
	public boolean CompareMessageForDeletionOfCompanyIfLeaseholdIsThere(String message){
		String expectedResult = "You Can Not Delete This Company As This Company Has a Cascading Relation with Other Functionalities!!!";
		if(expectedResult.equals(message)){
			//System.out.println("Test case 86 passed");
			return true;
		}
		else{
			//System.out.println("Test case 86 failed");
			return false;
		}
	}
	
	public boolean CompareMessageForDeletionOfCompanyIfNoLeasehold(){
		String expectedResult = "Company Has Been Successfully Deleted!!!";
		if(expectedResult.equals(GetResultMessageOnCompanyFrameTopPaneView())){
			System.out.println("Test case 85 passed");
			return true;
		}
		else{
			System.out.println("Test case 85 failed");
			return false;
		}
		
	}
	
	public void ClickPlusButtonFrontOfCompany(String companyName){

		WebElement objPlusButtonFrontOfCompany;
		//Get number of rows In table.
		int row_Count = Config.driver.findElements(By.xpath("//table[contains(@class,'datagrid-btable')]/tbody/tr[contains(@id,'datagrid-row-r1-1')]")).size();
		 String first_part = "//table[contains(@class,'datagrid-btable')]/tbody/tr[contains(@datagrid-row-index,'";
		 String second_part = "')]/td[@field='name']";
		
		// //table[contains(@class,'datagrid-btable')]/tbody/tr[contains(@datagrid-row-index,'0')]/td[@field='name']
		 
		 for(int i=0;i < row_Count;i++){
			 String final_xpath=first_part+i+second_part;
			 String table_data=Config.driver.findElement(By.xpath(final_xpath)).getText();
			 if(table_data.equals(companyName)){
//				 System.out.println("Found plus company button " + companyName + " count is " + i);
				 String plusButtonPath = "//tr[@id='datagrid-row-r1-1-" + i + "']//span";			 
				 objPlusButtonFrontOfCompany = WaitTillObjectExists(plusButtonPath);
				 objPlusButtonFrontOfCompany.click();
//				 System.out.println("clicked plus button");
			 }
		 }
	}

	public void EditCompanyNameInCompanyDetailView(String newCompanyName){
		WebElement objCompanyName = WaitTillObjectExists("//input[@name='name']");
		objCompanyName.clear();
		objCompanyName.sendKeys(newCompanyName);
	}
	
	public boolean CheckCompanyNameInCompanyDetailView(String companyName){
		WebElement objCompanyName = WaitTillObjectExists("//input[@name='name']");
		String textCompanyName = objCompanyName.getAttribute("value");
		if(textCompanyName.equals(companyName)){
			System.out.println("company name matches");
			return true;
		}
		return false;
	}
	
	public void EditCompanyTypeInCompanyDetailView(String companyType){
		WebElement objCompanyType = WaitTillObjectExists("//select[@id='companytype']");
		Select ddObjCompanyType = new Select(objCompanyType);
//		System.out.println("In company type dd");
		ddObjCompanyType.selectByVisibleText(companyType);
	}
	
	public boolean CheckCompanyTypeInCompanyDetailView(String companyType){
		WebElement objCompanyType = WaitTillObjectExists("//select[@id='companytype']");
		String textCompanyType = objCompanyType.getAttribute("value");
		if(textCompanyType.equals(companyType)){
			System.out.println("company type matches");
			return true;
		}
		return false;
	}
	
	public void EditCompanySubTypeInCompanyDetailView(String companySubType){
		WebElement objCompanySubType = WaitTillObjectExists("//select[@name='subtype']");
		Select ddobjCompanySubType = new Select(objCompanySubType);
		ddobjCompanySubType.selectByVisibleText(companySubType);
	}
	
	public boolean CheckCompanySubTypeInCompanyDetailView(String companySubType){
		WebElement objCompanySubType = WaitTillObjectExists("//input[@name='subtype']");
		String textCompanySubType = objCompanySubType.getAttribute("value");
		System.out.println(textCompanySubType);
		if(textCompanySubType.equals(companySubType)){
			System.out.println("company subtype matches");
			return true;
		}
		return false;
	}
	
	public void EditCompanyAddressInCompanyDetailView(String companyAddress){
		WebElement objCompanyAddress = WaitTillObjectExists("//input[@name='address']/preceding-sibling::*[1]");
		objCompanyAddress.clear();
		objCompanyAddress.sendKeys(companyAddress);
	}
	
	public boolean CheckCompanyAddressInCompanyDetailView(String companyAddress){
		WebElement objCompanyAddress = WaitTillObjectExists("//input[@name='address']/preceding-sibling::*[1]");
		String textCompanyAddress = objCompanyAddress.getAttribute("value");
		System.out.println(textCompanyAddress);
		if(textCompanyAddress.equals(companyAddress)){
			System.out.println("Company address matches");
			return true;
		}
		return false;
	}
	
	public void EditCompanyPhoneInCompanyDetailView(String companyPhone){
		WebElement objCompanyPhone = WaitTillObjectExists("//input[@name='phone']/preceding-sibling::*[1]");
		objCompanyPhone.clear();
		objCompanyPhone.sendKeys(companyPhone);
	}
	
	public boolean CheckCompanyPhoneInCompanyDetailView(String companyPhone){
		WebElement objCompanyPhone = WaitTillObjectExists("//input[@name='phone']/preceding-sibling::*[1]");
		String textCompanyPhone = objCompanyPhone.getAttribute("value");
		System.out.println(textCompanyPhone);
		if(textCompanyPhone.equals(companyPhone)){
			System.out.println("company phone matches");
			return true;
		}
		return false;
	}
	
	public void EditCompanyEmailInCompanyDetailView(String companyEmail){
		WebElement objCompanyEmail = WaitTillObjectExists("//input[@name='email']");
		objCompanyEmail.clear();
		objCompanyEmail.sendKeys(companyEmail);
	}
	
	public boolean CheckCompanyEmailInCompanyDetailView(String companyEmail){
		WebElement objCompanyEmail = WaitTillObjectExists("//input[@name='email']");
		String textCompanyEmail = objCompanyEmail.getAttribute("value");
		if(textCompanyEmail.equals(companyEmail)){
			System.out.println("company email matches");
			return true;
		}
		return false;
	}
	
	public void EditCompanyPanInCompanyDetailView(String CompanyPan){
		WebElement objCompanyPan = WaitTillObjectExists("//input[@name='pan']");
		objCompanyPan.clear();
		objCompanyPan.sendKeys(CompanyPan);
	}
	
	public boolean CheckCompanyPanInCompanyDetailView(String CompanyPan){
		WebElement objCompanyPan = WaitTillObjectExists("//input[@name='pan']");
		String textCompanyPan = objCompanyPan.getAttribute("value");
		if(textCompanyPan.equals(CompanyPan)){
			System.out.println("compny pan matches");
			return true;
		}
		return false;
	}
	
	public void EditCompanyTinInCompanyDetailView(String CompanyTin){
		WebElement objCompanyTin = WaitTillObjectExists("//input[@name='tin']");
		objCompanyTin.clear();
		objCompanyTin.sendKeys(CompanyTin);
	}
	
	public boolean CheckCompanyTinInCompanyDetailView(String CompanyTin){
		WebElement objCompanyTin = WaitTillObjectExists("//input[@name='tin']");
		String textCompanyTin = objCompanyTin.getAttribute("value");
		if(textCompanyTin.equals(CompanyTin)){
			System.out.println("Tin matches");
			return true;
		}
		return false;
	}
	
	public void EditCompanyMobileInCompanyDetailView(String CompanyMobile){
		WebElement objCompanyMobile = WaitTillObjectExists("//input[@name='mobile']/preceding-sibling::*[1]");
		objCompanyMobile.clear();
		objCompanyMobile.sendKeys("1234567891");
	}
	
	public boolean CheckCompanyMobileInCompanyDetailView(String CompanyMobile){
		WebElement objCompanyMobile = WaitTillObjectExists("//input[@name='mobile']/preceding-sibling::*[1]");
		String textCompanyMobile = objCompanyMobile.getAttribute("value");
		System.out.println(textCompanyMobile);
		System.out.println(CompanyMobile);
		if(CompanyMobile.equals(textCompanyMobile)){
			System.out.println("Mobile matches");
			return true;
		}
		if(CompanyMobile.contains(textCompanyMobile)){
			System.out.println("2 Mobile matches");
			return true;
		}
		return false;
	}
	
	public void EditCompanyWebsiteInCompanyDetailView(String CompanyWebsite){
		WebElement objCompanyWebsite = WaitTillObjectExists("//input[@name='website']");
		objCompanyWebsite.clear();
		objCompanyWebsite.sendKeys(CompanyWebsite);
	}
	
	public boolean CheckCompanyWebsiteInCompanyDetailView(String CompanyWebsite){
		WebElement objCompanyWebsite = WaitTillObjectExists("//input[@name='website']");
		String textCompanyWebsite = objCompanyWebsite.getAttribute("value");
		if(textCompanyWebsite.equals(CompanyWebsite)){
			System.out.println("Company website matches");
			return true;
		}
		return false;
	}
	
	public void EditCompanyCountryInCompanyDetailView(String CompanyCountry){
		WebElement objCompanyCountry = WaitTillObjectExists("//select[@name='countryname']");
		Select ddCompanyCountry = new Select(objCompanyCountry);
		ddCompanyCountry.selectByIndex(0);
		ddCompanyCountry.selectByVisibleText(CompanyCountry);
	}
	
	public boolean CheckCompanyCountryInCompanyDetailView(String CompanyCountry){
		WebElement objCompanyCountry = WaitTillObjectExists("//select[@name='countryname']");
		String textCompanyCountry = objCompanyCountry.getAttribute("value");
		if(textCompanyCountry.equals(CompanyCountry)){
			System.out.println("country matches");
			return true;
		}
		return false;
	}
	
	public void EditCompanyStateInCompanyDetailView(String CompanyState){
		WebElement objCompanyState = WaitTillObjectExists("//select[@name='state']");
		Select ddCompanyState = new Select(objCompanyState);
		ddCompanyState.selectByVisibleText(CompanyState);
	}
	
	public boolean CheckCompanyStateInCompanyDetailView(String CompanyState){
		WebElement objCompanyState = WaitTillObjectExists("//input[@name='state']");
		String textCompanyState = objCompanyState.getAttribute("value");
		if(textCompanyState.equals(CompanyState)){
			System.out.println("company state matches");
			return true;
		}
		return false;
	}
	
	public void EditCompanyCityInCompanyDetailView(String CompanyCity){
		WebElement objCompanyCity = WaitTillObjectExists("//select[@name='city']");
		Select ddCompanyCity = new Select(objCompanyCity);
		ddCompanyCity.selectByVisibleText(CompanyCity);
	}
	
	public boolean CheckCompanyCityInCompanyDetailView(String CompanyCity){
		WebElement objCompanyCity = WaitTillObjectExists("//input[@name='city']");
		String textCompanyCity = objCompanyCity.getAttribute("value");
		if(textCompanyCity.equals(CompanyCity)){
			System.out.println("company city matches");
			return true;
		}
		return false;
	}
	
	public void EditCompanyTotalEmployeeInCompanyDetailView(String CompanyTotalEmployee){
		WebElement objCompanyTotalEmployee = WaitTillObjectExists("//input[@name='totalemployee']/preceding-sibling::*[1]");
		objCompanyTotalEmployee.clear();
		objCompanyTotalEmployee.sendKeys(CompanyTotalEmployee);
	}
	
	public boolean CheckCompanyTotalEmployeeInCompanyDetailView(String CompanyTotalEmployee){
		WebElement objCompanyTotalEmployee = WaitTillObjectExists("//input[@name='totalemployee']/preceding-sibling::*[1]");
		String textCompanyTotalEmployee = objCompanyTotalEmployee.getAttribute("value");
		if(textCompanyTotalEmployee.equals(CompanyTotalEmployee)){
			System.out.println("company total employees matches");
			return true;
		}
		return false;
	}
	
	public void ClickSaveButtonInCompanyDetailView(){
		WebElement objSaveButton = WaitTillObjectExists("//span[contains(text(),'Save')]");
		objSaveButton.click();
	}
	
}
