package org.itenas.oop.View.Bio;

import java.util.Scanner;
import org.itenas.oop.DAO.AdminDAO;
import org.itenas.oop.DAOImpl.AdminDAOImpl;
import org.itenas.oop.bea.User;

public class Form {
	
	public static void FormCariBioPegawai() {
		Scanner s = new Scanner (System.in);
		String Email;
		User us = new User();
		AdminDAO opr = new AdminDAOImpl();
		System.out.print("Masukkan Email dari data yang akan dicari: ");
		Email = s.nextLine();
		us.setEmail(Email);
		
		opr.GetBioPegawaiByEmail(Email);
		
		s.close();
	}
	
	public static void FormDeleteBioPegawai() {
		Scanner s = new Scanner (System.in);
		User us = new User();
		String Email;
		AdminDAO opr = new AdminDAOImpl();
		System.out.print("Masukkan Email dari data yang akan dihapus: ");
		Email = s.nextLine();
		us.setEmail(Email);
		opr.DeleteBioPegawai(us);
		
		s.close();
	}
	
	public static void FormUpdateBioPegawai() {
		Scanner s = new Scanner (System.in);
		User us = new User();
		String Email;
		AdminDAO opr = new AdminDAOImpl();
		char back;
		
		System.out.print("Masukkan Email dari data yang akan diupdate: ");
		Email = s.nextLine();
		us.setEmail(Email);
		System.out.println("              *************************************                  ");
        System.out.println("              |    Form Insert Biodata Pegawai    |                  ");
        System.out.println("              *************************************                  ");
        System.out.print(  "              | Email			: ");
        us.setEmail(s.nextLine());	
        System.out.print(  "              | Password		: ");
        us.setPassword(s.nextLine());
        System.out.print(  "              | Nama			: ");
        us.setNama(s.nextLine());
        System.out.print(  "              | Jenis Kelamin		: ");
        us.setGender(s.nextLine());
        System.out.print(  "              | Tanggal Lahir(yyyymmdd)	: ");
        us.setDOB(s.nextLine());
        System.out.print(  "              | No Telpn		: ");
        us.setTelpn(s.nextLine());
        System.out.print(  "              | Alamat			: ");
        us.setAlamat(s.nextLine());
        System.out.println("              *************************************                  ");
        opr.UpdateBioPegawai(us);
        System.out.print("[B] Tekan Tombol B untuk kembali ke menu sebelumnya: ");
		back = s.next().charAt(0);
		if (back == 'B' || back == 'b') {
			displayMenu.displayMenuBioPegawai();
		}
        s.close();
	}
	
	public static void FormInsertBioPegawai() {
		Scanner s = new Scanner (System.in);
		User us = new User();
		AdminDAO opr = new AdminDAOImpl();
		char back;
		
		System.out.println("              *************************************                  ");
        System.out.println("              |    Form Insert Biodata Pegawai    |                  ");
        System.out.println("              *************************************                  ");
        System.out.print(  "              | Email			: ");
        us.setEmail(s.nextLine());	
        System.out.print(  "              | Password		: ");
        us.setPassword(s.nextLine());
        System.out.print(  "              | Nama			: ");
        us.setNama(s.nextLine());
        System.out.print(  "              | Jenis Kelamin		: ");
        us.setGender(s.nextLine());
        System.out.print(  "              | Tanggal Lahir(yyyymmdd)	: ");
        us.setDOB(s.nextLine());
        System.out.print(  "              | No Telpn		: ");
        us.setTelpn(s.nextLine());
        System.out.print(  "              | Alamat			: ");
        us.setAlamat(s.nextLine());
        System.out.println("              *************************************                  ");
        opr.SaveBioPegawai(us);
        System.out.print("[B] Tekan Tombol B untuk kembali ke menu sebelumnya: ");
		back = s.next().charAt(0);
		if (back == 'B' || back == 'b') {
			displayMenu.displayMenuBioPegawai();
		}
        s.close();
	}
}
//(IDP, Nama_Pegawai, Divisi, Level, Masa_Kerja, Status, Jumlah_Cuti, Jumlah_Absen, Jumlah_Dinas)