package coreIC;

import java.util.ArrayList;
import java.util.List;

public class Init {
    ReportUpdater actualizador;

    public void Init(String[] args){
        List<AcceptanceTest> listaDeTests = new ArrayList<>();
        listaDeTests.add(new AcceptanceTest());
        listaDeTests.add(new AcceptanceTest());

        TestReport reporteDeTests = new TestReport(listaDeTests);
        TestSourceFile archivConLosTest = new TestSourceFile(listaDeTests);

        this.actualizador = new ReportUpdater(reporteDeTests, archivConLosTest);

    }

    public void run(){

    }
}
