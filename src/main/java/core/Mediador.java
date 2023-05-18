package core;

public class Mediador {

	Tracker t;
	TestSummary ts;
	
	public  Mediador(Tracker t, TestSummary ts) {
		
		this.t = t;
		this.ts = ts;
	}
	
//	public TestSummary newChanges() {
//		return t.newChanges();
//	}
	
	public void addObserver(Observer o){
		
		((ObservableTestSummary)this.ts).addObserver(o);
		
	}
}
