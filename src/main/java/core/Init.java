package core;

public class Init {

	
	public Init(){
		System.out.println("ESTOY VIVO");
		TestSummary ts = new TestSummaryTrackerHub();
		TestSummary concrete = ts.track("path");
		TestSummary ushub  = new TestSummaryUSHub(concrete);
		TestSummary acceptanceTest  = new TestSummaryHubAcceptanceTest(ushub);
		
		System.out.println("aajskdaskld");
		
		TestSummary ObservableTestSummary = new ConcreteObservableTestSummary(acceptanceTest);
	}
}
