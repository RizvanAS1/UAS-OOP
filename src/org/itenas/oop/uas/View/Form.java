package org.itenas.oop.View;

import java.util.Scanner;

import org.itenas.oop.DAO.PegawaiMagangDAO;
import org.itenas.oop.DAO.PegawaiTetapDAO;
import org.itenas.oop.DAOImpl.PegawaiMagangDAOImpl;
import org.itenas.oop.DAOImpl.PegawaiTetapDAOImpl;
import org.itenas.oop.bea.PegawaiMagang;
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
        System.out.print(  "              | IDP			        : ");
        pt.setIDP(s.nextLine());       
        System.out.print(  "              | Nama		    	: ");
        pt.setNama_Pegawai(s.nextLine());      
        System.out.print(  "              | Divisi			    : ");
        pt.setDivisi(s.nextLine());      
        System.out.print(  "              | Level			    : ");
        pt.setLevel(s.nextLine());      
        System.out.print(  "              | Masa Kerja		    : ");
        pt.setMasa_Kerja(Integer.parseInt(s.nextLine()));      
        System.out.print(  "              | Status			    : ");
        pt.setStatus(s.nextLine());       
        System.out.print(  "              | Gaji Pokok		    : ");
        pt.setGaji_Pokok(Integer.parseInt(s.nextLine()));        
        System.out.print(  "              | Jumlah Cuti		    : ");
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

		public static void FormInsertPegawaiMagang() {
			Scanner s = new Scanner (System.in);
			PegawaiMagang pm = new PegawaiMagang();
			PegawaiMagangDAO opr = new PegawaiMagangDAOImpl();
			char back;
			
			System.out.println("              ************************************                  ");
	        System.out.println("              |  Form Insert Data Pegawai Magang  |                 ");
	        System.out.println("              ************************************                  ");
	        System.out.print(  "              | IDPM		     : ");
	        pm.setIDPM(s.nextLine());       
	        System.out.print(  "              | Nama			 : ");
	        pm.setNama_PegawaiM(s.nextLine());      
	        System.out.print(  "              | Divisi			 : ");
	        pm.setDivisi(s.nextLine());        
	        System.out.print(  "              | Status			 : ");
	        pm.setStatus(s.nextLine());  
	        System.out.print(  "              | Masa Kerja		 : ");
	        pm.setMasa_Kerja(Integer.parseInt(s.nextLine()));        
	        System.out.print(  "              | Gaji Pokok		 : ");
	        pm.setGaji_Pokok(Integer.parseInt(s.nextLine()));        
	        System.out.print(  "              | Lama Bekerja	 : ");
	        pm.setLama_Bekerja(Integer.parseInt(s.nextLine()));        
	        System.out.print(  "              | Tanggal Masuk	 : ");
	        pm.setTanggal_Masuk(s.nextLine());       
	        System.out.print(  "              | Tanggal Keluar	 : ");
	        pm.setTanggal_keluar(s.nextLine());       
	        System.out.println("              ************************************                  ");
	        
	        opr.SavePegawaiMagang(pm);
	        System.out.print("[B] Tekan Tombol B untuk kembali ke menu sebelumnya: ");
			back = s.next().charAt(0);
			if (back == 'B' || back == 'b') {
				displayMenuPegawaiMagang.displayMenuPM();
			}
	        s.close();
	}
	
}

