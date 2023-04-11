package core;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Timer;

public class App {
	
	public ArrayList<Observer> observersChecker ; 
	public ArrayList<Observer> observersReport ; 
	public FileUpdateChecker checker ;  	
	public Report report; 
	public ReportUpdater updater;

	public App() { 
		
        File archivo = createFile("mock");
		
		this.observersReport = new ArrayList<Observer>();
		this.checker = new FileUpdateChecker(archivo);
		this.report = new Report(observersReport, 100, null);
		this.updater = new ReportUpdater(report);

	}

	public File createFile(String nombre) {
		File archivo = new File(nombre+".txt");
        try {
            if (archivo.createNewFile()) {
                System.out.println("Archivo creado con éxito.");
                return archivo;
            } else {
                System.out.println("El archivo ya existe.");
                return archivo;
            }
        } catch (IOException e) {
            System.out.println("Ocurrió un error al crear el archivo.");
            e.printStackTrace();
        }
        return null;
	}

	public void initChecker() {
		//cada 5 segundos chequea cambios
		Timer timer = new Timer();
		timer.schedule( this.checker , 5000 );
	}
}
