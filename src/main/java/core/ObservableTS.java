package core;


import Interfaces.Observable;
import Interfaces.Observer;
import Interfaces.TestSummary;

import java.util.Iterator;
import java.util.Map;

public class ObservableTS extends TSDecorator implements Observable {
	
	public ObservableTS(TestSummary concrete) {
		super(concrete);
	}
	
	@Override
	public void update(Map<String, Boolean> m) {
		super.update(m);
		notifyObservers(m);
	}

	@SuppressWarnings("static-access")
	@Override
	public void addObserver(Observer o) {
		this.observers.add(o);
	}

	@SuppressWarnings("static-access")
	@Override
	public void removeObserver(Observer o) {
		this.observers.remove(o);
	}

	@Override
	public void notifyObservers(Object map) {
		for (@SuppressWarnings("rawtypes")
		    Iterator iterator = observers.iterator(); iterator.hasNext();) {
			Observer observer = (Observer) iterator.next();
			observer.update(map);
		}
	}
}
