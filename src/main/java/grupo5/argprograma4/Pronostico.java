package grupo5.argprograma4;

public class Pronostico {
    private Partido partido;
    private Equipo equipo1;
    private Equipo equipo2;
    private ResultadoEnum resultado;
    private Persona persona;

    public ResultadoEnum getResultado() {
        return resultado;
    }

    public Persona getPersona() {
        return persona;
    }

    public Partido getPartido() {
        return partido;
    }

    public Pronostico(Partido partido, Equipo equipo1, Equipo equipo2, ResultadoEnum resultado, Persona persona) {
        this.partido = partido;
        this.equipo1 = equipo1;
        this.equipo2 = equipo2;
        this.resultado = resultado;
        this.persona = persona;
    }

    @Override
    public String toString() {
        return "Pronostico [" + equipo1 + " - " + equipo2 + "-" + resultado + "]" + persona.getNombre();
    }

}