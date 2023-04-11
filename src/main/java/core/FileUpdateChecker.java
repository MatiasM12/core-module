package core;

import java.io.File;
import java.util.TimerTask;

public class FileUpdateChecker extends TimerTask {
	
	public long timeStamp;
	public File file;
	public ReportUpdater updater;
	
	public FileUpdateChecker( File file ) {
		super();
		this.file = file;
		this.timeStamp = file.lastModified();
	}


	@Override
	public void run() {
		long timeStamp = file.lastModified();
		System.out.println(timeStamp);
		System.out.println(this.timeStamp);
		if( this.timeStamp != timeStamp ) {
//		    this.timeStamp = timeStamp;
//		    updater.updateReport();
			System.out.println("hola");
		}
	}
	
}
