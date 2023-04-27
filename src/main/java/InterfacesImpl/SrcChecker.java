package InterfacesImpl;

import core.Checker;

import java.net.URL;
import java.util.Date;

public class SrcChecker extends Checker {
    private Date lastModification;
    @Override
    public void check(URL path) {
        if(true){
            observer.update();
        }
    }
}
