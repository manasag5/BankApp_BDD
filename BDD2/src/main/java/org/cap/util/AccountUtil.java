package org.cap.util;

public class AccountUtil {
	private static int accountno=0;
	public static int generateAccountNumber() {
		return ++accountno;
		
	}

}
