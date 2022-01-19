package org.itenas.oop.View;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import org.itenas.oop.DAO.PegawainonTetapDAO;
import org.itenas.oop.DAOImpl.PegawainonTetapDAOImpl;
import org.itenas.oop.bea.PegawainonTetap;

public class displayPegawainonTetap {
	public static void main(String[] args) {
		PegawainonTetapDAO nopr = new PegawainonTetapDAOImpl();
		DisplayPegawainonTetap(nopr.GetAllPegawainonTetap());
		FormSlipGaji(nopr.GetAllPegawainonTetap());
	}
	
	public static void DisplayPegawainonTetap(List<PegawainonTetap> listPegawainonTetap) {
		Scanner s = new Scanner(System.in);
		char back;
		System.out.println();
		System.out.println("     ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		System.out.println("    							                                                    DATA PEGAWAI NON TETAP                                                                                                ");
		System.out.println("     ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		System.out.println("    |\tIDP\t\t|\tNama\t\t|\tDivisi\t\t|\tLevel\t\t|\tMasa Kerja\t|\tStatus\t\t|\tGaji Pokok\t|\tJumlah Lembur\t|\tJumlah Cuti\t|\tJumlah Absen\t|\tJumlah Dinas\t|");
		System.out.println("     ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		for (PegawainonTetap pnt : listPegawainonTetap) {
			System.out.println("    |\t"+pnt.getIDP()+"\t|\t"+pnt.getNama_Pegawai()+"\t|\t"+pnt.getDivisi()+"\t|\t"+pnt.getLevel()+"\t|\t"+pnt.getMasa_Kerja()+"\t\t|\t"+pnt.getStatus()+"\t\t|\t"+pnt.getGaji_Pokok()+"\t\t|\t"+pnt.getJumlah_Lembur()+"\t\t|\t"+pnt.getJumlah_Cuti()+"\t\t|\t"+pnt.getJumlah_Absen()+"\t\t|\t"+pnt.getJumlah_Dinas()+"\t\t|");
			System.out.println("     ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		}
		System.out.print("[B] Tekan Tombol B untuk kembali ke menu sebelumnya: ");
		back = s.next().charAt(0);
		if (back == 'B' || back == 'b') {
			displayMenuPegawainonTetap.displayMenunonPT();
		}
		s.close();
	}
	
	public static void FormSlipGaji(List<PegawainonTetap> listPegawainonTetap) {
		Scanner s = new Scanner (System.in);
		LocalDate myObj = LocalDate.now();
		PegawainonTetap pegawainonTetap = new PegawainonTetap();
		char back;
		String IDP;
		System.out.print("Masukkan IDP : ");
		IDP = s.nextLine();
		pegawainonTetap.setIDP(IDP);
		for (PegawainonTetap pnt : listPegawainonTetap) {
			if(IDP.equals(pnt.getIDP())){
				int bonus = pnt.getJumlah_Dinas() * 250000;
				int potongan = pnt.getJumlah_Cuti() * 150000;
				double pajak = pnt.getGaji_Pokok() * 0.1;
				System.out.println("              *************************************                  ");
		        System.out.println("              |             Slip Gaji             |                  ");
		        System.out.println("              *************************************                  ");
		        System.out.print  ("              | Tanggal			: ");
		        System.out.println(myObj);
		        System.out.println("              | Nama			: " +pnt.getNama_Pegawai());
		        System.out.println("              | Jabatan			: " +pnt.getLevel());
		        System.out.println("              | IDP			: " +pnt.getIDP());
		        System.out.println("              | Gaji Pokok		: Rp. " +pnt.getGaji_Pokok());
		        System.out.println("              | Dinas			: Rp. " +bonus);
		        System.out.println("              | Potongan		: Rp. " +potongan);
		        System.out.println("              | Pajak			: Rp. " +(int)pajak);
		        System.out.println("              | Total Gaji		: Rp. " +((pnt.getGaji_Pokok() + bonus) - potongan - (int)pajak));
			}
		}
		System.out.print("[B] Tekan Tombol B untuk kembali ke menu sebelumnya: ");
		back = s.next().charAt(0);
		if (back == 'B' || back == 'b') {
			displayMenuPegawainonTetap.displayMenunonPT();
		}
		s.close();
	}
}
