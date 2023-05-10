package core;

import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public abstract class Tracker implements Observer, TestSummary{
    TestSummary testSummary;
    Tracker(String url){
        this.testSummary = hook(url);

    }
    public abstract TestSummary hook(String url);
    void setObserver(TestSummary testSummary){
        this.testSummary = testSummary;
    }
    protected abstract void track(String path) throws FileNotFoundException;
    @Override
    public void update(Object object){
        Map<String, Map<String, Boolean>> obj = (Map<String, Map<String, Boolean>>) object;
        Set<String> s = obj.keySet();
        Iterator<String> it =s.iterator();
        String key =  it.next();

        this.testSummary.setName(key);
        this.testSummary.setTests(obj.get(key));
    }
}
