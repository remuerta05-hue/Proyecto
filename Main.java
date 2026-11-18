import java.io.File;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.
dom.NodeList;

import personajes.Juego;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] nombres = new String[Juego.CAPACIDAD_RANKING];
        int[] puntos = new int[Juego.CAPACIDAD_RANKING];

        int total = Metodos.cargarRanking(
                Juego.FICHERO_RANKING,
                nombres,
                puntos
        );

        int opcion;

        System.out.println("=================================================");
        System.out.println("            BIENVENIDO AL VIDEOJUEGO          ");
        System.out.println("=================================================");

        do {

            System.out.println("\n-------------------------------------------------");
            Metodos.mostrarMenu();
            System.out.println("-------------------------------------------------");

            opcion = Metodos.leerOpcion(sc, 1, 4);

            switch (opcion) {

                case 1:

                    System.out.println("\n══════════ NUEVA PARTIDA ══════════");

                    String nombre = Metodos.leerNombre(sc);

                    int puntosPartida = Metodos.jugarPartida(sc, nombre);

                    total = Metodos.registrarPuntuacion(
                            nombres,
                            puntos,
                            total,
                            nombre,
                            puntosPartida
                    );

                    Metodos.guardarRanking(
                            Juego.FICHERO_RANKING,
                            nombres,
                            puntos,
                            total
                    );

                    System.out.println("\n══════════ RANKING ACTUAL ══════════");
                    Metodos.mostrarRanking(nombres, puntos, total);
                    break;

                case 2:

                    System.out.println("\n══════════ RANKING ══════════");
                    Metodos.mostrarRanking(nombres, puntos, total);
                    break;

                case 3:

                    System.out.println("\n══════════ INFORMACIÓN DEL JUEGO ══════════");
                    Metodos.mostrarInformacion();
                    break;

                case 4:

                    System.out.println("\n══════════ SALIENDO DEL JUEGO ══════════");
                    break;
            }

        } while (opcion != 4);

        System.out.println("\n=================================================");
        System.out.println("      ¡Gracias por jugar! Hasta la próxima      ");
        System.out.println("=================================================");

        sc.close();
    }
}

    