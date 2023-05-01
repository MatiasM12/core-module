package core;

import java.io.FileNotFoundException;

public interface Tracker {
    ReportResult find(String path) throws FileNotFoundException;
}
