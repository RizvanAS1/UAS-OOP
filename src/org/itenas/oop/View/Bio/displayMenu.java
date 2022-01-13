package org.itenas.oop.View.Bio;

import java.util.Scanner;

import org.itenas.oop.DAO.AdminDAO;
import org.itenas.oop.DAOImpl.AdminDAOImpl;
import org.itenas.oop.View.Main;

public class displayMenu {
	public static void displayMenuBioPegawai() {
		Scanner s = new Scanner (System.in);
		AdminDAO opr = new AdminDAOImpl();
		int menu;
		System.out.println("              *****************************************                  ");
        System.out.println("              |            Biodata Pegawai            |                  ");
        System.out.println("              *****************************************                  ");
        System.out.println("              | Pilihan:                              |                  ");
        System.out.println("              |        1. Input Biodaata              |  				 ");
        System.out.println("              |        2. Cari Data By Email          |                  ");
        System.out.println("              |        3. Tampilkan Seluruh Data      |                  ");
        System.out.println("              |        4. Perbarui Data               |                  ");
        System.out.println("              |        5. Hapus Data                  |                  ");
        System.out.println("              |        6. Logout                      |                  ");
        System.out.println("              *****************************************                  ");	
        System.out.println();
        System.out.print("Pilih menu: ");
        menu = s.nextInt();
        while (!(menu == 1 || menu == 2 || menu == 3 || menu == 4 || menu == 5 || menu == 6)) {
        	System.out.println("Warning: Menu yang Anda masukkan salah!");
        	System.out.print("Silahkan pilih menu kembali: ");
        	menu = s.nextInt();
        }
        switch (menu) {
        	case 1:
        		Form.FormInsertBioPegawai();
        		break;
        	case 2:
        		Form.FormCariBioPegawai();
        		break;
        	case 3:
        		BioPegawai.DisplayBioPegawai(opr.GetAllBioPegawai());
        		break;
        	case 4:
        		Form.FormUpdateBioPegawai();
        		break;
        	case 5:
        		Form.FormDeleteBioPegawai();
        		break;
        	case 6:
        		Main.OpeningMenu();
        		break;
        	default:
        		break;
        }
        s.close();
	}
	
}
