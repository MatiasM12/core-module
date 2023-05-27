package CoreInicialization;

import core.TSProvider;

import java.util.Iterator;
import java.util.Set;

public class PluginChooser {
	
	  public TSProvider getOne(Set<TSProvider> factories, String factoryName){
		  	Iterator<TSProvider> iterator = factories.iterator();
	        while(iterator.hasNext()){
	        	TSProvider t = iterator.next();
	            if(t.getClass().getName().equals(factoryName))
	                return t;
	        }
	        return null;
	    }
}
