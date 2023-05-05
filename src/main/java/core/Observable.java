package core;

import java.util.Collection;

public class Observable {
    Collection<Observer> observers;

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
