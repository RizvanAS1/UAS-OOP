package org.itenas.oop.View;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;
import org.itenas.oop.DAO.PegawaiMagangDAO;
import org.itenas.oop.DAOImpl.PegawaiMagangDAOImpl;
import org.itenas.oop.bea.PegawaiMagang;


public class displayPegawaiMagang {
	public static void main(String[] args) {
		PegawaiMagangDAO opr = new PegawaiMagangDAOImpl();
		//DisplayPegawaiMagang(opr.GetAllPegawaiMagang());
		FormSlipGaji(opr.GetAllPegawaiMagang());
	}
	
	public static void DisplayPegawaiMagang(List<PegawaiMagang> listPegawaiMagang) {
		Scanner s = new Scanner(System.in);
		char back;
		System.out.println();
		System.out.println("     ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		System.out.println("    							                                                    DATA PEGAWAI  Magang                                                                                                ");
		System.out.println("     ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		System.out.println("    |\tIDPM\t\t|\tNama\t\t|\tDivisi\t\t|\tMasa Kerja\t|\tStatus\t\t|\tGaji Pokok\t|\tLama Bekerja\t|\tTanggal Masuk\t|\tTanggal Keluar\t|");
		System.out.println("     ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		for (PegawaiMagang pm : listPegawaiMagang) {
			System.out.println("    |\t"+pm.getIDPM()+"\t|\t"+pm.getNama_PegawaiM()+"\t|\t"+pm.getDivisi()+"\t|\t"+pm.getMasa_Kerja()+"\t\t|\t"+pm.getStatus()+"\t\t|\t"+pm.getGaji_Pokok()+"\t\t|\t"+pm.getLama_Bekerja()+"\t\t|\t"+pm.getTanggal_Masuk()+"\t\t|\t"+pm.getTanggal_keluar()+"\t\t|");
			System.out.println("     ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		}
		System.out.print("[B] Tekan Tombol B untuk kembali ke menu sebelumnya: ");
		back = s.next().charAt(0);
		if (back == 'B' || back == 'b') {
			displayMenuPegawaiMagang.displayMenuPM();
		}
		s.close();
	}
	
	public static void FormSlipGaji(List<PegawaiMagang> listPegawaiMagang) {
		Scanner s = new Scanner (System.in);
		LocalDate myObj = LocalDate.now();
		PegawaiMagang pegawaiMagang = new PegawaiMagang();
		char back;
		String IDPM;
		System.out.print("Masukkan IDPM : ");
		IDPM = s.nextLine();
		pegawaiMagang.setIDPM(IDPM);
		for (PegawaiMagang pm : listPegawaiMagang) {
			if(IDPM.equals(pm.getIDPM())){
				
				System.out.println("              *************************************                  ");
		        System.out.println("              |             Slip Gaji             |                  ");
		        System.out.println("              *************************************                  ");
		        System.out.print  ("              | Tanggal			: ");
		        System.out.println(myObj);
		        System.out.println("              | Nama			: " +pm.getNama_PegawaiM());
		        System.out.println("              | IDPM			: " +pm.getIDPM());
		        System.out.println("              | Gaji Pokok		: Rp. " +pm.getGaji_Pokok());
		        System.out.println("              | Total Gaji		: Rp. " +pm.getGaji_Pokok());
			}
		}
		System.out.print("[B] Tekan Tombol B untuk kembali ke menu sebelumnya: ");
		back = s.next().charAt(0);
		if (back == 'B' || back == 'b') {
			displayMenuPegawaiMagang.displayMenuPM();
		}
		s.close();
	}

}
