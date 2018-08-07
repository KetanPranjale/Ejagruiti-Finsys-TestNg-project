package ej.finsys.modules;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import ej.finsys.config.Config;

public class CloseApplication {
	
	@AfterTest
	public void ExecuteCloseApplication(){
		System.out.println("Executing close application");
		Config.driver.quit();
	}

}
