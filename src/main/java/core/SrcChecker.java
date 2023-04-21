package core;

import java.net.URL;
import java.util.Date;

public class SrcChecker extends core.Observable implements Checker{

    private URL path;
    private Date lastModification;
    public void check(){
        if(true){
            notifyObservers();
        }
    }
}
