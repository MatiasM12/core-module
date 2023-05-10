package core;

public class Dupla <T, M>{
    T element1;
    M element2;
    Dupla (T element1, M element2){
        this.element1 = element1;
        this.element2 = element2;
    }

    public T getT(){
        return this.element1;
    }

    public M getM(){
        return this.element2;
    }

    public void setT(T element1){
        this.element1 = element1;
    }

    public void setM(M element2){
        this.element2 = element2;
    }
}
