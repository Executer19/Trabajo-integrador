package grupo5.argprograma4;

public class Equipo {
    private String nombre;
    private String descripcion;

    // Aqui creamos la clase Equipo, con su constructor y sus metodos accesores y
    // mutadores
    // Con esta clase generamos un objeto Equipo para cada equipo que participe en
    // el certamen donde se realicen los pronosticos
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Equipo(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return nombre;
    }

}
