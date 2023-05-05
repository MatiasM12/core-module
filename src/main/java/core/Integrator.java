package core;

import java.io.IOException;

public class Integrator {
	
    private Report report;
    private Listener listener;
    
    public Integrator(Report report,Listener listener){
    	this.report = report;
    	this.listener = listener;
    }
    
    public void subscribe(Observer o){
        this.report.addObserver(o);
    }
    
    public void refresh() throws IOException {
        this.listener.handle(null);
    }

}
