package grupo5.argprograma4;

public class Ronda {
    private String ronda;
    private Partido[] partidos;

    public int puntos(Equipo equipo) {
        int totalPuntos = 0;
        // For mejorado o forEach
        for (Partido partido : partidos) {
            ResultadoEnum resultado = partido.resultado(equipo);
            if (resultado == ResultadoEnum.GANADOR) {
                totalPuntos += 3;
            } else if (resultado == ResultadoEnum.EMPATE) {
                totalPuntos += 1;
            }
        }
        return totalPuntos;
    }

    public Ronda(String ronda, Partido[] partidos) {
        this.ronda = ronda;
        this.partidos = partidos;
    }

}

/*
 * fase de grupos
 * 
 * arg arab pierde +0 [0]
 * arg mex gana +3 [1]
 * arg pol gana +3 [2]
 * esp canada ?? [3]
 * japon alemania [4]
 * 
 * 
 * faseDeGrupos.totalPuntos(Argentina) => 6
 * 
 */