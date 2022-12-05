package com.onyeka.model;

public class Task extends ListP {
	private int TaskID;
	private String TaskName;
	private String DateCreated;
	private boolean isCompleted;
	
	public int getTaskID() {
		return TaskID;
	}
	public void setTaskID(int taskID) {
		TaskID = taskID;
	}
	public String getTaskName() {
		return TaskName;
	}
	public void setTaskName(String taskName) {
		TaskName = taskName;
	}
	public String getDateCreated() {
		return DateCreated;
	}
	public void setDateCreated(String dateCreated) {
		DateCreated = dateCreated;
	}
	public boolean isCompleted() {
		return isCompleted;
	}
	public void setCompleted(boolean isCompleted) {
		this.isCompleted = isCompleted;
	}
	
}
