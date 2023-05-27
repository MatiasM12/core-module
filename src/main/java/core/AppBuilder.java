package core;

import Interfaces.TestSummary;

public class AppBuilder {
    public ObservableTS build(TSProvider TSProvider1, String userStory) {
        TestSummary ts = TSProvider1.getTS(userStory);
        ObservableTS oTS = new ObservableTS(ts);
        ObserverTS over = new ObserverTS(oTS);
        TSProvider1.setObserver(over);
        return oTS;
    }
}
