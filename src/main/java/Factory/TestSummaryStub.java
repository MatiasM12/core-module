package Factory;


import core.DecoratorTestSummary;
import core.TestSummary;

public class TestSummaryStub extends DecoratorTestSummary{

	public TestSummaryStub(TestSummary s) {
		super(s);
		
	}

}
