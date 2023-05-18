package core;


public interface Tracker extends Observable {

	public ConcreteTestSummary hook(String url);

}
