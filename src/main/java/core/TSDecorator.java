package core;

import Interfaces.TestSummary;

import java.util.Map;

public abstract class TSDecorator implements TestSummary {
	
	protected TestSummary delegado;
	
	public TSDecorator(TestSummary unDelegado) {
		this.delegado = unDelegado;
	}

	@Override
	public void updateTests(Map<String,Boolean> s) {
		this.delegado.updateTests(s);
	}
	
	protected  Map<String, Boolean> getTestSummary(){
		return ((ConcreteTS)this.delegado).testResults;
	}

}
