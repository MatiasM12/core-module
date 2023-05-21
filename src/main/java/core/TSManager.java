package core;
import core.Observable;

import java.util.Iterator;

public abstract class TSManager implements Observable {
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
	public void notifyObservers(Object object) {
		for (@SuppressWarnings("rawtypes")
			 Iterator iterator = observers.iterator(); iterator.hasNext();) {
			Observer observer = (Observer) iterator.next();
			observer.update(object);
		}
	}
	protected abstract ConcreteTestSummary hook(String repo, String story);
}
