package core;

public class Persona {
    // Variables de instancia para la clase Persona
    private String nombre;
    private int edad;
    private String direccion;

    // Constructor para crear una nueva instancia de Persona
    public Persona(String nombre, int edad, String direccion) {
        this.nombre = nombre;
        this.edad = edad;
        this.direccion = direccion;
    }

    // Métodos para obtener y establecer los valores de las variables de instancia
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    public void moverse() {
        System.out.println("La persona " + nombre + " se está moviendo ");
    }

    // Método para imprimir los detalles de una persona
    public void imprimirDetalles() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Edad: " + edad);
        System.out.println("Dirección: " + direccion);
    }
}
