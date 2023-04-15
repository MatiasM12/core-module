package core;

import java.io.File;
import java.util.Observable;
import java.util.Observer;
import java.util.TimerTask;

public class SrcChecker extends TimerTask {
    File file;
    Observer reportUpdater;
    public SrcChecker(Observer obs, String path) {
        this.reportUpdater = obs;
        this.file = new File(path);
    }

    @Override
    public void run() {
        //entrar al path y leer si cambio el archivo. El parseo del mismo se va a hacer dsp en el finder o por ahi
        System.out.println("Leyendo archivo por cambios");
        //si detecta cambios notifica a su observador
        if(false == true) reportUpdater.update();
    }
}
