package core;

import java.util.Map;

public abstract class Tracker {

	String url;
	
	public Tracker(String url) {
		this.url = url;
	}
	
	abstract public Map<String,String> hook();
	
}
