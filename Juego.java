

public class Juego
{
    private Juego() {}
        //Cajero 
    public static final int VIDA_MAX = 100;
    public static final int NUM_POCION= 3;
    public static final int CURACION_BEBIDA= 25;
    public static final int DANO_MIN_GOLPE= 10;
    public static final int DANO_MÁX_GOLPE = 20;

        //Asaltante 
        
    public static final int[] VIDA_ENEMIGO={40,60,80};
    public static final int DANO_MIN= 5;
    public static final int DANO_MAX= 15;
    public static final String [] NIVELES_ENEMIGOS= { "Novato", "Profesional", "Experto" };

        //Defensa

    public static final String [] OBJETOS_ASALTANTE = {"Caja de cereales","Bolsa de detergente" , "Melon" }; 
    public static final String [] OBJETOS_CAJERO= {"Rollo de tickets" , "Escáner de códigos" , "Grapadora"};

        //Puntuación, Ranking

    public static final int PUNTOS_POR_ENEMIGO = 100;
    public static final int CAPACIDAD_RANKING = 10;
    public static final String FICHERO_RANKING = "ranking.xml";

        //

    
}