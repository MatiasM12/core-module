package coreInicialization;

import Interfaces.TestSummary;
import core.ConcreteTS;
import core.ObservableTS;


public class ObservableTSFactory {
	
	public ObservableTS create() {
		TestSummary concrete = new ConcreteTS();
		TestSummary ts = new ObservableTS(concrete);
		return (ObservableTS) ts;
	}
}
