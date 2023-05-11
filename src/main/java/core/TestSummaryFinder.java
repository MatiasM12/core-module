package core;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Set;

public class TestSummaryFinder{
    public Set<TestSummary> findTestSummary(String path) throws ClassNotFoundException, InstantiationException, IllegalAccessException, FileNotFoundException {
        File file = new File(path);
        if (!file.exists()) throw new FileNotFoundException();
        File[] files = file.listFiles();
        Set<TestSummary> ret = new HashSet<>();
        if(files == null) return ret;
        for (File f : files) {
            if (f.getName().endsWith(".class")) {
                String fileName = f.getName().replace(".class", "");
                Class<?> cls = Class.forName(fileName);
                if (!Tracker.class.isAssignableFrom(cls)) continue;
                ret.add((Tracker) cls.newInstance());
            }
        }
        return ret;
    }
}
