package core;

import java.util.Iterator;
import java.util.Set;

public class FactoryObtainer {

	
	public Factory getOneFactory(Set<Factory> trackerSet) {
        Iterator<Factory> iterator = trackerSet.iterator();
        Factory t = null;
        while (iterator.hasNext()) {
            t = iterator.next();
        }
        return t;
    }
}
