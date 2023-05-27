package core;

import Interfaces.Observer;
import Interfaces.TestSummary;

import java.util.Map;

public class ObserverTS extends TSDecorator implements Observer {
    public ObserverTS(TestSummary unDelegado) {
        super(unDelegado);
    }

    @Override
    public Map<String, Boolean> getTests() {
        return null;
    }

    @Override
    public void update(Object object) {
        if(object instanceof TestSummary) {
            Map<String, Boolean> map = ((TestSummary) object).getTests();
            super.updateTests(map);
        }
    }
}
