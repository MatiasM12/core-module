/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package core;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

import static org.junit.jupiter.api.Assertions.*;

class LibraryTest {
    static String finderImplPath;
    static String checkerImplPath;
    static InitCore initCore;
    static Report observableReport;
    static String directory;


    @BeforeAll
    public static void escenario1() throws MalformedURLException {
        finderImplPath = "";
        checkerImplPath = "";
        initCore = new InitCore(finderImplPath, checkerImplPath);
        directory = "C:\\Users\\Usuario\\Desktop\\Universidad\\20231erSem\\PP2\\diagramas";
        observableReport = initCore.init("DefaultFinder", directory, 1);
    }
    @Test void someLibraryMethodReturnsTrue() {
        assertTrue(true);
    }

    @Test void test() throws IOException {
        ReportResult reportResult = observableReport.getReport();

        String absoluteFilePath= directory + "\\jota.txt";
        File file = new File(absoluteFilePath);
        file.createNewFile();

        ReportResult newReportResult = observableReport.getReport();
        assertFalse(reportResult.equals(newReportResult));
    }

    @Test void test2() throws IOException {
        ReportResult reportResult = observableReport.getReport();
        ReportResult newReportResult = observableReport.getReport();
        assertTrue(reportResult.equals(newReportResult));
    }
}
