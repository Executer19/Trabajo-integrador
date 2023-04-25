package grupo5.argprograma4;

public class Partido {
    private Equipo equipo1;
    private Equipo equipo2;
    private int golesEquipo1;
    private int golesEquipo2;

    // Aqui creamos la clase equipo con su constructor y sus metodos accesors y
    // mutadores.
    // Cada partido consta de dos objetos Equipo y dos enteros que simbolizan sus
    // goles
    // El metodo resultado retorna un Enum que indica el resultado del equipo que
    // pasamos como argumento
    // comparando los goles que hizo con los de su rival.

    public Equipo getEquipo1() {
        return equipo1;
    }

    public void setEquipo1(Equipo equipo1) {
        this.equipo1 = equipo1;
    }

    public Equipo getEquipo2() {
        return equipo2;
    }

    public void setEquipo2(Equipo equipo2) {
        this.equipo2 = equipo2;
    }

    public int getGolesEquipo1() {
        return golesEquipo1;
    }

    public void setGolesEquipo1(int golesEquipo1) {
        this.golesEquipo1 = golesEquipo1;
    }

    public int getGolesEquipo2() {
        return golesEquipo2;
    }

    public void setGolesEquipo2(int golesEquipo2) {
        this.golesEquipo2 = golesEquipo2;
    }

    public Partido(Equipo equipo1, Equipo equipo2, int golesEquipo1, int golesEquipo2) {
        this.equipo1 = equipo1;
        this.equipo2 = equipo2;
        this.golesEquipo1 = golesEquipo1;
        this.golesEquipo2 = golesEquipo2;
    }

    public ResultadoEnum resultado(Equipo equipo) {
        if (equipo == equipo1) {
            return golesEquipo1 > golesEquipo2 ? ResultadoEnum.GANADOR
                    : golesEquipo1 < golesEquipo2 ? ResultadoEnum.PERDEDOR : ResultadoEnum.EMPATE;
        } else if (equipo == equipo2) {
            return golesEquipo2 > golesEquipo1 ? ResultadoEnum.GANADOR
                    : golesEquipo2 < golesEquipo1 ? ResultadoEnum.PERDEDOR : ResultadoEnum.EMPATE;
        } else {
            throw new IllegalArgumentException("El equipo no jugó este partido.");
        }
    }

}

/*
 * BOCA 1 0 RIVER
 * EQ1 EQ2
 * Partido clasico(BOCA, RIVER, 1, 0);
 * 
 * clasico.resultado(BOCA) => GANADOR
 * clasico.resultado(RIVER) => PERDEDOR
 * clasico.resultado(RACING) => EXCEPCION
 */

/*
 * OPERADOR TERNARIO
 * 
 * PRUEBA LOGICA ? RESULTADO POSITIVO : RESULTADO NEGATIVO
 * 
 * IF() {
 * IF () {
 * 
 * }
 * }
 * 
 */