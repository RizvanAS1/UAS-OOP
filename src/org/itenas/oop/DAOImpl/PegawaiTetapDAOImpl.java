package org.itenas.oop.DAOImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.itenas.oop.DAO.PegawaiTetapDAO;
import org.itenas.oop.bea.PegawaiTetap;
import org.itenas.oop.bea.User;
import org.itenas.oop.dbConnection.dbConnection;

public class PegawaiTetapDAOImpl implements PegawaiTetapDAO{
	public static void main(String[] args) {
		
	}
	@Override
	public User LoginPegawaiTetap(String Email, String Password) {
		dbConnection db = new dbConnection();
		User user = new User();
		user = null;
		try {
			db.connect();
			String query = "SELECT * FROM user WHERE Email = '"+Email+"' AND Password='"+Password+"'";
			ResultSet rs = db.readData(query);
			List<User> listUser = new ArrayList<User>();
			
			while (rs.next()) {
				User us = new User();
				us.setEmail(rs.getObject(1).toString());
				us.setPassword(rs.getObject(2).toString());
				
				listUser.add(us);
				
				for(User usr : listUser) {
					if(Email.equals(us.getEmail()) && Password.equals(us.getPassword())) {
						user = usr;
					}
				}
			}
			db.disconnect();
		} catch (SQLException e) {
			System.out.println("The following error has occured: " + e.getMessage());
		}
		return user;
	}

	@Override
	
	public List<PegawaiTetap> GetAllPegawaiTetap() {
		List<PegawaiTetap> listPegawaiTetap = new ArrayList<PegawaiTetap>();
		dbConnection db = new dbConnection();
		String query;
		try {
			db.connect();
			query = "SELECT * FROM pegawaitetap";
			ResultSet rs = db.readData(query);
			
			while (rs.next()) {
				PegawaiTetap pt = new PegawaiTetap();
				pt.setIDP(rs.getObject(1).toString());
				pt.setNama_Pegawai(rs.getObject(2).toString());
				pt.setDivisi(rs.getObject(3).toString());
				pt.setLevel(rs.getObject(4).toString());
				pt.setMasa_Kerja(Integer.parseInt(rs.getObject(5).toString()));
				pt.setStatus(rs.getObject(6).toString());
				pt.setGaji_Pokok(Integer.parseInt(rs.getObject(7).toString()));
				pt.setJumlah_Lembur(Integer.parseInt(rs.getObject(8).toString()));
				pt.setJumlah_Cuti(Integer.parseInt(rs.getObject(9).toString()));
				pt.setJumlah_Absen(Integer.parseInt(rs.getObject(10).toString()));
				pt.setJumlah_Dinas(Integer.parseInt(rs.getObject(11).toString()));
				
				listPegawaiTetap.add(pt);
			}
			db.disconnect();
		} catch (SQLException e) {
			System.out.println("Terjadi error: " + e.getMessage());}
		return listPegawaiTetap;
	}

	@Override
	public void SavePegawaiTetap(PegawaiTetap pt) {
		dbConnection db = new dbConnection();
		String query;
		try {
			db.connect();
			query = "INSERT INTO pegawaitetap (IDP, Nama_Pegawai, Divisi, Level, Masa_Kerja, Status, Gaji_Pokok, Jumlah_Lembur, Jumlah_Cuti, Jumlah_Absen, Jumlah_Dinas)"
				  + "VALUES ('" + pt.getIDP() +"', '"
				  + pt.getNama_Pegawai() +"', '"
				  + pt.getDivisi() +"', '"
				  + pt.getLevel() +"', "
				  + pt.getMasa_Kerja() +", '"
				  + pt.getStatus() +"', "
				  + pt.getGaji_Pokok() +", "
				  + pt.getJumlah_Lembur() +", "
				  + pt.getJumlah_Cuti() +", "
				  + pt.getJumlah_Absen() +", "
				  + pt.getJumlah_Dinas() +")";
			db.executeQuery(query);
			System.out.println("Data berhasil ditambahkan!");
		} catch (Exception e) {
			System.out.println("Terjadi error: " + e.getMessage());
		}
	}

	@Override
	public void UpdateBioPegawaiT(PegawaiTetap pt) {
		dbConnection db = new dbConnection();
		String query;
		try {
			db.connect();
			query = "UPDATE pegawaitetap SET IDP='"+ pt.getIDP() +"',"
				  + " Nama_Pegawai ='"+ pt.getNama_Pegawai() +"',"
				  + " Divisi ='"+ pt.getDivisi() +"',"
				  + " Level ='"+ pt.getLevel() +"',"
				  + " Masa_Kerja ="+ pt.getMasa_Kerja() +","
				  + " Status ='"+ pt.getStatus() +"',"
				  + " Gaji_Pokok ="+ pt.getGaji_Pokok() +","
				  + " Jumlah_Lembur ="+ pt.getJumlah_Lembur() +","
				  + " Jumlah_Cuti ="+ pt.getJumlah_Cuti() +","
				  + " Jumlah_Absen ="+ pt.getJumlah_Absen() +","
				  + " Jumlah_Dinas ="+ pt.getJumlah_Dinas() +" WHERE IDP='"+ pt.getIDP() +"'";
			db.executeQuery(query);
			System.out.println("Data berhasil diperbarui!");
		} catch (Exception e) {
			System.out.println("Terjadi error: " + e.getMessage());
		}
	}
}
