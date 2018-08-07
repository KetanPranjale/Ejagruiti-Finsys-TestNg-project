package Temp;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Maths2 {
	
	@Parameters({"m1","m2","em"})
	@Test
	public void Multiplication(double var1, double var2,String expected){
		double result = var1 * var2;
		Assert.assertEquals(result, Double.parseDouble(expected));
	}
	
	@Parameters({"d1","d2","ed"})
	@Test
	public void Division(double var1, double var2,String expected){
		double result = var1 / var2;
		Assert.assertEquals(result, Double.parseDouble(expected));
	}

}
