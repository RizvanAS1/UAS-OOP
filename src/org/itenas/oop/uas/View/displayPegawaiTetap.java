package org.itenas.oop.View;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;
import org.itenas.oop.DAO.PegawaiTetapDAO;
import org.itenas.oop.DAOImpl.PegawaiTetapDAOImpl;
import org.itenas.oop.bea.PegawaiTetap;

public class displayPegawaiTetap {
	public static void main(String[] args) {
		PegawaiTetapDAO opr = new PegawaiTetapDAOImpl();
		//DisplayPegawaiTetap(opr.GetAllPegawaiTetap());
		FormSlipGaji(opr.GetAllPegawaiTetap());
	}
	
	public static void DisplayPegawaiTetap(List<PegawaiTetap> listPegawaiTetap) {
		Scanner s = new Scanner(System.in);
		char back;
		System.out.println();
		System.out.println("     ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		System.out.println("    							                                                    DATA PEGAWAI  TETAP                                                                                                ");
		System.out.println("     ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		System.out.println("    |\tIDP\t\t|\tNama\t\t|\tDivisi\t\t|\tLevel\t\t|\tMasa Kerja\t|\tStatus\t\t|\tGaji Pokok\t|\tJumlah Cuti\t|\tJumlah Absen\t|\tJumlah Dinas\t|");
		System.out.println("     ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		for (PegawaiTetap pt : listPegawaiTetap) {
			System.out.println("    |\t"+pt.getIDP()+"\t|\t"+pt.getNama_Pegawai()+"\t|\t"+pt.getDivisi()+"\t|\t"+pt.getLevel()+"\t|\t"+pt.getMasa_Kerja()+"\t\t|\t"+pt.getStatus()+"\t\t|\t"+pt.getGaji_Pokok()+"\t\t|\t"+pt.getJumlah_Cuti()+"\t\t|\t"+pt.getJumlah_Absen()+"\t\t|\t"+pt.getJumlah_Dinas()+"\t\t|");
			System.out.println("     ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		}
		System.out.print("[B] Tekan Tombol B untuk kembali ke menu sebelumnya: ");
		back = s.next().charAt(0);
		if (back == 'B' || back == 'b') {
			displayMenuPegawaiTetap.displayMenuPT();
		}
		s.close();
	}
	
	public static void FormSlipGaji(List<PegawaiTetap> listPegawaiTetap) {
		Scanner s = new Scanner (System.in);
		LocalDate myObj = LocalDate.now();
		PegawaiTetap pegawaiTetap = new PegawaiTetap();
		char back;
		String IDP;
		System.out.print("Masukkan IDP : ");
		IDP = s.nextLine();
		pegawaiTetap.setIDP(IDP);
		for (PegawaiTetap pt : listPegawaiTetap) {
			if(IDP.equals(pt.getIDP())){
				int bonus = pt.getJumlah_Dinas() * 250000;
				int pajak = pt.getJumlah_Cuti() * 150000;
				System.out.println("              *************************************                  ");
		        System.out.println("              |             Slip Gaji             |                  ");
		        System.out.println("              *************************************                  ");
		        System.out.print  ("              | Tanggal			: ");
		        System.out.println(myObj);
		        System.out.println("              | Nama			: " +pt.getNama_Pegawai());
		        System.out.println("              | Jabatan			: " +pt.getLevel());
		        System.out.println("              | IDP			: " +pt.getIDP());
		        System.out.println("              | Gaji Pokok		: Rp. " +pt.getGaji_Pokok());
		        System.out.println("              | Dinas			: Rp. " +bonus);
		        System.out.println("              | Pajak			: Rp. " +pajak);
		        System.out.println("              | Total Gaji		: Rp. " +(pt.getGaji_Pokok() + bonus - pajak));
			}
		}
		System.out.print("[B] Tekan Tombol B untuk kembali ke menu sebelumnya: ");
		back = s.next().charAt(0);
		if (back == 'B' || back == 'b') {
			displayMenuPegawaiTetap.displayMenuPT();
		}
		s.close();
	}
}
