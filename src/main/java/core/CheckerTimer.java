package core;

import java.net.URL;
import java.util.Timer;
import java.util.TimerTask;

public class CheckerTimer extends Timer {
    private TimerTask task;
    private int period;
    public CheckerTimer(Checker checker, int period, String path){
        this.task = new TimerTask() {
            @Override
            public void run() {
                checker.check(path);
            }
        };
        this.period = period;
    }
    public void run(){
        this.schedule(task, 0, period);
    }
}
