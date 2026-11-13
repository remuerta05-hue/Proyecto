package personajes.NivelesEnemigo;

import personajes.Asaltante;
import personajes.Juego;

public class Experto extends Asaltante implements IVida, IAtaque, IObjeto {

  


    public Experto (String nombre, int vidaMax,int vidaMin,int vida, int danoMax, int danoMin, int dano,int nivel, String objeto) {
        super(nombre, vidaMax, vidaMin, vida, danoMax, danoMin, dano, nivel);

    }
    public void vida() {
        System.out.println("Vida del Experto: " + Juego.VIDA_ENEMIGO [2]);
    }
    public void ataque() {
        System.out.println("Daño del Experto: " + Juego.DANO_ENEMIGO[2]);
    }
    public void objeto() {
        System.out.println("Objeto del Experto: " + Juego.OBJETOS_ASALTANTE[2]);
    }

    
}
