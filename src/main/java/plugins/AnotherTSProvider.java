package plugins;

import Interfaces.TSProvider;
import Interfaces.TestSummary;

public class AnotherTSProvider extends TSProvider {
    @Override
    public TestSummary getTS(String userStory) {
        return null;
    }
}
