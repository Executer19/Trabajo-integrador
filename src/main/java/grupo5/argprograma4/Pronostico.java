package grupo5.argprograma4;

public class Pronostico {
    private Partido partido;
    private Equipo equipo1;
    private Equipo equipo2;
    private ResultadoEnum resultado;

    public int puntos(Equipo equipo) {
        ResultadoEnum resultadoReal = partido.resultado(equipo);
        if (resultado == resultadoReal) {
            // acertó el resultado predicho
            return 1;
        } else {
            // no acertó el resultado
            return 0;
        }
    }

    public Pronostico(Partido partido, Equipo equipo1, Equipo equipo2, ResultadoEnum resultado) {
        this.partido = partido;
        this.equipo1 = equipo1;
        this.equipo2 = equipo2;
        this.resultado = resultado;
    }

    @Override
    public String toString() {
        return "Pronostico [" + equipo1 + " - " + equipo2 + "-" + resultado + "]";
    }

}

/*
 * Pronostico pronosticoFinal(Final, Argentina, GANADOR);
 * 
 * => GANA ARGENTINA
 * 
 * pronosticoFinal.puntos(); => suma 1 punto
 * 
 * 
 * 
 */