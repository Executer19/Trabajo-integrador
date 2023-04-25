package grupo5.argprograma4;

public class Pronostico {
    private Partido partido;
    private Equipo equipo;
    private ResultadoEnum resultado;

    public int puntos() {
        ResultadoEnum resultadoReal = partido.resultado(equipo);
        if (resultado == resultadoReal) {
            // acertó el resultado predicho
            return 1;
        } else {
            // no acertó el resultado
            return 0;
        }
    }

    public Pronostico(Partido partido, Equipo equipo, ResultadoEnum resultado) {
        this.partido = partido;
        this.equipo = equipo;
        this.resultado = resultado;
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