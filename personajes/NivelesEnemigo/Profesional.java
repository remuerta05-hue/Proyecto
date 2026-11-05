package personajes.NivelesEnemigo;

import personajes.Asaltante;
import personajes.Juego;

public class Profesional extends Asaltante implements IVida, IAtaque, IObjeto
{
    private final int danoMax;
    private final int danoMin;
    private final String objeto;

    public Profesional (String nombre, int vidaMax,int vidaMin,int vida, int danoMax, int danoMin, int dano,int nivel, String objeto) {
        super(nombre, vidaMax, vidaMin, vida, danoMax, danoMin, dano,nivel,objeto);
        
        this.danoMax= Juego.DANO_ENEMIGO[2];
        this.danoMin= Juego.DANO_ENEMIGO[2];
        this.objeto= Juego.OBJETOS_ASALTANTE[2];
    }

    @Override
    public int getDanoMax() {
        return danoMax;
    }

    @Override
    public int getDanoMin() {
        return danoMin;
    }

    @Override
    public String getObjeto() {
        return objeto;
    }
    
}
