package core;


import InterfacesImpl.DefaultReportTracker;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class US1 {
    static String trackerDirectoryPath = "./build/resources/test/availableTrackers";
    static String trackerImpl = "InterfacesImpl.DefaultReportTracker";
    static String reportDirectoryPath = "reportPath";

    static Integrator integrator;

    @BeforeAll
    public static void escenario1() throws IOException, ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        System.out.println("Working Directory = " + System.getProperty("user.dir"));
        InitCore initCore = new InitCore();
        integrator = initCore.init(trackerImpl,reportDirectoryPath, trackerDirectoryPath);
    }

    @Test
    void CA0() {
        assertDoesNotThrow(() -> {
        	integrator.refresh();
        });
    }

}
