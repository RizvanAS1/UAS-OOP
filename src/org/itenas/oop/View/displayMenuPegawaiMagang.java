package org.itenas.oop.View;

import java.util.Scanner;

import org.itenas.oop.DAO.PegawaiMagangDAO;
import org.itenas.oop.DAOImpl.PegawaiMagangDAOImpl;

public class displayMenuPegawaiMagang {
	public static void displayMenuPM() {
			
			Scanner s = new Scanner (System.in);
			PegawaiMagangDAO opr = new PegawaiMagangDAOImpl();
			int menu;
			System.out.println("              **************************************                  ");
	        System.out.println("              |        Data Pegawai Magang         |                  ");
	        System.out.println("              **************************************                  ");
	        System.out.println("              | Pilihan:                           |                  ");
	        System.out.println("              |        1. Input Data               |  				  ");
	        System.out.println("              |        2. Tampilkan Seluruh Data   |                  ");
	        System.out.println("              |        3. Update Data              |                  ");
	        System.out.println("              |        4. Cetak Slip Gaji          |                  ");
	        System.out.println("              |        5. Logout                   |                  ");
	        System.out.println("              **************************************                  ");	
	        System.out.println();
	        System.out.print("Pilih menu: ");
	        menu = s.nextInt();
	        while (!(menu == 1 || menu == 2 || menu == 3 || menu == 4 || menu == 5)) {
	        	System.out.println("Warning: Menu yang Anda masukkan salah!");
	        	System.out.print("Silahkan pilih menu kembali: ");
	        	menu = s.nextInt();
	        }
	        switch(menu) {
	        case 1:
	        	Form.FormInsertPegawaiMagang();
	        	break;
	        case 2:
	        	displayPegawaiMagang.DisplayPegawaiMagang(opr.GetAllPegawaiMagang());
	        	break;
	        case 3:
	        	Form.FormUpdatePegawaiMagang();
	        	break;
	        case 4:
	        	displayPegawaiMagang.FormSlipGaji(opr.GetAllPegawaiMagang());
	        	break;
	        case 5:
	        	Main.OpeningMenu();
	        	break;
	        default:
	        	break;
	        }
	        s.close();
		}
}
