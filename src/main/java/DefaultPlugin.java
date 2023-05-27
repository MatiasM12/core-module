import Interfaces.TestSummary;
import core.ConcreteTestSummary;
import core.Plugin;

import java.util.HashMap;

public class DefaultPlugin extends Plugin {
    @Override
    public TestSummary getTS(String userStory) {
        return new ConcreteTestSummary(new HashMap<>());
    }
}
