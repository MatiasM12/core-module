package core;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Set;

public class InitCore {
    /*
    public InitCore(String findersImplPath){
    }*/
    public NewCore init(String trackersPath) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, IOException, InvocationTargetException {
        TrackerFinder trackerFinder = new TrackerFinder();
        Set<Tracker> trackerSet = trackerFinder.findTrackers(trackersPath);

        NewCore core = new NewCore();
        for(Tracker t : trackerSet){
            t.setObserver(core);
        }

        return core;
    }
}
