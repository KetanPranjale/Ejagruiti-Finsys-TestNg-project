package ej.finsys.steps;

public class TemporaryExecutor {
	public static void main(String[] args){
		
		//---- Executing Login test case 1 Valid UN, PW
		LoginBackground.Step1("ch64");
		LoginBackground.Step2("http://localhost:90/finsys");
		LoginTest.Step1("dummycfo");
		LoginTest.Step2("passw0rd");
		LoginTest.Step3();
		LoginTest.Step4();
		LoginTest.Step5();
		
		//---- Executing Login test case 2 Valid UN , Invalid PW
		LoginBackground.Step1("ch64");
		LoginBackground.Step2("http://localhost:90/finsys");
		LoginTest.Step1("dummycfo");
		LoginTest.Step2("invalid");
		LoginTest.Step3();
		LoginTest.Step4();
		LoginTest.Step5();
		
		//---- Exeuting login test case 3 Invalid UN, Valid PW
		LoginBackground.Step1("ch64");
		LoginBackground.Step2("http://localhost:90/finsys");
		LoginTest.Step1("invalid");
		LoginTest.Step2("password");
		LoginTest.Step3();
		LoginTest.Step4();
		LoginTest.Step5();
		
		//---- Executing login test case 4 Blank UN, Blank PW
		LoginBackground.Step1("ch64");
		LoginBackground.Step2("http://localhost:90/finsys");
		LoginTest.Step1("");
		LoginTest.Step2("");
		LoginTest.Step3();
		LoginTest.Step4();
		LoginTest.Step5();
		
		//---- Executing login test case 5 special characters in username and invalid passwords
		LoginBackground.Step1("ch64");
		LoginBackground.Step2("http://localhost:90/finsys");
		LoginTest.Step1("$#%$user");
		LoginTest.Step2("invalid");
		LoginTest.Step3();
		LoginTest.Step4();
		LoginTest.Step5();
	}
}
