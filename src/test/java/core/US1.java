package core;


import coreInicialization.DecoratorInit;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

public class US1 {

    private TSDecorator plugin;
 

 /*   @BeforeEach
    public void escenario() {
       DecoratorInit init = new DecoratorInit();
       ObservableTS o = app.build((TSDecorator) plugin, "US1");
       vista = new MockVista(o);
    }

    @SuppressWarnings("serial")
	@Test
    void CA1() {
        int oldTestsQuantity = vista.getTests().size();
        plugin.fingirCambios(new HashMap<String, Boolean>() {{
                    put("CA1",false);
                    put("CA2",true);
                }});
        assertTrue(vista.getTests().size() == oldTestsQuantity + 1);
    }
    
    @SuppressWarnings("serial")
	@Test
    void CA2() throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException{
        int oldTestsQuantity = vista.getTests().size();
        plugin.fingirCambios(new HashMap<String, Boolean>() {{
            remove("CA1");
        }});
        assertTrue(vista.getTests().size() == oldTestsQuantity - 1);
    }

    @SuppressWarnings("serial")
	@Test
    void CA3() throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException{
        Boolean oldState = vista.getTests().get("CA1");
        plugin.fingirCambios(new HashMap<String, Boolean>() {{
            put("CA1",true);
        }});
        assertNotEquals(oldState,vista.getTests().get("CA1"));
    }

    @SuppressWarnings("serial")
	@Test
    void CA4() throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException{
        plugin.fingirCambios(new HashMap<String, Boolean>() {{
            //is empty
        }});
        assertEquals(vista.getTests().size(), 0);
    }*/
}
