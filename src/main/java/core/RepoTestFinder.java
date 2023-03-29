package core;

import java.util.Observable;

@SuppressWarnings("deprecation")
public class RepoTestFinder extends Observable{
	//no se si me gusta el nombre, pero habia que arrancar por algo
	
	String restultadoTest;
	
	public RepoTestFinder() {
		this.restultadoTest = "Hola mundo! Esto es un resultado de los test";
	}
	
	public void setResultadoTest(String nuevoValor) {
		this.restultadoTest = nuevoValor;
		
		setChanged();
	    notifyObservers();
	}

}
