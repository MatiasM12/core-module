package core;

import java.util.ArrayList;

public class Report extends Observable{

	public ArrayList<Observer> observers;
	public int successRate;
	ArrayList<AcceptanceTest> testList;
	
	public Report(ArrayList<Observer> observers, int successRate, ArrayList<AcceptanceTest> testList) {
		super();
		this.observers = observers;
		this.successRate = successRate;
		this.testList = testList;
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
