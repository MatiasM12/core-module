package core;

public class Init {
	public Report reporte;
	public ReportUpdater reportUpdater;

	public Init(String path, int intervaloActualizacion) {
		this.reportUpdater = new ReportUpdater(path, intervaloActualizacion, this);
	}

//	public Init() { //yo creo que esto esta mal pero fue la forma de probarlo en el momento jaja
//
//		this.observers = new ArrayList<Observer2>();
//		this.checker = new FileUpdateChecker("mock.text", observers);
//
//		this.reporte = new Report("mock.txr");
//
//		//cada 5 segundos chequea cambios
//	    Timer timer = new Timer();
//	    int delay = 1000;
//	    int interval = 5000;
//	    timer.scheduleAtFixedRate(new TimerTask() {
//	      public void run() {
//	    	reporte.actualizador.fileChecker.check();
//	    	//checker.check();
//	      }
//	    }, delay, interval);
//	}
}
