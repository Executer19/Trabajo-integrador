package grupo5.argprograma4;

import java.util.List;

public class Persona {
    private String nombre;
    private List<Pronostico> pronosticos;
    private int puntos;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Pronostico> getPronosticos() {
        return pronosticos;
    }

    public void setPronosticos(List<Pronostico> pronosticos) {
        this.pronosticos = pronosticos;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public Persona(String nombre) {
        this.nombre = nombre;
        this.puntos = 0;
    }

    @Override
    public String toString() {
        return "Persona [" + nombre + "-" + puntos + "puntos]";
    }

}
