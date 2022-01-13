package org.itenas.oop.DAO;

import java.util.List;
import org.itenas.oop.bea.Admin;
import org.itenas.oop.bea.User;

public interface AdminDAO {
	//Login
	public Admin LoginAdmin(String Id, String Pw);
	//CRUD
	public List<User> GetAllBioPegawai();
	public void GetBioPegawaiByEmail(String Email);
	public void SaveBioPegawai(User us);
	public void UpdateBioPegawai(User us);
	public void DeleteBioPegawai(User us);
}
