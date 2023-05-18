package core;

import java.util.Map;

public class ObserverTestSummary extends DecoratorTestSummary implements Observer{
    public ObserverTestSummary(TestSummary s) {
        super(s);
    }
    @Override
    public void update(Object object) {
        if(object instanceof TestSummary){
            newChange(  (   (TestSummary) object)
                            .getTestResults() );
        }
    }
    @Override
    public void newChange(Map<String,String> m) {
        super.ts.newChange(m);
    }
    @Override
    public Map<String, String> getTestResults() {
        return super.ts.getTestResults();
    }
}
