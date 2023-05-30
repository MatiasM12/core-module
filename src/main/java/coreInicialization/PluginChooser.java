package coreInicialization;

import Interfaces.TSProvider;

import java.util.Iterator;
import java.util.Set;

public class PluginChooser {
	
	  public TSProvider getOne(Set<TSProvider> providers, String providerName){
		  	Iterator<TSProvider> iterator = providers.iterator();
	        while(iterator.hasNext()){
	        	TSProvider t = iterator.next();
	            if(t.getClass().getName().equals(providerName))
	                return t;
	        }
	        return null;
	    }
}