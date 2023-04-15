package core;

import java.util.Date;
import java.util.Timer;

public class Scheduler {
    SrcChecker FileChecker;
    public Scheduler(SrcChecker checker, int intervaloActualizacion) {
        this.FileChecker = checker;
        Timer tmp = new Timer();
        tmp.schedule(this.FileChecker,new Date(), intervaloActualizacion);
    }
}
