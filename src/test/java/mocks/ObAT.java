package mocks;

import java.util.Objects;

import Interfaces.Observer;
import Interfaces.TestSummary;

public class ObAT implements Observer{

	TestSummary ts;
	
	@Override
	public void update(TestSummary ts) {
		this.ts = ts;
	}
	
	 public TestSummary getTS(){
		return ts;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ObAT other = (ObAT) obj;
		return Objects.equals(ts, other.ts);
	}

}
