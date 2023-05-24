package core;

import java.util.Map;

public class StubTsDecorator  extends DecoratorTestSummary implements TestSummary {

	
	String us;
	
	public StubTsDecorator(TestSummary s, String args) {
		super(s);
		this.us = args;
	}

	@Override
	public TestSummary update(Map<String, String> m) {
				
		return super.update(m);
	}
	
	

}
