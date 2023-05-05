package TrackersMock;

import java.nio.file.Paths;

import core.ReportResult;
import core.Tracker;

public class TrackerInvalidPath implements Tracker {

	@Override
	public ReportResult find(String path) throws IllegalArgumentException {
		
		if (!Paths.get(path).toFile().exists()) throw new IllegalArgumentException();
		
		return new ReportResult(path, null);
	}
}
