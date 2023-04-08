package core;

import java.util.ArrayList;
import java.util.Observable;

@SuppressWarnings("deprecation")
public class Report extends Observable{

	public int successRate;
	
	public ReportUpdater actualizador;
	public ArrayList<AcceptanceTest> testList;
	
	public Report(ArrayList<Observer2> observers, int successRate, ArrayList<AcceptanceTest> testList) {
		super();
		//super.observers = observers;
		this.successRate = successRate;
		this.testList = testList;
	}
	
	public Report(String pathFuente) {
		this.actualizador = new ReportUpdater(this, "path");
		
	}
}
