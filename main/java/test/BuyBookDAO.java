package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BuyBookDAO {
	public BookBean bb = null;
	public BookBean buy(String code) {
		try {
			Connection con = DBConnection.getCon();
			PreparedStatement ps = con.prepareStatement("SELECT * FROM BookDetails WHERE Code = ?");
			ps.setString(1, code);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				bb = new BookBean();
				bb.setCode(rs.getString(1));
				bb.setName(rs.getString(2));
				bb.setAuthor(rs.getString(3));
				bb.setPrice(rs.getFloat(4));
				bb.setQty(rs.getInt(5));
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return bb;
	}
}
