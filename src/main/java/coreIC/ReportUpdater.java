package coreIC;


import java.util.List;

public class ReportUpdater {
    private Report reporte;
    private SourceFiles archivoFuente;

    public ReportUpdater(Report reporte, SourceFiles archivoFuente){
        this.reporte = reporte;
        this.archivoFuente = archivoFuente;
    }

    private void update() {
        List<Object> listaNueva = archivoFuente.getValues();
        this.reporte.setValues(listaNueva);
    }
}
