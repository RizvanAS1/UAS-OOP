package org.itenas.oop.View.Bio;

import java.util.List;
import java.util.Scanner;

import org.itenas.oop.DAO.AdminDAO;
import org.itenas.oop.DAOImpl.AdminDAOImpl;
import org.itenas.oop.bea.User;

public class BioPegawai {
	public static void main(String[] args) {
		AdminDAO opr = new AdminDAOImpl();
		DisplayBioPegawai(opr.GetAllBioPegawai());
	}
	
	public static void DisplayBioPegawai(List<User> listUser) {
		Scanner s = new Scanner(System.in);
		char back;
		System.out.println();
		System.out.println("     ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		System.out.println("    							                                                    DATA PEGAWAI				                                                                |");
		System.out.println("     ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		System.out.println("    |\tEmail\t\t\t|\tPassword\t|\tNama\t\t|\tGender\t|\tDOB\t\t|\tTelpn\t\t|\tAlamat\t\t\t|");
		System.out.println("     ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		for (User usr : listUser) {
			System.out.println("    |\t"+usr.getEmail()+"\t\t\t|\t"+usr.getPassword()+"\t|\t"+usr.getNama()+"\t|\t"+usr.getGender()+"\t|\t"+usr.getDOB()+"\t|\t"+usr.getTelpn()+"\t|\t"+usr.getAlamat()+"\t\t\t|");
			System.out.println("     ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		}
		System.out.print("[B] Tekan Tombol B untuk kembali ke menu sebelumnya: ");
		back = s.next().charAt(0);
		if (back == 'B' || back == 'b') {
			displayMenu.displayMenuBioPegawai();
		}
		s.close();
	}
	
	public static void displayTupleBioPegawai(User user) {
		Scanner s = new Scanner (System.in);
		char back;
		System.out.println();
		System.out.println("     ------------------------------------------------------------");
		System.out.println("    |                      DATA BIO PEGAWAI                     |");
		System.out.println("     ------------------------------------------------------------");
		System.out.println("    |Email\t\t: " + user.getEmail()+"\t\t\t|");
		System.out.println("    |Nama\t\t: " + user.getNama()+"\t\t\t|");
		System.out.println("    |DOB\t\t: " + user.getDOB()+"\t\t\t\t|");
		System.out.println("    |Telpn\t\t: " + user.getTelpn()+"\t\t\t\t|");
		System.out.println("    |Alamat\t\t: " + user.getAlamat()+"\t\t\t|");
		System.out.println("     ------------------------------------------------------------");
		System.out.print("[B] Tekan Tombol B untuk kembali ke menu sebelumnya: ");
		back = s.next().charAt(0);
		if (back == 'B' || back == 'b') {
			displayMenu.displayMenuBioPegawai();
		}
		s.close();
	}
}
