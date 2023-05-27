package core;


import java.util.Iterator;
import java.util.Map;

public class ObservableTS extends DecoratorTS implements Observable {
	
	public ObservableTS(TestSummary concrete) {
		super(concrete);
	}
	
	@Override
	public TestSummary update(Map<String, Boolean> test) {
		super.ts.update(test);
		notifyObservers(test);
		return super.ts;
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
	public void notifyObservers(Object object) {
		for (@SuppressWarnings("rawtypes")
		Iterator iterator = observers.iterator(); iterator.hasNext();) {
			Observer observer = (Observer) iterator.next();
			observer.update(object);
		}
	}
	
	public Map<String,Boolean> getTestSummary(){
		return super.getTestSummary();
	}

}
