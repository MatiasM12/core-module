package core;

import CoreInicialization.AppBuilder;
import Interfaces.TSProvider;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

public class US1 {

    private MockTSProvider plugin;
    private MockVista vista;

    @BeforeEach
    public void escenario() {
       AppBuilder app = new AppBuilder();
       plugin = new MockTSProvider();
       ObservableTS o = app.build((TSProvider) plugin, "US1");
       vista = new MockVista(o);
    }

    @Test
    void CA1seAgregaUnTest() {
        int oldTestsQuantity = vista.getTests().size();
        plugin.fingirCambios(new HashMap<String, Boolean>() {{
                    put("CA1",false);
                    put("CA2",true);
                }});
        assertTrue(vista.getTests().size() == oldTestsQuantity + 1);
    }
    @Test
    void CA2seBorraUnTest() throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException{
        int oldTestsQuantity = vista.getTests().size();
        plugin.fingirCambios(new HashMap<String, Boolean>() {{
            remove("CA1");
        }});
        assertTrue(vista.getTests().size() == oldTestsQuantity - 1);
    }

    @Test
    void CA3cambiaEstadoDeTest() throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException{
        Boolean oldState = vista.getTests().get("CA1");
        plugin.fingirCambios(new HashMap<String, Boolean>() {{
            put("CA1",true);
        }});
        assertNotEquals(oldState,vista.getTests().get("CA1"));
    }

    @Test
    void CA4sinTest() throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException{
        plugin.fingirCambios(new HashMap<String, Boolean>() {{
            //is empty
        }});
        assertEquals(vista.getTests().size(), 0);
    }
}
