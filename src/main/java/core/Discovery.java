package core;

import InterfacesImpl.DefaultFinder;
import InterfacesImpl.SrcChecker;

import java.util.HashMap;
import java.util.Map;

public class Discovery {

    String path;
    public Discovery(String path){
        this.path = path;
    }

    public Map<String, Finder> discoverFinders(){
        Map<String, Finder> finders = new HashMap<>();
        finders.put("DefaultFinder", new DefaultFinder());
        return finders;
    }


    public Map<String, Checker> discoverCheckers(){
        Map<String, Checker> checkers = new HashMap<>();
        checkers.put("SrcChecker", new SrcChecker());
        return checkers;
    }
}
