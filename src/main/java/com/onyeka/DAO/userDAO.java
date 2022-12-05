package com.onyeka.DAO;
import java.sql.*;
import com.onyeka.model.*;

public class userDAO {
	Connection con;
	PreparedStatement pst;
	
	public userDAO(Connection con) {
		this.con=con;
	}
	public User getUser(String email,String password) {
		String query="SELECT * FROM USERS WHERE email=? AND password=?";
		User user=null;
		try {
			pst=con.prepareStatement(query);
			pst.setString(1, email);
			pst.setString(2, password);
			ResultSet rs=pst.executeQuery();
			if(rs.next()) {
				user=new User();
				user.setUserId(rs.getInt(1));
				user.setEmail(rs.getString(2));
				user.setfName(rs.getString(3));
				user.setlName(rs.getString(4));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}
}
