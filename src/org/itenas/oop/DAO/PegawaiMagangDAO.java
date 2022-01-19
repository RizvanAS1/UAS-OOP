package org.itenas.oop.DAO;

import org.itenas.oop.bea.User;
import java.util.List;
import org.itenas.oop.bea.PegawaiMagang;

public interface PegawaiMagangDAO {
	public User LoginPegawaiMagang(String Email, String Password);
	public List<PegawaiMagang> GetAllPegawaiMagang();
	public void SavePegawaiMagang(PegawaiMagang pm);
}
