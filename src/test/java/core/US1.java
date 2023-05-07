package core;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class US1 {

    static TestSummary core;
    static MockTracker mock;
    @BeforeAll
    public static void escenario(){
        core = new TestSummary();
        mock = new MockTracker();
        mock.addObserver(core);
    }

    @BeforeEach
    public void vaciarTests(){
        mock.ningunTest();
    }

    @Test
    public void CA1(){
        assertTrue(core.getTestResults().size() == 0);
        this.mock.unSoloTest();
        assertTrue(core.getTestResults().size() == 1);
    }

    @Test
    public void CA2(){
        this.mock.unSoloTest();
        assertTrue(core.getTestResults().size() == 1);
        mock.ningunTest();
        assertTrue(core.getTestResults().size() == 0);
    }

//    @Test
//    public void CA3(){
//        this.mock.unSoloTest();
//        TestResult ret = new TestResult("Test1", true);
//        Object[] array = core.getTestResults().toArray();
//        assertTrue(array. == ret);
//        this.mock.unoCambia();
//    }

}
