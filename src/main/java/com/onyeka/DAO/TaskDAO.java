package com.onyeka.DAO;

import java.sql.*;
import com.onyeka.model.*;
import java.util.*;

public class TaskDAO {
	Connection con;
	
	public TaskDAO(Connection con) {
		this.con=con;
	}
	
	public ArrayList<Task> getSpecificTasks(int ListID) {
		ArrayList<Task> specTasks=new ArrayList<>();
		String query="SELECT TaskID,ListID,TaskName,Date(DateAdded),isCompleted FROM TASKS WHERE ListID=?";
		try {
			PreparedStatement pst=con.prepareStatement(query);
			pst.setInt(1, ListID);
			ResultSet rs=pst.executeQuery();
			while(rs.next()) {
				Task tsk=new Task();
				tsk.setTaskID(rs.getInt(1));
				tsk.setListID(rs.getInt(2));
				tsk.setTaskName(rs.getString(3));
				tsk.setDateCreated(rs.getString(4));
				tsk.setCompleted(rs.getBoolean(5));
				specTasks.add(tsk);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return specTasks;
	}
	public int insertTasks(String desc,int ListID, int userID) {
		String query="INSERT INTO TASKS(ListID, TaskName,UserID) VALUES(?,?,?)";
		int rowCount=0;
		try {
			PreparedStatement pst=con.prepareStatement(query);
			pst.setInt(1, ListID);
			pst.setString(2, desc);
			pst.setInt(3, userID);
			rowCount=pst.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return rowCount;
	}
	public int MarkComplete(int TaskId) {
		String query="UPDATE TASKS SET isCompleted=true where TaskID=?";
		int rowCount=0;
		try {
			PreparedStatement pst=con.prepareStatement(query);
			pst.setInt(1, TaskId);
			rowCount=pst.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return rowCount;
	}
	public int DeleteTask(int TaskID) {
		String query = "DELETE FROM TASKS WHERE TaskID = ?";
		int rowCount=0;
		try {
			PreparedStatement pst=con.prepareStatement(query);
			pst.setInt(1, TaskID);
			rowCount=pst.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return rowCount;
	}
	public ArrayList<Task> getAllTasks(int userID) {
		ArrayList<Task> specTasks=new ArrayList<>();
		String query="SELECT TaskID,ListID,TaskName,Date(DateAdded),isCompleted FROM TASKS WHERE userID=? ORDER BY 5";
		try {
			PreparedStatement pst=con.prepareStatement(query);
			pst.setInt(1, userID);
			ResultSet rs=pst.executeQuery();
			while(rs.next()) {
				Task tsk=new Task();
				tsk.setTaskID(rs.getInt(1));
				tsk.setListID(rs.getInt(2));
				tsk.setTaskName(rs.getString(3));
				tsk.setDateCreated(rs.getString(4));
				tsk.setCompleted(rs.getBoolean(5));
				specTasks.add(tsk);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return specTasks;
	}
	
	public int completedTasks(ArrayList<Task> specTasks) {
		int completed=0;
		for(Task t:specTasks) {
			if(t.isCompleted()) {
				completed++;
			}
		}
		return completed;
	}

}
