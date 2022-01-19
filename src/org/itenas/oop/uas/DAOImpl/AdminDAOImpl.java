package org.itenas.oop.DAOImpl;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.itenas.oop.DAO.AdminDAO;
import org.itenas.oop.View.Bio.BioPegawai;
import org.itenas.oop.bea.Admin;
import org.itenas.oop.bea.User;
import org.itenas.oop.dbConnection.dbConnection;

//(IDP, Nama_Pegawai, Divisi, Level, Masa_Kerja, Status, Jumlah_Cuti, Jumlah_Absen, Jumlah_Dinas)
public class AdminDAOImpl implements AdminDAO{

	@Override
	public List<User> GetAllBioPegawai() {
		List<User> listUser = new ArrayList<User>();
		dbConnection db = new dbConnection();
		String query;
		
		try {
			db.connect();
			query = "SELECT * FROM user";
			ResultSet rs = db.readData(query);
			
			while(rs.next()) {
				User us = new User();
				us.setEmail(rs.getObject(1).toString());
				us.setPassword(rs.getObject(2).toString());
				us.setNama(rs.getObject(3).toString());
				us.setGender(rs.getObject(4).toString());
				us.setDOB(rs.getObject(5).toString());
				us.setTelpn(rs.getObject(6).toString());
				us.setAlamat(rs.getObject(7).toString());
				
				listUser.add(us);
			}
			db.disconnect();
		} catch (SQLException e) {
			System.out.println("Terjadi error: " + e.getMessage());
		}
		return listUser;
	}

	@Override
	public void GetBioPegawaiByEmail(String Email) {
		dbConnection db = new dbConnection();
		String query;
		User us = new User();
		
		try {
			db.connect();
			query = "SELECT * FROM user WHERE Email='"+Email+"'";
			ResultSet rs = db.readData(query);
			
			if(rs.next()) {
				ResultSetMetaData metaData = rs.getMetaData();
                int jumlahKolom = metaData.getColumnCount();
                do {
                	for (int i = 1; i <= jumlahKolom; i++) {
						us.setEmail(rs.getObject(1).toString());
						us.setPassword(rs.getObject(2).toString());
						us.setNama(rs.getObject(3).toString());
						us.setGender(rs.getObject(4).toString());
						us.setDOB(rs.getObject(5).toString());
						us.setTelpn(rs.getObject(6).toString());
						us.setAlamat(rs.getObject(7).toString());
					}
                }while (rs.next());
			}else {
				us.setEmail(null);
			}
		} catch (SQLException e) {
			System.out.println("Terjadi error: " + e.getMessage());
		}
		BioPegawai.displayTupleBioPegawai(us);
	}

	@Override
	public void SaveBioPegawai(User us) {
		dbConnection db = new dbConnection();
		String query;
		try {
			db.connect();
			query = "INSERT INTO user (Email, Password, Nama, Gender, DOB, NoTlpn, Alamat)"
				  + " VALUES ('" + us.getEmail() + "', '"
				  + us.getPassword() + "', '"
				  + us.getNama() + "', '"
				  + us.getGender() + "', "
				  + us.getDOB() + ", '"
				  + us.getTelpn() + "', '"
				  + us.getAlamat() + "')";
			db.executeQuery(query);
			System.out.println("Data berhasil ditambahkan!");
		} catch (Exception e) {
			System.out.println("Terjadi error: " + e.getMessage());
		}
	}

	@Override
	public void UpdateBioPegawai(User us) {
		dbConnection db = new dbConnection();
		String query;
		try {
			db.connect();
			query = "UPDATE user SET Email='"+us.getEmail()+"',"
				  + " Password ='"+us.getPassword()+"', "
				  + " Nama ='"+us.getNama()+"', "
				  + " Gender ='"+us.getGender()+"', "
				  + " DOB ="+us.getDOB()+", "
				  + " NoTlpn ='"+us.getTelpn()+"', "
				  + " Alamat ='"+us.getAlamat()+"' Where Email='"+us.getEmail()+"'";
			db.executeQuery(query);
			System.out.println("Data berhasil diperbarui!");
		} catch (Exception e) {
			System.out.println("Terjadi error: " + e.getMessage());
		}
	}

	@Override
	public void DeleteBioPegawai(User us) {
		dbConnection db = new dbConnection();
		String query;
		try {
			db.connect();
			query = "DELETE FROM user WHERE Email='"+us.getEmail()+"'";
			db.executeQuery(query);
			System.out.println("Data berhasil dihapus!");
			BioPegawai.DisplayBioPegawai(GetAllBioPegawai());
		} catch (Exception e) {
			System.out.println("Terjadi error: " + e.getMessage());
		}
	}

	@Override
	public Admin LoginAdmin(String Id, String Pw) {
		dbConnection db = new dbConnection();
		Admin adm = new Admin();
		adm = null;
		try {
			db.connect();
			
			String query = "SELECT * FROM admin WHERE Id = '"+Id+"' AND Pw='"+Pw+"'";
			ResultSet rs = db.readData(query);
			List<Admin> listAdmin = new ArrayList<Admin>();
			
			while (rs.next()) {
				Admin admin = new Admin();
				admin.setId(rs.getObject(1).toString());
				admin.setPw(rs.getObject(2).toString());
				
				listAdmin.add(admin);
				
				for (Admin ad : listAdmin) {
					if (Id.equals(ad.getId()) && Pw.equals(ad.getPw())){
						adm = ad;
					}
				}
			}
			db.disconnect();
		} catch (SQLException e) {
			System.out.println("The following error has occured: " + e.getMessage());
		}
		return adm;
	}
}
