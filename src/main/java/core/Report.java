package core;

import java.util.ArrayList;

public class Report extends Observable{

	public ArrayList<Observer> observers = new ArrayList<>();
	public int successRate;
	ArrayList<AcceptanceTest> testList = new ArrayList<AcceptanceTest>();
	
	public Report() {
		super();
	}
	
	public void removeObserver(Observer o) {
		
	}
	
	public void addObserver(Observer o) {
		observers.add(observer);
	}
	
	public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
	}
}
