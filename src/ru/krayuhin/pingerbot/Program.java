package ru.krayuhin.pingerbot;

public class Program {

	public static void main(String[] args) {
		
		Model mod = new Model();
		View view = new View();
		mod.addObserver(view);
		Controller cont = new Controller(mod, view);
		cont.addObserver(view);
		
		while (true){
			cont.getCommand();
		}

	}

}
