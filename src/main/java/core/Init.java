package core;

public class Init {

	
	public  Init(){
		System.out.println("sadsad");
		TestSummary ts = new TestSummaryTrackerHub();
		TestSummary concrete = ts.track("path");
		TestSummary ushub  = new TestSummaryUSHub(concrete);
		TestSummary acceptanceTest  = new TestSummaryHubAcceptanceTest(ushub);
		ConcreteObservableTestSummary ObservableTestSummary = new ConcreteObservableTestSummary(acceptanceTest);
		Mediator m = new Mediator(ObservableTestSummary);
		}
}
