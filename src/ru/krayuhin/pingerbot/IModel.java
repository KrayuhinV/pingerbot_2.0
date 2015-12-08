package ru.krayuhin.pingerbot;

import java.util.List;

public interface IModel {
	
	public int getThreadCount();
	public String getUrl(int index);
	public int getAttempts(int index);
	public int getOkAttempts(int index);
	public void setTime(int index, long times);
	public long getTime(int index);
	public void setAttempts(int index,int attempts);
	public void setOkAttempts(int index,int okattempts);
	public int getMaxId();
	public void addNewTask(String name, String url);
	public void deleteTask(int id);
	public String getTask(int id);
	public List<Task> getTaskList();
	public String getAllTasks();
}
