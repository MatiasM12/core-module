package core;

public abstract class Plugin {
	Observer observador;
	TestSummary testSummary;
	public Plugin(Observer o){
		this.observador = o;
	}

	public Observable createObservableTS(String args);
	public TestSummary  getTSDecorator();


	TestSummary getTS(String userStory){
		return this.testSummary;
	}

	public void notifyNewChanges(){
		observador.update(this.testSummary);
	}


}
