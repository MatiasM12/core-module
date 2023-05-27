package core;

import java.util.Map;

public class Provider{

	TestSummary Observable;
	TestSummary plugin;
	
	public Provider(TestSummary s, TestSummary tsPlugin) {
		Observable = s;
		plugin = tsPlugin;
	}

	public void suscribeObserver(Observer o){
		((Observable)this.Observable).addObserver(o);
	}
	
	protected TestSummary update(Map <String,Boolean> m) {
		return this.plugin.update(m);
	}
	
	protected Map<String,Boolean> getMap() {
		return ((ObservableTS)this.Observable).getTestSummary();
	}
}

