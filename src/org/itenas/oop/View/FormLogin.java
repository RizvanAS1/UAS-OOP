package org.itenas.oop.View;

import java.util.Scanner;
import org.itenas.oop.DAO.AdminDAO;
import org.itenas.oop.DAO.PegawaiTetapDAO;
import org.itenas.oop.DAOImpl.AdminDAOImpl;
import org.itenas.oop.DAOImpl.PegawaiTetapDAOImpl;
import org.itenas.oop.View.Bio.displayMenu;
import org.itenas.oop.bea.Admin;
import org.itenas.oop.bea.User;
import org.itenas.oop.dbConnection.Validator;

public class FormLogin {
	public static void LoginAdmin() {
		Scanner s = new Scanner (System.in);
		AdminDAO opr = new AdminDAOImpl();
		Admin admin;
		String Id, Pw;
		boolean Login = false;
		
		do {
			System.out.println("+-------------------------------------------+");
			System.out.println("|                   LOGIN                   |");
			System.out.println("+-------------------------------------------+");
			System.out.print("| Id	: "); Id = s.nextLine();
			System.out.print("| Pw	: "); Pw = s.nextLine();
			System.out.println("+-------------------------------------------+");
			System.out.println();
			
			admin = opr.LoginAdmin(Id, Pw);
			if (admin != null) {
				Login = true;
				System.out.println("Login Berhasil, Hello... " + Id);
				displayMenu.displayMenuBioPegawai();
			} else {
				System.out.println("Email atau password yang Anda masukkan salah, coba lagi...!");
			}
		} while (!Login);
		s.close();
	}
	
	public static void LoginPegawai() {
		Scanner s = new Scanner (System.in);
		Validator val = new Validator();
		User user = new User();
		PegawaiTetapDAO opr = new PegawaiTetapDAOImpl();
		String Email, Password;
		boolean Login = false;

		do {
			System.out.println("+-------------------------------------------+");
			System.out.println("|                   LOGIN                   |");
			System.out.println("+-------------------------------------------+");
			Email = val.validateInput(s, "| Email		: ", "email");
			System.out.print("| Password	: "); Password = s.nextLine();
			System.out.println();
			user = opr.LoginPegawaiTetap(Email, Password);
			if (user != null) {
				Login = true;
				System.out.println("Login Berhasil, Hello... " + Email);
			} else {
				System.out.println("Email atau Password yang Anda Masukan salah, coba lagi...");
			}
		} while (!Login);
		
		
	}
}
