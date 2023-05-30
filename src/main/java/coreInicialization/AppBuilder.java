package coreInicialization;

import Interfaces.TestSummary;
import core.ObservableTS;
import core.ObserverTS;
import Interfaces.TSProvider;

public class AppBuilder {
    public ObservableTS build(TSProvider tsProvider, String userStory) {
        TestSummary ts = tsProvider.getTS(userStory);
        ObservableTS oTS = new ObservableTS(ts);
        ObserverTS over = new ObserverTS(oTS);
        tsProvider.setObserver(over);
        return oTS;
    }
}