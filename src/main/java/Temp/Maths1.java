package Temp;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Maths1 {
	
	@Parameters({"a1","a2","ea"})
	@Test
	public void Addition(double var1, double var2,String expected){
		double result = var1 + var2;
		Assert.assertEquals(result, Double.parseDouble(expected));
	}
	
	@BeforeTest
	@Test
	public void dothis()
	{
		System.out.println("Before Test in dothis method");
	}
	
	@Parameters({"s1","s2","es"})
	@Test
	public void Substraction(double var1, double var2, String expected){
		double result = var1 - var2;
		Assert.assertEquals(result, Double.parseDouble(expected));
	}
}
