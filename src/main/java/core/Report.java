package core;

import java.util.ArrayList;

public class Report extends Observable{

	public int successRate;
	public ArrayList<AcceptanceTest> testList;
	
	public Report(ArrayList<Observer> observers, int successRate, ArrayList<AcceptanceTest> testList) {
		super();
		super.observers = observers;
		this.successRate = successRate;
		this.testList = testList;
	}
}
