package core;

import java.util.Map;

public class ObserverTestSummary extends DecoratorTestSummary implements Observer{
    public ObserverTestSummary(TestSummary s) {
        super(s);
    }
    @Override
    public void update(Object object) {
        if (object instanceof TestSummary) {
            TestSummary ts = (TestSummary) object;
            if(! getTestResults().equals(ts)) updateTests(ts);
        }else{throw new IllegalArgumentException("Se espera que llegue un TestSummary al core, pero llego un "+ object.getClass());
    }
    @Override
    public void updateTests(TestSummary ts) {
        super.delegado.updateTests(ts);
    }
    @Override
    public Map<String, Boolean> getTestResults() {
        return super.delegado.getTestResults();
    }
}
