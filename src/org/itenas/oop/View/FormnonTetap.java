package org.itenas.oop.View;

import java.util.Scanner;

import org.itenas.oop.DAO.PegawainonTetapDAO;
import org.itenas.oop.DAOImpl.PegawainonTetapDAOImpl;
import org.itenas.oop.bea.PegawainonTetap;

public class FormnonTetap {
	public static void FormInsertPegawainonTetap() {
		Scanner s = new Scanner (System.in);
		PegawainonTetap pnt = new PegawainonTetap();
		PegawainonTetapDAO nopr = new PegawainonTetapDAOImpl();
		char back;
		FormLogin.LoginPegawai();
		System.out.println("              ************************************                  ");
        System.out.println("              |  Form Insert Data Pegawai Non Tetap  |              ");
        System.out.println("              ************************************                  ");
        System.out.print(  "              | IDP			: ");
        pnt.setIDP(s.nextLine());       
        System.out.print(  "              | Nama			: ");
        pnt.setNama_Pegawai(s.nextLine());      
        System.out.print(  "              | Divisi			: ");
        pnt.setDivisi(s.nextLine());      
        System.out.print(  "              | Level			: ");
        pnt.setLevel(s.nextLine());      
        System.out.print(  "              | Masa Kerja		: ");
        pnt.setMasa_Kerja(Integer.parseInt(s.nextLine()));      
        System.out.print(  "              | Status			: ");
        pnt.setStatus(s.nextLine());       
        System.out.print(  "              | Gaji Pokok		: ");
        pnt.setGaji_Pokok(Integer.parseInt(s.nextLine()));
        System.out.print(  "              | Jumlah Lembur		: ");
        pnt.setJumlah_Lembur(Integer.parseInt(s.nextLine())); 
        System.out.print(  "              | Jumlah Cuti		: ");
        pnt.setJumlah_Cuti(Integer.parseInt(s.nextLine()));        
        System.out.print(  "              | Jumlah Absen		: ");
        pnt.setJumlah_Absen(Integer.parseInt(s.nextLine()));       
        System.out.print(  "              | Jumlah Dinas		: ");
        pnt.setJumlah_Dinas(Integer.parseInt(s.nextLine()));       
        System.out.println("              ************************************                  ");
        nopr.SavePegawainonTetap(pnt);
        System.out.print("[B] Tekan Tombol B untuk kembali ke menu sebelumnya: ");
		back = s.next().charAt(0);
		if (back == 'B' || back == 'b') {
			displayMenuPegawainonTetap.displayMenunonPT();
		}
        s.close();
	}
}
