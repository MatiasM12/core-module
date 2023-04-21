package core;

import java.util.Observable;
import java.util.Observer;

public class ControllerUI implements Observer {
    PvCore corex;

    public ControllerUI(PvCore core) {
        this.corex = core;
    }

    @Override
    public void update(Observable o, Object arg) {
        corex.getReport();
    }
}
