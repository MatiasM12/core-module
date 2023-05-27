package core;

import Interfaces.TestSummary;

import java.util.Map;

public abstract class DecoratorTestSummary implements TestSummary {
	
	protected TestSummary delegado;
	
	public DecoratorTestSummary(TestSummary unDelegado) {
		this.delegado = unDelegado;
	}

	@Override
	public void updateTests(Map<String,Boolean> s) {
		this.delegado.updateTests(s);
	}
	
	protected  Map<String, Boolean> getTestSummary(){
		return ((ConcreteTestSummary)this.delegado).testResults;
	}

}
