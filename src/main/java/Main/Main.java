package Main;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class Main {

    static String trackerDirectoryPath = "C:\\Users\\Usuario\\IntelliJ-Workspace\\VALKIRIA\\core-module\\build\\classes\\java\\main\\InterfacesImpl";
    static String trackerImpl = "InterfacesImpl.DefaultReportTracker";
    static String reportDirectoryPath = "reportPath";

    public static void main(String[] args) throws IOException, ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        InitCore initCore = new InitCore(trackerDirectoryPath);
        Core core = initCore.init(trackerImpl,reportDirectoryPath);

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                try {
                    core.refresh();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }, new Date(), 5000);
    }
}
