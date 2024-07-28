package test;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class CustRegisterDAO {
	public int k = 0;
	public int register(CustomerBean cb) {
		try {
			Connection con = DBConnection.getCon();
			PreparedStatement ps = con.prepareStatement("INSERT INTO Customer VALUES (?,?,?,?,?,?,?)");
			ps.setString(1, cb.getUname());
			ps.setString(2, cb.getPword());
			ps.setString(3, cb.getFname());
			ps.setString(4, cb.getLname());
			ps.setString(5, cb.getAddr());
			ps.setString(6, cb.getMid());
			ps.setLong(7, cb.getPhno());
			k = ps.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}
		return k;
	}
}
