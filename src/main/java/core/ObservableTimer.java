package core;

import java.util.Observer;
import java.util.Timer;
import java.util.TimerTask;

public class ObservableTimer extends Timer {
    public TimerTask task;
    private Observer observador;
    private int period;

    public ObservableTimer(Observer actualizador, int period){
        this.task = new TimerTask() {
            @Override
            public void run() {
                notifyObservers();
            }
        };
    }

    private void notifyObservers() {
        this.observador.update(null, null);
    }

    private void addObserver(Observer observador){
        this.observador = observador;
    }

    public void run(){
        schedule(task, 0, period);
    }


}
