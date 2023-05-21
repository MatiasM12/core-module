package core;

public abstract class DecoratorTestSummary implements TestSummary {
	
	TestSummary delegado;
	
	public DecoratorTestSummary(TestSummary s) {
		this.delegado = s;
	}
}
