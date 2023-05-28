package Interfaces;


import java.util.Map;

public abstract class TSProvider {
	Observer observer;
	public abstract TestSummary getTS(String userStory);

	public void notifyNewChanges(Map<String, Boolean> ts){
		observer.update(ts);
	}
	public void setObserver(Observer over) {
		this.observer = over;
	}
}