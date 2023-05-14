package core;


import java.util.Iterator;
import java.util.Map;

public class ObservableTestSummary extends DecoratorTestSummary implements Observable {
	
	
	
	public ObservableTestSummary(TestSummary concrete,Map<String, String> m) {
		super(concrete);
		update(m);
	}
	
	
	@Override
	public TestSummary update(Map<String, String> m) {
		super.ts = new ConcreteTestSummary(m);
		notifyObservers(m);
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
	

}
