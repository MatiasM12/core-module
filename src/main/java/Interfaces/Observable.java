package Interfaces;

import java.util.Collection;
import java.util.HashSet;

public interface Observable {

	
	public Collection<Observer> observers = new HashSet<Observer>();

    public void addObserver(Observer o);

    public void removeObserver(Observer o);

    public void notifyObservers(Object object);
}
