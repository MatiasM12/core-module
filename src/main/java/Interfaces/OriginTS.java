package Interfaces;

import core.TSDecorator;

public abstract  class OriginTS extends TSDecorator{

	public OriginTS(TestSummary unDelegado,String url,String us) {
		super(unDelegado);
		this.connectTS(url,us);
	}
	
	public abstract boolean connectTS(String url,String us);

}
