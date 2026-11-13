package personajes;

import java.util.Random;

import personajes.NivelesEnemigo.Experto;

public class Asaltante extends Personaje
{
    private final int nivel;
    private final String objeto;

    public Asaltante(String nombre, int vidaMax, int vidaMin, int vida, int danoMax, int danoMin, int dano, int nivel)
    {
        super(nombre, vidaMax, vidaMin, vida, danoMax, danoMin, dano);
        this.nivel = nivel;
        this.objeto = Juego.OBJETOS_ASALTANTE[nivel];
    }

    

  
    


    public int getNivel() {
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
}
