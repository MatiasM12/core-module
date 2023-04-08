package core;

import java.util.ArrayList;

public class FileUpdateChecker {
	
	public String filePath;
	
	public FileUpdateChecker(String filePath, ArrayList<Observer2> observers) {
		super();
		this.filePath = filePath;
		//super.observers = observers;
	}

	public FileUpdateChecker(String string) {
		this.filePath = string;
	}
	
	public Boolean check() {
/*
 * En algun lado se va a estar corriendo este metodo cada 1 seg por ejemplo
 * y cuando devuelva true, se va a pedir al updater que haga el update
*/
		System.out.println("chequeo exitoso");
		return false;
	}
}
