package core;

import java.net.URL;
import java.util.Date;

public class SrcChecker{

    private Observer observer;
    private URL path;
    private Date lastModification;

    SrcChecker(URL path, Observer observer){
        this.path = path;
        this.observer = observer;
    }
    public void check(){
        if(true){
            observer.update();
        }
    }
}
