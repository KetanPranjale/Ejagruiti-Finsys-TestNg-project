package ej.finsys.config;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import ej.finsys.exterm.GenericFunctionLibrary;

public class NormaliseParameters {
	
	private void setCountParmeterValue_child(String parametername, String parametervalue)throws IOException, URISyntaxException
	{
		InputStream input=null; // First load whole parameters.properties files so that data wont be loss
		Properties prop=new Properties();
		//input=getClass().getClassLoader().getResourceAsStream("parameters.properties");
		input = new FileInputStream("src/test/resources/parameters.properties");
		prop.load(input);
		input.close();
		
		OutputStream output;
		File f = new File("src/test/resources/parameters.properties");
		output = new FileOutputStream(f);
		prop.setProperty(parametername, parametervalue);
		prop.store(output, null);
		output.close();
	}
	
	public static void setCountParmeterValue(String parametername, String parametervalue) throws IOException, URISyntaxException
	{
		NormaliseParameters pf=new NormaliseParameters();
		pf.setCountParmeterValue_child(parametername, parametervalue);
	}
	
	private String getParameterValue_child(String parametername)throws IOException
	{
		InputStream input=null;
		Properties prop=new Properties();
		//input=getClass().getClassLoader().getResourceAsStream("parameters.properties");
		input = new FileInputStream("src/test/resources/parameters.properties");
		prop.load(input);
		
		String parameterValue=prop.getProperty(parametername);
		input.close();
		return parameterValue;
	}
	
	public static String getParameterValue(String parametername)throws IOException, URISyntaxException
	{
		NormaliseParameters pf=new NormaliseParameters();
		if(parametername.charAt(0)=='#'){ // Getting unique test data value at runtime
			
			//---- To generate unique test data using datetime stamp appending
			// Using appending of datetime stamp , runtime testdata value
/*
			str1 =GenericFunctionLibrary.GenerateUniqueString();
			return pf.getParameterValue_child(parametername)+str1;*/
						
			//---- Generate unique test data by appending unique number to parameter
			//keeping the count of uniquely created test data
			parametername = parametername.substring(1);
			String ucount = pf.getCountValue_child("uniquecount");//Getting value from count.properties file
			int uniquecount = Integer.valueOf(ucount);
			uniquecount++;
			String value= pf.getParameterValue_child(parametername)+uniquecount;
			setCountParmeterValue("uniquecount", Integer.toString(uniquecount));
			return value;
			
		}else if(parametername.length()>4){
			if(parametername.substring(0, 4).equals("prm_"))
				return pf.getParameterValue_child(parametername);
		}
		return parametername;
	}

	private String getCountValue_child(String parametername) throws IOException {
		// TODO Auto-generated method stub
		InputStream input=null;
		Properties prop=new Properties();
		input = new FileInputStream("src/test/resources/parameters.properties");
//		input=getClass().getClassLoader().getResourceAsStream("src/test/resources/parameters.properties");
		prop.load(input);
		
		String parameterValue=prop.getProperty(parametername);
		input.close();
		return parameterValue;
	}
	
	public static String getParameterCompanyCreated(String parametername)throws IOException{
		NormaliseParameters pf=new NormaliseParameters();
		return pf.getParameterCompanyCreated_Child(parametername);
	}
	
	public String getParameterCompanyCreated_Child(String parametername)throws IOException{
		InputStream input=null;
		Properties prop=new Properties();
		input = new FileInputStream("src/test/resources/parameters.properties");
		//input=getClass().getClassLoader().getResourceAsStream("companycreated.properties");
		prop.load(input);
		
		String parameterValue=prop.getProperty(parametername);
		input.close();
		return parameterValue;
	}
	
	public static void setParameterCompanyCreated(String parametername, String parametervalue) throws URISyntaxException, IOException{
		NormaliseParameters pf=new NormaliseParameters();
		pf.setParameterCompanyCreated_child(parametername, parametervalue);
	}
	
	private void setParameterCompanyCreated_child(String parametername, String parametervalue) throws URISyntaxException, IOException{

		InputStream input=null; // First load whole parameters.properties files so that data wont be loss
		Properties prop=new Properties();
		//input=getClass().getClassLoader().getResourceAsStream("parameters.properties");
		input = new FileInputStream("src/test/resources/parameters.properties");
		prop.load(input);
		input.close();
		
		OutputStream output = null;
		prop.setProperty(parametername, parametervalue);
   		//prop.store(new FileOutputStream(new File(url.toURI())), null);
		output = new FileOutputStream("src/test/resources/parameters.properties");
		prop.store(output, null);
		output.close();
  		//System.out.println("Written into file successfully");
	}

}
