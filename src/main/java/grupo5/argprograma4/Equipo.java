package grupo5.argprograma4;

public class Equipo {
    private String nombre;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Equipo(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return nombre;
    }

}

// Creamos la clase equipo, que tiene como parametro un String nombre.
// Creamos abajo su constructor que recibe como argumento el String nombre
// Por ultimo, sobreescribimos el metodo toString para que nos devuelva el
// nombre del equipo.