package personajes;




public class Asaltante extends Personaje
{
    private final int nivel;
    private final String objeto;
       public Asaltante(String nombre, int vidaMax, int vidaMin, int vida, int danoMax, int danoMin, int dano, int nivel)
    {
        super(nombre, vidaMax, vidaMin, vida, danoMax, danoMin, dano);
        this.nivel = nivel;
        this.objeto = Juego.OBJETOS_ASALTANTE[nivel - 1];
    }

    
    public int getNivel() {
        return nivel;
    }

    public String getObjeto() {
        return objeto;
    }

    
   
    public String describirAtaque(String[] objetosAsaltante) {

    int posicion = (int) (Math.random() * objetosAsaltante.length);

    return "El asaltante te ataca con " + objetosAsaltante[posicion];
}


    







     
}
