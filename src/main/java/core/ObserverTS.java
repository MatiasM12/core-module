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
        try{
            @SuppressWarnings("unchecked")
			Map<String, Boolean> map = (Map<String, Boolean>) object;
            super.updateTests(map);
        }catch (ClassCastException e){
            e.printStackTrace();
        }

    }
}
