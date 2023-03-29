package core;

public class Casa {
    // Atributos
    private int numHabitaciones;
    private double area;
    private String direccion;

    // Constructor
    public Casa(int numHabitaciones, double area, String direccion) {
        this.numHabitaciones = numHabitaciones;
        this.area = area;
        this.direccion = direccion;
    }

    // Métodos
    public int getNumHabitaciones() {
        return numHabitaciones;
    }

    public double getArea() {
        return area;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setNumHabitaciones(int numHabitaciones) {
        this.numHabitaciones = numHabitaciones;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
