package com.onyeka.model;

public class ListP {
	private int ListID;
	private String listName;
	private String DateCreated;
	public ListP() {
		
	}
	public int getListID() {
		return ListID;
	}
	public void setListID(int listID) {
		ListID = listID;
	}
	public String getListName() {
		return listName;
	}
	public void setListName(String listName) {
		this.listName = listName;
	}
	public String getDateCreated() {
		return DateCreated;
	}
	public void setDateCreated(String dateCreated) {
		DateCreated = dateCreated;
	}
	
}
