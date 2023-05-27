package Main;

import Interfaces.TestSummary;
import core.ConcreteTS;
import Interfaces.TSProvider;

import java.util.HashMap;

public class DefaultTSProvider extends TSProvider {
    @Override
    public TestSummary getTS(String userStory) {
        return new ConcreteTS(new HashMap<>());
    }
}
