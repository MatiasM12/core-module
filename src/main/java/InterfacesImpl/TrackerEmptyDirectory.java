package InterfacesImpl;

import java.io.File;
import java.io.FileNotFoundException;

import javax.annotation.processing.FilerException;

import core.ReportResult;
import core.Tracker;

public class TrackerEmptyDirectory  implements Tracker {

	@Override
	public ReportResult find(String path) throws FileNotFoundException, FilerException {
		
		File file = new File(path);
		
		
		if(file.length()==0) throw new FilerException("La carpeta es vacia");
		
		
		
		return new ReportResult(path, null);
		

		
		
	}

}
