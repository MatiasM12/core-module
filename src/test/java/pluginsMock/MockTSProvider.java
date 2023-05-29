package pluginsMock;

import Interfaces.TSProvider;
import Interfaces.TestSummary;
import core.ConcreteTS;

import org.junit.jupiter.api.Disabled;

import java.util.HashMap;
import java.util.Map;

public class MockTSProvider extends TSProvider {

    public Map<String, Boolean> tests;
    public MockTSProvider(){
        this.tests = new HashMap<>();
        this.tests.put("CA1",false);
    }
    @Override
    public TestSummary getTS(String userStory) {
        return new ConcreteTS(this.tests);
    }

    @Disabled
    public void fingirCambio(int choice){
        switch (choice) {
            case 1:
                this.tests.put("CA2", true);
                notifyNewChanges(this.tests);
                break;
            case 2:
                this.tests.remove("CA1");
                notifyNewChanges(this.tests);
                break;
            case 3:
                this.tests.put("CA1",true);
                notifyNewChanges(this.tests);
                break;
            case 4:
                this.tests.clear();
                break;
            default:
                System.out.println("Invalid choice");
        }
        super.notifyNewChanges(this.tests);
    }

    public void fingirCambios(HashMap<String, Boolean> map) {
        notifyNewChanges(map);
    }
}