package core;

import java.io.File;
import java.util.TimerTask;

public class FileUpdateChecker extends TimerTask {
	
	public long timeStamp;
	public File file;
	public ReportUpdater updater;
	
	public FileUpdateChecker( File file , ReportUpdater updater) {
		super();
		this.file = file;
		this.updater = updater;
		this.timeStamp = file.lastModified();
	}

	@Override
	public void run() {
		long timeStamp = file.lastModified();
		
		if( this.timeStamp != timeStamp ) {
			this.timeStamp = timeStamp;
		    updater.updateReport();
		}
	}
	
}
