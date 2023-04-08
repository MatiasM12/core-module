package core;

import java.util.ArrayList;

public class Observable {
	
	public ArrayList<Observer> observers;

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
