package core;

import java.util.ArrayList;
import java.util.Observable;

@SuppressWarnings("deprecation")
public class Report extends Observable{
	public int successRate;
	public ReportUpdater2 actualizador;
	public ArrayList<AcceptanceTest> testList;
	
	public Report(String pathFuente) {
		this.actualizador = new ReportUpdater2(this, pathFuente);
		actualizador.update(this);
	}
	
}
