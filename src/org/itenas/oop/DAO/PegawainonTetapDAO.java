package org.itenas.oop.DAO;

import java.util.List;
import org.itenas.oop.bea.PegawainonTetap;
import org.itenas.oop.bea.User;

public interface PegawainonTetapDAO {
	//Login
	public User LoginPegawainonTetap(String Email, String Password);
	public List<PegawainonTetap> GetAllPegawainonTetap();
	public void SavePegawainonTetap(PegawainonTetap pnt);
}
