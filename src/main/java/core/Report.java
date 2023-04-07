package core;

import java.util.ArrayList;
import java.util.Set;

public class Report extends Observable{

	Set<Observer> observers;
	int successRate;
	ArrayList<AcceptanceTest> testList = new ArrayList<AcceptanceTest>();
	
	public Report() {
		super();
	}
	
	public void removeObserver(Observer o) {
		
	}
	
	public void addObserver(Observer o) {
		
	}
	
	public void notifyObservers() {
		
	}
}
