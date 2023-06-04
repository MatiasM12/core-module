package core;

import Interfaces.TestSummary;

public abstract class TSDecorator implements TestSummary {
	
	protected TestSummary delegado;
	
	public TSDecorator(TestSummary unDelegado) {
		this.delegado = unDelegado;
	}

	@Override
	public TestSummary update(TestSummary ts) {
		
		return this.delegado.update(ts);
	}
}
