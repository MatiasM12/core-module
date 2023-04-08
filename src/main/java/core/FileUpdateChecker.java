package core;

import java.util.ArrayList;

public class FileUpdateChecker extends Observable{
	
	public String filePath;
	
	public FileUpdateChecker(String filePath, ArrayList<Observer> observers) {
		super();
		this.filePath = filePath;
		super.observers = observers;
	}

	public Boolean check() {
		notifyObservers();
		System.out.println("chequeo exitoso");
		return true;
	}
	
}
