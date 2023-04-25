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

        // De aqui en adelante trabajaremos sobre las listas generadas por la lectura de
        // cada archivo .csv

        System.out.println(partidos);
        System.out.println(pronosticos);
    }

    private static List<Partido> leerPartidos(String archivo) {
        // Creo una lista de partidos vacia
        List<Partido> partidos = new ArrayList<>();

        try {
            List<String> lineas = Files.readAllLines(Paths.get(archivo));

            // Recorremos la lista "lineas" y de cada linea extraemos la informacion y
            // creamos un objeto partido que sera añadido a la lista partidos
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
        // Creo una lista de pronosticos vacia
        List<Pronostico> pronosticos = new ArrayList<>();

        try {
            // Creo una lista auxiliar que viene de la lectura del archivo de pronosticos
            List<String> lineas = Files.readAllLines(Paths.get(archivo));

            // Recorremos la lista "lineas" y de cada elemento de ella sacamos los datos
            // para crear un pronostico
            for (String linea : lineas) {
                String[] campos = linea.split(";");
                Equipo equipo1 = new Equipo(campos[0]);
                ResultadoEnum resultado = ResultadoEnum.valueOf(campos[1].toUpperCase());
                Equipo equipo2 = new Equipo(campos[2]);

                // Vamos a crear un partido null
                // De la lista de partidos, vamos a buscar cual es el correspondiente a nuestro
                // pronostico
                // Sera aquel partido donde jueguen ambos equipos
                // podria agregarse ronda
                Partido partido = null;
                for (Partido p : partidos) {
                    if (p.getEquipo1().equals(equipo1) && p.getEquipo2().equals(equipo2)) {
                        partido = p;
                        break;
                    }
                }
                if (partido != null) {
                    pronosticos.add(new Pronostico(partido, equipo1, equipo2, resultado));
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return pronosticos;
    }
}
