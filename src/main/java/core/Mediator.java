package core;
import core.ConcreteObservableTestSummary;
import core.Observer;

public class Mediator {

	ConcreteObservableTestSummary ts;
	
	Mediator(ConcreteObservableTestSummary ts){
		
		this.ts = ts;
	}
	
	public void addObserver(Observer o){
		this.ts.addObserver(o);
	}
}
