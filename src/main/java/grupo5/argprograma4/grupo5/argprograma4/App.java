package grupo5.argprograma4;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import grupo5.argprograma4.Partido;
import grupo5.argprograma4.ResultadoEnum;

import java.util.ArrayList;

public class App {
    public static void main(String[] args) {

    }

    private static List<Partido> leerPartido(String archivo) {
        List<Partido> partidos = new ArrayList<>();

        try {
            List<String> lineas = Files.readAllLines(Paths.get(archivo));

            for (String linea : lineas) {
                String[] campos = linea.split(",");
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
                String[] campos = linea.split(",");
                Equipo equipo = new Equipo(campos[0]);
                ResultadoEnum resultado = ResultadoEnum.valueOf(campos[1].toUpperCase());
                Partido partido = null;
                for (Partido p : partidos) {
                    if (p.getEquipo1().equals(equipo) || p.getEquipo2().equals(equipo)) {
                        partido = p;
                        break;
                    }
                }
                if (partido != null) {
                    pronosticos.add(new Pronostico(partido, equipo, resultado));
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return pronosticos;
    }
}
