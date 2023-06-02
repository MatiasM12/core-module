package interfaces;

import core.TSDecorator;

public abstract class TSProvider {
	
	public TSProvider() {
	}
	
	public abstract USTestSummary getUSTS(String userStory);

}