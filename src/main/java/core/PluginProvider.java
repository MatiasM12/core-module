package core;

import java.util.Iterator;
import java.util.Set;

public class PluginProvider {
	
	  public TSProvider getOne(Set<TSProvider> factories, String factoryName){
		  	Iterator<TSProvider> iterator = factories.iterator();
	        while(iterator.hasNext()){
	        	TSProvider t = iterator.next();
	            if(t.getClass().getName().equals(factoryName))
	                return t;
	        }
	        return null;
	    }
	  
	    
	    public TSProvider getOneFactory(Set<TSProvider> trackerSet) {
	        Iterator<TSProvider> iterator = trackerSet.iterator();
	        TSProvider t = null;
	        while (iterator.hasNext()) {
	            t = iterator.next();
	        }
	        return t;
	    }

	
}
