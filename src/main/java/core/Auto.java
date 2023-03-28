package core;

public class Auto {
    // Variables de instancia para la clase Persona
    private String nombre;
    private int a�o;
    private String marca;

    // Constructor para crear una nueva instancia de Persona
    public Auto(String nombre, int a�o, String marca) {
        this.nombre = nombre;
        this.a�o = a�o;
        this.marca = marca;
    }

    // M�todos para obtener y establecer los valores de las variables de instancia
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    // M�todo para imprimir los detalles de un auto
    public void imprimirDetalles() {
        System.out.println("Nombre: " + nombre);
        System.out.println("A�o: " + a�o);
        System.out.println("Marca: " + marca);
    }
}
