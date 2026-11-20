
import java.io.File;
import java.util.Scanner;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import personajes.Asaltante;
import personajes.Cajero;
import personajes.Juego;
import personajes.NivelesEnemigo.Experto;
import personajes.NivelesEnemigo.Novato;
import personajes.NivelesEnemigo.Profesional;


public class Metodos {

    public static void mostrarPortada() {
        System.out.println("   ______________________________________________");
        System.out.println("  |  __________________________________________  |");
        System.out.println("  | |                                          | |");
        System.out.println("  | |       SUPERMERCADO  \"EL BUEN PRECIO\"     | |");
        System.out.println("  | |            ABIERTO 24 HORAS              | |");
        System.out.println("  | |__________________________________________| |");
        System.out.println("  |                                              |");
        System.out.println("  |   [ CAJA ]     ___      ___      ___         |");
        System.out.println("  |    |    |     |   |    |   |    |   |        |");
        System.out.println("  |____|____|_____|___|____|___|____|___|________|");
        System.out.println();
        System.out.println("        EL DESPERTAR DEL HEROE: TURNO DE NOCHE");
        System.out.println();
    }


    public static void mostrarMenu() {
        System.out.println("\n=== EL DESPERTAR DEL HÉROE: TURNO DE NOCHE ===");
        System.out.println("1. Nueva partida");
        System.out.println("2. Consultar ranking");
        System.out.println("3. Ayuda");
        System.out.println("4. Salir");
    }

    public static void mostrarInformacion() {
        System.out.println("\n=== AYUDA ===");
        System.out.println("Eres el cajero de una tienda y entran " + Juego.VIDA_ENEMIGO.length +
                            " asaltantes seguidos (de nivel creciente) que te lanzan objetos.");

        System.out.println("Empiezas con " + Juego.VIDA_MAX + " de vida y " + Juego.NUM_BEBIDAS +
                            " bebidas energéticas que te brindan " + Juego.CURACION_BEBIDA + " de vida.");

        System.out.println(" Cada ronda puedes defenderte y causar " + Juego.DANO_MIN_CAJERO + " de daño minimo y "
                            + Juego.DANO_MAX_CAJERO + " de daño máximo. ");

        System.out.println("Habrá tres niveles de enemigos, que causan entre " + Juego.DANO_MIN_ASALTANTE
                            + " y " + Juego.DANO_MAX_ASALTANTE + " de daño:");

        for (int i = 0; i < Juego.NIVELES_ENEMIGOS.length; i++) {
            System.out.println("  Nivel " + (i + 1) + ": " + Juego.NIVELES_ENEMIGOS[i]
                + " (" + Juego.VIDA_ENEMIGO[i] + " de vida)");
        }
        System.out.println("Acciones en cada turno: 1. Atacar  2. Beber energética  3. Ver inventario  4. Abandonar.");
        System.out.println("Ver el inventario o elegir una acción imposible no gasta turno.");
        System.out.println("Puntuación: " + Juego.PUNTOS_POR_ENEMIGO
            + " por enemigo derrotado, más tu vida restante si ganas los tres combates.");
    }

    public static int leerOpcion(Scanner sc, int min, int max) {
        int opcion = min - 1;
        while (opcion < min || opcion > max) {
            System.out.print("> ");
            if (sc.hasNextInt()) {
                opcion = sc.nextInt();
                if (opcion < min || opcion > max) {
                    System.out.println("Opción fuera de rango (" + min + "-" + max + ").");
                }
            } else {
                System.out.println("Debes escribir un número entero.");
            }
            sc.nextLine();
        }
        return opcion;
    }

    public static String leerNombre(Scanner sc) {
        String nombre;

        do {
            System.out.print(" Introduce tu nombre: ");
            nombre = sc.nextLine().trim();

            if (nombre.isEmpty()) {
                System.out.println("El nombre no puede estar vacío.");
            }

        } while (nombre.isEmpty());

        return nombre;
    }

    

    public static int calcularPuntuacion(int derrotados, int vida) {
        int puntos = derrotados * Juego.PUNTOS_POR_ENEMIGO;
        if (derrotados == Juego.VIDA_ENEMIGO.length) {
            puntos += vida;
        }
        return puntos;
    }
            public static Asaltante crearAsaltante(int nivel) {
        if (nivel == 1) {
            return new Novato();
        } else if (nivel == 2) {
            return new Profesional();
        } else {
            return new Experto();
        }
    }
    
        public static int jugarPartida(Scanner sc, String nombre) {
        Cajero cajero = new Cajero(nombre, Juego.VIDA_MAX, 0, Juego.DANO_MAX_CAJERO,
                Juego.DANO_MIN_CAJERO, Juego.NUM_BEBIDAS);
        int derrotados = 0;

        System.out.println(" \n Bienvenido " + nombre);
        System.out.println("\n Tu turno nocturno empezo y estas en caja");

        for (int nivel = 1; nivel <= Juego.VIDA_ENEMIGO.length; nivel++) {
            Asaltante asaltante = crearAsaltante(nivel);
            System.out.println(" \n Entra a la tienda: " + asaltante.getNombre());

            int resultado = simularCombate(sc, cajero, asaltante);
            if (resultado != Juego.VICTORIA) {
                break;
            }
            derrotados++;
        }

        int puntos = calcularPuntuacion(derrotados, cajero.getVida());
        System.out.println("\n" + nombre + ", has obtenido " + puntos + " puntos.");
        return puntos;
    }

    public static int simularCombate(Scanner sc, Cajero cajero, Asaltante asaltante)
    {
        int resultado = Juego.EN_CURSO;

        while (resultado == Juego.EN_CURSO) {
            mostrarEstado(cajero, asaltante);
            int opcion = leerOpcion(sc, 1, 4);
            boolean turnoConsumido = false;     // solo atacar o curarse con éxito lo ponen a true

            switch (opcion) {
                case 1:                         // atacar
                    int dano = cajero.atacar();
                    asaltante.recibirDano(dano);
                    System.out.println(cajero.describirAtaque(Juego.OBJETOS_CAJERO)
                            + " (" + dano + " de daño).");
                    turnoConsumido = true;
                    break;
                case 2:                         // beber una energética
                    if (cajero.bebidas() == 0) {
                        System.out.println("No te quedan bebidas energéticas.");
                    } else if (cajero.tieneVidaCompleta()) {
                        System.out.println("Ya tienes la vida completa.");
                    } else {
                        cajero.usarBebida();
                        System.out.println("Bebes una energética. Vida: " + cajero.getVida());
                        turnoConsumido = true;
                    }
                    break;
                case 3:                        
                    cajero.mostrarInventario();
                    break;
                case 4:                         
                    System.out.println("Sales corriendo de la tienda...");
                    resultado = Juego.ABANDONO;
                    break;
            }

            if (resultado == Juego.EN_CURSO) {
                if (!asaltante.estaVivo()) {
                    System.out.println(asaltante.getNombre() + " huye de la tienda.");
                    resultado = Juego.VICTORIA;     // un enemigo derrotado no ataca
                } else if (turnoConsumido) {
                    int danoAsaltante = asaltante.atacar();
                    cajero.recibirDano(danoAsaltante);
                    System.out.println(asaltante.describirAtaque(Juego.OBJETOS_ASALTANTE)
                            + " (" + danoAsaltante + " de daño).");
                    if (!cajero.estaVivo()) {
                        System.out.println("Caes al suelo entre los productos...");
                        resultado = Juego.DERROTA;
                    }
                }
            }
        }
        return resultado;
    }

        public static void mostrarEstado(Cajero cajero, Asaltante asaltante) {
            System.out.println("\n--- Combate " + asaltante.getNivel() + " de " + Juego.VIDA_ENEMIGO.length + " ---");
            asaltante.mostrarDatos();
            cajero.mostrarDatos();
            System.out.println("Bebidas energéticas: " + cajero.bebidas());
            System.out.println("1. Atacar  2. Beber energética  3. Ver inventario  4. Abandonar");
    }

            
                //Ranking
                
            public static int registrarPuntuacion(String[] nombres, int[] puntos, int total,
                                            String nombre, int nuevosPuntos)
        {
          
            int posicion = 0;
            while (posicion < total && puntos[posicion] >= nuevosPuntos) {
                posicion++;
            }

           
            if (posicion >= Juego.CAPACIDAD_RANKING) {
                return total;
            }

            
            int ultimo = total;
            if (total == Juego.CAPACIDAD_RANKING) {
                ultimo = Juego.CAPACIDAD_RANKING - 1;   
            }
            for (int i = ultimo; i > posicion; i--) {
                nombres[i] = nombres[i - 1];
                puntos[i] = puntos[i - 1];
            }

           
            nombres[posicion] = nombre;
            puntos[posicion] = nuevosPuntos;

            if (total < Juego.CAPACIDAD_RANKING) {
                total++;
            }
            return total;
        }

        public static void mostrarRanking(String[] nombres, int[] puntos, int total)
        {
            if (total == 0) {
                System.out.println("\nTodavía no hay puntuaciones en el ranking.");
                return;
            }
            System.out.println("\n=== RANKING ===");
            for (int i = 0; i < total; i++) {
                System.out.println((i + 1) + ". " + nombres[i] + " - " + puntos[i] + " puntos");
            }
        }
                /**
         * Lee el ranking del fichero XML y lo carga en los arrays (basado en LeerXML).
         * @param fichero ruta del fichero XML
         * @param nombres array donde se guardan los nombres
         * @param puntos  array donde se guardan las puntuaciones
         * @return número de registros leídos (0 si el fichero no existe,
         *         -1 si el fichero existe pero está dañado o tiene datos incorrectos)
         */
        public static int cargarRanking(String fichero, String[] nombres, int[] puntos)
        {
            int total = 0;
            File archivo = new File(fichero);
            if (!archivo.exists()) {
                return 0;               
            }
            try {
                DocumentBuilderFactory fabrica = DocumentBuilderFactory.newInstance();
                 fabrica.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false);
                DocumentBuilder constructor = fabrica.newDocumentBuilder();
                Document documento = constructor.parse(archivo);
                documento.getDocumentElement().normalize();

                NodeList lista = documento.getElementsByTagName("numero");
                if (lista.getLength() > nombres.length) {
                    System.out.println("El ranking tiene más de " + nombres.length + " registros.");
                    return -1;
                }
                for (int i = 0; i < lista.getLength(); i++) {
                    Element numero = (Element) lista.item(i);
                    String nombre = numero.getElementsByTagName("nombre").item(0).getTextContent().trim();
                    int valor = Integer.parseInt(
                            numero.getElementsByTagName("puntuacion").item(0).getTextContent().trim());

                    // Comprobaciones que la DTD no puede hacer
                    if (nombre.isEmpty()) {
                        System.out.println("Hay un registro sin nombre (posición " + (i + 1) + ").");
                        return -1;
                    }
                    if (valor < 0 || valor > Juego.PUNTUACION_MAXIMA) {
                        System.out.println("Puntuación fuera de rango (posición " + (i + 1) + "): " + valor);
                        return -1;
                    }
                    if (total > 0 && valor > puntos[total - 1]) {
                        System.out.println("El ranking no está ordenado de mayor a menor.");
                        return -1;
                    }
                    nombres[total] = nombre;
                    puntos[total] = valor;
                    total++;
                }
            } catch (Exception e) {
                // Incluye XML mal formado, campos que faltan o puntuaciones que no son números
                System.out.println("No se pudo leer el ranking: " + e.getMessage());
                return -1;
            }
            return total;
        }
                /**
         * Guarda el ranking en el fichero XML, sobrescribiéndolo entero (basado en CrearXML).
         * @param fichero ruta del fichero XML
         * @param nombres nombres de los jugadores, ordenados
         * @param puntos  puntuaciones, en el mismo orden que los nombres
         * @param total   número de registros ocupados
         */

        public static void guardarRanking(String fichero, String[] nombres, int[] puntos, int total)
        {
            try {
                DocumentBuilderFactory fabrica = DocumentBuilderFactory.newInstance();
                DocumentBuilder constructor = fabrica.newDocumentBuilder();
                Document documento = constructor.newDocument();

                Element raiz = documento.createElement("ranking");
                raiz.setAttribute("nombre", "Top jugadores");
                documento.appendChild(raiz);

                for (int i = 0; i < total; i++) {
                    Element numero = documento.createElement("numero");
                    numero.setAttribute("posicion", String.valueOf(i + 1));
                    raiz.appendChild(numero);

                    Element nombre = documento.createElement("nombre");
                    nombre.setTextContent(nombres[i]);
                    numero.appendChild(nombre);

                    Element puntuacion = documento.createElement("puntuacion");
                    puntuacion.setTextContent(String.valueOf(puntos[i]));
                    numero.appendChild(puntuacion);
                }

                Transformer transformer = TransformerFactory.newInstance().newTransformer();
                transformer.setOutputProperty(OutputKeys.INDENT, "yes");
                transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
                transformer.setOutputProperty(OutputKeys.DOCTYPE_SYSTEM, "ranking.dtd");
                transformer.transform(new DOMSource(documento), new StreamResult(new File(fichero)));
            } catch (Exception e) {
               System.out.println ("Error generado al XML: " + e.getMessage());
            }
        }

       
        
    }

