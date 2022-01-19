package org.itenas.oop.dbConnection;

import java.util.Scanner;

public class Validator {
	public String validateInput(Scanner scanner, String label, String type) {
		int test;
		String input, regex = ".*", errorMsg = "";
		
		if (type.equals("email")) {
			regex = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
					+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
			errorMsg = "Err: Format email salah, ulangi lagi...!";
		} else if (type.equals("nip")) {
			regex = "[0-9]{9}";
			errorMsg = "Err: Nip harus dalam format angka, 9 karakter";
		} else if (type.equals("nama")) {
			regex = "^[A-Za-z]+((\\s)?((\\'|\\-|\\.)?([A-Za-z])+))*$";
			errorMsg = "Err: Format nama salah, ulangi lagi...!";
		}
		
		do {
			test = 1;
			System.out.print(label);
			input = scanner.nextLine();
			
			if (!input.matches(regex)) {
				System.out.println(errorMsg);
				test = 0;
			}
			
		} while (test == 0);
		
		return input;
	}
}
