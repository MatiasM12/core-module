package core;

import Interfaces.Observable;
import Interfaces.TestSummary;

public class AppBuilder {
    public ObservableTestSummary build(Plugin plugin1, String userStory) {
        TestSummary ts = plugin1.getTS(userStory);
        ObservableTestSummary oTS = new ObservableTestSummary(ts);
        ObserverTestSummary over = new ObserverTestSummary(oTS);
        plugin1.setObserver(over);
        return oTS;
    }
}
