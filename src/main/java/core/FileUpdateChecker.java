package core;

import java.util.Set;

public class FileUpdateChecker extends Observable{
	
	String filePath;
	Set<Observer> observers;
	ReportUpdater updater = new ReportUpdater();
	
	public Boolean check() {
		return true;
	}
	
	public void removeObserver(Observer o) {
		
	}
	
	public void addObserver(Observer o) {
		
	}
	
	public void notifyObservers() {
		
	}
}
