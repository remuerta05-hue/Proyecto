package personajes;

import java.util.Random;

public class Asaltante extends Personaje
{
    private final int nivel;
    private final String objeto;

    public Asaltante (String nombre, int vidaMax,int vidaMin,int vida, int danoMax, int danoMin, int dano,int nivel, String objeto) {
        super(nombre, vidaMax, vidaMin, vida, danoMax, danoMin, dano);
        this.nivel = nivel;
        this.objeto = Juego.OBJETOS_ASALTANTE[nivel - 1];
    }

    public Asaltante(int nivel)
    {
        super("Asaltante " + Juego.NIVELES_ENEMIGOS[nivel - 1],
                Juego.VIDA_ENEMIGO[nivel - 1],
                0,
                Juego.VIDA_ENEMIGO[nivel - 1],
                Juego.DANO_MAX_ASALTANTE,
                Juego.DANO_MIN_ASALTANTE,
                Juego.DANO_MIN_ASALTANTE);
        this.nivel = nivel;
        this.objeto = Juego.OBJETOS_ASALTANTE[nivel - 1];
    }

    public int getNivel () {
        return nivel;
    }

    public String getObjeto() {
        return objeto;
    }

    
     public int  atacar () {
    Random random = new Random();
    int ataque = random.nextInt(6) +15; 
    return ataque;
    }

    public boolean esquivar() {
        Random random = new Random();
        int probabilidad = random.nextInt(100); 
        if (probabilidad < 30) {
            System.out.println("El Asaltante ha esquivado el ataque.");
        } else {
            System.out.println("El Asaltante no ha esquivado el ataque.");
            System.out.println("El Asaltante ha recibido daño : " + getDano() + " puntos de daño.");
        }
        if (getVida() <= 0) {
            System.out.println(" El Asaltante ha sido derrotado.!Gano la partida.! ");
        }
        return probabilidad < 30;
        
    } 
}
