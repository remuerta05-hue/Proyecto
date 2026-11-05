package personajes;


public class Juego
{
    //private Juego() {}
        //Cajero 
    public static final int VIDA_MAX = 100;
    public static final int NUM_BEBIDAS= 3;
    public static final int CURACION_BEBIDA= 25;
    public static final int DANO_MIN_CAJERO= 10;
    public static final int DANO_MÁX_CAJERO = 20;

        //Asaltante 
        
    public static final int[] VIDA_ENEMIGO={40,60,80};
    public static final int DANO_MIN_ASALTANTE= 5;
    public static final int DANO_MAX_ASALTANTE= 15;
    public static final String [] NIVELES_ENEMIGOS= { "Novato", "Profesional", "Experto" };
    public static final int [] DANO_ENEMIGO={5, 10,15};

        //Defensa

    public static final String [] OBJETOS_ASALTANTE = {"Caja de cereales","Bolsa de detergente" , "Melon" }; 
    public static final String [] OBJETOS_CAJERO= {"Rollo de tickets" , "Escáner de códigos" , "Grapadora"};

        //Puntuación, Ranking

    public static final int PUNTOS_POR_ENEMIGO = 100;
    public static final int CAPACIDAD_RANKING = 10;
    public static final String FICHERO_RANKING = "ranking.xml";

        //Combate 

    public static final int EN_CURSO= 0;
    public static final int VICTORIA = 1;
    public static final int DERROTA= 2;
    public static final int ABANDONO = 3;

    
}