package core;

import Interfaces.TestSummary;

import java.util.HashMap;
import java.util.Map;

public class MockPlugin extends Plugin{

    public Map<String, Boolean> tests;
    public MockPlugin(){
        this.tests = new HashMap<>();
        this.tests.put("CA1",false);
    }
    @Override
    public TestSummary getTS(String userStory) {
        return new ConcreteTestSummary(this.tests);
    }


    public void fingirCambio(int choice){
        switch (choice) {
            case 1:
                this.tests.put("CA2", true);
                doChange();
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
    }

    private void doChange() {
        super.notifyNewChanges(new ConcreteTestSummary(this.tests));
    }
}
