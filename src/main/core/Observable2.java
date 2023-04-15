package core;

import java.util.ArrayList;

public class Observable2 {
//los refactorice por que entiendo que tenemos que usar los de java	

	public ArrayList<Observer2> observers;

	public void removeObserver(Observer2 o) {
		observers.remove(o);
	}
	
	public void addObserver(Observer2 o) {
		observers.add(o);
	}
	
	public void notifyObservers() {
        for (Observer2 observer : observers) {
            observer.update();
        }
	}
}
