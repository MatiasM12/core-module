package TrackersMock;

import java.io.File;
import java.io.FileNotFoundException;

import core.ReportResult;
import core.Tracker;

public class TrackerNonExistentPath implements Tracker {

	@Override
	public ReportResult find(String path) throws FileNotFoundException{
		File file = new File(path);
		
		if(!file.exists()) throw new FileNotFoundException();
			
		return new ReportResult(path, null);
	}
	

}
