package core;

import java.util.Collection;
import java.util.HashSet;
import java.util.Vector;

public class Observable {
    Collection<Observer> observers;

    public Observable(){
        this.observers = new Vector<>();
    }
    public void addObserver(Observer o){
        observers.add(o);
    }

    public void removeObserver(Observer o){
        observers.remove(o);
    }

    public void notifyObservers(Object object){
        for(Observer o : observers){
            if(o != null)
            o.update(object);
        }
    }

}
