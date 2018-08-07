package ej.finsys.listener;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.UnknownHostException;
import java.util.Scanner;

import org.apache.log4j.Logger;
import org.testng.ISuite;
import org.testng.ISuiteListener;

import ej.finsys.config.Config;
import ej.finsys.config.NormaliseParameters;
import ej.finsys.exterm.GenericFunctionLibrary;
import ej.finsys.modules.SendEmail;
import ej.finsys.results.HTMLReportGenerator;

public class SuiteListener implements ISuiteListener {
	final static Logger logger=Logger.getLogger(SuiteListener.class);
	
	//---- Store test cases id's not to be run
	protected static String[] tcids = null;
	protected static String tcNotToRun = null;
	
	public static boolean toSkip=false;
	
	@Override
	public void onStart(ISuite suite) {
		// TODO Auto-generated method stub
		
		//---- Getting ids of test cases not to be run
/*		System.out.println("Enter test case id's of test cases not to be run: in coma(,) seperated format");
		Scanner in = new Scanner(System.in);
		tcNotToRun = in.nextLine();
		tcids = tcNotToRun.split(",");*/
		//End of input code
		
		System.out.println("### Suite \""+suite.getName()+"\" execution started ");
		logger.info("### Suite \""+suite.getName()+"\" execution started ");
		String fileName = null;
		try {
			fileName = Config.getParameterValue("pathtosavereport")+GenericFunctionLibrary.GenerateUniqueString()+".html";
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			HTMLReportGenerator.TestSuiteStart(fileName, "Ketan");
			try {
				NormaliseParameters.setParameterCompanyCreated("reportcreated", fileName);
			} catch (URISyntaxException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onFinish(ISuite suite) {
		// TODO Auto-generated method stub
		System.out.println("### Suite \""+suite.getName()+"\"  execution finished");
		logger.info("### Suite \""+suite.getName()+"\"  execution finished");
		HTMLReportGenerator.TestSuiteEnd();
		try {
			SendEmail.SendReportThroughEmail();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
