package org.itenas.oop.bea;

public class User {
	private String Email;
	private String Password;
	private String Nama;
	private String Gender;
	private String DOB;
	private String Telpn;
	private String Alamat;
	
	//Setter & Getter
	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getNama() {
		return Nama;
	}

	public void setNama(String nama) {
		Nama = nama;
	}

	public String getGender() {
		return Gender;
	}

	public void setGender(String gender) {
		Gender = gender;
	}

	public String getDOB() {
		return DOB;
	}

	public void setDOB(String dOB) {
		DOB = dOB;
	}

	public String getTelpn() {
		return Telpn;
	}

	public void setTelpn(String telpn) {
		Telpn = telpn;
	}

	public String getAlamat() {
		return Alamat;
	}

	public void setAlamat(String alamat) {
		Alamat = alamat;
	}
}
