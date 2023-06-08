package Interfaces;

import core.TSDecorator;

public abstract class OriginTS extends TSDecorator {

	public OriginTS(TestSummary ts) {
		super(ts);
	}

	public abstract boolean connectTS(String url, String us);

}
