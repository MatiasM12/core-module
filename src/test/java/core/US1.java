package core;

import CoreInicialization.AppBuilder;
import Interfaces.TSProvider;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

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
    void seAgregaUnTest() {
        int oldTestsQuantity = vista.getTests().size();
        plugin.fingirCambio(1);
        assertTrue(vista.getTests().size() == oldTestsQuantity + 1);
    }

    @Disabled
    @Test
    void seBorraUnTest() throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException{
//        int oldTestsQuantity = test.size();
//        removeOneTest();
//        provider.update(test);
//        assertEquals(provider.getMap().size(),oldTestsQuantity - 1);
    }

    @Disabled
    @Test
    void CambiaEstadoDeTest() throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException{
//        Boolean oldStatus = provider.getMap().get("CA1");
//        changeStatusTest();
//        provider.update(test);
//        assertNotEquals(provider.getMap().get("CA1"),oldStatus);
    }

    @Disabled
    @Test
    void sinTest() throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException{
//        provider.update(emptyTest);
//        assertEquals(provider.getMap().size(),0);
    }

    @Disabled
    @Test
    void cambiaElTest() throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException{
//        Map<String,Boolean> repoUpdate = new HashMap<String,Boolean>();
//        provider.update(repoUpdate);
//        assertEquals(provider.getMap().size(),0);
    }

}
