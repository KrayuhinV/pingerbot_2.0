package ru.krayuhin.pingerbot;

import java.io.*;
import java.util.*;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.jdom2.*;
import org.jdom2.filter.ElementFilter;
import org.jdom2.input.*;
import org.jdom2.output.*;

@XmlRootElement(name = "listTask")//observable
public class Model extends Observable implements IModel{
	
	private List<Task> taskList = new ArrayList<Task>();
	int threadCount = 10;
	private List<IView> viewListeners = new ArrayList<IView>();
	
	@Override
	public int getThreadCount() {
		return threadCount;
	}

	public void setThreadCount(int threadCount) {
		this.threadCount = threadCount;
	}
	
	@Override
	public String getUrl(int index){
		return this.taskList.get(index).getUrl();
	}
	
	@Override
	public int getAttempts(int index)
    {
        return this.taskList.get(index).getAttempts();
    }
	
	@Override
	public int getOkAttempts(int index)
    {
        return this.taskList.get(index).getOkAttempts();
    }
	
	@Override
	public long getTime(int index)
    {
        return this.taskList.get(index).getTime();
    }
	
	@Override
	public void setAttempts(int index, int attempts)
    {
        Task task = this.taskList.get(index);
        task.setAttempts(attempts);
        this.taskList.set(index, task);
    }
	
	@Override
	public void setOkAttempts(int index, int okattempts)
    {
        Task task = this.taskList.get(index);
        task.setOkAttempts(okattempts);
        this.taskList.set(index, task);
    }
	
	@Override
    public void setTime(int index, long times)
    {
        Task task = this.taskList.get(index);
        task.setTime(times);
        this.taskList.set(index, task);
    }

	@XmlElement
	public void setTaskLit(List<Task> taskList){
		this.taskList = taskList;
	}
	
	@Override
	public List<Task> getTaskList(){
		return taskList;
	}
	
	public Model(){
		
	}
	
	public void addIview(IView targetListener){
		viewListeners.add(targetListener);
	}
	
	public void removeIview(IView targetListener){
		viewListeners.remove(targetListener);
	}
	
	public void notify(int i){
		
	}
	
	public int getMaxId(){
		int maxId = 1;
		for (Task task : taskList){
			if (task.getId() > maxId ){
				maxId = task.getId();
			}
		}
		return maxId+1;
	}
	
	public void addNewTask(String name, String url){
		taskList.add(new Task(getMaxId(), name, url, 0, 0, 0));//добавить отчет во view
	}
	
	public void deleteTask(int id){
		for (Task task : taskList){
			if (task.getId() == id ){
				taskList.remove(task);
			}
		}
	}
	
	public String getTask(int id){
		String result = "You have entered an invalid id";
		for (Task task : taskList){
			if (task.getId() == id ){
				result = task.taskToString();
			}
		}
		return result;
	}
	
	public String getAllTasks(){
		String result = null;
		for (Task task : taskList){
			result += task.taskToString();
		}
		return result;
	}

}
