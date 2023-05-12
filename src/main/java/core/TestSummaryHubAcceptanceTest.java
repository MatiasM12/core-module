package core;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class TestSummaryHubAcceptanceTest extends DecoratorTestSummary {

	TestSummary ts;
	
	public TestSummaryHubAcceptanceTest(TestSummary concrete) {
		
		this.ts = concrete;
		System.out.println("AcceptanceTest");
		Random r = new Random();
		Map <String,String> m = new HashMap<String,String>();
		
		String caso = "";
		boolean BooleanLastBoolean = true; 
		for (int i = 0; i < 7; i++) {
			if (BooleanLastBoolean &&r.nextBoolean()) {
				BooleanLastBoolean = false;
				caso = "NOT PASS";
				m.put("CA "+i, caso);
			}
			else if(r.nextBoolean()) {
				BooleanLastBoolean = true;
				caso = "PASS";
				m.put("CA "+i, caso);
			}
			
			else {
				BooleanLastBoolean = false;
				caso = "ERROR";
				m.put("CA "+i, caso);
			}
			
		}
		
		
		this.setAcceptanceTest("US1", m );
	}


	@Override
	public void setUS(String s) {
		this.setUS(s);
		
	}

	@Override
	public void setAcceptanceTest(String s, Map<String, String> m) {
		this.ts.setAcceptanceTest(s, m);
	}

}
