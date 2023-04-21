package core;

import java.util.HashMap;
import java.util.Map;

public class Discovery {

    String path;
    public Discovery(String path){
        this.path = path;
    }

    public Map<String, Finder> discover(){
        Map<String, Finder> finders = new HashMap<>();
        finders.put("DefaultFinder", new DefaultFinder());
        return finders;
    }
}
