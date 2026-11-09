package personajes;

import java.util.Random;


public class Cajero extends Personaje 
{
    private int vida= Juego.VIDA_MAX;
    private final int[] bebidas = new int[Juego.NUM_BEBIDAS];
    private int num_bebidas;

    public Cajero (String nombre, int vidaMax, int vidaMin, int danoMax, int danoMin, int bebidas) {
        super(nombre, vidaMax, vidaMin, 0, danoMax, danoMin, 0);}

    public String getNombre() {
        return super.getNombre();
    }

    public int bebidas() {
        System.out.println("Tienes " + num_bebidas + " bebidas energéticas");
        return num_bebidas;
    }

    public void usarBebida() {
        if (num_bebidas > 0) {
            vida += 25;
            num_bebidas--;
            System.out.println("Has bebido una bebida energética y has recuperado 25 puntos de vida");
        } else {
            System.out.println("No te quedan bebidas energéticas");
        }
    }   
    
     public int  atacar () {
    Random random = new Random();
    int ataque = random.nextInt(6) +20; 
    return ataque;
    }

    public boolean esquivar() {
        Random random = new Random();
        int probabilidad = random.nextInt(100); 
        if (probabilidad < 30) {
            System.out.println("El Cajero ha esquivado el ataque.");
        } else {
            System.out.println("El Cajero no ha esquivado el ataque.");
            System.out.println("El Cajero ha recibido daño : " + getDano() + " puntos de daño.");
        }
        if (getVida() <= 0) {
            System.out.println(" Ya no le queda vida ");
        }
        return probabilidad < 30;

        }
    public int vida() {
        return vida;
        }
}