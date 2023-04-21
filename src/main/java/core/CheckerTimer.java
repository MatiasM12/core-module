package core;

import java.util.Observer;
import java.util.Timer;
import java.util.TimerTask;

public class CheckerTimer extends Timer {
    private TimerTask task;
    //private core.Observer observador;
    private int period;
    public CheckerTimer(Checker checker, int period){
        this.task = new TimerTask() {
            @Override
            public void run() {
                checker.check();
            }
        };
        this.period = period;
    }
    public void run(){
        this.schedule(task, 0, period);
    }
}
