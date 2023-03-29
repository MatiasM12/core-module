package core;

public class Robot {
    // Atributos
    private String nombre;
    private int bateria;
    private int velocidad;

    // Constructor
    public Robot(String nombre, int bateria, int velocidad) {
        this.nombre = nombre;
        this.bateria = bateria;
        this.velocidad = velocidad;
    }

    // Métodos
    public void moverse() {
        System.out.println("El robot " + nombre + " se está moviendo a una velocidad de " + velocidad + " km/h");
    }

    public void cargarBateria() {
        System.out.println("El robot " + nombre + " está cargando su batería...");
        bateria = 100;
    }

    public void mostrarEstado() {
        System.out.println("El robot " + nombre + " tiene una batería de " + bateria + "% y una velocidad de " + velocidad + " km/h");
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }
}
