package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PayDAO {
	public int k = 0;
	public BookBean getBookDetails(String code) {
		BookBean bb = new BookBean();
		try {
			Connection con = DBConnection.getCon();
			PreparedStatement ps = con.prepareStatement("SELECT * FROM BookDetails WHERE Code = ?");
			ps.setString(1, code);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				bb.setCode(rs.getString("code"));
				bb.setPrice(rs.getFloat("price"));
				bb.setQty(rs.getInt("qty"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return bb;
	}
	public int update(BookBean bb) {
		try {
			Connection con = DBConnection.getCon();
			PreparedStatement ps = con.prepareStatement("UPDATE BookDetails SET Quantity = ? WHERE Code = ?");
			ps.setInt(1, bb.getQty());
			ps.setString(2, bb.getCode());
			k = ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return k;
	}
}
