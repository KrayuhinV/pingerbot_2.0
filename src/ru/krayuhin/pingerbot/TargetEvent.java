package ru.krayuhin.pingerbot;

import java.util.EventObject;

public class TargetEvent extends EventObject{
	
	public TargetEvent(IModel model, int i){
		super(model);
	}

}
