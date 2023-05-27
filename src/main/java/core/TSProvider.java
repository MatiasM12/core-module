package core;

import Interfaces.Observer;
import Interfaces.TestSummary;

public abstract class TSProvider {
	Observer observer;
	public abstract TestSummary getTS(String userStory);

	public void notifyNewChanges(TestSummary ts){
		observer.update(ts);
	}
	public void setObserver(Observer over) {
		this.observer = over;
	}
}