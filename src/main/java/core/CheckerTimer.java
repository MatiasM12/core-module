package core;

import java.util.Timer;
import java.util.TimerTask;

public class CheckerTimer extends Timer {
    private TimerTask task;
    private int period;
    public CheckerTimer(SrcChecker checker, int period){
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
