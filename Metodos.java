import java.util.Scanner;

import personajes.Asaltante;
import personajes.Cajero;
import personajes.Juego;


public class Metodos {
    
        public static void mostrarMenu()
    {
            System.out.println("\n=== EL DESPERTAR DEL HÉROE: TURNO DE NOCHE ===");
            System.out.println("1. Nueva partida");
            System.out.println("2. Consultar ranking");
            System.out.println("3. Ayuda");
            System.out.println("4. Salir");
    }
    
        public static void mostrarInformacion(){
            System.out.println("\n=== AYUDA ===");
            System.out.println("Eres el cajero de una tienda y entran " + Juego.VIDA_ENEMIGO.length + 
                                " asaltantes seguidos (de nivel creciente) que te lanzan objetos.");

            System.out.println( "Empiezas con " + Juego.VIDA_MAX + " de vida y " + Juego.NUM_BEBIDAS + 
                                " bebidas energéticas que te brindan " + Juego.CURACION_BEBIDA + " de vida.");
            
            System.out.println ( " Cada ronda puedes defenderte y causar " + Juego.DANO_MIN_CAJERO + "de daño minimo y " 
                                + Juego.DANO_MÁX_CAJERO + " de daño máximo. " );
            
            System.out.println ( " Habrán tres niveles de enemigos: " + Juego.NIVELES_ENEMIGOS + " que causarán " 
                                + Juego.DANO_ENEMIGO + " respectivamente "); 

            for (int i = 0; i < Juego.NIVELES_ENEMIGOS.length; i++) {
            System.out.println("  Nivel " + (i + 1) + ": " + Juego.NIVELES_ENEMIGOS[i]
                    + " (" + Juego.VIDA_ENEMIGO[i] + " de vida)");
            }
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
                System.out.println("Debes escribir un número.");
            }
            sc.nextLine();                          
        }
        return opcion;
        }
        
 
        public static String leerNombre(Scanner sc) {

            String nombre;

        do {
            System.out.print("Introduce tu nombre: ");
            nombre = sc.nextLine();

        if (nombre.isEmpty()) {
            System.out.println("El nombre no puede estar vacío.");
        }

        } while (nombre.isEmpty());

            return nombre;
    }



         public static Asaltante crearAsaltante(int nivel) 
        {
                    Asaltante asaltante = new Asaltante(null, nivel, nivel, nivel, nivel, nivel, nivel, nivel);
                    return asaltante;
        }
         
         

        public static int simularPelea(Scanner sc, Cajero cajero, Asaltante asaltante) {
            return Juego.VICTORIA;
        }

        public static int calcularPuntacion(int derrotados, int vida) {
            int puntos = derrotados * Juego.PUNTOS_POR_ENEMIGO;
            if (derrotados == Juego.VIDA_ENEMIGO.length) {
                puntos += vida;
            }
            return puntos;
        }

        public static int  jugarPartida (Scanner sc, String nombre) {
            
            Cajero cajero = new Cajero(nombre, 0, 0, 0, 0, 0);
            int derrotados = 0;

            System.out.println( " \n Bienvenido " + nombre );
            System.out.println (  "\n Tu turno nocturno empezo y estas en caja");

            for (int nivel= 1 ;  nivel <= Juego.VIDA_ENEMIGO.length; nivel ++ ){
            Asaltante asaltante = new Asaltante(nombre, nivel, nivel, nivel, nivel, nivel, nivel, nivel);
            System.out.println (" \n Entra a la tienda: " + asaltante.getNombre());

            int resultado = simularCombate(sc, cajero, asaltante);
            if (resultado != Juego.VICTORIA){
                break;
            } 

            derrotados++;
        }

            int puntos = calcularPuntacion(derrotados, cajero.getVida());
            System.out.println("\n" + nombre + ", has obtenido " + puntos + " puntos.");
            return puntos;
        
    }


    
        public static int simularCombate(Scanner sc, Cajero cajero, Asaltante asaltante)
    {
            int resultado = Juego.EN_CURSO;
 
            while (resultado == Juego.EN_CURSO) {
            int opcion = leerOpcion(sc, 1, 4);
            boolean turnoConsumido = false;     
 
            switch (opcion) {
                case 1:                    
                    int dano = cajero.atacar();
                    asaltante.recibirDano(dano);
                        cajero.describirAtaqueCajero();
                        System.out.println(" (" + dano + " de daño).");
                    turnoConsumido = true;
                    break;
                case 2:                        
                    if (cajero.bebidas() == 0) {
                        System.out.println("No te quedan bebidas energéticas.");
                    } else if (cajero.getVidaMax () == 100){
                    System.out.println
                    ("Ya tienes la vida completa.");
                    } else {
                        cajero.usarBebida();
                        System.out.println("Bebes una energética. Vida: " + cajero.getVida());
                        turnoConsumido = true;
                    }
                    break;
                case 3:                                             
                    System.out.println("Sales corriendo de la tienda...");
                    resultado = Juego.ABANDONO;
                    break;
            }
                if (asaltante.getVida() < 40 && asaltante.getVida() < 60 && asaltante.getVida() < 80 ) {

                    System.out.println(asaltante.getNombre() + " huye de la tienda.");
                        resultado = Juego.VICTORIA;

                        } else if (turnoConsumido) {

                        int danoAsaltante = asaltante.atacar();
                        cajero.recibirDano(danoAsaltante);

                    System.out.println(asaltante.getNombre() + " te ataca con un objeto.");
                    System.out.println(" (" + danoAsaltante + " de daño)");

                        if (cajero.getVida() != Juego.VIDA_MAX) 
                    {
                    System.out.println("Caes al suelo entre los productos...");
                        
                        resultado = Juego.DERROTA;
                    }
                    return Juego.EN_CURSO;
                }
            }
        }

       
       
    }

        public static void mostrarEstado(Cajero cajero, Asaltante asaltante) {
            System.out.println("\n--- Combate " + asaltante.getNivel() + " de " + Juego.VIDA_ENEMIGO.length + " ---");
            asaltante.mostrarDatos();
            cajero.mostrarDatos();
            System.out.println("Bebidas energéticas: " + cajero.bebidas());
            System.out.println("1. Atacar  2. Beber energética  3. Ver inventario  4. Abandonar");
        }

        public static int calcularPuntuacion(int derrotados, int vidaFinal) {
            int puntos = derrotados * Juego.PUNTOS_POR_ENEMIGO;
            if (derrotados == Juego.VIDA_ENEMIGO.length) {
                puntos = puntos + vidaFinal;            
            }
        return puntos;
        
    }
      

