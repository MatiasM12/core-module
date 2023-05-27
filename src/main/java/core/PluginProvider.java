package core;

import java.util.Iterator;
import java.util.Set;

public class PluginProvider {
	
	  public Plugin getOne(Set<Plugin> factories, String factoryName){
		  	Iterator<Plugin> iterator = factories.iterator();
	        while(iterator.hasNext()){
	        	Plugin t = iterator.next();
	            if(t.getClass().getName().equals(factoryName))
	                return t;
	        }
	        return null;
	    }
	  
	    
	    public Plugin getOneFactory(Set<Plugin> trackerSet) {
	        Iterator<Plugin> iterator = trackerSet.iterator();
	        Plugin t = null;
	        while (iterator.hasNext()) {
	            t = iterator.next();
	        }
	        return t;
	    }

	
}
