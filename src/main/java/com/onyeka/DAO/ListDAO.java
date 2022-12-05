package com.onyeka.DAO;
import java.sql.*;

import java.util.ArrayList;
import com.onyeka.model.ListP;
public class ListDAO {
	private Connection con;
	
	public ListDAO(Connection con) {
		this.con=con;
	}
	
	public ArrayList<ListP> getLists(int id){
		String query="SELECT ListID,UserId,ListName,date(DateCreated) FROM Lists WHERE UserId=?";
		ArrayList<ListP> Lists=new ArrayList<>();
		try {
			PreparedStatement pst=con.prepareStatement(query);
			pst.setInt(1, id);
			ResultSet rs=pst.executeQuery();
			while(rs.next()) {
				ListP list=new ListP();
				list.setListID(rs.getInt(1));
				list.setListName(rs.getString(3));
				list.setDateCreated(rs.getString(4));
				Lists.add(list);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return Lists;
	}
	
	public ArrayList<ListP> getLists(int id,String query){
		ArrayList<ListP> Lists=new ArrayList<>();
		try {
			PreparedStatement pst=con.prepareStatement(query);
			pst.setInt(1, id);
			ResultSet rs=pst.executeQuery();
			while(rs.next()) {
				ListP list=new ListP();
				list.setListID(rs.getInt(1));
				list.setListName(rs.getString(3));
				list.setDateCreated(rs.getString(4));
				Lists.add(list);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return Lists;
	}
	
	public int insertList(String listDesc, int id) {
		String query="INSERT INTO Lists(ListName,UserId) VALUES(?,?)";
		int rowsAffected=0;
		try {
			PreparedStatement pst=con.prepareStatement(query);
			pst.setString(1, listDesc);
			pst.setInt(2, id);
			rowsAffected=pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rowsAffected;
	}
}
