package core;

import java.io.FileNotFoundException;

public abstract class Tracker extends Observable {
    public abstract void track(String path) throws FileNotFoundException;

}
