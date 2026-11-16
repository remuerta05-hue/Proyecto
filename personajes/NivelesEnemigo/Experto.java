package personajes.NivelesEnemigo;

import personajes.Asaltante;
import personajes.Juego;

public class Experto extends Asaltante implements IVida, IAtaque, IObjeto {

    public Experto() {
        super(Juego.NIVELES_ENEMIGOS[2], Juego.VIDA_ENEMIGO[2], 0, Juego.VIDA_ENEMIGO[2],
              Juego.DANO_MAX_ASALTANTE, Juego.DANO_MIN_ASALTANTE, Juego.DANO_MAX_ASALTANTE, 3);
    }
}
    
