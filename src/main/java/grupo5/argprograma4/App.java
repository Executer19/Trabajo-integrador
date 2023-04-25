package grupo5.argprograma4;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        String resultados = "./resultados.csv";
        String pronosticosRuta = "./pronosticos.csv";
        List<Partido> partidos = leerPartidos(resultados);
        List<Pronostico> pronosticos = leerPronosticos(pronosticosRuta, partidos);

        System.out.println(partidos);
        System.out.println(pronosticos);
    }

    private static List<Partido> leerPartidos(String archivo) {
        List<Partido> partidos = new ArrayList<>();

        try {
            List<String> lineas = Files.readAllLines(Paths.get(archivo));

            for (String linea : lineas) {
                String[] campos = linea.split(";");
                Equipo equipo1 = new Equipo(campos[0]);
                int golesEquipo1 = Integer.parseInt(campos[1]);
                int golesEquipo2 = Integer.parseInt(campos[2]);
                Equipo equipo2 = new Equipo(campos[3]);
                partidos.add(new Partido(equipo1, equipo2, golesEquipo1, golesEquipo2));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return partidos;
    }

    private static List<Pronostico> leerPronosticos(String archivo, List<Partido> partidos) {
        List<Pronostico> pronosticos = new ArrayList<>();

        try {
            List<String> lineas = Files.readAllLines(Paths.get(archivo));

            for (String linea : lineas) {
                String[] campos = linea.split(";");
                Equipo equipo1 = new Equipo(campos[0]);
                ResultadoEnum resultado = null;
                switch (campos[1].toUpperCase()) {
                    case "GANA1":
                        resultado = ResultadoEnum.GANA1;
                        break;
                    case "GANA2":
                        resultado = ResultadoEnum.GANA2;
                        break;
                    case "EMPATE":
                        resultado = ResultadoEnum.EMPATE;
                        break;
                }
                Equipo equipo2 = new Equipo(campos[2]);
                Persona persona = new Persona(campos[3]);
                Partido partido = null;
                for (Partido p : partidos) {
                    if (p.getEquipo1().getNombre().equals(equipo1.getNombre())
                            && p.getEquipo2().getNombre().equals(equipo2.getNombre())) {
                        partido = p;
                        break;
                    }
                }
                if (partido != null) {
                    pronosticos.add(new Pronostico(partido, equipo1, equipo2, resultado, persona));
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return pronosticos;
    }

    private static void puntuacion(List<Pronostico> pronosticos, List<Partido> partidos, Persona persona) {
        int puntos = 0;
        for (Pronostico pro : pronosticos) {
            if (pro.getPersona().equals(persona)) {
                for (Partido par : partidos) {
                    if (pro.getPartido().equals(par)) {
                        if (pro.getResultado().equals(par.resultado())) {
                            puntos++;
                        }
                    }
                }
            }
        }
        persona.setPuntos(puntos);
    }
}
