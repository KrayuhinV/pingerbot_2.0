package ru.krayuhin.pingerbot;

import java.util.*;
import java.util.Observer;
import java.util.Scanner;

public class View implements IView{
	
	public void print(String output){
		System.out.println(output);
	}
	
	public String getInput(){
		Scanner skn = new Scanner(System.in);
		String result = skn.nextLine();
		return result;
	}

	@Override
	public void update(TargetEvent e) {
		// TODO Auto-generated method stub
		
	}	

}
