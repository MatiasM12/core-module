package core;

import java.util.Iterator;
import java.util.Set;

public class FactoryObtainer {
	
	  public Factory getFactory(Set<Factory> factories,String factoryName){
		  	System.out.println(factories.toString());
		  	System.out.println(factoryName);
		  	Iterator<Factory> iterator = factories.iterator();
	        while(iterator.hasNext()){
	        	Factory t = iterator.next();
	            if(t.getClass().getName().equals(factoryName))
	                return t;
	        }
	        return null;
	    }
	  
	    
	    public Factory getOneFactory(Set<Factory> trackerSet) {
	        Iterator<Factory> iterator = trackerSet.iterator();
	        Factory t = null;
	        while (iterator.hasNext()) {
	            t = iterator.next();
	        }
	        return t;
	    }

	
}
