package personajes.NivelesEnemigo;

import personajes.Asaltante;
import personajes.Juego;

public class Novato extends Asaltante implements IVida, IAtaque, IObjeto
 {

    public Novato(String nombre, int vidaMax, int vidaMin, int vida, int danoMax, int danoMin, int dano, int nivel, String objeto)
        
     
    {
        super(nombre, vidaMax, vidaMin, vida, danoMax, danoMin, dano, nivel);      
    }

    public void vida() {
        System.out.println("Vida del Experto: " + Juego.VIDA_ENEMIGO [3]);
    }
    public void ataque() {
        System.out.println("Daño del Experto: " + Juego.DANO_ENEMIGO[3]);
    }
    public void objeto() {
        System.out.println("Objeto del Experto: " + Juego.OBJETOS_ASALTANTE[3]);
    }
}


