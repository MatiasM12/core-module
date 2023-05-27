package core;

import Interfaces.TSProvider;
import Interfaces.TestSummary;

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

    public void fingirCambio(int choice){
        switch (choice) {
            case 1:
                this.tests.put("CA2", true);
                break;
            case 2:
                System.out.println("You selected option 2");
                break;
            case 3:
                System.out.println("You selected option 3");
                break;
            default:
                System.out.println("Invalid choice");
        }
        super.notifyNewChanges(this.tests);
    }
}
