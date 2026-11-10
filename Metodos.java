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
                                + Juego.DANO_MAX_CAJERO + " de daño máximo. " );
            
            System.out.println ( " Habrán tres niveles de enemigos: " + Juego.NIVELES_ENEMIGOS + " que causarán " 
                                + Juego.DANO_ENEMIGO + " respectivamente "); 

            for (int i = 0; i < Juego.NIVELES_ENEMIGOS.length; i++) {
            System.out.println("  Nivel " + (i + 1) + ": " + Juego.NIVELES_ENEMIGOS[i]
                    + " (" + Juego.VIDA_ENEMIGO[i] + " de vida)");
            }
            System.out.println("Puntuación: " + Juego.PUNTOS_POR_ENEMIGO
                + " por enemigo derrotado, más tu vida restante si ganas los tres combates.");
            }

        public static int leerOpcion(Scanner sc, int min, int max){
    
        while (true) {
            System.out.print("> ");
            if (sc.hasNextInt()) {
                int opcion = sc.nextInt();
                sc.nextLine();
                 if (opcion >= min && opcion <= max) {
                    return opcion;
                }
                System.out.println("Opción fuera de rango (" + min + "-" + max + ").");
            } else {
                sc.nextLine();       
                System.out.println("Debes introducir un número.");
            }
        }
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
         return new Asaltante(nivel);
        }
         
         

        public static int  jugarPartida (Scanner sc, String nombre) {
            
            Cajero cajero = new Cajero(nombre, 0, 0, 0, 0, 0);
            int derrotados = 0;

            System.out.println( " \n Bienvenido " + nombre );
            System.out.println (  "\n Tu turno nocturno empezo y estas en caja");

            for (int nivel= 1 ;  nivel <= Juego.VIDA_ENEMIGO.length; nivel ++ ){


          
        }

        

    }
}




        
        
    


