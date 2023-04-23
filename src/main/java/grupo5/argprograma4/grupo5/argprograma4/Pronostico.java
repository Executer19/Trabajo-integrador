package grupo5.argprograma4;

import grupo5.argprograma4.ResultadoEnum;

public class Pronostico {
    private Partido partido;
    private Equipo equipo;
    private ResultadoEnum resultado;

    public int puntos() {
        ResultadoEnum resultadoReal = partido.resultado(equipo);
        if (resultado == resultadoReal) {
            // acertó el resultado exacto
            return 3;
        } else if (resultado == ResultadoEnum.EMPATE && resultadoReal == ResultadoEnum.EMPATE) {
            // acertó que hubo empate
            return 1;
        } else {
            // no acertó el resultado ni el empate
            return 0;
        }
    }

    public Pronostico(Partido partido, Equipo equipo, ResultadoEnum resultado) {
        this.partido = partido;
        this.equipo = equipo;
        this.resultado = resultado;
    }
}
