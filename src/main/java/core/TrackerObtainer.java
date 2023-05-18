package core;

import java.util.Iterator;
import java.util.Set;

public class TrackerObtainer {

	
	 
	
	  public Tracker getTracker(Set<Tracker> trackers,String trackerName){
	    	Iterator<Tracker> iterator = trackers.iterator();
	        while(iterator.hasNext()){
	            Tracker t = iterator.next();
	            if(t.getClass().getName().equals(trackerName))
	                return t;
	        }
	        return null;
	    }
	  

	    public Tracker getOneTracker(Set<Tracker> trackerSet) {
//	        if(trackerSet == null)
	        Iterator<Tracker> iterator = trackerSet.iterator();
	        Tracker t = null;
	        while (iterator.hasNext()) {
	            t = iterator.next();
	        }
	        return t;
	    }

	
}
