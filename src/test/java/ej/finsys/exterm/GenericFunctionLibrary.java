package ej.finsys.exterm;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Random;

public class GenericFunctionLibrary {

	// ---- Generate random number between max & min
	public static int GenerateRandomNumber(int MaxVal, int MinVal) {
		int randNum;
		Random rand = new Random();
		randNum = rand.nextInt(MaxVal);
		if (randNum < MinVal) { // ---- If random number is less than minimum
								// then adjust value by adding difference
								// randomly
			randNum = randNum + (MinVal - randNum)
					+ rand.nextInt(MaxVal - MinVal);
		}
		return randNum;
	}

	// ---- Generate random number as string with given number of digits
	// required
	public static String GenerateRandomNumber(int numberofdigits) {
		String numberString = "";
		Random rand = new Random();
		while (numberofdigits != 0) {// ---- Generate random numbers 1 by 1 and
										// add into string
			numberString = numberString + rand.nextInt(9);
			numberofdigits--;
		}
		return numberString;
	}

	/**
	 * Generate random string
	 * @param numberofcharacters
	 *            e.g 5
	 * @param Options
	 *            e.g. 1 for lower case, 2 for upper case, 3 for combination of
	 *            upper and lower case, 4 for special characters
	 * @return String
	 */
	
	public static String GenerateRandomString(int numberofcharacters,
			int Options) {
		String randomString = "";
		if (Options == 1) {
			while (numberofcharacters != 0) {
				randomString = randomString
						+ (char) GenericFunctionLibrary.GenerateRandomNumber(
								122, 97);
				numberofcharacters--;
			}
		} else if (Options == 2) {
			while (numberofcharacters != 0) {
				randomString = randomString
						+ (char) GenericFunctionLibrary.GenerateRandomNumber(
								90, 65);
				numberofcharacters--;
			}
		} else if (Options == 3) {
			while (numberofcharacters != 0) {
				int uporlow = GenericFunctionLibrary
						.GenerateRandomNumber(20, 0);
				if ((uporlow % 2) == 1) {
					randomString = randomString
							+ (char) GenericFunctionLibrary
									.GenerateRandomNumber(90, 65);
				} else {
					randomString = randomString
							+ (char) GenericFunctionLibrary
									.GenerateRandomNumber(122, 97);
				}
				numberofcharacters--;
			}
		} else if (Options == 4) { // Not complete yet
			while (numberofcharacters != 0) {
				randomString = randomString
						+ (char) GenericFunctionLibrary.GenerateRandomNumber(
								47, 33);
				numberofcharacters--;
			}

		}
		return randomString;
	}

	/**
	 * Return system date in format ddMMyy, dd-yy-MM, MM-dd-yyyy
	 * @param dateformat
	 *            e.g. ddMMyy, dd-yy-MM, MM-dd-yyyy
	 * @return String in format "dd/mm/yy"
	 */
	public static String GetSystemDateTime(String dateformat) {
		SimpleDateFormat sdf = new SimpleDateFormat(dateformat);
		Date dt = new Date();
		String dateExtract = sdf.format(dt);
		String dateString = "";
		switch (dateformat) {
		case "ddMMyy":
			dateString = dateExtract.substring(0, 2) + "/"
					+ dateExtract.substring(2, 4) + "/"
					+ dateExtract.substring(4, 6);
			break;
		case "dd-yy-MM":
			dateString = dateExtract.substring(0, 2) + "/"
					+ dateExtract.substring(6, 8) + "/"
					+ dateExtract.substring(3, 5);
			break;
		case "MM-dd-yyyy":
			dateString = dateExtract.substring(3, 5) + "/"
					+ dateExtract.substring(0, 2) + "/"
					+ dateExtract.substring(8, 10);
			break;
		}

		return dateString;
	}

	/**
	 * Always return unique string value which never be repeated
	 * 
	 * @return String
	 */

	public static String GenerateUniqueString() {
		String str1;
		SimpleDateFormat sdf = new SimpleDateFormat("ddMMMyyhhmmss");
		Date dt = new Date();
		str1 = sdf.format(dt);
		return str1;
	}

	/**
	 * Always return unique numeric value which never be repeated
	 * 
	 * @return String
	 */
	// ---- Generate unique string always which is never repeated
	public static String GenerateUniqueNumber() {
		String str1;
		SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyhhmmss");
		Date dt = new Date();
		str1 = sdf.format(dt);
		return str1;
	}

	/**
	 * Generate password 
	 * @param lengthofpassword
	 *            e.g. 7 Note password should contain 1 upper case, 1 lower
	 *            case, 1 special character & 1 numeric value
	 * @return
	 */
	// ---- 
	public static String GeneratePassword(int lengthofpassword) {
		String passwordString = "";
		passwordString = passwordString
				+ GenericFunctionLibrary.GenerateRandomString(1, 1);
		passwordString = passwordString
				+ GenericFunctionLibrary.GenerateRandomString(1, 2);
		passwordString = passwordString
				+ GenericFunctionLibrary.GenerateRandomString(1, 4);
		passwordString = passwordString
				+ GenericFunctionLibrary.GenerateRandomNumber(1);
		if (lengthofpassword > 4) {
			passwordString = passwordString
					+ GenericFunctionLibrary.GenerateRandomString(
							lengthofpassword - 4,
							GenericFunctionLibrary.GenerateRandomNumber(4, 1));
		}
		return passwordString;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(GenericFunctionLibrary.GenerateRandomNumber(33, 6));
		System.out.println(GenericFunctionLibrary.GenerateRandomNumber(10));// ----Random
																			// number
																			// with
																			// given
																			// number
																			// of
																			// digits
		System.out.println(GenericFunctionLibrary.GenerateRandomString(15, 4));
		System.out.println(GenericFunctionLibrary
				.GetSystemDateTime("MM-dd-yyyy"));
		System.out.println(GenericFunctionLibrary.GeneratePassword(7));// ----
																		// Password
		System.out.println(GenericFunctionLibrary.GenerateUniqueNumber());// ----
																			// Unique
																			// number
		System.out.println(GenericFunctionLibrary.GenerateUniqueString());// ----
																			// unique
																			// string
	}

}
