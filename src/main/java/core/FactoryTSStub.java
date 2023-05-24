package core;

public class FactoryTSStub   implements Factory {

	private TestSummary updater;
	
	@Override
	public Observable createObservableTS(String args) {
		TestSummary ts = new ConcreteTestSummary();
		TestSummary tsOb = new ObservableTestSummary(ts);
		TestSummary stub = new StubTsDecorator(tsOb,args);
		this.updater = stub;
		return (Observable)tsOb;
	}
	
	@Override
	public TestSummary getTSDecorator() {
		// TODO Auto-generated method stub
		return this.updater;
	}

}
