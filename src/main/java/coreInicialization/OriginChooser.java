package coreInicialization;

import Interfaces.TestSummary;

import java.util.Iterator;
import java.util.Set;

public class OriginChooser {
	
	  public TestSummary getOne(Set<TestSummary> ts, String impl){
		  	Iterator<TestSummary> iterator = ts.iterator();
	        while(iterator.hasNext()){
	        	TestSummary t = iterator.next();
	        	if(t.getClass().getName().equals(impl))
	                return t;
	        }
	        return null;
	    }
}
