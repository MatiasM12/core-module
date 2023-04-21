package core;

public class SrcChecker extends core.Observable implements Checker{

    public void check(){
        if(true){
            notifyObservers();
        }
    }
}
