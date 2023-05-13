package core;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class TrackerHub  extends Tracker{

	public TrackerHub(String url) {
		super(url);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Map<String,String> hook() {
		
		Map<String,String> m = new HashMap<String,String>();
		m.put("US1", "CA 1");
		
		return m;
	}

}
