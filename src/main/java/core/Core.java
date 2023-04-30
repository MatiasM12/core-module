package core;

import java.io.IOException;

public class Core {
    private Report report;
    private Listener listener;
    public Core(Report report, Listener listener){
        this.report = report;
    }
    public void subscribe(Observer o){
        this.report.addObserver(o);
    }
    public void refresh() throws IOException {
        this.listener.handle(null);
    }
}
