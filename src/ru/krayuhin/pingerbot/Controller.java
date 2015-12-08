package ru.krayuhin.pingerbot;

import java.util.*;

public class Controller extends Observable{//input parameters validation 
	
	private IModel model1;
	private IView view1;
	private PingerClass pinger;
	
	Controller(IModel model, IView view){
		this.model1 = model;
		this.view1 = view;
		pinger = new PingerClass(model1);
	}
	
	public void getCommand(){
		view1.print("Enter the command");
		String command = view1.getInput();
		
		switch(command){
		case ("help"):{
			String help = "add \n" + "     " + "Add a new task: \n" + "     " + "-URL (string in format http://google.ru:80/) \n" + "    " + "-name \n" +
			"delete \n" + "     " + "Delete task by id \n" + "get \n" + "     " + "Get task by id \n" + 
			"show \n" + "     " + "Show all tasks \n" + "save \n" + "     " + "Save Task List \n" + "exit \n" + "     " + "Exit the programm \n";
			view1.print(help);
			break;
		}
		case ("add"):{
			view1.print("Name");
			String name = view1.getInput();
			view1.print("URL");
			String url = view1.getInput();
			model1.addNewTask(name, url);
			pinger.connetionStart();
			break;
		}
		case ("delete"):{
			view1.print("Enter id for remove: ");
			int id = Integer.parseInt(view1.getInput());
			model1.deleteTask(id);
			break;
		}
		case ("get"):{
			view1.print("Enter id for show: ");
			int id = Integer.parseInt(view1.getInput());
			view1.print(model1.getTask(id));
			break;
		}
		case ("show"):
			view1.print(model1.getAllTasks());
			break;
		case ("save"):
			break;
		case ("exit"):{
			pinger.connectionStop();
			view1.print("Work complited");
			System.exit(0);
			break;
		}
		default:
			view1.print("Input 'Help' please");
		}
	}

}
