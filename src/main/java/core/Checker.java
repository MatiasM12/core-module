package core;

import java.net.URL;
import java.util.Date;

public abstract class Checker {
    protected Observer observer;
    public void addObserver(Observer observer){
        this.observer = observer;
    }
    public abstract void check(URL path);
}
