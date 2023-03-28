package core;

public class Auto {
    // Variables de instancia para la clase Persona
    private String nombre;
    private int año;
    private String marca;

    // Constructor para crear una nueva instancia de Persona
    public Auto(String nombre, int año, String marca) {
        this.nombre = nombre;
        this.año = año;
        this.marca = marca;
    }

    // Métodos para obtener y establecer los valores de las variables de instancia
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    // Método para imprimir los detalles de un auto
    public void imprimirDetalles() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Año: " + año);
        System.out.println("Marca: " + marca);
    }
}
