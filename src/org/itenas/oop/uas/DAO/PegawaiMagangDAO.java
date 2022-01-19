package org.itenas.oop.DAO;

import java.util.List;

import org.itenas.oop.bea.PegawaiMagang;
import org.itenas.oop.bea.PegawaiTetap;
import org.itenas.oop.bea.User;

public interface PegawaiMagangDAO {
	//Login
	public User LoginPegawaiMagang(String Email, String Password);
	public List<PegawaiMagang> GetAllPegawaiMagang();
	public void SavePegawaiMagang(PegawaiMagang pm);
	

}
