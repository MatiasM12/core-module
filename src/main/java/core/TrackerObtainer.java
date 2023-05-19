package core;

import java.util.Iterator;
import java.util.Set;

public class TrackerObtainer {

	
	 
	
	  public TestSummary getTracker(Set<TestSummary> trackers,String trackerName){
		  	System.out.println(trackers.toString());
		  	System.out.println(trackerName);
		  	Iterator<TestSummary> iterator = trackers.iterator();
	        while(iterator.hasNext()){
	        	TestSummary t = iterator.next();
	            if(t.getClass().getName().equals(trackerName))
	                return t;
	        }
	        return null;
	    }
	  

	    public TestSummary getOneTracker(Set<TestSummary> trackerSet) {
//	        if(trackerSet == null)
	        Iterator<TestSummary> iterator = trackerSet.iterator();
	        TestSummary t = null;
	        while (iterator.hasNext()) {
	            t = iterator.next();
	        }
	        return t;
	    }

	
}
