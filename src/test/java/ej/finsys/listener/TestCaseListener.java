package ej.finsys.listener;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import org.apache.log4j.Logger;
import org.testng.IMethodInstance;
import org.testng.IMethodInterceptor;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import ej.finsys.config.Config;
import ej.finsys.config.NormaliseParameters;
import ej.finsys.exterm.GenericFunctionLibrary;
import ej.finsys.results.HTMLReportGenerator;

public class TestCaseListener implements ITestListener, IMethodInterceptor  {
	final static Logger logger=Logger.getLogger(TestCaseListener.class);
	
	private int testStep=0;
	
	//---- This method is called before the method is invoked 
	@Override
	public List<IMethodInstance> intercept(List<IMethodInstance> methods, ITestContext context){

		//---- If test case is to be skipped, set method invocation count to zero so that all methods will be skipped  
		/*		
		for (IMethodInstance method : methods) {
			System.out.println("Method intercepted");
			if (SuiteListener.toSkip == true){
//				System.out.println("setting invocation count to zero");
				ITestNGMethod testMethod =  method.getMethod();
				testMethod.setInvocationCount(0);
			}
		}*/
		return methods;
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
	
	@Override
	public void onTestStart(ITestResult result){//For step of test case
		// TODO Auto-generated method stub
		
		System.out.println("###Test step \""+result.getName()+"\" started");
		logger.info("###Test step \""+result.getName()+"\" started");
		Object[] obj= result.getParameters();
//		System.out.println("Parameters injected are "+org.testng.internal.Parameters.getInjectedParameter(c, method, context, testResult));
		System.out.print("Parameters provided ");
		logger.info("Parameters provided ");
		for(int i=0; i<obj.length;i++){
			try {
				if(obj[i].toString().length()> 4)
					System.out.print(NormaliseParameters.getParameterValue(obj[i].toString()));
					logger.info(NormaliseParameters.getParameterValue(obj[i].toString()));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				logger.fatal(e.toString());
			} catch (URISyntaxException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				logger.fatal(e.toString());
			}
		}
		System.out.println(" ");
		testStep++;
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("### Sucessful test step \""+result.getName()+"\"");
		logger.info("### Sucessful test step \""+result.getName()+"\"");
		
		//---- Storing the parameters passed to test step
		String parameters = " Parameters: ";
		Object[] obj= result.getParameters();
		for(int i=0; i<obj.length;i++){
			try {
				if(obj[i].toString().length()> 4)
					parameters = parameters +" - " + NormaliseParameters.getParameterValue(obj[i].toString());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				logger.fatal(e.toString());
			} catch (URISyntaxException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				logger.fatal(e.toString());
			}
		}
		
		String screenshotPath = "G:\\Finsys Reports\\Passed Screenshots\\" + result.getName()+GenericFunctionLibrary.GenerateUniqueNumber()+".png";
		String screenshotDestination="";
		try {
			screenshotDestination = HTMLReportGenerator.getScreenshot(Config.driver, screenshotPath);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HTMLReportGenerator.StepDetails("pass", result.getName() ,parameters ,screenshotDestination);
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("### Failed test step \""+result.getName()+"\"");
		logger.error("### Failed test step \""+result.getName()+"\"");

		//---- Storing the parameters passed to test step
		String parameters = " Parameters: ";
		Object[] obj= result.getParameters();
		for(int i=0; i<obj.length;i++){
			try {
				if(obj[i].toString().length()> 4)
					parameters = parameters +" - " + NormaliseParameters.getParameterValue(obj[i].toString());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				logger.fatal(e.toString());
			} catch (URISyntaxException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				logger.fatal(e.toString());
			}
		}
		
		String screenshotPath = "G:\\Finsys Reports\\Failed Screenshots\\" + result.getName()+GenericFunctionLibrary.GenerateUniqueNumber()+".png";
		String screenshotDestination="";
		try {
			screenshotDestination = HTMLReportGenerator.getScreenshot(Config.driver, screenshotPath);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		HTMLReportGenerator.StepDetails("fail", result.getName(),parameters ,screenshotDestination);
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
/*		System.out.println("### Skipped test step \""+result.getName()+"\"");
		logger.info("### Skipped test step \""+result.getName()+"\"");*/
		
		//---- Storing the parameters passed to test step
		String parameters = " Parameters: ";
		Object[] obj= result.getParameters();
		for(int i=0; i<obj.length;i++){
			try {
				if(obj[i].toString().length()> 4)
					parameters = parameters +" - " + NormaliseParameters.getParameterValue(obj[i].toString());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				logger.fatal(e.toString());
			} catch (URISyntaxException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				logger.fatal(e.toString());
			}
		}		
		
		HTMLReportGenerator.StepDetails("info", result.getName(), parameters ,"");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		logger.info("###Test execution failed but is within success percentage");
	}

	@Override
	public void onStart(ITestContext context) {//Test case started
		// TODO Auto-generated method stub
		
		//---- Checking which test cases are to be skipped
/*		for(int i=0;i<SuiteListener.tcids.length;i++){
			if(context.getCurrentXmlTest().getParameter("tcid").equals(SuiteListener.tcids[i])){//if this is the test case to be skipped set parameter SuiteListener.toSkip as true
//				System.out.println("Skipping test case "+context.getCurrentXmlTest().getParameter("tcid"));
//				System.out.println("Skip set to true ");
				SuiteListener.toSkip=true;
				return;
			}else{
				SuiteListener.toSkip=false;
			}
		}*/
				
		System.out.println("### Test Case id=\""+context.getCurrentXmlTest().getParameter("tcid")+"\" description\""+context.getName()+"\" started");
		logger.info("### Test Case id=\""+context.getCurrentXmlTest().getParameter("tcid")+"\" description\""+context.getName()+"\" started");
		HTMLReportGenerator.TestCaseStart("Test case: " + context.getCurrentXmlTest().getParameter("tcid") + ":"+ context.getName(), " Description: " + context.getName());
	}

	@Override
	public void onFinish(ITestContext context) { // Test case finished
		// TODO Auto-generated method stub
		System.out.println("### Test Case \""+context.getCurrentXmlTest().getParameter("tcid")+"\" finished");
		logger.info("### Test Case \""+context.getCurrentXmlTest().getParameter("tcid")+"\" finished");
		testStep=0;
		HTMLReportGenerator.TestCaseEnd();
	}

}
