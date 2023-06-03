package coreInicialization;
import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.util.Set;

import Interfaces.TestSummary;

public class OriginTSBuilder {

	String path;

    public OriginTSBuilder(String path){
       this.path = path;
    }
    public TestSummary init(String url,String us,String pluginElegido,TestSummary ts) throws FileNotFoundException, ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        Set<TestSummary> set = new OriginFinder(this.path).find(ts,url,us);
        TestSummary origin =  new OriginChooser().getOne(set, pluginElegido);
        
        System.out.println(origin.toString()+" origen");
        
        return origin;
    }
}
