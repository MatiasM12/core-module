package core;

import java.util.Set;

public abstract class Tracker{
    Observer observer;
    void setObserver(Observer observer){
        this.observer = observer;
    }
    abstract Set<TestResult> track(String path);
}
