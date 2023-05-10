package Main;

import com.google.common.base.Ticker;
import core.Tracker;

import java.io.FileNotFoundException;
import java.util.*;

public class SelfTracker extends Tracker {
    @Override
    protected void track(String path) throws FileNotFoundException {
        Timer timer = new Timer();
        Random random = new Random();
        Set<TestResult> testResultSet = new HashSet<>();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                for(int i = 0; i < 10; i++){
                    TestResult testResult = new TestResult("Test" + i, random.nextBoolean());
                    testResultSet.add(testResult);
                }
                update(testResultSet);
            }
        }, new Date(), 5000);
    }
}
