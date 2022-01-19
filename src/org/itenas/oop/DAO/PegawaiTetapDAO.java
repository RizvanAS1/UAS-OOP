package org.itenas.oop.DAO;

import java.util.List;
import org.itenas.oop.bea.PegawaiTetap;
import org.itenas.oop.bea.User;

public interface PegawaiTetapDAO {
	//Login
	public User LoginPegawaiTetap(String Email, String Password);
	public List<PegawaiTetap> GetAllPegawaiTetap();
	public void SavePegawaiTetap(PegawaiTetap pt);
	public void UpdateBioPegawaiT(PegawaiTetap pt);
}
