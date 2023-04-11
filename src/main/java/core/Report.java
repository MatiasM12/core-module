package core;

import java.util.ArrayList;
import java.util.Observable;
import core.AcceptanceTest;

@SuppressWarnings("deprecation")
public class Report extends Observable{
	public int successRate;
	public ReportUpdater actualizador;
	public ArrayList<AcceptanceTest> testList;
	
	public Report(String pathFuente) {
		this.actualizador = new ReportUpdater(this, pathFuente);
		actualizador.update(this);
	}
	
}
