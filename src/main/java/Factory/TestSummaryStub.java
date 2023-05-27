package Factory;

import java.util.Map;

import core.DecoratorTestSummary;
import core.TestSummary;

public class TestSummaryStub extends DecoratorTestSummary{

	public TestSummaryStub(TestSummary s) {
		super(s);
	}

	@Override
	public TestSummary update(Map<String,Boolean> m) {
		return super.update(m);
	}
	
	public void setTS(TestSummary ts) {
		super.ts = ts;
	}

}
