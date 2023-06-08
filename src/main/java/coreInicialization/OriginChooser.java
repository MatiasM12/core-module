package coreInicialization;

import Interfaces.TestSummary;

import java.util.Iterator;
import java.util.Set;

public class OriginChooser {
	
	  public TestSummary getOne(Set<TestSummary> ts, String impl){
		  
		  	System.out.println(ts.toString()+" imples actuales");
		  	
		  	Iterator<TestSummary> iterator = ts.iterator();
	        while(iterator.hasNext()){
	        	TestSummary t = iterator.next();
	        	
	        	if(t.getClass().getName().equals("imp."+impl))
	                return t;
	        }
	        return null;
	    }
}
