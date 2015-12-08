package ru.krayuhin.pingerbot;

import java.util.EventListener;

public interface IView extends EventListener{
	
	public void print(String output);
	public String getInput();
	public void update(TargetEvent e);
}
