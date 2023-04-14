package core;

import java.util.Observer;

public class CheckerBuilder {

    //no deberia guardar, es un builder
    private SrcChecker checker;
    private Scheduler sch;
    public CheckerBuilder(String path, int intervaloActualizacion, Observer obs) {
        SrcChecker checker = new SrcChecker(obs, path);
        new Scheduler(checker, intervaloActualizacion);
    }
}
