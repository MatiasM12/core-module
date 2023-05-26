package core;

import java.util.Iterator;
import java.util.Set;

public class TSObtainer {

	
	public TestSummary getOneFactory(Set<TestSummary> trackerSet) {
        Iterator<TestSummary> iterator = trackerSet.iterator();
        TestSummary t = null;
        while (iterator.hasNext()) {
            t = iterator.next();
        }
        return t;
    }
}
