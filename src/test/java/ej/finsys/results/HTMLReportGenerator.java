package ej.finsys.results;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.channels.FileChannel;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.relevantcodes.extentreports.NetworkMode;


public class HTMLReportGenerator {

	static ExtentReports report=null;
	static ExtentTest logger; 
	
	public static String getScreenshot(WebDriver driver, String screenshotPath) throws Exception{
		try{
		TakesScreenshot takeScreenshot = (TakesScreenshot) driver;
		File source = takeScreenshot.getScreenshotAs(OutputType.FILE);
		File finalDestination = new File(screenshotPath);
		
		FileChannel ipChannel = new FileInputStream(source).getChannel();
		FileChannel opChannel = new FileOutputStream(screenshotPath).getChannel();
		opChannel.transferFrom(ipChannel, 0, ipChannel.size());
		
		ipChannel.close();
		opChannel.close();
		return screenshotPath;
		}catch(Exception excp){
			System.out.println(excp.getMessage());
		}
		return screenshotPath;
	}
	
	public static void TestSuiteStart(String ResultHTMLFilePath,String UserName) throws UnknownHostException
	{
		report=new ExtentReports(ResultHTMLFilePath,false,NetworkMode.OFFLINE);
		
		report.addSystemInfo("Host Name", InetAddress.getLocalHost().getHostName())
	        .addSystemInfo("Environment", "QA")
	        .addSystemInfo("User Name", UserName);
	}
	
	@AfterSuite
	public static void TestSuiteEnd()
	{
//		System.out.println("Suite finished execution");
		report.flush();
//		report.close();
	}
	
	public static void TestCaseStart(String TestName,String Description)
	{
		logger=report.startTest(TestName, Description);
	}
	
	public static void TestCaseEnd()
	{
		report.endTest(logger);
	}
	
	public static void StepDetails(String Status,String StepName,String StepDetails,String objectImagePath)
	{
		String tbl=StepDetails+"<br>"+logger.addScreenCapture(objectImagePath);
		if(Status.equalsIgnoreCase("pass"))
		{		logger.log(LogStatus.PASS,StepName,tbl);}
		else if(Status.equalsIgnoreCase("fail"))
		{		logger.log(LogStatus.FAIL,StepName, tbl);}
		else if(Status.equalsIgnoreCase("error"))
		{		logger.log(LogStatus.ERROR,StepName, StepDetails);}
		else if(Status.equalsIgnoreCase("info"))
		{		logger.log(LogStatus.INFO,StepName, StepDetails);}
		else
		{logger.log(LogStatus.INFO,StepName, StepDetails);}
		
	}
	
	public static void main(String[] args) throws UnknownHostException {
/*		TestSuiteStart("G:\\Result\\ReportTest.html", "ejagruti");
		TestCaseStart("this is test name", "this is description");
		StepDetails("pass", "this is step1", "this is step details1","G:\\Class Documents\\Deliverables\\1-List Of Generic Functions.PNG");
		StepDetails("fail", "this is step2", "this is step details2","G:\\Class Documents\\Deliverables\\config_properties.PNG");
		TestCaseEnd();
		TestSuiteEnd();*/

	}

}
