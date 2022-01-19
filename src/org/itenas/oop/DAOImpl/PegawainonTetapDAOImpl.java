package org.itenas.oop.DAOImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.itenas.oop.DAO.PegawainonTetapDAO;
import org.itenas.oop.bea.PegawainonTetap;
import org.itenas.oop.bea.User;
import org.itenas.oop.dbConnection.dbConnection;

public class PegawainonTetapDAOImpl implements PegawainonTetapDAO{
	@Override
	public User LoginPegawainonTetap(String Email, String Password) {
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
	
	public List<PegawainonTetap> GetAllPegawainonTetap() {
		List<PegawainonTetap> listPegawainonTetap = new ArrayList<PegawainonTetap>();
		dbConnection db = new dbConnection();
		String query;
		try {
			db.connect();
			query = "SELECT * FROM pegawainontetap";
			ResultSet rs = db.readData(query);
			
			while (rs.next()) {
				PegawainonTetap pnt = new PegawainonTetap();
				pnt.setIDPnT(rs.getObject(1).toString());
				pnt.setNama_Pegawai(rs.getObject(2).toString());
				pnt.setDivisi(rs.getObject(3).toString());
				pnt.setLevel(rs.getObject(4).toString());
				pnt.setMasa_Kerja(Integer.parseInt(rs.getObject(5).toString()));
				pnt.setStatus(rs.getObject(6).toString());
				pnt.setGaji_Pokok(Integer.parseInt(rs.getObject(7).toString()));
				pnt.setJumlah_Lembur(Integer.parseInt(rs.getObject(8).toString()));
				pnt.setJumlah_Cuti(Integer.parseInt(rs.getObject(9).toString()));
				pnt.setJumlah_Absen(Integer.parseInt(rs.getObject(10).toString()));
				pnt.setJumlah_Dinas(Integer.parseInt(rs.getObject(11).toString()));
				
				listPegawainonTetap.add(pnt);
			}
			db.disconnect();
		} catch (SQLException e) {
			System.out.println("Terjadi error: " + e.getMessage());}
		return listPegawainonTetap;
	}

	@Override
	public void SavePegawainonTetap(PegawainonTetap pnt) {
		dbConnection db = new dbConnection();
		String query;
		try {
			db.connect();
			query = "INSERT INTO pegawainontetap (IDPnT, Nama_Pegawai, Divisi, Level, Masa_Kerja, Status, Gaji_Pokok, Jumlah_Lembur, Jumlah_Cuti, Jumlah_Absen, Jumlah_Dinas)"
				  + "VALUES ('" + pnt.getIDPnT() +"', '"
				  + pnt.getNama_Pegawai() +"', '"
				  + pnt.getDivisi() +"', '"
				  + pnt.getLevel() +"', "
				  + pnt.getMasa_Kerja() +", '"
				  + pnt.getStatus() +"', "
				  + pnt.getGaji_Pokok() +", "
				  + pnt.getJumlah_Lembur() +", "
				  + pnt.getJumlah_Cuti() +", "
				  + pnt.getJumlah_Absen() +", "
				  + pnt.getJumlah_Dinas() +")";
			db.executeQuery(query);
			System.out.println("Data berhasil ditambahkan!");
		} catch (Exception e) {
			System.out.println("Terjadi error: " + e.getMessage());
		}
	}
}
