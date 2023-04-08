package core;

import java.util.ArrayList;

public class FileUpdateChecker extends Observable{
	
	public String filePath;
	public ArrayList<Observer> observers;
	
	public FileUpdateChecker(String filePath, ArrayList<Observer> observers) {
		super();
		this.filePath = filePath;
		this.observers = observers;
	}

	public Boolean check() {
		notifyObservers();
		System.out.println("chequeo exitoso");
		return true;
	}
	
}
