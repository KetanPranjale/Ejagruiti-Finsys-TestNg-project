package Temp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

public class TempAccess {
	
	public void WriteTemp() throws IOException, URISyntaxException
	{ 
		InputStream input=null;
		Properties prop=new Properties();
		input = getClass().getClassLoader().getResourceAsStream("temp.properties");
		prop.load(input);
		input.close();

		OutputStream output = null;
/*		URL url = getClass().getClassLoader().getResources("temp.properties");
		output = new OutputStreamWriter(new FileOutputStream(new File(url.toURI())), StandardCharsets.UTF_8);*/
//		FileOutputStream = new FileOutputStream("temp.properties");
		output = new FileOutputStream("src/main/java/temp.properties");
		prop.setProperty("honda", "new value 2");
		prop.setProperty("jamunkaccha", "keint");
		prop.setProperty("lotus4", "brand new value");

		// save properties to project root folder
		prop.store(output, null);
		System.out.println("writing in temporary file");
	}
}
