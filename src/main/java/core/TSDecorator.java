package core;

import java.util.Map;

import interfaces.USTestSummary;

public abstract class TSDecorator implements USTestSummary {
	
	protected USTestSummary delegado;
	
	public TSDecorator(USTestSummary unDelegado) {
		this.delegado = unDelegado;
	}


	@Override
	public void updateTests(Map<String,Boolean> s) {
		this.delegado.updateTests(s);
	}
}
