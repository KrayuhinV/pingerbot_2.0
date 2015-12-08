package ru.krayuhin.pingerbot;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "Task")
public class Task {
	
	private int id;
	private String name;
	private String url;
	private int attempts;
	private int okAttempts;
	private long time;
	
	@XmlAttribute
	public void setId(int id){
		this.id = id;
	}
	
	public int getId(){
		return id;
	}
	
	@XmlElement
	public void setName(String name){
		this.name = name;
	}
	
	public String getName(){
		return name;
	}
	
	@XmlElement
	public void setUrl(String url){
		this.url = url;
	}
	
	public String getUrl(){
		return url;
	}
	
	@XmlElement
	public void setAttempts(int attempts){
		this.attempts = attempts;
	}
	
	public int getAttempts(){
		return attempts;
	}
	
	@XmlElement
	public void setOkAttempts(int okAttempts){
		this.okAttempts = okAttempts;
	}
	
	public int getOkAttempts(){
		return okAttempts;
	}
	
	@XmlElement
	public void setTime(long time){
		this.time = time;
	}
	
	public long getTime(){
		return time;
	}
	
	public String taskToString(){
		return this.getId() + " " + this.getName() + " " + this.getUrl() + " " + this.getAttempts() + " " + this.getOkAttempts() + " " + this.getTime() + "\n";
	}
		
	public Task(int id, String name, String url, int attempts, int okAttempts, int time){ //one char par names
		this.id = id;
		this.name = name;
		this.url = url;
		this.attempts = attempts;
		this.okAttempts = okAttempts;
		this.time = time;
	}
	
	public Task() {
	}

}
