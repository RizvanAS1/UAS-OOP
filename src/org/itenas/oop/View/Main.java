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
        System.out.println("              |              2. Pegawai                |                  ");
        System.out.println("              |              3. Exit                   |                  ");
        System.out.println("              ******************************************                  ");	
        System.out.println();
        System.out.print("Pilih Menu: ");
        menu = s.nextInt();
        while (!(menu == 1 || menu == 2 || menu == 3)) {
        	System.out.println("Warning: Menu yang Anda masukkan salah!");
        	System.out.print("Silahkan pilih menu kembali: ");
        	menu = s.nextInt();
        }
        switch(menu) {
        	case 1:
        		FormLogin.LoginAdmin();
        		break;
        	case 2:
        		PilihPegawai();
        		break;
        	case 3:
        		System.out.println("Terima Kasih Wahai Para Pegawai-Pegawai Ku...");
        		System.exit(0);
        	default:
        		break;
        }
        s.close();
	}
	
	public static void PilihPegawai() {
		Scanner s = new Scanner (System.in);
		int menu;
		System.out.println("              ******************************************                  ");
        System.out.println("              |            Selamat Datang              |                  ");
        System.out.println("              ******************************************                  ");
        System.out.println("              |            1. Pegawai Tetap            |  				  ");
        System.out.println("              |            2. Pegawai Non Tetap        |                  ");
        System.out.println("              |            3. Pegawai Magang           |                  ");
        System.out.println("              |            4. Kembali                  |                  ");
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
    		displayMenuPegawaiTetap.displayMenuPT();
    		break;
    	case 2:
    		displayMenuPegawainonTetap.displayMenunonPT();
    		break;
    	case 3:
    		displayMenuPegawaiMagang.displayMenuPM();
    	case 4:
    		OpeningMenu();
    		break;
    	default:
    		break;
        }
        s.close();
	}
	
}
