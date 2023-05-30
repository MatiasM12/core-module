package coreInicialization;


import core.TSDecorator;

import java.util.Iterator;
import java.util.Set;

public class DecoratorChooser {
	
	  public TSDecorator getOne(Set<TSDecorator> decorador, String factoryName){
		  	Iterator<TSDecorator> iterator = decorador.iterator();
	        while(iterator.hasNext()){
	        	TSDecorator t = iterator.next();
	            if(t.getClass().getName().equals(factoryName))
	                return t;
	        }
	        return null;
	    }
}
