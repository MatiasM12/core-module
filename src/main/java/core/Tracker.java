package core;

import java.io.FileNotFoundException;

import javax.annotation.processing.FilerException;

public interface Tracker {
    ReportResult find(String path) throws FileNotFoundException, FilerException;
}
