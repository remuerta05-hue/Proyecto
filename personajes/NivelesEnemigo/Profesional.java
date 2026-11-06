package personajes.NivelesEnemigo;

import personajes.Asaltante;
import personajes.Juego;

public class Profesional extends Asaltante implements IVida, IAtaque, IObjeto
{
    

    public Profesional (String nombre, int vidaMax,int vidaMin,int vida, int danoMax, int danoMin, int dano,int nivel, String objeto) {
        super(nombre, vidaMax, vidaMin, vida, danoMax, danoMin, dano,nivel,objeto);
        
    
     }
    public void vida() {
        System.out.println("Vida del Profesional: " + Juego.VIDA_ENEMIGO [1]);
    }
    public void ataque() {
        System.out.println("Daño del Profesional: " + Juego.DANO_ENEMIGO[1]);
    }
    public void objeto() {
        System.out.println("Objeto del Profesional: " + Juego.OBJETOS_ASALTANTE[0]+ Juego.OBJETOS_ASALTANTE[1]);
    }
}
