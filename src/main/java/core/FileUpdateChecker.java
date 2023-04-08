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
		return true;
	}
	
	public void removeObserver(Observer o) {
		observers.remove(o);
	}
	
	public void addObserver(Observer o) {
		observers.add(o);
	}
	
	public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
	}
}
