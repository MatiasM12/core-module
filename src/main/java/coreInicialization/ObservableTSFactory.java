package coreInicialization;

import Interfaces.TestSummary;
import core.ConcreteTS;
import core.ObservableTS;

public class ObservableTSFactory {
	
	ObservableTS ts;

	public ObservableTS create() {
		TestSummary concrete = new ConcreteTS();
		TestSummary ts = new ObservableTS(concrete);
		this.ts = (ObservableTS) ts;
		return (ObservableTS) ts;
	}

	public ObservableTS getTs() {
		return this.ts;
	}
}
