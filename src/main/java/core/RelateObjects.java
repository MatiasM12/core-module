package core;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Set;

public class RelateObjects {
	
	public TrackerFinder trackerFinder;
	public Report report;
	public ReportRefresher refresher;
	public Listener listener;
	
	public RelateObjects(TrackerFinder t,Report report,ReportRefresher refresher,Listener listener) {
		this.trackerFinder = t;
		this.report = report;
		this.refresher =refresher;
		this.listener = listener;
	}
	
	public void relateApp(String trackerImp) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, IOException{
		 this.trackerFinder.initTrackers();  //INICIALIZO LOS TRACKERS
		 Tracker tracker = this.trackerFinder.getTracker(trackerImp);  //BUSCO EL TRACKER
		 this.refresher.setTracker(tracker); //RELACIONO EL TRACKER CON SU REFRESHER
		 this.listener.setRefresher(refresher); //Relaciono el listener con su refresher
		 listener.start();
	}

}
