package core;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class UserStory extends Observable implements TestSummary{
    String name;
    Map<String, Boolean> tests;
    UserStory(){
        this.observers = new HashSet<>();
    }
    @Override
    public Map<String, Boolean> getTests() {
        return this.tests;
    }
    @Override
    public void setTests(Map<String, Boolean> map) {
        this.tests = map;
        Map<String, Map<String, Boolean>> ret = new HashMap<>();
        ret.put(this.name, this.tests);
        notifyObservers(ret);
    }
    @Override
    public void setName(String name) {
        this.name = name;
    }
    @Override
    public String getName() {
        return this.name;
    }
}
