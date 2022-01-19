package org.itenas.oop.View;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		OpeningMenu();
	}
	
	public static void OpeningMenu() {
		Scanner s = new Scanner (System.in);
		int menu;
		System.out.println("              ******************************************                  ");
        System.out.println("              |             Selamat Datang             |                  ");
        System.out.println("              ******************************************                  ");
        System.out.println("              |              1. Admin                  |  				  ");
        System.out.println("              |              2. Pegawai Tetap          |                  ");
        System.out.println("              |              3. Pegawai Non Tetap      |                  ");
        System.out.println("              |              4. Exit                   |                  ");
        System.out.println("              ******************************************                  ");	
        System.out.println();
        System.out.print("Pilih Menu: ");
        menu = s.nextInt();
        while (!(menu == 1 || menu == 2 || menu == 3 || menu == 4)) {
        	System.out.println("Warning: Menu yang Anda masukkan salah!");
        	System.out.print("Silahkan pilih menu kembali: ");
        	menu = s.nextInt();
        }
        switch(menu) {
        	case 1:
        		FormLogin.LoginAdmin();
        		break;
        	case 2:
        		displayMenuPegawaiTetap.displayMenuPT();
        		break;
        	case 3:
        		displayMenuPegawainonTetap.displayMenunonPT();
        	case 4:
        		System.out.println("Terima Kasih...");
        		System.exit(0);
        		break;
        	default:
        		break;
        }
        s.close();
	}
}
