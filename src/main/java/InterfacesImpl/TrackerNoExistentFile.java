package InterfacesImpl;

import java.io.File;
import java.io.FileNotFoundException;

import core.ReportResult;
import core.Tracker;

public class TrackerNoExistentFile implements Tracker {

	@Override
	public ReportResult find(String path) throws FileNotFoundException{
		
		
		File file = new File(path);
		
		if(file.exists()) {
			
			return new ReportResult(path, null);
		}

		throw new FileNotFoundException("No se encontro el archivo");
		
	}
	

}
