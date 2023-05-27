package core;

import java.util.Iterator;
import java.util.Set;

public class FactoryObtainer {

	
	public Factory getOneFactory(Set<Factory> factorySet) {
        Iterator<Factory> iterator = factorySet.iterator();
        Factory t = null;
        while (iterator.hasNext()) {
            t = iterator.next();
        }
        return t;
    }
}
