package core;

public class ProviderTS extends DecoratorTestSummary {

	public ProviderTS(TestSummary s) {
		super(s);
		// TODO Auto-generated constructor stub
	}

	public void suscribeObserver(Observer o){
		((Observable)super.ts).addObserver(o);
	}
}
