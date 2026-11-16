package personajes.NivelesEnemigo;

import personajes.Asaltante;
import personajes.Juego;

public class Profesional extends Asaltante implements IVida, IAtaque, IObjeto {

    public Profesional() {
        super(Juego.NIVELES_ENEMIGOS[1], Juego.VIDA_ENEMIGO[1], 0, Juego.VIDA_ENEMIGO[1],
              Juego.DANO_MAX_ASALTANTE, Juego.DANO_MIN_ASALTANTE, Juego.DANO_MAX_ASALTANTE, 2);
    }
}
    

