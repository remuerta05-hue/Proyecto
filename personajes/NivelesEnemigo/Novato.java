package personajes.NivelesEnemigo;

import personajes.Asaltante;
import personajes.Juego;

public class Novato extends Asaltante implements IVida, IAtaque, IObjeto {

    public Novato() {
        super(Juego.NIVELES_ENEMIGOS[0], Juego.VIDA_ENEMIGO[0], 0, Juego.VIDA_ENEMIGO[0],
              Juego.DANO_MAX_ASALTANTE, Juego.DANO_MIN_ASALTANTE, Juego.DANO_MAX_ASALTANTE, 1);
    }
}

