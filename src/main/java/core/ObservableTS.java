package core;

import Interfaces.Observable;
import Interfaces.Observer;
import Interfaces.TestSummary;

import java.util.Iterator;

public class ObservableTS extends TSDecorator implements Observable {

	TestSummary lastTS;

	public ObservableTS(TestSummary concrete) {
		super(concrete);
	}

	@Override
	public TestSummary update(TestSummary ts) {
		this.lastTS = ts;
		TestSummary tsUpdate = super.update(ts);
		notifyObservers(tsUpdate);
		return tsUpdate;
	}

	@SuppressWarnings("static-access")
	@Override
	public void addObserver(Observer o) {
		this.observers.add(o);
		notifyObservers(lastTS);
	}

	@SuppressWarnings("static-access")
	@Override
	public void removeObserver(Observer o) {
		this.observers.remove(o);
	}

	@Override
	public void notifyObservers(TestSummary ts) {
		for (@SuppressWarnings("rawtypes")
		Iterator iterator = observers.iterator(); iterator.hasNext();) {
			Observer observer = (Observer) iterator.next();
			observer.update(ts);
		}
	}
}
