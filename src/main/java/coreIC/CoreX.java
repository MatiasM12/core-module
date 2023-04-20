package coreIC;

import java.util.ArrayList;
import java.util.List;

public class CoreX {
    ReportUpdater actualizador;

    public CoreX(String[] args){
        List<AcceptanceTest> listaDeTests = new ArrayList<>();
        listaDeTests.add(new AcceptanceTest());
        listaDeTests.add(new AcceptanceTest());

        TestReport reporteDeTests = new TestReport(listaDeTests);
        TestSourceFile archivConLosTest = new TestSourceFile(listaDeTests);

        this.actualizador = new ReportUpdater(reporteDeTests, archivConLosTest);

        //tengo un dicovery que busca los distintos finder y los disponibiliza en la ui

    }

//    public void run(String finderEspecifico, URL link){
//        new finderEspecifico(link);
//        //como me llega un string, lo mapeo con el discovery
//
//        new ReportContainer(finderEspecifico);
//        new ReportUpdater(finderEspecifico);
//
//    }
}
