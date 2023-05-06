package core;

import java.io.FileNotFoundException;
import java.util.Set;

public abstract class Tracker implements Observer{
    Observer observer;
    void setObserver(Observer observer){
        this.observer = observer;
    }
    protected abstract void track(String path) throws FileNotFoundException;
    @Override
    public void update(Object object){
        this.observer.update((Set<TestResult>) object);
    }
}
