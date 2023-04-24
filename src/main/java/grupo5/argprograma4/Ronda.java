package grupo5.argprograma4;

public class Ronda {

    private String ronda;
    private Partido[] partidos;

    public int puntos(Equipo equipo) {
        int totalPuntos = 0;
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

}
