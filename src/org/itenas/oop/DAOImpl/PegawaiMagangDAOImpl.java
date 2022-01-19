package org.itenas.oop.DAOImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.itenas.oop.DAO.PegawaiMagangDAO;
import org.itenas.oop.bea.PegawaiMagang;
import org.itenas.oop.bea.User;
import org.itenas.oop.dbConnection.dbConnection;

public class PegawaiMagangDAOImpl implements PegawaiMagangDAO{

	@Override
	public User LoginPegawaiMagang(String Email, String Password) {
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
	public List<PegawaiMagang> GetAllPegawaiMagang() {
		List<PegawaiMagang> listPegawaiMagang = new ArrayList<PegawaiMagang>();
		dbConnection db = new dbConnection();
		String query;
		
		try {
			db.connect();
			query = "SELECT * FROM pegawaimagang";
			ResultSet rs = db.readData(query);
			
			while (rs.next()) {
				PegawaiMagang pm = new PegawaiMagang();
				pm.setIDPM(rs.getObject(1).toString());
				pm.setNama_PegawaiM(rs.getObject(2).toString());
				pm.setDivisi(rs.getObject(3).toString());
				pm.setMasa_Kerja(Integer.parseInt(rs.getObject(4).toString()));
				pm.setStatus(rs.getObject(5).toString());
				pm.setGaji_Pokok(Integer.parseInt(rs.getObject(6).toString()));
				pm.setLama_Bekerja(Integer.parseInt(rs.getObject(7).toString()));
				pm.setTanggal_Masuk(rs.getObject(8).toString());
				pm.setTanggal_keluar(rs.getObject(9).toString());
				
				listPegawaiMagang.add(pm);
			}
			db.disconnect();
		} catch (SQLException e) {
			System.out.println("Terjadi error: " + e.getMessage());}
		return listPegawaiMagang;
	}

	@Override
	public void SavePegawaiMagang(PegawaiMagang pm) {
		dbConnection db = new dbConnection();
		String query;
		try {
			db.connect();
			query = "INSERT INTO pegawaimagang (IDPM, Nama_PegawaiM, Divisi, Masa_Kerja, Status, Gaji_Pokok, Lama_Bekerja, Tanggal_Masuk, Tanggal_Keluar)"
				  + "VALUES ('" + pm.getIDPM() +"', '"
				  + pm.getNama_PegawaiM() +"', '"
				  + pm.getDivisi() +"', '"
				  + pm.getMasa_Kerja() +"', '"
				  + pm.getStatus() +"', '"
				  + pm.getGaji_Pokok() +"', '"
				  + pm.getLama_Bekerja() +"', '"
				  + pm.getTanggal_Masuk() +"', '"
				  + pm.getTanggal_keluar() +"')";
			db.executeQuery(query);
			System.out.println("Data berhasil ditambahkan!");
		} catch (Exception e) {
			System.out.println("Terjadi error: " + e.getMessage());
		}
	}

	@Override
	public void UpdateBioPegawaiM(PegawaiMagang pm) {
		dbConnection db = new dbConnection();
		String query;
		try {
			db.connect();
			query = "UPDATE pegawaimagang SET IDPM='"+ pm.getIDPM() +"',"
				  + " Nama_PegawaiM ='"+ pm.getNama_PegawaiM() +"',"
				  + " Divisi ='"+ pm.getDivisi() +"',"
				  + " Masa_Kerja ="+ pm.getMasa_Kerja() +","
				  + " Status ='"+ pm.getStatus() +"',"
				  + " Gaji_Pokok ="+ pm.getGaji_Pokok() +","
				  + " Lama_Bekerja ="+ pm.getLama_Bekerja() +","
				  + " Tanggal_Masuk ="+ pm.getTanggal_Masuk() +","
				  + " Tanggal_Keluar ="+ pm.getTanggal_keluar() +" Where IDPM="+ pm.getIDPM();
			db.executeQuery(query);
			System.out.println("Data berhasil diperbarui!");
		} catch (Exception e) {
			System.out.println("Terjadi error: " + e.getMessage());
		}
	}
}
