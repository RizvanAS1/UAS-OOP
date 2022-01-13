package org.itenas.oop.View;

import java.util.Scanner;

import org.itenas.oop.DAO.PegawaiTetapDAO;
import org.itenas.oop.DAOImpl.PegawaiTetapDAOImpl;
import org.itenas.oop.bea.PegawaiTetap;

public class Form {
	public static void FormInsertPegawaiTetap() {
		Scanner s = new Scanner (System.in);
		PegawaiTetap pt = new PegawaiTetap();
		PegawaiTetapDAO opr = new PegawaiTetapDAOImpl();
		char back;
		
		System.out.println("              ************************************                  ");
        System.out.println("              |  Form Insert Data Pegawai Tetap  |                  ");
        System.out.println("              ************************************                  ");
        System.out.print(  "              | IDP			: ");
        pt.setIDP(s.nextLine());       
        System.out.print(  "              | Nama			: ");
        pt.setNama_Pegawai(s.nextLine());      
        System.out.print(  "              | Divisi			: ");
        pt.setDivisi(s.nextLine());      
        System.out.print(  "              | Level			: ");
        pt.setLevel(s.nextLine());      
        System.out.print(  "              | Masa Kerja		: ");
        pt.setMasa_Kerja(Integer.parseInt(s.nextLine()));      
        System.out.print(  "              | Status			: ");
        pt.setStatus(s.nextLine());       
        System.out.print(  "              | Gaji Pokok		: ");
        pt.setGaji_Pokok(Integer.parseInt(s.nextLine()));
        System.out.print(  "              | Jumlah Lembur		: ");
        pt.setJumlah_Lembur(Integer.parseInt(s.nextLine())); 
        System.out.print(  "              | Jumlah Cuti		: ");
        pt.setJumlah_Cuti(Integer.parseInt(s.nextLine()));        
        System.out.print(  "              | Jumlah Absen		: ");
        pt.setJumlah_Absen(Integer.parseInt(s.nextLine()));       
        System.out.print(  "              | Jumlah Dinas		: ");
        pt.setJumlah_Dinas(Integer.parseInt(s.nextLine()));       
        System.out.println("              ************************************                  ");
        opr.SavePegawaiTetap(pt);
        System.out.print("[B] Tekan Tombol B untuk kembali ke menu sebelumnya: ");
		back = s.next().charAt(0);
		if (back == 'B' || back == 'b') {
			displayMenuPegawaiTetap.displayMenuPT();
		}
        s.close();
	}
}
