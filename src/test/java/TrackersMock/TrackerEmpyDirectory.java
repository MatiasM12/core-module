package TrackersMock;

import java.io.FileNotFoundException;

import javax.annotation.processing.FilerException;

import core.ReportResult;
import core.Tracker;

public class TrackerEmpyDirectory implements Tracker{

	@Override
	public ReportResult find(String path) throws FileNotFoundException, FilerException {
		// TODO Auto-generated method stub
		return null;
	}

}
